package dhamraj.jindal.tourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
Toolbar toolbar;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        toolbar=(Toolbar)findViewById(R.id.feedback_toolbar);
        toolbar.setTitle("Feedback Page");
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorsetting));
        setSupportActionBar(toolbar);
        button=(Button)findViewById(R.id.feedback_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Feedback.this,"THANK'S FOR FEEDBACK",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Feedback.this,NavigationDrawer.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
