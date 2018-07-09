package dhamraj.jindal.tourism;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Contact c=new Contact();
    DatabaseHelper helper=new DatabaseHelper(this);
   TextInputLayout  nameinputlayout;
    TextInputLayout countryinputlayout;
    TextInputLayout contactinputlayout;
    TextInputLayout emailinputlayout;
    TextInputLayout passwordinputlayout;
    TextInputLayout confirmpasswordinputlayout;
    String name,email,password,con_pass,contact,country;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameinputlayout=(TextInputLayout)findViewById(R.id.register_name);
        countryinputlayout=(TextInputLayout)findViewById(R.id.register_country);
        contactinputlayout=(TextInputLayout)findViewById(R.id.register_contact);
        emailinputlayout=(TextInputLayout)findViewById(R.id.register_email);
        passwordinputlayout=(TextInputLayout)findViewById(R.id.register_password);
        confirmpasswordinputlayout=(TextInputLayout)findViewById(R.id.register_confirmpassword);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validatename() | !validatecountry() | !validateemail() | !validateconfirmpassword() | !validatepassword() | !validatecontact())
                {
                    return;
                }
                String emailget=helper.registeremailcheck(email);

                if (password.equals(con_pass) && (!(email.equals(emailget))))
                {
                    c.setName(name);
                    c.setContact(contact);
                    c.setCountry(country);
                    c.setEmail(email);
                    c.setPassword(password);
                    helper.insertContact(c);
                    Toast.makeText(Register.this,"REGISTERED SUCCESS",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Register.this,Login.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Register.this,"PLEASE LOGIN TO CONTINUE",Toast.LENGTH_SHORT).show();
                }
               if((!password.equals(con_pass)))
               {

                       Toast.makeText(Register.this,"INVALID PASSWORD CONFIRMATION",Toast.LENGTH_SHORT).show();
               }
               if(email.equals(emailget)){
                   Toast.makeText(Register.this,"PERSON WITH THE SAME EMAIL ADDRESS ALREADY EXISTS",Toast.LENGTH_SHORT).show();

               }

            }
        });
    }
    public boolean validatename(){
          name=nameinputlayout.getEditText().getText().toString();
         if(name.isEmpty()){
             nameinputlayout.setError("Please enter your Name");
             return false;
         }
         else{
             nameinputlayout.setError(null);
             return true;
         }
    }
    public boolean validatecountry(){
        country=countryinputlayout.getEditText().getText().toString();
        if(country.isEmpty()){
            countryinputlayout.setError("Please enter your Country");
            return false;
        }
        else{
            countryinputlayout.setError(null);
            return true;
        }
    }
    public boolean validatecontact(){
        contact=contactinputlayout.getEditText().getText().toString();
        if(contact.isEmpty()){
            contactinputlayout.setError("Please enter your Contact");
            return false;
        }
        else{
            contactinputlayout.setError(null);
            return true;
        }
    }
    public boolean validateemail(){
         email=emailinputlayout.getEditText().getText().toString();
        if(email.isEmpty()){
            emailinputlayout.setError("Please enter your Email");
            return false;
        }
        else{
            emailinputlayout.setError(null);
            return true;
        }
    }
    public boolean validatepassword(){
         password=passwordinputlayout.getEditText().getText().toString();
        if(password.isEmpty()){
            passwordinputlayout.setError("Please enter your Password");
            return false;
        }
        else{
            passwordinputlayout.setError(null);
            return true;
        }
    }
    public boolean validateconfirmpassword(){
        con_pass=confirmpasswordinputlayout.getEditText().getText().toString();
        if(con_pass.isEmpty()){
            confirmpasswordinputlayout.setError("Please enter your Password");
            return false;
        }
        else{
            confirmpasswordinputlayout.setError(null);
            return true;
        }
    }
}
