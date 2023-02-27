/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.registration.core;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Admin
 */
public interface RegistrationInterface extends Remote {

    boolean createRegistration(Lecturer dto) throws RemoteException;

    Lecturer findByRegistrationID(String id) throws RemoteException;

    ArrayList<Lecturer> findAllRegistration() throws RemoteException;

    boolean removeRegistration(String id) throws RemoteException;

    boolean updateRegistration(Lecturer dto) throws RemoteException;
}
