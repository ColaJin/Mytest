package com;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Activiti {
    @Test
    public void testGenerteTable() {
        //第一步：创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml", "processEngineConfiguration01");
        //第二步：创建ProcessEngine对象
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void testGenerteTableAnother() {

        //条件：1、activiti配置文件名称：activiti.cfg.xml
        //     2、bean的id="processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void testDeleteProcessDefinition() {

        //条件：1、activiti配置文件名称：activiti.cfg.xml
        //     2、bean的id="processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        String deploymentId = "5502";
        repositoryService.deleteDeployment(deploymentId);
        //强制性删除，级联删除，不填的时候为false
        /*repositoryService.deleteDeployment(deploymentId,true);*/
    }


    @Test
    public void testDownLoadFile() throws Exception {

        //条件：1、activiti配置文件名称：activiti.cfg.xml
        //     2、bean的id="processEngineConfiguration"
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
        String deploymentId = processDefinition.getDeploymentId();

        //获取png文件
        InputStream pngI = repositoryService.getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        //获取bpmn文件
        InputStream bpmnI = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());


        OutputStream pngO = new FileOutputStream("d://process.png");
        OutputStream bpmnO = new FileOutputStream("d://process.bpmn");

        IOUtils.copy(pngI,pngO);
        IOUtils.copy(bpmnI,bpmnO);

    }

    /**
     * 全部流程实例挂起，模板发生改变
     *
     * @throws Exception
     */
    @Test
    public void testAllProcessInstanceSuspendAndActivate() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //全部流程实例挂起
        /*String definitionId = "";
        repositoryService.createProcessDefinitionQuery().processDefinitionId(definitionId);*/
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey("StorageIn")
                .singleResult();

        //得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();

        String processDefinitionId = processDefinition.getId();

        if (suspended) {
            //暂停状态激活
            repositoryService.activateProcessDefinitionById(processDefinitionId,true,null);
            System.out.println("流程定义"+processDefinitionId+"激活");
        }else {
            repositoryService.suspendProcessDefinitionById(processDefinitionId,true,null);
            //挂起后流程不能操作
            System.out.println("流程定义"+processDefinitionId+"挂起");
        }
    }

    /**
     * 单个流程实例挂起，模板发生改变
     *
     * @throws Exception
     */
    @Test
    public void testSingleProcessInstanceSuspendAndActivate() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //流程实例挂起
        /*String definitionId = "";
        repositoryService.createProcessDefinitionQuery().processDefinitionId(definitionId);*/
        //流程实例id
//        String processInstanceId = "";
        ProcessInstance processInstance = runtimeService
                .createProcessInstanceQuery()
//                .processInstanceId(processInstanceId)
                .processInstanceBusinessKey("StorageIn:1")
                .singleResult();

        //得到当前流程定义的实例是否都为暂停状态
        boolean suspended = processInstance.isSuspended();

        String processInstanceId = processInstance.getId();

        if (suspended) {
            //暂停状态激活
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例"+processInstanceId+"激活");
        }else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            //挂起后流程不能操作
            System.out.println("流程实例"+processInstanceId+"挂起");
        }
    }

}
