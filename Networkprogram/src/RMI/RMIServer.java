package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

	public static void main(String[] args) {
		try {
			// Start the rmiprogram registry
			LocateRegistry.createRegistry(1099);

			// Create an instance of the AdderImpl class
			AdderImpl adder = new AdderImpl();

			// Bind the remote object (stub) in the registry
			Naming.rebind("rmi://localhost/Adder", adder);

			System.out.println("rmiprogram Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
