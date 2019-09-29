package droolScratch;

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
import com.droolscours.CashFlow;
import com.util.KnowledgeSessionHelper;
import com.util.OutputDisplay;

public class TestLession1 {
	StatelessKieSession statelessSession = null;
	KieSession statefullSession = null;
	static KieContainer KieContainer;

	@BeforeClass
	public static void beforeClass() {
		KieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	/*@Test
	public void testFirstOne() {
		statefullSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(KieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		statefullSession.setGlobal("showResults", outputDisplay);
		statefullSession.addEventListener(new RuleRuntimeEventListener() {

			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object updated\n" + event.getObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted\n" + event.getObject().toString());

			}

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object deleted\n" + event.getOldObject().toString());

			}
		});
		Account a = new Account();
		a.setAccountNo(12);
		FactHandle handleA = statefullSession.insert(a);
		a.setAccountNo(10);
		statefullSession.update(handleA, a);
		statefullSession.delete(handleA);
		statefullSession.fireAllRules();
	}
	
	@Test
	public void testFirstTwo() {
		System.out.println("------------------"+this.getClass().getMethods()[0]+"------------------------");
		statefullSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(KieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		statefullSession.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		FactHandle handleA = statefullSession.insert(a);
		System.out.println("First fire all rules");
		statefullSession.fireAllRules();
		System.out.println("Second fire all rules");
		a.setAccountNo(11);
		statefullSession.update(handleA, a);
		statefullSession.fireAllRules();
	}
*/
	@Test
	public void testRuleOneFactThatInsertObject() {
		statefullSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(KieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		statefullSession.setGlobal("showResults", outputDisplay);
		statefullSession.addEventListener(new RuleRuntimeEventListener() {

			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object updated\n" + event.getObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted\n" + event.getObject().toString());

			}

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object deleted\n" + event.getOldObject().toString());

			}
		});
		CashFlow cashFlow = new CashFlow();
		FactHandle handleCash = statefullSession.insert(cashFlow);
		statefullSession.fireAllRules();
	}
}
