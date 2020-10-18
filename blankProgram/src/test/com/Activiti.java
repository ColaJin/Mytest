package com;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
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
                .createProcessEngineConfigurationFromResource("activiti-cfg.xml", "processEngineConfiguration01");
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

}
