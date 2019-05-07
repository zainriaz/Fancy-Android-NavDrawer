package project.mca.fancydrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.infideap.drawerbehavior.Advance3DDrawerLayout;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Advance3DDrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = findViewById(R.id.drawer_layout);
        drawer.useCustomBehavior(Gravity.END); //assign custom behavior for "Right" drawer

        // customisation of the drawer
        drawer.setViewRotation(Gravity.END, 15); // set degree of Y-rotation ( value : 0 -> 45)
        drawer.setViewScale(Gravity.END, 1f); //set height scale for main view (0f to 1f)
        drawer.setViewElevation(Gravity.END, 20); //set main view elevation when drawer open (dimension)
        drawer.setViewScrimColor(Gravity.END, Color.TRANSPARENT); //set drawer overlay (color)
        drawer.setDrawerElevation(Gravity.END, 20); //set drawer elevation (dimension)
        drawer.setRadius(Gravity.END, 25); //set end container's corner radius (dimension)

        // setting NavigationView menu item click listener
        NavigationView navigationView = findViewById(R.id.nav_view_notification);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings_menu_item) {
            // open the right navigation drawer

            drawer.openDrawer(Gravity.END, true);
        }
        return true;
    }



    // handling navigation menu item clicks here...
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_language) {
            Toast.makeText(this, "Change language", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_theme) {
            Toast.makeText(this, "Change Theme", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_about) {
            Toast.makeText(this, "About e-panjeeyan", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_help) {
            Toast.makeText(this, "Help Dany!", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.nav_logout) {
            Toast.makeText(this, "Logout user", Toast.LENGTH_SHORT).show();
        }

        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}
