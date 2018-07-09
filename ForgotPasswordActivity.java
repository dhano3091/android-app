package dhamraj.jindal.tourism;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
Button button;
Toolbar toolbar;
String input;
TextInputLayout textInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        button=(Button)findViewById(R.id.button_forgot);
        toolbar=(Toolbar)findViewById(R.id.login_toolbar);
        textInputLayout=(TextInputLayout)findViewById(R.id.email_textinput);
        setSupportActionBar(toolbar);
        ActionBar bn=getSupportActionBar();
        bn.setTitle("SET UP NEW PASSWORD");
        toolbar.setTitleTextColor(getResources().getColor(R.color.color));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateemail()==true)
                {

                }
                else
                    {   String emailcheck=helper.registeremailcheck(input);
                        if(emailcheck.equals(input)){
                            Intent i =new Intent(ForgotPasswordActivity.this,ForgotPassword2Activity.class);
                            i.putExtra("passing_key",emailcheck);
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(ForgotPasswordActivity.this,"INVALID EMAIL",Toast.LENGTH_SHORT).show();
                        }

                }

            }
        });
    }
    public boolean validateemail()
    {
        input=textInputLayout.getEditText().getText().toString();
        if(input.isEmpty()){
            textInputLayout.setError("Please enter your Email");
            return true;
        }
        else{
            textInputLayout.setError(null);
            return false;
        }
    }
}
