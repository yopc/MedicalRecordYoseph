package com.example.medicalrecordyoseph;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
public class ProfileActivity extends AppCompatActivity {
    TextView profileName, profileEmail, profileUsername, profilePassword,profileBirthday,profileBloodGroup,profileDiagnosisHistory,profileLabReport,profilePreHospital;
    TextView titleName, titleUsername;
    Button editProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        profileBirthday=findViewById(R.id.profileBirthday);
        profileBloodGroup=findViewById(R.id.profileBloodGroup);
        profileDiagnosisHistory=findViewById(R.id.profileDiagnosisHistory);
        profileLabReport=findViewById(R.id.profileLabReport);
        profilePreHospital=findViewById(R.id.profilePreHospital);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        editProfile = findViewById(R.id.editButton);
        showAllUserData();
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
            }
        });
    }
    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");
        String birthdayUser = intent.getStringExtra("birthday");
        String bloodGroupUser = intent.getStringExtra("bloodGroup");
        String diagnosisHistoryUser = intent.getStringExtra("diagnosisHistory");
        String labReportUser = intent.getStringExtra("labReport");
        String preHospitalUser = intent.getStringExtra("preHospital");
        titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser);
        profileBirthday.setText(birthdayUser);
        profileBloodGroup.setText(bloodGroupUser);
        profileDiagnosisHistory.setText(diagnosisHistoryUser);
        profileLabReport.setText(labReportUser);
        profilePreHospital.setText(preHospitalUser);


    }
    public void passUserData(){
        String userUsername = profileUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    String birthdayFromDB = snapshot.child(userUsername).child("birthday").getValue(String.class);
                    String bloodGroupFromDB = snapshot.child(userUsername).child("bloodGroup").getValue(String.class);
                    String diagnosisHistoryFromDB = snapshot.child(userUsername).child("diagnosisHistory").getValue(String.class);
                    String labReportFRomDB = snapshot.child(userUsername).child("labReport").getValue(String.class);
                    String preHospitalFRomDB = snapshot.child(userUsername).child("preHospital").getValue(String.class);
                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("username", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);
                    intent.putExtra("birthday", birthdayFromDB);
                    intent.putExtra("bloodGroup", bloodGroupFromDB);
                    intent.putExtra("diagnosisHistory", diagnosisHistoryFromDB);
                    intent.putExtra("labReport", labReportFRomDB);
                    intent.putExtra("preHospital", preHospitalFRomDB);


                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}