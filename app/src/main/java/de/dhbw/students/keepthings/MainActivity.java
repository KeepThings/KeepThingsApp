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
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    static ArrayList<String> itemTitle;
    static ArrayList<String> itemPerson;
    static ArrayList<String> itemDateTo;
    static ArrayList<String> itemDateFrom;
    static ArrayList<LentOutEntry> lentOutEntrys;
    static TextView textView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lentOutEntrys = new ArrayList<>();

        lentOutEntrys.add(new LentOutEntry("title", "person", "dateTo", "dateFrom"));
        lentOutEntrys.add(new LentOutEntry("Pfanne", "Max Mustermann", "30 Oct 18", "27 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("30 Euro", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Fahrradpumpe", "Max Mustermann", "30 Oct 18", "26 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Fußball", "Max Mustermann", "30 Oct 18", "20 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Taschenlampe", "Max Mustermann", "30 Oct 18", "6 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Zelt", "Max Mustermann", "30 Oct 18", "22 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Kopfhörer", "Max Mustermann", "30 Oct 18", "18 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Kettensäge", "Max Mustermann", "30 Oct 18", "9 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Schraubenzieher", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Biertischgarnitur", "Max Mustermann", "30 Oct 18", "12 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Anhänger", "Max Mustermann", "30 Oct 18", "5 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Wanderstiefel", "Max Mustermann", "30 Oct 18", "17 Oct 18"));
        lentOutEntrys.add(new LentOutEntry("Lautsprecher", "Max Mustermann", "30 Oct 18", "9 Oct 18"));

        itemTitle = new ArrayList<>();
        itemPerson = new ArrayList<>();
        itemDateTo = new ArrayList<>();
        itemDateFrom = new ArrayList<>();

        for (LentOutEntry entry : lentOutEntrys) {
            itemTitle.add(entry.getTitle());
            itemPerson.add(entry.getPerson());
            itemDateTo.add(entry.getDateTo());
            itemDateFrom.add(entry.getDateFrom());

        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.draw_layout_main);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.lendoutfragment_container,
                new LendOutFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_lend_out_list);

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
                getSupportFragmentManager().beginTransaction().replace(R.id.lendoutfragment_container,
                        new LendOutFragment()).commit();
                break;
            case R.id.nav_marketplace:
                getSupportFragmentManager().beginTransaction().replace(R.id.lendoutfragment_container,
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
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
