import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class CreateTables {
	/**ʹ�������ļ�������������Ҫ��23�ű�*/
	@Test
	public void createTable_2(){
//		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//		//�������ĺ��Ķ���ProcessEnginee����
//		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")	//
									.buildProcessEngine();
		System.out.println("processEngine:"+processEngine);
	}
}
