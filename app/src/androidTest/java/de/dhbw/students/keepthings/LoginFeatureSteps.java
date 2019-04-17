package de.dhbw.students.keepthings;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
public class LoginFeatureSteps extends GreenCoffeeSteps
{
    private static final String INVALID_EMAIL = "guest";
    private static final String INVALID_PASSWORD = "5678";
    private static final String VALID_EMAIL = "guest@gamil.com";
    private static final String VALID_PASSWORD = "5678afsssaf";
    private static final String CORRECT_EMAIL = "Test@Test.de";
    private static final String CORRECT_PASSWORD = "123456789";

    @Given("^I see an empty login form$")
    public void iSeeAnEmptyLoginForm()
    {
        onViewWithId(R.id.email).isEmpty();
        onViewWithId(R.id.password).isEmpty();
    }
    @When("^I introduce an invalid email$")
    public void iIntroduceAnInvalidemail()
    {
        onViewWithId(R.id.email).type(INVALID_EMAIL);
    }
    @When("^I introduce an valid email$")
    public void iIntroduceAnvalidemail()
    {
        onViewWithId(R.id.email).type(VALID_EMAIL);
    }
    @When("^I introduce an invalid password$")
    public void iIntroduceAnInvalidPassword()
    {
        onViewWithId(R.id.password).type(INVALID_PASSWORD);
    }
    @When("^I introduce an valid password$")
    public void iIntroduceAnvalidPassword()
    {
        onViewWithId(R.id.password).type(VALID_PASSWORD);
    }
    @When("^I introduce an correct email$")
    public void iIntroduceAnCorrectEmail()
    {
        onViewWithId(R.id.email).type(CORRECT_EMAIL);
    }
    @When("^I introduce an correct password$")
    public void iIntroduceAnCorrectPassword()
    {
        onViewWithId(R.id.password).type(CORRECT_PASSWORD);
    }
    @When("^I press the login button$")
    public void iPressTheLoginButton()
    {
        onViewWithId(R.id.email_sign_in_button).click();
    }
    @Then("^I see an error message saying 'This email address is invalid'$")
    public void iSeeAnErrorMessageSayingInvalidEmail()
    {
        onViewWithId(R.id.email).check(matches(hasErrorText("This email address is invalid")));
    }
    @Then("^I see an error message saying 'This password is too short'$")
    public void iSeeAnErrorMessageSayingShortPassword()
    {
        onViewWithId(R.id.password).check(matches(hasErrorText("This password is incorrect")));
    }
    @Then("^I see an error message saying 'This password is incorrect'$")
    public void iSeeAnErrorMessageSayingInvalidPassword()
    {
        onViewWithId(R.id.password).check(matches(hasErrorText("This password is incorrect")));
    }
    @Then("^I see an error message saying 'This field is required'$")
    public void iSeeAnErrorMessageSayingFieldRequired()
    {
        onViewWithId(R.id.email).check(matches(hasErrorText("This field is required")));
    }
    @Then("^I am logged in$")
    public void iAmLoggedIn()
    {
        try {Thread.sleep(500);} catch (Exception e) {}
        onViewWithId(R.id.draw_layout_main).isDisplayed();
    }
}