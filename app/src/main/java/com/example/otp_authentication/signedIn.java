package com.example.otp_authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signedIn extends AppCompatActivity {

    Button btnSignOut;
    TextView txtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        findViews();

        setPhoneNumber();

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(signedIn.this,MainActivity.class));
                finish();
            }
        });
    }

    private void findViews() {
        txtPhone=findViewById(R.id.txtPhone);
        btnSignOut=findViewById(R.id.btnSignOut);
    }

    private void setPhoneNumber(){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        try {
            txtPhone.setText(user.getPhoneNumber());
        }catch (Exception e){
            Toast.makeText(this,"Phone number not found", Toast.LENGTH_SHORT).show();
        }
    }
}



