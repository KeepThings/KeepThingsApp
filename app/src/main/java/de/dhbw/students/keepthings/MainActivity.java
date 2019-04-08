package de.dhbw.students.keepthings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import de.dhbw.students.keepthings.api.ApiCommands;
import de.dhbw.students.keepthings.main.UserItemEntry;
import de.dhbw.students.keepthings.main.UserItemsFragment;
import de.dhbw.students.keepthings.marketplace.MarketplaceFragment;
import de.dhbw.students.keepthings.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static TextView textView;
    static ArrayList<String> itemTitle;
    static ArrayList<String> itemPerson;
    static ArrayList<String> itemDateTo;
    static ArrayList<String> itemDateFrom;
    static ArrayList<UserItemEntry> lentOutEntrys;
    private DrawerLayout drawer;
    private boolean isListInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lentOutEntrys = new ArrayList<>();

        lentOutEntrys.add(new UserItemEntry("title", "person", "dateTo", "dateFrom"));
        lentOutEntrys.add(new UserItemEntry("Pfanne", "Max Mustermann", "30 Oct 18", "27 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("30 Euro", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Fahrradpumpe", "Max Mustermann", "30 Oct 18", "26 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Fußball", "Max Mustermann", "30 Oct 18", "20 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Taschenlampe", "Max Mustermann", "30 Oct 18", "6 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Zelt", "Max Mustermann", "30 Oct 18", "22 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Kopfhörer", "Max Mustermann", "30 Oct 18", "18 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Kettensäge", "Max Mustermann", "30 Oct 18", "9 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Schraubenzieher", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Biertischgarnitur", "Max Mustermann", "30 Oct 18", "12 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Anhänger", "Max Mustermann", "30 Oct 18", "5 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Wanderstiefel", "Max Mustermann", "30 Oct 18", "17 Oct 18"));
        lentOutEntrys.add(new UserItemEntry("Lautsprecher", "Max Mustermann", "30 Oct 18", "9 Oct 18"));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.draw_layout_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ApiCommands.getUserItems("1", this);


        navigationView.setCheckedItem(R.id.nav_lend_out_list);


    }

    public void setFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.user_item_fragment_container,
                new UserItemsFragment()).commit();
        isListInit = true;
    }

    public void setItems(ArrayList<UserItemEntry> lentOutEntrys) {
        itemTitle = new ArrayList<>();
        itemPerson = new ArrayList<>();
        itemDateTo = new ArrayList<>();
        itemDateFrom = new ArrayList<>();

        for (UserItemEntry entry : lentOutEntrys) {
            itemTitle.add(entry.getTitle());
            itemPerson.add(entry.getPerson());
            itemDateTo.add(entry.getDateTo());
            itemDateFrom.add(entry.getDateFrom());

        }
    }

    public boolean isListInit() {
        return isListInit;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_lend_out_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.user_item_fragment_container,
                        new UserItemsFragment()).commit();
                break;
            case R.id.nav_marketplace:
                getSupportFragmentManager().beginTransaction().replace(R.id.user_item_fragment_container,
                        new MarketplaceFragment()).commit();
                break;
            case R.id.nav_wordpress:
                String wordpressUrl = "https://keepthingsnlb.wordpress.com/";
                Intent wordpressIntent = new Intent();
                wordpressIntent.setAction(Intent.ACTION_VIEW);
                wordpressIntent.setData(Uri.parse(wordpressUrl));
                startActivity(wordpressIntent);
                break;
            case R.id.nav_github:
                String githubUrl = "https://github.com/KeepThings/";
                Intent githubIntent = new Intent();
                githubIntent.setAction(Intent.ACTION_VIEW);
                githubIntent.setData(Uri.parse(githubUrl));
                startActivity(githubIntent);
                break;
            case R.id.nav_settings:
                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
