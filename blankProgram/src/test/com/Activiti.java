package com;

import Activiti.config.SecurityUtils;
import entity.User;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*//完成SPring配置文件加载
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:activiti.cfg.xml")*/
public class Activiti {

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private SecurityUtils securityUtils;

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

    /**
     * 部署流程使用classPath
     */
    @Test
    public void deployProcess1() {
        String bpmnName = "UELMethodTest";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment().name("测试UELMEthod流程");
        Deployment deployment = null;
        try {
            deployment = deploymentBuilder.addClasspathResource(bpmnName + ".bpmn")
                    .addClasspathResource(bpmnName + ".png").deploy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("部署成功：流程部署ID：" + deployment.getId());
    }

    //删除部署信息
    @Test
    public void deleteDeployProcess() {
        // 获取核心对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // RepositoryService 仓库
        RepositoryService repositoryService  = processEngine.getRepositoryService();
        String deploymentId = "20001";
        repositoryService .deleteDeployment(deploymentId);
        System.out.println("删除流程部署成功");
    }

    /**
     * 流程定义key相同时会发生问题，启动的项目分不清
     *
     * @throws Exception
     */
    @Test
    public void testUELMethodStartProcess() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processDfinationKey="myProcess_1";

        Map<String, Object> variables = new HashMap<>();
        variables.put("userId",8);
        runtimeService.startProcessInstanceByKey(processDfinationKey,variables);
        System.out.println("流程启动成功");
    }

    @Test
    public void testLocalVariable() throws Exception {
        //User需要实现Serializable接口
        User user = new User("jyd",21);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Map<String, User> variable = new HashMap<>();
        variable.put("user",user);
        String taskId = "2502";
        taskService.setVariablesLocal(taskId,variable);

        System.out.println("当前结点流程变量设置成功");
    }

    @Test
    public void testTaskBack() throws Exception {
        //User需要实现Serializable接口
        User user = new User("jyd",21);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        String taskId = "2502";
        //先判断该任务的办理人是否是当前用户
        Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(user.getName()).singleResult();
        if (task == null) {
            throw new RuntimeException("该任务的执行人不是您");
        }
        //任务拾取后回退
        taskService.setAssignee(taskId,null);

        System.out.println("当前任务回退成功");
    }

    @Test
    public void testTaskHandover() throws Exception {
        //User需要实现Serializable接口
        User user = new User("jyd",21);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        String taskId = "2502";
        //先判断该任务的办理人是否是当前用户
        Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(user.getName()).singleResult();
        if (task == null) {
            throw new RuntimeException("该任务的执行人不是您");
        }
        String assignee = "jyw";
        //任务交接
        taskService.setAssignee(taskId,assignee);

        System.out.println("当前任务交接成功");
    }


    @Test
    public void testGetProcessDefintionByProcessRuntime() throws Exception {

        securityUtils.logInAs("salaboy");

        //分页查询流程定义信息
        Page<org.activiti.api.process.model.ProcessDefinition> processDefinitionPage =
                processRuntime.processDefinitions(Pageable.of(0, 10));
        int totalItems = processDefinitionPage.getTotalItems();
        System.out.println("查看部署流程的个数 = " + totalItems);

        List<org.activiti.api.process.model.ProcessDefinition> content = processDefinitionPage.getContent();
        for (org.activiti.api.process.model.ProcessDefinition processDefinition : content) {
            String id = processDefinition.getId();
            System.out.println("当前部署的流程定义的id = " + id);
        }
    }

    @Test
    public void testStartProcessByProcessRuntime() throws Exception {

        securityUtils.logInAs("salaboy");

        org.activiti.api.process.model.ProcessInstance processInstance =
                processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("team01").build());
        System.out.println("流程实例的id = " + processInstance.getId());
    }


    @Test
    public void testQueryTaskByTaskRuntime() {
        securityUtils.logInAs("salaboy");

        Page<org.activiti.api.task.model.Task> tasks =
                taskRuntime.tasks(Pageable.of(0, 10));

        int totalItems = tasks.getTotalItems();
        System.out.println("任务的总数 = " + totalItems);
        for (org.activiti.api.task.model.Task task : tasks.getContent()) {
            String id = task.getId();
            System.out.println("任务的id = " + id);
            String name = task.getName();
            System.out.println("任务名称 = " + name);
        }
    }


    @Test
    public void testQueryTaskAndCompleteTask(){
        securityUtils.logInAs("salaboy");

        Page<org.activiti.api.task.model.Task> page =
                taskRuntime.tasks(Pageable.of(0, 10));

        int totalItems = page.getTotalItems();
        System.out.println("任务的总数 = " + totalItems);
        for (org.activiti.api.task.model.Task task : page.getContent()) {
            String id = task.getId();
            System.out.println("任务的id = " + id);
            String name = task.getName();
            System.out.println("任务名称 = " + name);

            //拾取任务
            taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(id).build());

            //完成任务
            taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(id).build());

        }
    }

}
