package WalenskiCorp.BDD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

class checkColorOfShoes {
    static String isItThatColor(String IsIt){
        if (IsIt.equals("Seledynowy")) {
            return "Yes";
        }
        return "No";
    }
}

public class StepIsItSeledynowy {

    String kajetColor;
    String respond;

    @Given("this is {string}")
    public void this_is(String col) {
        this.kajetColor = col;
    }

    @When("I ask are you sure I's Seledynowy")
    public void i_ask_are_you_sure_I_s_Seledynowy() {
        this.respond = checkColorOfShoes.isItThatColor(kajetColor);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedColor) {
        assertEquals(expectedColor, respond);
    }

}