/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMIprog;

/**
 *
 * @author shree
 */
// Java program to implement the Search interface
import java.rmi.*;
import java.rmi.server.*;
public class SearchQuery extends UnicastRemoteObject implements Search
{
	// Default constructor to throw RemoteException
	// from its parent constructor
	SearchQuery() throws RemoteException
	{
		super();
	}

	// Implementation of the query interface
	public String query(String search)
					throws RemoteException
	{
		String result;
		if (search.equals("Reflection in Java"))
			result = "Found";
		else
			result = "Not Found";

		return result;
	}
}
