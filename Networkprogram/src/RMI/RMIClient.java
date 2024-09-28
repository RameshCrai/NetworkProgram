package RMI;

import java.rmi.Naming;

public class RMIClient {

	public static void main(String[] args) {
		try {
			// Look up the remote object in the rmiprogram registry
			Adder adder = (Adder) Naming.lookup("rmi://localhost/Adder");

			// Call the remote method and print the result
			int result = adder.add(5, 3);
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
