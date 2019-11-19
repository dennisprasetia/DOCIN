package com.wonokoyo.docin.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.ArraySet;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.wonokoyo.docin.R;
import com.wonokoyo.docin.model.viewmodel.DocViewModel;
import com.wonokoyo.docin.model.viewmodel.VoadipViewModel;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavController navController;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private AppBarConfiguration appBarConfig;

    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.fragment_container), appBarConfig) ||
                super.onSupportNavigateUp();
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
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void setupNavigation() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        navController = Navigation.findNavController(this, R.id.fragment_container);

        final Set<Integer> topLevelDestinations = new ArraySet<>();
        topLevelDestinations.add(R.id.nav_home);
        topLevelDestinations.add(R.id.nav_planning);
        topLevelDestinations.add(R.id.nav_bap_doc);
        topLevelDestinations.add(R.id.nav_bpb_voadip);
        topLevelDestinations.add(R.id.nav_contact);
        topLevelDestinations.add(R.id.nav_setting);

        appBarConfig = new AppBarConfiguration.Builder(topLevelDestinations)
                .setDrawerLayout(drawer)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        NavigationUI.setupWithNavController(navigationView, navController);

        tvUser = navigationView.getHeaderView(0).findViewById(R.id.tvUser);
        tvUser.setText(getIntent().getStringExtra("username"));
    }

    public DocViewModel getDocViewModel() {
        return ViewModelProviders.of(this).get(DocViewModel.class);
    }

    public VoadipViewModel getVoadipViewModel() {
        return ViewModelProviders.of(this).get(VoadipViewModel.class);
    }
}
