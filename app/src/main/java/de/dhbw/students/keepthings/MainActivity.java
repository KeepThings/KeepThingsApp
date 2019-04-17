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
import de.dhbw.students.keepthings.user_item.UserItemEntry;
import de.dhbw.students.keepthings.user_item.UserItemsFragment;
import de.dhbw.students.keepthings.marketplace.MarketplaceFragment;
import de.dhbw.students.keepthings.settings.SettingsActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static TextView textView;
    static ArrayList<String> itemTitle;
    static ArrayList<String> itemPerson;
    static ArrayList<String> itemDateTo;
    static ArrayList<String> itemDateFrom;
    static ArrayList<UserItemEntry> lentOutEntrys;
    private LentOutFragment lentOutFragment;
    private DrawerLayout drawer;
    private boolean isListInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        lentOutFragment = new LentOutFragment();

        navigationView.setCheckedItem(R.id.nav_user_item_list);


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
        lentOutFragment = new LentOutFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.lendoutfragment_container,
                lentOutFragment).commit();
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
            case R.id.nav_user_item_list:
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
