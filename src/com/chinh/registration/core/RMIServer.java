/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinh.registration.core;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Admin
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            Registry rgsty = LocateRegistry.createRegistry(1888);
            RegistrationInterface stub = new RegistrationServiceImpl();
            Naming.rebind("rmi://localhost:1888/RMIServer", stub);
            System.out.println("Server is running.");
        } catch (RuntimeException | RemoteException | MalformedURLException e) {
            System.out.println(e);
        }
    }
}
