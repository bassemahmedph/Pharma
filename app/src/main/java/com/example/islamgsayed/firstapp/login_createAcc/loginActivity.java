package com.example.islamgsayed.firstapp.login_createAcc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.islamgsayed.firstapp.Home.navdrawer;
import com.example.islamgsayed.firstapp.Map.MapPlacesActivity;
import com.example.islamgsayed.firstapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private EditText editTextUsername ;
    private EditText Password ;
    private Button Btnlogin;
    private Button  newaccount;
//    private TextView textViewforget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), navdrawer.class));

        }
        editTextUsername = findViewById(R.id.editTextUsername);
        Password = findViewById(R.id.password);
        Btnlogin= findViewById(R.id.btnlogin);
        newaccount=findViewById(R.id.newaccount);



        Btnlogin.setOnClickListener(this);
        newaccount.setOnClickListener(this);
    }

    private void UserLogin(){
        String email = editTextUsername.getText().toString().trim();
        String password = Password.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter first name ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter password ", Toast.LENGTH_SHORT).show();
            return;
        }
        if (editTextUsername.getText().toString().equals("pharmacy@yahoo.com")&&Password.getText().toString().equals("123456789"))
        {
            startActivity(new Intent(getApplicationContext(), MapPlacesActivity.class));

        }
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(), navdrawer.class));
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == Btnlogin){

            UserLogin();
        }
       if(v == newaccount){

           startActivity(new Intent(this , registrationform.class));
       }
    }
}
