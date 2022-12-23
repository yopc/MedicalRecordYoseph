package com.example.medicalrecordyoseph;

public class HelperClass {
    String name,email,username,password,birthday,bloodGroup,diagnosisHistory,labReport,preHospital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDiagnosisHistory() {
        return diagnosisHistory;
    }

    public void setDiagnosisHistory(String diagnosisHistory) {
        this.diagnosisHistory = diagnosisHistory;
    }

    public String getLabReport() {
        return labReport;
    }

    public void setLabReport(String labReport) {
        this.labReport = labReport;
    }

    public String getPreHospital() {
        return preHospital;
    }

    public void setPreHospital(String preHospital) {
        this.preHospital = preHospital;
    }

    public HelperClass(String name, String email, String username, String password, String birthday, String bloodGroup, String diagnosisHistory, String labReport, String preHospital) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.bloodGroup = bloodGroup;
        this.diagnosisHistory = diagnosisHistory;
        this.labReport = labReport;
        this.preHospital = preHospital;
    }

    public HelperClass() {
    }
}
