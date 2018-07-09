package dhamraj.jindal.tourism;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationDrawer extends AppCompatActivity  {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
TabLayout tabLayout;
PagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        navigationView=(NavigationView)findViewById(R.id.navigation);
        toolbar=(Toolbar)findViewById(R.id.home_toolbar);
        tabLayout=(TabLayout)findViewById(R.id.custom_tablayout);
        ViewPager viewPager=(ViewPager)findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);
        adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "Home");
        adapter.addFragment(new Tab2(),"Places to Visit");
        viewPager.setAdapter(adapter);
        Intent i=getIntent();
        String a=i.getStringExtra("NAME_KEY");
        toolbar.setTitle("WELCOME, "+a);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorsetting));
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(NavigationDrawer.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.feedback:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent i=new Intent(NavigationDrawer.this,Feedback.class);
                        finish();
                        startActivity(i);
                        break;
                    case R.id.logout_navigation:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent ic=new Intent(NavigationDrawer.this,Login.class);
                        startActivity(ic);
                        finish();
                        Toast.makeText(NavigationDrawer.this,"LOGOUT SUCCESS",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent shareintent=new Intent(Intent.ACTION_SEND);
                        shareintent.setType("text/plain");
                        String tosend="hey! check out this app by taking it from me.";
                        shareintent.putExtra(Intent.EXTRA_TEXT,tosend);
                        startActivity(Intent.createChooser(shareintent,"Share Via"));
                        break;
                    case R.id.contact:
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://chandigarhtourism.gov.in/Chandigarh%20Tourism%20-%20contact.htm"));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                            }
                            else{
                            Toast.makeText(NavigationDrawer.this,"UNABLE TO SHOW",Toast.LENGTH_SHORT).show();

                        }
                    break;
                }
                return true;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.logout:
                Intent i=new Intent(NavigationDrawer.this, Login.class);
                startActivity(i);
                finish();
                Toast.makeText(NavigationDrawer.this,"LOGOUT SUCCESS",Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutapp:
                AlertDialog.Builder dialog=new AlertDialog.Builder(NavigationDrawer.this);
                dialog.setTitle("ABOUT APP");
                dialog.setMessage("APP NAME: CHANDIGARH TOURISM"+"\n"+"APP VERSION: 1.0.0"+"\n"+"CONTACT: 7528917766(DEVELOPER)"+"\n"+"WEB ADDRESS: http://chandigarhtourism.gov.in/index.html");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;
            case R.id.close:
                finish();
                Toast.makeText(NavigationDrawer.this,"CLOSE SUCCESSFUL",Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


}
