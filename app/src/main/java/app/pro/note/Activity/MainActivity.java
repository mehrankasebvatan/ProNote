package app.pro.note.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import app.pro.note.Fragment.CategoryFragment;
import app.pro.note.Fragment.FavoriteFragment;
import app.pro.note.Fragment.HomeFragment;
import app.pro.note.Fragment.ProfileFragment;
import app.pro.note.R;

public class MainActivity extends AppCompatActivity {

    ImageView img_menu;
    NavigationView nv_main;
    DrawerLayout dl_main;
    ChipNavigationBar nb_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cast();
        onClick();
        navigation();
        battomBar();


    }

    private void cast() {

        img_menu = findViewById(R.id.img_menu);
        nv_main = findViewById(R.id.nv_main);
        dl_main = findViewById(R.id.dl_main);
        nb_main = findViewById(R.id.nb_main);

    }

    private void onClick() {
    }

    private void navigation() {

        img_menu.setOnClickListener(view -> {
            if (dl_main.isDrawerOpen(Gravity.RIGHT)) {
                dl_main.closeDrawers();
            } else {
                dl_main.openDrawer(Gravity.RIGHT);
            }
        });

        nv_main.bringToFront();
        nv_main.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id) {


                }
                return false;
            }
        });


    }


    private void battomBar() {

        nb_main.setItemSelected(R.id.nb_home, true);
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, homeFragment);
        fragmentTransaction.commit();

        nb_main.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                if (i == R.id.nb_home) {
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, homeFragment);
                    fragmentTransaction.commit();
                }

                if (i == R.id.nb_category) {
                    CategoryFragment categoryFragment = new CategoryFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, categoryFragment);
                    fragmentTransaction.commit();
                }

                if (i == R.id.nb_favorite) {
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, favoriteFragment);
                    fragmentTransaction.commit();
                }

                if (i == R.id.nb_profile) {
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fl_main, profileFragment);
                    fragmentTransaction.commit();
                }
            }
        });

    }


    @SuppressLint("RtlHardcoded")
    @Override
    public void onBackPressed() {

        if (dl_main.isDrawerOpen(Gravity.RIGHT)) {
            dl_main.closeDrawers();
        } else {
            finish();
        }

    }


}