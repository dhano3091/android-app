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

public class ForgotPassword2Activity extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
Button button;
Toolbar toolbar;
String input1,input2;
TextInputLayout passwordInputLayout;
TextInputLayout confirmpasswordInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);
        button=(Button)findViewById(R.id.con_butr);
        toolbar=(Toolbar)findViewById(R.id.confirmpassword_toolbar);
        passwordInputLayout=(TextInputLayout)findViewById(R.id.forgot2_password);
        confirmpasswordInputLayout=(TextInputLayout)findViewById(R.id.forgot2_passwordconfirm);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("SET UP NEW PASSWORD");
        toolbar.setTitleTextColor(getResources().getColor(R.color.color));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(!validatepassword() | !validateconfirmpassword()){
                    return;
                }
                if(input1.equals(input2))
                {
                    Intent i=getIntent();
                    String email=i.getStringExtra("passing_key");
                    boolean b=helper.update(input1,email);
                    if(b==true){
                        Toast.makeText(ForgotPassword2Activity.this,"PASSWORD SETUP SUCCESSFULL",Toast.LENGTH_SHORT).show();
                        i=new Intent(ForgotPassword2Activity.this,Login.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(ForgotPassword2Activity.this,"UNSUCCESSFUL PASSWORD SETUP",Toast.LENGTH_SHORT).show();

                    }

                }
                else{
                    Toast.makeText(ForgotPassword2Activity.this,"INVALID PASSWORD CONFIRMATION",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
    public boolean validatepassword(){
         input1=passwordInputLayout.getEditText().getText().toString();
        if(input1.isEmpty()){
            passwordInputLayout.setError("Please enter Password");
            return false;
        }
        else{
            passwordInputLayout.setError(null);
            return true;
        }
    }
    public boolean validateconfirmpassword(){
        input2=confirmpasswordInputLayout.getEditText().getText().toString();
        if(input2.isEmpty()){
            confirmpasswordInputLayout.setError("Please confirm Password");
            return false;
        }
        else{
            confirmpasswordInputLayout.setError(null);
            return true;
        }
    }
}
