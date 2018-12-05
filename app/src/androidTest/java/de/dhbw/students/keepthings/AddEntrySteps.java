package de.dhbw.students.keepthings;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import de.dhbw.students.keepthings.new_lent_out_entry.NewLentOutEntryActivity;
public class AddEntrySteps extends GreenCoffeeSteps
{
    private static final String ITEMNAME = "a cool thing";
    private static final String PERSON = "Testbody";
    private static final String DATEFROM = "06-12-2018";
    private static final String DATETO = "08-12-2018";


    @When("^I introduce a personn$")
    public void iIntroduceAPersonWhen()
    {
        onViewWithId(R.id.person_add).type(PERSON);
    }
    @When("^I introduce a itemNamee$")
    public void iIntroduceAItemNameWhen()
    {
        onViewWithId(R.id.title_add).type(ITEMNAME);
    }
    @And("^I introduce a person$")
    public void iIntroduceAPersonAdd()
    {
        onViewWithId(R.id.person_add).type(PERSON);
    }
    @And("^I introduce a itemName$")
    public void iIntroduceAItemNameAdd()
    {
        onViewWithId(R.id.title_add).type(ITEMNAME);
    }
    @And("^I introduce a dateFrom$")
    public void iIntroduceADateFromAdd()
    {
        onViewWithId(R.id.item_datefrom).click();
    }
    @And("^I introduce a dateTo$")
    public void iIntroduceADateToAdd()
    {
        onViewWithId(R.id.item_dateto).click();
    }
    @And("^I press the submit button$")
    public void iPressTheSubmitButton()
    {
        onViewWithId(R.id.button_add_entry).click();
    }
    @Then("^I see an error message saying 'Title can't be empty'$")
    public void iSeeAnErrorMessageSayingTitelCantBeEmpty()
    {
        onView(withText("Title can't be empty")).check(matches(isDisplayed()));
    }
    @Then("^I see an error message saying 'Person can't be empty'$")
    public void iSeeAnErrorMessageSayingPersonCantBeEmpty()
    {
        onView(withText("Person can't be empty")).check(matches(isDisplayed()));
    }
    @Then("^I see an error message saying 'Please select a date before the end date.'$")
    public void iSeeAnErrorMessageSayingPleaseSelectAdateBeforeTheEndDate()
    {
        onView(withText("Please select a date before the end date.")).check(matches(isDisplayed()));
    }
    @Then("^I see an error message saying 'Please select a date after the start date.'$")
    public void iSeeAnErrorMessageSayingPleaseSelectAdateAfterTheStartDate()
    {
        onView(withText("Please select a date after the start date.")).check(matches(isDisplayed()));
    }
    @Then("^I see an message saying 'Successly delivered the data!'$")
    public void iSeeAnErrorMessageSayingSuccesslyDeliveredTheData()
    {
        onView(withText("Successly delivered the data!")).check(matches(isDisplayed()));
    }
}