package ru.mydomain.raspisanieusatu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import ru.mydomain.raspisanieusatu.adapter.TabsFragmentAdapter;

/**
 * Created by TotAll on 11.07.2016.
 */
public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_main;

    private String Theme;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    String FileText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        Theme = "Default";
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);


        initToolbar();
        initNavigatonView();
        initTabs();

    }

    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
    }


    private void initTabs() {
        TabLayout tabLayout;
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }



    private void initNavigatonView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open,R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.actionNotificationItem:
                        showNatificationTab();
                        break;
                    case R.id.changetheme:
                        changetheme();

                        break;
                }

                return true;
            }
        });

    }

    private void changetheme() {
        if (Theme == "Default"){
        setTheme(R.style.AppRed);
            Toast.makeText( getApplicationContext(),"2",Toast.LENGTH_LONG).show();
        Theme = "Red";}
        if (Theme == "Red"){
            setTheme( R.style.AppDefault );
        }

    }

    private void showNatificationTab(){
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }
}


