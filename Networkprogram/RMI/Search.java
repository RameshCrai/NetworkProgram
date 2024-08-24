/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package networking.RMI;

/**
 *
 * @author shree
 */
// Creating a Search interface
import java.rmi.*;
public interface Search extends Remote
{
	// Declaring the method prototype
	public String query(String search) throws RemoteException;
}
