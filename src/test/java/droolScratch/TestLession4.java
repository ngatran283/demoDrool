package droolScratch;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.droolscours.Account;
import com.droolscours.AccountingPeriod;
import com.util.KnowledgeSessionHelper;
import com.util.OutputDisplay;

public class TestLession4 {
	static KieContainer kieContainer;
	KieSession sessionStatefull = null;

	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("------------Before------------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("------------After ------------");
	}

/*	@Test
	public void testRuleFlow1() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionForJBPM(kieContainer, "ksession-lesson4");
		OutputDisplay display = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", display);
		Account a = new Account();
		sessionStatefull.insert(a);
		// sessionStatefull.startProcess("RF1");
		sessionStatefull.fireAllRules();
	}*/
	
	@Test
	public void testRuleFlow3() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-lesson4a");
		OutputDisplay display = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", display);
		Account a = new Account();
		a.setBalance(500);
		sessionStatefull.insert(a);
		AccountingPeriod period = new AccountingPeriod();
		sessionStatefull.insert(period);
		sessionStatefull.fireAllRules();
	}
}
