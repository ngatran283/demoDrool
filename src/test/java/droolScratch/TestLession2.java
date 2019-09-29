package droolScratch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.droolscours.Account;
import com.droolscours.AccountingPeriod;
import com.droolscours.CashFlow;
import com.util.DateHelper;
import com.util.KnowledgeSessionHelper;
import com.util.OutputDisplay;

public class TestLession2 {
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

	/*@Test
	public void testdeuxFait1() {
		statefullSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(KieContainer, "ksession-lesson2");

		OutputDisplay display = new OutputDisplay();
		statefullSession.setGlobal("showResults", display);
		Account a = new Account();
		statefullSession.insert(a);
		AccountingPeriod period = new AccountingPeriod();
		statefullSession.insert(period);
		statefullSession.fireAllRules();
	}*/
	
	 /*@Test
	    public void testTwoFacts() {
		 statefullSession = KnowledgeSessionHelper
	                    .getStatefulKnowledgeSession(KieContainer,"ksession-lesson2");
	            OutputDisplay display = new OutputDisplay();
	            statefullSession.setGlobal("showResults", display);
	            Account a = new Account();
	            a.setAccountNo(2);
	            a.setBalance(0);
	            statefullSession.insert(a);
	            Account b = new Account();
	            a.setAccountNo(1);
	            a.setBalance(0);
	            statefullSession.insert(b);
	            CashFlow cash1 = new CashFlow();
	            cash1.setAccountNo(1);
	            cash1.setAmount(1000);
	            cash1.setType(CashFlow.CREDIT);
	            statefullSession.insert(cash1);
	            statefullSession.fireAllRules();            
	            Assert.assertEquals(a.getBalance(), 1000,0);

	    }*/
	
	 @Test
	    public void testTwoFacts() throws Exception {
		 statefullSession = KnowledgeSessionHelper
                 .getStatefulKnowledgeSession(KieContainer,"ksession-lesson2");
         System.out.print("Go here");

	            OutputDisplay display = new OutputDisplay();
	            System.out.print("Go here");
	            statefullSession.setGlobal("showResults", display);
	            AccountingPeriod period = new AccountingPeriod();
	            period.setStartDate(DateHelper.getDate("2016-01-01"));
	            period.setEndDate(DateHelper.getDate("2016-03-31"));
	            statefullSession.insert(period);
	            
	            Account a = new Account();
	            a.setAccountNo(1);
	            a.setBalance(0);
	            statefullSession.insert(a);

	            CashFlow cash1 = new CashFlow();
	            cash1.setAccountNo(1);
	            cash1.setAmount(1000);
	            cash1.setType(CashFlow.CREDIT);
	            cash1.setDate(DateHelper.getDate("2016-01-15"));
	            statefullSession.insert(cash1);
	            
	            CashFlow cash2 = new CashFlow();
	            cash2.setAccountNo(1);
	            cash2.setAmount(500);
	            cash2.setType(CashFlow.DEBIT);
	            cash2.setDate(DateHelper.getDate("2016-02-15"));
	            statefullSession.insert(cash2);
	            
	            CashFlow cash3 = new CashFlow();
	            cash3.setAccountNo(1);
	            cash3.setAmount(1000);
	            cash3.setType(CashFlow.CREDIT);
	            cash3.setDate(DateHelper.getDate("2016-04-15"));
	            statefullSession.insert(cash3);
	            
	            statefullSession.fireAllRules();            
	            Assert.assertEquals(a.getBalance(), 500,0);

	    }
}
