package dhamraj.jindal.tourism;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class LazerValey extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazer_valey);
        toolbar=(Toolbar)findViewById(R.id.valley_toolbar);
        toolbar.setTitle("LazerValley");
        toolbar.setTitleTextColor(getResources().getColor(R.color.color));
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.location,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        switch (item.getItemId()){
            case R.id.placed:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:30.7532847,76.7899045"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
