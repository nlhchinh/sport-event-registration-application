/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.registration.core;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Lecturer implements Serializable {

    private String registrationID;
    private String fullName;
    private Date birthday;
    private boolean gender;
    private String email;
    private String phone;
    private String idCardNumber;
    private String nationality;
    private String emergencyContactPerson;
    private String emergencyContactPhone;
    private String bloodGroup;
    private String medicalHistory;
    private String address;
    private int sportTshirtSize;

    public Lecturer() {
    }

    public Lecturer(String registrationID, String fullName, Date birthday, boolean gender, String email, String phone, String idCardNumber, String nationality, String emergencyContactPerson, String emergencyContactPhone, String bloodGroup, String medicalHistory, String address, int sportTshirtSize) {
        this.registrationID = registrationID;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
        this.nationality = nationality;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactPhone = emergencyContactPhone;
        this.bloodGroup = bloodGroup;
        this.medicalHistory = medicalHistory;
        this.address = address;
        this.sportTshirtSize = sportTshirtSize;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSportTshirtSize() {
        return sportTshirtSize;
    }

    public void setSportTshirtSize(int sportTshirtSize) {
        this.sportTshirtSize = sportTshirtSize;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "registrationID=" + registrationID + ", fullName=" + fullName + ", birthday=" + birthday + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", idCardNumber=" + idCardNumber + ", nationality=" + nationality + ", emergencyContactPerson=" + emergencyContactPerson + ", emergencyContactPhone=" + emergencyContactPhone + ", bloodGroup=" + bloodGroup + ", medicalHistory=" + medicalHistory + ", address=" + address + ", sportTshirtSize=" + sportTshirtSize + '}';
    }
}
