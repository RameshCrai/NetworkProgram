/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc_RMI_GUI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Bedo
 */
public class Server_RMI {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1098);
            Calc_Interface_Impliment cl = new Calc_Interface_Impliment();
            reg.rebind("CalSurvices", cl);
            System.out.println("Server starts ...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
