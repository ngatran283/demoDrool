package droolScratch;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.droolscours.Customer;
import com.droolscours.PrivateAccount;
import com.util.KnowledgeSessionHelper;
import com.util.OutputDisplay;

public class TestLession3 {
	StatelessKieSession statelessSession = null;
	KieSession statefullSession = null;
	static KieContainer KieContainer;

	@BeforeClass
	public static void beforeClass() {
		KieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("------------Before------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("------------After------------");
	}

	
	/* @Test
	    public void testInConstrait() {
		 statefullSession = KnowledgeSessionHelper
	                    .getStatefulKnowledgeSession(KieContainer,"ksession-lesson3");
	            OutputDisplay display = new OutputDisplay();
	            statefullSession.setGlobal("showResults", display);
	            CashFlow cashFlow = new CashFlow();
	            cashFlow.setType(CashFlow.CREDIT);
	            statefullSession.insert(cashFlow);
	            statefullSession.fireAllRules();
	    }*/
	
	 @Test
	    public void testNestedAccessor() throws Exception {
		 statefullSession = KnowledgeSessionHelper
	                .getStatefulKnowledgeSession(KieContainer, "ksession-lesson3");
	        OutputDisplay display = new OutputDisplay();
	        statefullSession.setGlobal("showResults", display);
	        Customer customer = new Customer();
	        customer.setName("Héron");
	        customer.setSurname("Nicolas");
	        PrivateAccount pAccount = new PrivateAccount();
	        pAccount.setOwner(customer);
	        statefullSession.insert(pAccount);
	        statefullSession.fireAllRules();
	    }
}
