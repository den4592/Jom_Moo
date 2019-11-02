package com.example.jom_moo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


        private TextView txtemail,txtpassword;
        private Button btnlogout;
        Register register=new Register();
        private FirebaseAuth firebaseAuth;
        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            firebaseAuth=FirebaseAuth.getInstance();
            //if already login then do first log out then again login
            if (firebaseAuth.getCurrentUser()==null){
                finish();
                startActivity(new Intent(MainActivity.this,Login.class));
            }

            FirebaseUser user =firebaseAuth.getCurrentUser();

            btnlogout=(Button)findViewById(R.id.btlogout);




            btnlogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(MainActivity.this, Login.class));
                }
            });

        }
    }
}