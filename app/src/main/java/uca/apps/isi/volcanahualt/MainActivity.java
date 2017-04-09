package uca.apps.isi.volcanahualt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uca.apps.isi.volcanahualt.api.Api;
import uca.apps.isi.volcanahualt.api.ApiInterface;
import uca.apps.isi.volcanahualt.fragments.ActividadesFragment;
import uca.apps.isi.volcanahualt.fragments.CercaDeMiFragment;
import uca.apps.isi.volcanahualt.fragments.CreditosFragment;
import uca.apps.isi.volcanahualt.fragments.GuiaTuristicaFragment;
import uca.apps.isi.volcanahualt.fragments.HomeFragment;
import uca.apps.isi.volcanahualt.fragments.VolcanesFragment;
import uca.apps.isi.volcanahualt.models.Volcan;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


            private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getData();
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

   @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
      Fragment fragment = null;
      Class fragmentClass = null;
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
          fragmentClass = HomeFragment.class;
        }

        else if (id == R.id.nav_volcanes){
          fragmentClass = VolcanesFragment.class;
        }

        else if (id == R.id.nav_actividades) {
          fragmentClass = ActividadesFragment.class;

        } else if (id == R.id.nav_guiaT) {
          fragmentClass = GuiaTuristicaFragment.class;

        } else if (id == R.id.nav_cercademi) {
          fragmentClass = CercaDeMiFragment.class;

        } else if (id == R.id.nav_creditos) {
          fragmentClass = CreditosFragment.class;

        }
      try {
        fragment = (Fragment) fragmentClass.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
      } catch (Exception e) {
        e.printStackTrace();
      }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void getData() {
        Call<List<Volcan>> call = Api.instance().getVolcanes();
        call.enqueue(new Callback<List<Volcan>>() {
            @Override
            public void onResponse(Call<List<Volcan>> call, Response<List<Volcan>> response) {
                if (response != null) {
                    for(Volcan volcan : response.body()) {
                        Log.i(TAG, volcan.getText());
                    }
                }
                else {
                    Log.i(TAG, "La respuesta es incorrecta");
                }
            }

            @Override
            public void onFailure(Call<List<Volcan>> call, Throwable throwable) {
                Log.e(TAG, throwable.getMessage());
            }
        });

    }

}
