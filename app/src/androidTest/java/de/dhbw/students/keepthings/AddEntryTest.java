package de.dhbw.students.keepthings;

import android.support.test.rule.ActivityTestRule;

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig;
import com.mauriciotogneri.greencoffee.GreenCoffeeTest;
import com.mauriciotogneri.greencoffee.ScenarioConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.IOException;
import de.dhbw.students.keepthings.new_lent_out_entry.NewLentOutEntryActivity;

@RunWith(Parameterized.class)
public class AddEntryTest extends GreenCoffeeTest
{
    @Rule
    public ActivityTestRule<NewLentOutEntryActivity> activity = new ActivityTestRule<>(NewLentOutEntryActivity.class);

    public AddEntryTest(ScenarioConfig scenarioConfig)
    {
        super(scenarioConfig);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<ScenarioConfig> scenarios() throws IOException
    {
        return new GreenCoffeeConfig()
                .withFeatureFromAssets("assets/addEntry.feature")
                .scenarios(
                        //new Locale("en", "GB")
                ); // the locales used to run the scenarios (optional)
    }

    @Test
    public void test()
    {
        start(new AddEntrySteps());
    }
}