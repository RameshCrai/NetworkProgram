/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc_RMI_GUI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Bedo
 */
public class Calc_Interface_Impliment extends UnicastRemoteObject implements Calculator_Interface {

	public Calc_Interface_Impliment() throws RemoteException {
		super();
	}

	public int Calculator(int a, int b, int choice) throws Exception {

		int result = 0;
		switch (choice) {
		case 0:
			result = a + b;
			break;
		case 1:
			result = a * b;
			break;
		case 2:
			result = a - b;
			break;
		case 3:
			result = a / b;
			break;
		default:
			System.out.println("Please Select Valid Number 1-4");
		}

		return result;

	}

}
