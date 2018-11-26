package de.dhbw.students.keepthings;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import de.dhbw.students.keepthings.R;

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
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        dateFromView = findViewById(R.id.date_from_edit);
        calendar = Calendar.getInstance();
        fromYear = calendar.get(Calendar.YEAR);

        fromMonth = calendar.get(Calendar.MONTH);
        fromDay = calendar.get(Calendar.DAY_OF_MONTH);
        dateToView = findViewById(R.id.date_to_edit);
        calendar = Calendar.getInstance();
        toYear = calendar.get(Calendar.YEAR);

        toMonth = calendar.get(Calendar.MONTH);
        toDay = calendar.get(Calendar.DAY_OF_MONTH);

        showFromDate(fromYear, fromMonth + 1, fromDay);
        showToDate(toYear, toMonth + 1, toDay);
    }

    @SuppressWarnings("deprecation")
    public void setFromDate(View view) {
        showDialog(2);
    }

    @SuppressWarnings("deprecation")
    public void setToDate(View view) {
        showDialog(3);
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

    private void showFromDate(int year, int month, int day) {
        if (toYear == year && toMonth + 1 == month && toDay == day) {
            dateFromView.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
            return;
        }
        if (toYear < year) {
            year = toYear;
            month = toMonth + 1;
            day = toDay;
            showToast(R.string.dateFromErrorMessage);
        }
        if (toYear <= year && toMonth + 1 < month) {
            year = toYear;
            month = toMonth + 1;
            day = toDay;
            showToast(R.string.dateFromErrorMessage);
        }
        if (toMonth + 1 <= month && toDay <= day) {
            month = toMonth + 1;
            day = toDay;
            showToast(R.string.dateFromErrorMessage);
        }


        dateFromView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showToDate(int year, int month, int day) {
        if (fromYear == year && fromMonth + 1 == month && fromDay == day) {
            dateToView.setText(new StringBuilder().append(day).append("/")
                    .append(month).append("/").append(year));
            return;
        }
        if (fromYear > year) {
            year = fromYear;
            month = fromMonth + 1;
            day = fromDay;
            showToast(R.string.dateToErrorMessage);
        }
        if (fromYear >= year && fromMonth + 1 > month) {
            year = fromYear;
            month = fromMonth + 1;
            day = fromDay;
            showToast(R.string.dateToErrorMessage);
        }
        if (fromMonth + 1 >= month && fromDay >= day) {
            month = fromMonth + 1;
            day = fromDay;
            showToast(R.string.dateToErrorMessage);
        }


        dateToView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private void showToast(int message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
