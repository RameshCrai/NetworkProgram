package RMI;

import java.rmi.RemoteException;

public class AdderImpl implements Adder {
	protected AdderImpl() throws RemoteException {
		super();
	}

	@Override
	public int add(int x, int y) throws RemoteException {

		return x + y;
	}

}
