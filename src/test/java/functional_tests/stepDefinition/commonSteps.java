package functional_tests.stepDefinition;

import cucumber.api.java.After;
import functional_tests.automationFramework.Framework;

import java.io.IOException;

/**
 * Created by aparnajammula on 4/27/16.
 */
public class commonSteps extends Framework{

    boolean HeadlessDriverFlag;

    @After
    public void cleanup(cucumber.api.Scenario scenario) throws IOException {
        try {
            if (scenario.isFailed()) {
                System.out.print(">>>SCENARIO FAILURE<<<: '"+scenario.getName()+"'");
                if (HeadlessDriverFlag == false){SaveScreenShot(scenario.getName());}
            }
        }
        catch (RuntimeException e){
            throw new RuntimeException(e);
        }
        finally {
            driverquit(HeadlessDriverFlag);
        }
    }
}
