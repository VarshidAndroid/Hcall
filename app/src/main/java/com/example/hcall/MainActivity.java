package com.example.hcall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hcall.Fragment.CampaignFragment;
import com.example.hcall.Fragment.CampaignListFragment;
import com.example.hcall.Fragment.ReportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout about,report,notification,edit_Profile,Privacy_policy,Help,Home,Logout;

    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;
    private Object CampaignFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConstraintLayout headerImageView= (ConstraintLayout) findViewById(R.id.drawer_header);





        init();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    private void init() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        //navigationView.setNavigationItemSelectedListener(MainActivity.this);
        View headerView = navigationView.getHeaderView(0);

        about=headerView.findViewById(R.id.constraintLayout9);
        report=headerView.findViewById(R.id.constraintLayout4);
        notification=headerView.findViewById(R.id.constraintLayout5);
        edit_Profile=headerView.findViewById(R.id.constraintLayout6);
        Privacy_policy=headerView.findViewById(R.id.constraintLayout7);
        Help=headerView.findViewById(R.id.constraintLayout8);
        Home=headerView.findViewById(R.id.constraintLayout3);
        Logout=headerView.findViewById(R.id.ass);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AboutUs.class));
            }
        });
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReportFragment.class);
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ReportFragment.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Notification.class));
            }
        });
        edit_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Edit_Profile.class));
            }
        });
        Privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Privacy_Policy.class));
            }
        });
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Help.class));
            }
        });







        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.CustomAlertDialog);
                ViewGroup viewGroup = v.findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.custom_dialog, viewGroup, false);
                Button buttonOk=dialogView.findViewById(R.id.cancle_btn);
                Button buttonyes = dialogView.findViewById(R.id.button_Logout);

                builder.setView(dialogView);
                final AlertDialog alertDialog = builder.create();
                buttonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                buttonyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent= new Intent(MainActivity.this,Splash.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
                alertDialog.show();


            }

        });

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        navController = Navigation.findNavController(this,R.id.host_main);
        appBarConfiguration = new AppBarConfiguration.Builder(new int[]{R.id.campaign,R.id.report})
                .setDrawerLayout(drawer)
                .build();

    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration );




    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        if (SharedPrefsUtils.getSharedPreferenceString(getApplicationContext(), "back").equalsIgnoreCase("0.0")) {
                SharedPrefsUtils.setSharedPreferenceString(getApplicationContext(), "back", "0");
                pushFragment(new CampaignFragment(), "CampaignFragment");
            } else if (SharedPrefsUtils.getSharedPreferenceString(getApplicationContext(), "back").equalsIgnoreCase("0.1")) {
                SharedPrefsUtils.setSharedPreferenceString(getApplicationContext(), "back", "0");
                pushFragment(new CampaignListFragment(), "CampaignListFragment");

            } else {
                finish();
            }
        }







    public boolean pushFragment(Fragment fragment, String tag) {

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.feed_in, R.anim.feed_out)
                    .replace(R.id.host_main, fragment, tag)
                    //.addToBackStack("fragment")
                    .commit();
            return true;
        }
        return false;
    }
}
