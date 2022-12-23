package com.example.medicalrecordyoseph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {
    EditText editName, editEmail, editUsername, editPassword,editBirthday,editBloodGroup,editDiagnosisHistory,editLabReport,editPreHospital;
    Button saveButton;
    String nameUser, emailUser, usernameUser, passwordUser,birthdayUser,bloodGroupUser,diagnosisHistoryUser,labReportUser,preHospitalUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        reference = FirebaseDatabase.getInstance().getReference("users");
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        saveButton = findViewById(R.id.saveButton);
        editBirthday = findViewById(R.id.editBirthday);
        editBloodGroup = findViewById(R.id.editBloodGroup);
        editDiagnosisHistory = findViewById(R.id.editDiagnosisHistory);
        editLabReport = findViewById(R.id.editLabReport);
        editPreHospital=findViewById(R.id.editPreHospital);
        showData();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged() || isPasswordChanged() || isEmailChanged() || isBirthdayChanged() || isBloodGroupChanged() || isDiagnosisHistoryChanged() || isLabReportChanged() || isPreHospitalChanged()){
                    Toast.makeText(EditProfileActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditProfileActivity.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        private boolean isNameChanged() {
            if (!nameUser.equals(editName.getText().toString())){
                reference.child(usernameUser).child("name").setValue(editName.getText().toString());
                nameUser = editName.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isEmailChanged() {
            if (!emailUser.equals(editEmail.getText().toString())){
                reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
                emailUser = editEmail.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isPasswordChanged() {
            if (!passwordUser.equals(editPassword.getText().toString())){
                reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
                passwordUser = editPassword.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isBirthdayChanged() {
            if (!birthdayUser.equals(editBirthday.getText().toString())){
                reference.child(usernameUser).child("birthday").setValue(editBirthday.getText().toString());
                birthdayUser= editBirthday.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isBloodGroupChanged() {
            if (!bloodGroupUser.equals(editBloodGroup.getText().toString())){
                reference.child(usernameUser).child("bloodGroup").setValue(editBloodGroup.getText().toString());
                bloodGroupUser= editBloodGroup.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isDiagnosisHistoryChanged() {
            if (!diagnosisHistoryUser.equals(editDiagnosisHistory.getText().toString())){
                reference.child(usernameUser).child("diagnosisHistory").setValue(editDiagnosisHistory.getText().toString());
                diagnosisHistoryUser= editDiagnosisHistory.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isLabReportChanged() {
            if (!labReportUser.equals(editLabReport.getText().toString())){
                reference.child(usernameUser).child("labReport").setValue(editLabReport.getText().toString());
                labReportUser= editLabReport.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        private boolean isPreHospitalChanged() {
            if (!preHospitalUser.equals(editPreHospital.getText().toString())){
                reference.child(usernameUser).child("preHospital").setValue(editPreHospital.getText().toString());
                preHospitalUser= editPreHospital.getText().toString();
                return true;
            } else {
                return false;
            }
        }
        public void showData(){
            Intent intent = getIntent();
            nameUser = intent.getStringExtra("name");
            emailUser = intent.getStringExtra("email");
            usernameUser = intent.getStringExtra("username");
            passwordUser = intent.getStringExtra("password");
            birthdayUser= intent.getStringExtra("birthday");
            bloodGroupUser = intent.getStringExtra("bloodGroup");
            diagnosisHistoryUser = intent.getStringExtra("diagnosisHistory");
            labReportUser = intent.getStringExtra("labReport");
            preHospitalUser = intent.getStringExtra("preHospital");

            editName.setText(nameUser);
            editEmail.setText(emailUser);
            editUsername.setText(usernameUser);
            editPassword.setText(passwordUser);
            editBirthday.setText(birthdayUser);
            editBloodGroup.setText(bloodGroupUser);
            editDiagnosisHistory.setText(diagnosisHistoryUser);
            editPreHospital.setText(preHospitalUser);
        }


    }
