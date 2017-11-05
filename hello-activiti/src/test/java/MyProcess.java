import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class MyProcess {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	/**�������̶���*/
	@Test
	public void deploymentProcessDefinition(){
		Deployment deployment = processEngine.getRepositoryService()//�����̶���Ͳ��������ص�Service
						.createDeployment()//����һ���������
						.name("MyProcess���ų���")//��Ӳ��������
						.addClasspathResource("diagrams/MyProcess.bpmn")//��classpath����Դ�м��أ�һ��ֻ�ܼ���һ���ļ�
						.addClasspathResource("diagrams/MyProcess.png")//��classpath����Դ�м��أ�һ��ֻ�ܼ���һ���ļ�
						.deploy();//��ɲ���
		System.out.println("����ID��"+deployment.getId());//1
		System.out.println("�������ƣ�"+deployment.getName());//helloworld���ų���  
	}
	
	/**��������ʵ��*/
	@Test
	public void startProcessInstance(){
		//���̶����key
		String processDefinitionKey = "myProcess";
		ProcessInstance pi = processEngine.getRuntimeService()//������ִ�е�����ʵ����ִ�ж�����ص�Service
						.startProcessInstanceByKey(processDefinitionKey);//ʹ�����̶����key��������ʵ����key��Ӧhelloworld.bpmn�ļ���id������ֵ��ʹ��keyֵ������Ĭ���ǰ������°汾�����̶�������
		System.out.println("����ʵ��ID:"+pi.getId());//����ʵ��ID    101
		System.out.println("���̶���ID:"+pi.getProcessDefinitionId());//���̶���ID   helloworld:1:4
	}
	
	/**��ѯ��ǰ�˵ĸ�������*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "����";
		List<Task> list = processEngine.getTaskService()//������ִ�е����������ص�Service
						.createTaskQuery()//���������ѯ����
						.taskAssignee(assignee)//ָ�����������ѯ��ָ��������
						.list();
		if(list!=null && list.size()>0){
			for(Task task:list){
				System.out.println("����ID:"+task.getId());
				System.out.println("��������:"+task.getName());
				System.out.println("����Ĵ���ʱ��:"+task.getCreateTime());
				System.out.println("����İ�����:"+task.getAssignee());
				System.out.println("����ʵ��ID��"+task.getProcessInstanceId());
				System.out.println("ִ�ж���ID:"+task.getExecutionId());
				System.out.println("���̶���ID:"+task.getProcessDefinitionId());
				System.out.println("########################################################");
			}
		}
	}
	
	/**����ҵ�����*/
	@Test
	public void completeMyPersonalTask(){
		//����ID
		String taskId = "2505";
		processEngine.getTaskService()//������ִ�е����������ص�Service
					.complete(taskId);
		System.out.println("�����������ID��"+taskId);
	}
	
}
