package droolScratch;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.util.KnowledgeSessionHelper;

public class FirstTry {
	StatelessKieSession statelessSession = null;
	KieSession statefullSession = null;
	static KieContainer KieContainer;

	@BeforeClass
	public static void beforeClass() {
		KieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	@Test
	public void testFirstOne() {
		statefullSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(KieContainer, "ksession-rules");
		statefullSession.fireAllRules();
	}

}
