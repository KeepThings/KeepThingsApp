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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
