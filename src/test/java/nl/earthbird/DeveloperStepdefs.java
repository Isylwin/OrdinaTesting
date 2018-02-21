package nl.earthbird;

import cucumber.api.java8.En;
import org.junit.Assert;

public class DeveloperStepdefs implements En {
    private Developer sut;
    private String result;

    public DeveloperStepdefs() {
        Given("^I am a java developer$", () -> {
            sut = new Developer("Henk");
        });
        When("^I write code$", () -> {
            result = sut.writeCode();
        });
        Then("^I want it tested$", () -> {
            Assert.assertEquals("Code, code, code, code, code, code, code", result);
        });
    }
}
