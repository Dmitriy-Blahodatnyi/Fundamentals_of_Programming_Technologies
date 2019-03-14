import com.project.evaluator.Evaluator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step extends Steps {
    private Evaluator evaluator;
    private String str;

    @Given("a new evaluator")
    public void newEvaluator() {
        evaluator = new Evaluator();
    }

    @When("I evaluate string $string")
    public void evaluateString(String string) {
        str = evaluator.evaluate(string);
    }

    @Then("I should get result $result")
    public void result(String result) {
        assertEquals(result, str);
    }
}