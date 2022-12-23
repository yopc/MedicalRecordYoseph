package com.example.medicalrecordyoseph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText signupName, signupUsername, signupEmail, signupPassword,signupBirthday,signupBloodGroup,signupDiagnosisHistory,signupLabReport,signupPreHospital;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupBirthday=findViewById(R.id.signup_birthday);
        signupBloodGroup=findViewById(R.id.signup_bloodGroup);
        signupDiagnosisHistory=findViewById(R.id.signup_diagnosisHistory);
        signupLabReport=findViewById(R.id.signup_labReport);
        signupPreHospital=findViewById(R.id.sighup_preHospital);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String birthday=signupBirthday.getText().toString();
                String bloodGroup=signupBloodGroup.getText().toString();
                String diagnosisHistory=signupDiagnosisHistory.getText().toString();
                String labReport=signupLabReport.getText().toString();
                String preHospital=signupPreHospital.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password,birthday,bloodGroup,diagnosisHistory,labReport,preHospital);
                reference.child(username).setValue(helperClass);
                Toast.makeText(SignupActivity.this, "You have Registered successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}