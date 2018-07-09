package dhamraj.jindal.tourism;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper helper=new DatabaseHelper(this);
    Toolbar toolbar;
TextInputLayout emailtextInputLayout;
TextInputLayout passwordtextInputLayout;
Button button1,button2,button3;
String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtextInputLayout=(TextInputLayout)findViewById(R.id.emailtextinputlayout);
        passwordtextInputLayout=(TextInputLayout)findViewById(R.id.passwordtextinputlayout);
        button1=(Button)findViewById(R.id.button_1);
        button2=(Button)findViewById(R.id.button_2);
        button3=(Button)findViewById(R.id.button_3);
        toolbar=(Toolbar)findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("LOGIN.....");
        toolbar.setTitleTextColor(getResources().getColor(R.color.color));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateemail() | !validatepassword()){
                     return;
                }
                 String check=helper.searchpass(email);
                String passtonext=helper.searchname(email);
                if (check.equals(pass)){
                    Toast.makeText(Login.this, "WELCOME TO CHANDIGARH TOURISM", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login.this,NavigationDrawer.class);
                    intent.putExtra("NAME_KEY",passtonext);
                    startActivity(intent);
                    finish();

                }
                else {
                    Toast.makeText(Login.this, "USERNAME OR PASSWORD INCORRECT", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });
       button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(Login.this,ForgotPasswordActivity.class);
               startActivity(i);
               finish();
           }
       });
    }
    private boolean validateemail(){
         email=emailtextInputLayout.getEditText().getText().toString().trim();
        if (email.isEmpty()){
            emailtextInputLayout.setError("Please enter Email");
            return false;
        }
        else{
            emailtextInputLayout.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatepassword(){
         pass=passwordtextInputLayout.getEditText().getText().toString().trim();
        if (pass.isEmpty()){
            passwordtextInputLayout.setError("Please enter Password");
            return false;
        }
        else{
            passwordtextInputLayout.setErrorEnabled(false);
            return true;
        }
    }
}
