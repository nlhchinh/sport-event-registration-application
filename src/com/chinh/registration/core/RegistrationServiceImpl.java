/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.registration.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class RegistrationServiceImpl extends UnicastRemoteObject implements RegistrationInterface {

    private final String filePath = System.getProperty("user.dir") + File.separator + "Registration.txt";

    public RegistrationServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean createRegistration(Lecturer dto) throws RemoteException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date birthday = dto.getBirthday();
            String formatedBirthday = sdf.format(birthday);
            String shirtSize = String.valueOf(dto.getSportTshirtSize());
            saveData(filePath, dto.getRegistrationID(), dto.getFullName(), formatedBirthday, dto.isGender() == true ? "true" : "false",
                    dto.getEmail(), dto.getPhone(), dto.getIdCardNumber(), dto.getNationality(), dto.getEmergencyContactPerson(),
                    dto.getEmergencyContactPhone(), dto.getBloodGroup(), dto.getMedicalHistory(), dto.getAddress(), shirtSize);
            return true;
        } catch (RemoteException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Lecturer findByRegistrationID(String id) throws RemoteException {
        Lecturer lecturer = new Lecturer();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (id.trim().equals(data[0].trim())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String registraionID = data[0];
                    String fullName = data[1];
                    Date parsedBirthday = sdf.parse(data[2]);
                    Boolean gender = Boolean.valueOf(data[3]);
                    String email = data[4];
                    String phone = data[5];
                    String idCardNumber = data[6];
                    String nationality = data[7];
                    String emergencyContactPerson = data[8];
                    String emergencyContactPhone = data[9];
                    String bloodGroup = data[10];
                    String medicalHistory = data[11];
                    String address = data[12];
                    int shirtSize = Integer.parseInt(data[13]);
                    lecturer = new Lecturer(registraionID, fullName, parsedBirthday, gender, email,
                            phone, idCardNumber, nationality, emergencyContactPerson, emergencyContactPhone,
                            bloodGroup, medicalHistory, address, shirtSize);
                    break;
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return lecturer;
    }

    @Override
    public ArrayList<Lecturer> findAllRegistration() throws RemoteException {
        ArrayList<Lecturer> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date parsedBirthday = sdf.parse(data[2]);
                Boolean gender = Boolean.valueOf(data[3]);
                int shirtSize = Integer.parseInt(data[13]);
                dataList.add(new Lecturer(data[0], data[1], parsedBirthday, gender, data[4], data[5],
                        data[6], data[7], data[8], data[9], data[10], data[11], data[12], shirtSize));
            }
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        return dataList;
    }

    @Override
    public boolean removeRegistration(String id) throws RemoteException {
        boolean removed = false;

        ArrayList<Lecturer> lines = findAllRegistration();
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Lecturer currentLine : lines) {
                if (currentLine.getRegistrationID().equals(id)) {
                    removed = true;
                    continue;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String formatedBirthday = sdf.format(currentLine.getBirthday());
                String line = currentLine.getRegistrationID() + ","
                        + currentLine.getFullName() + ","
                        + formatedBirthday + ","
                        + currentLine.isGender() + ","
                        + currentLine.getEmail() + ","
                        + currentLine.getPhone() + ","
                        + currentLine.getIdCardNumber() + ","
                        + currentLine.getNationality() + ","
                        + currentLine.getEmergencyContactPerson() + ","
                        + currentLine.getEmergencyContactPhone() + ","
                        + currentLine.getBloodGroup() + ","
                        + currentLine.getMedicalHistory() + ","
                        + currentLine.getAddress() + ","
                        + currentLine.getSportTshirtSize();
                writer.write(line + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return removed;
    }

    @Override
    public boolean updateRegistration(Lecturer dto) throws RemoteException {
        boolean updated = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            System.out.println(line);
            while (line != null) {
                String[] fields = line.split(",");
                System.out.println("fields[0]: " + fields[0]);
                if (fields[0].equals(dto.getRegistrationID())) {
                    String formatedBirthday = sdf.format(dto.getBirthday());
                    System.out.println("dto.getBirthday(): " + dto.getBirthday());
                    System.out.println("formatedBirthday: " + formatedBirthday);
                    StringBuilder sb = new StringBuilder();
                    sb.append(dto.getRegistrationID()).append(",")
                            .append(dto.getFullName()).append(",")
                            .append(formatedBirthday).append(",")
                            .append(dto.isGender()).append(",")
                            .append(dto.getEmail()).append(",")
                            .append(dto.getPhone()).append(",")
                            .append(dto.getIdCardNumber()).append(",")
                            .append(dto.getNationality()).append(",")
                            .append(dto.getEmergencyContactPerson()).append(",")
                            .append(dto.getEmergencyContactPhone()).append(",")
                            .append(dto.getBloodGroup()).append(",")
                            .append(dto.getMedicalHistory()).append(",")
                            .append(dto.getAddress()).append(",")
                            .append(dto.getSportTshirtSize());
                    lines.add(sb.toString());
                    updated = true;
                } else {
                    lines.add(line);
                    System.out.println("line: " + line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String currentLine : lines) {
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return updated;
    }

    public void saveData(String filePath, String registrationID, String fullName, String birthday, String gender, String email,
            String phone, String idCardNumber, String nationality, String emergencyContactPerson,
            String emergencyContactPhone, String bloodGroup, String medicalHistory, String address,
            String sportTshirtSize) throws RemoteException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(registrationID);
            sb.append(",");
            sb.append(fullName);
            sb.append(",");
            sb.append(birthday);
            sb.append(",");
            sb.append(gender);
            sb.append(",");
            sb.append(email);
            sb.append(",");
            sb.append(phone);
            sb.append(",");
            sb.append(idCardNumber);
            sb.append(",");
            sb.append(nationality);
            sb.append(",");
            sb.append(emergencyContactPerson);
            sb.append(",");
            sb.append(emergencyContactPhone);
            sb.append(",");
            sb.append(bloodGroup);
            sb.append(",");
            sb.append(medicalHistory);
            sb.append(",");
            sb.append(address);
            sb.append(",");
            sb.append(sportTshirtSize);
            sb.append("\n");

            bw.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws ParseException {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1888);
            RegistrationInterface stub = (RegistrationInterface) registry.lookup("RMIServer");
            String date = "2000/02/01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date parsed = sdf.parse(date);
            Lecturer dto = new Lecturer("SE140506", "a", parsed, true, "a",
                    "a", "a", "a", "a", "a",
                    "a", "a", "a", 1);
            stub.updateRegistration(dto);
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
