package rmutsb.mook.chatchon.makingfavorcoffee;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import rmutsb.mook.chatchon.makingfavorcoffee.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;

//    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NavigationView ActionBar
//        mToolbar = (Toolbar) findViewById(R.id.nav_action);
//        setSupportActionBar(mToolbar);
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Add Fragment to Activity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment())
                    .commit();
        }
    } //Main Method

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {

//        if (mToggle.onOptionsItemSelected(item)){
//            return true;
//        }

//        return super.onOptionsItemSelected(item);
//    }
} //Main Class
