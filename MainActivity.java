package dhamraj.jindal.tourism;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech toSpeech;
    Toolbar toolbar;
    String text="CLICK ON IMAGE TO CONTINUE";
 ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Chandigarh Tourism");
        toolbar.setTitleTextColor(getResources().getColor(R.color.color));
        imageView=(ImageView)findViewById(R.id.image_view);
        toSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    toSpeech.setLanguage(Locale.ENGLISH);
                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                else{
                    Intent in = new Intent(MainActivity.this, Login.class);
                    startActivity(in);
                    finish();
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
                finish();
            }
        });


    }
}
