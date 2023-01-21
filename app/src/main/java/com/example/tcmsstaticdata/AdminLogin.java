package com.example.tcmsstaticdata;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class AdminLogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//Arslan app static
    private AppCompatImageView menuIcon;
    private DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));


        menuIcon = findViewById(R.id.acivIcon);
        drawerLayout = findViewById(R.id.drawerlayout);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.account_navigation_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);

        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case  R.id.nav_dash:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentContainer, DashboardFragment.newInstance());
                        fragmentTransaction.addToBackStack("dash");
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction.commit();
                        break;
                    case  R.id.nav_account:

                       // FragmentManager frahM = getSupportFragmentManager();
                      //  frahM.beginTransaction().replace(R.id.fragmentContainer, AccountFragment1.class, null)
                               // .setReorderingAllowed(true)
                              //  .addToBackStack("main").commit();

                       FragmentManager fragmentManager1 = getSupportFragmentManager();
                       fragmentManager1.beginTransaction().
                               replace(R.id.fragmentContainer, AccountFragment1.newInstance())
                               .addToBackStack("main").commit();

                 /*       FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.fragmentContainer, AccountFragment1.newInstance());
                        fragmentTransaction1.addToBackStack("account");
                        fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction1.commit(); */
                        break;
                }
                return true;
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, DashboardFragment.newInstance());
        fragmentTransaction.addToBackStack("dash");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //
        int id = menuItem.getItemId();
        if (id == R.id.nav_refer) {
            getSupportFragmentManager().beginTransaction().replace(R.id.drawerlayout,
                    new NavFragment()).commit();
        }
        return false;
    }
}