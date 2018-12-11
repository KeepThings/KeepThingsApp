package de.dhbw.students.keepthings;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.And;
import com.mauriciotogneri.greencoffee.annotations.Given;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
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
    private static final String DATEFROM = "14-12-2018";
    private static final String DATETO = "18-12-2018";
    private static final String INVALID_DATETO = "10-12-2018";
    private static final String INVALID_DATEFROM = "22-12-2018";

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
    public void iIntroduceADateFromAdd() { onViewWithId(R.id.date_from_add).clearText();onViewWithId(R.id.date_from_add).type(DATEFROM); }
    @And("^I introduce a dateTo$")
    public void iIntroduceADateToAdd() { closeSoftKeyboard();onViewWithId(R.id.date_to_add).clearText();onViewWithId(R.id.date_to_add).type(DATETO); }
    @And("^I introduce a invalid dateFrom$")
    public void iIntroduceAInvalidDateFromAdd() { onViewWithId(R.id.date_from_add).clearText();onViewWithId(R.id.date_from_add).type(INVALID_DATEFROM); }
    @And("^I introduce a invalid dateTo$")
    public void iIntroduceAInvalidDateToAdd() { closeSoftKeyboard();onViewWithId(R.id.date_to_add).clearText();onViewWithId(R.id.date_to_add).type(INVALID_DATETO); }
    @And("^I press the submit button$")
    public void iPressTheSubmitButton() { closeSoftKeyboard();onViewWithId(R.id.button_add_entry).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Then("^I see an error message saying 'Title can't be empty'$")
    public void iSeeAnErrorMessageSayingTitelCantBeEmpty()
    {
        onViewWithId(R.id.title_add).check(matches(hasErrorText("Title can't be empty")));
    }
    @Then("^I see an error message saying 'Person can't be empty'$")
    public void iSeeAnErrorMessageSayingPersonCantBeEmpty()
    {
        onViewWithId(R.id.person_add).check(matches(hasErrorText("Person can't be empty")));
    }
    @Then("^I see an error message saying 'Please select a date before the end date.'$")
    public void iSeeAnErrorMessageSayingPleaseSelectAdateBeforeTheEndDate()
    {
        onViewWithId(R.id.date_from_add).check(matches(hasErrorText("Please select a date before the end date.")));
    }
    @Then("^I see an error message saying 'Please select a date after the start date.'$")
    public void iSeeAnErrorMessageSayingPleaseSelectAdateAfterTheStartDate()
    {
        onViewWithId(R.id.date_to_add).check(matches(hasErrorText("Please select a date after the start date.")));
    }
    @Then("^I see an message saying 'Successly delivered the data!'$")
    public void iSeeAnErrorMessageSayingSuccesslyDeliveredTheData()
    {
        //onViewWithId(R.id.person_add).check(matches(hasErrorText("Successly delivered the data!")));
        //onView(withText("Successly delivered the data!")).check(matches(isDisplayed()));
    }
}