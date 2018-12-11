package de.dhbw.students.keepthings.new_lent_out_entry;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Calendar;

import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.api.ApiCommands;

public class NewLentOutEntryActivity extends AppCompatActivity {

    private Calendar calendar;
    private TextView dateFromView, dateToView;
    private int fromYear, fromMonth, fromDay, toYear, toMonth, toDay;
    private DatePickerDialog.OnDateSetListener myFromDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    fromYear = arg1;
                    fromMonth = arg2;
                    fromDay = arg3;
                    showFromDate(arg1, arg2 + 1, arg3);
                }
            };
    private DatePickerDialog.OnDateSetListener myToDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    toYear = arg1;
                    toMonth = arg2;
                    toDay = arg3;
                    showToDate(arg1, arg2 + 1, arg3);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        Toolbar toolbar = findViewById(R.id.toolbar_new_entry);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });

        dateFromView = findViewById(R.id.date_from_add);
        calendar = Calendar.getInstance();
        fromYear = calendar.get(Calendar.YEAR);
        fromMonth = calendar.get(Calendar.MONTH)+1;
        fromDay = calendar.get(Calendar.DAY_OF_MONTH);

        dateToView = findViewById(R.id.date_to_add);
        calendar = Calendar.getInstance();
        toYear = calendar.get(Calendar.YEAR);
        toMonth = calendar.get(Calendar.MONTH)+1;
        toDay = calendar.get(Calendar.DAY_OF_MONTH);

        showFromDate(fromYear, fromMonth , fromDay);
        showToDate(toYear, toMonth , toDay);
    }

    @SuppressWarnings("deprecation")
    public void setFromDate(View view) {
        showDialog(2);
    }

    @SuppressWarnings("deprecation")
    public void setToDate(View view) {
        showDialog(3);
    }


    public void submit(View view) {
        EditText title = findViewById(R.id.title_add);
        EditText person = findViewById(R.id.person_add);
        EditText desc = findViewById(R.id.desc_add);
        TextView dateFrom = findViewById(R.id.date_from_add);
        TextView dateTo = findViewById(R.id.date_to_add);

        String[] tempdate = dateFrom.getText().toString().split("-");
        fromDay = Integer.parseInt(String.valueOf(tempdate[0]));
        fromMonth = Integer.parseInt(String.valueOf(tempdate[1]));
        fromYear = Integer.parseInt(String.valueOf(tempdate[2]));
        tempdate = dateTo.getText().toString().split("-");
        toDay = Integer.parseInt(String.valueOf(tempdate[0]));
        toMonth = Integer.parseInt(String.valueOf(tempdate[1]));
        toYear = Integer.parseInt(String.valueOf(tempdate[2]));

        if (title.getText().toString().equals("")) {
            title.setError("Title can't be empty");
            title.requestFocus();
            return;
        }
        if (person.getText().toString().equals("")) {
            person.setError("Person can't be empty");
            person.requestFocus();
            return;
        }
        if (!showFromDate(fromYear, fromMonth, fromDay)){
            dateFromView.setError(getString(R.string.dateFromErrorMessage));
            dateFromView.requestFocus();
            return;
        }
        if (!showToDate(toYear, toMonth, toDay)){
            dateToView.setError(getString(R.string.dateToErrorMessage));
            dateToView.requestFocus();
            return;
        }
        ApiCommands.addEntry(title.getText().toString(), desc.getText().toString(), 2, person.getText().toString(), parseDate(dateFrom.getText().toString()), parseDate(dateTo.getText().toString()), this);
        onBackPressed();
    }

    public String parseDate(String date) {
        String[] dateSplit = date.split("-");
        if (dateSplit.length != 3) {
            return "";
        }
        StringBuilder dateReverse = new StringBuilder();
        dateReverse.append(dateSplit[2]);
        dateReverse.append("-");
        dateReverse.append(dateSplit[1]);
        dateReverse.append("-");
        dateReverse.append(dateSplit[0]);
        return dateReverse.toString();
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        if (id == 2) {
            return new DatePickerDialog(this,
                    myFromDateListener, fromYear, fromMonth, fromDay);
        }
        if (id == 3) {
            return new DatePickerDialog(this,
                    myToDateListener, toYear, toMonth, toDay);
        }
        return null;
    }

    private boolean showFromDate(int year, int month, int day) {
        boolean result = true;
        dateFromView.setError(null);
        if (toYear == year && toMonth == month && toDay == day) {
            dateFromView.setText(new StringBuilder().append(day).append("-")
                    .append(month).append("-").append(year));
            return true;
        }
        if (toYear < year) {
            result = false;

        }
        if (toYear <= year && toMonth< month) {
            result = false;
        }
        if (toYear <= year && toMonth<= month && toDay < day) {
            result = false;
        }
        dateFromView.setText(new StringBuilder().append(day).append("-")
                .append(month).append("-").append(year));
        hideKeyboard(this);
        return result;
    }

    private boolean showToDate(int year, int month, int day) {
        boolean result = true;
        dateToView.setError(null);
        if (fromYear == year && fromMonth == month && fromDay == day) {
            dateToView.setText(new StringBuilder().append(day).append("-")
                    .append(month).append("-").append(year));
            return true;
        }
        if (fromYear > year) {
            result = false;

        }
        if (fromYear >= year && fromMonth> month) {
            result = false;

        }
        if (fromYear >= year && fromMonth>= month && fromDay > day) {
            result = false;

        }
        dateToView.setText(new StringBuilder().append(day).append("-")
                .append(month).append("-").append(year));
        hideKeyboard(this);
        return result;
    }

    public void showToast(int message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
