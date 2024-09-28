package Lab;

public class AddressTester {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide an address as a command line argument.");
            return;
        }

        String address = args[0];
        
        if (isValidAddress(address)) {
            System.out.println("The address is valid: " + address);
        } else {
            System.out.println("The address seems to be invalid.");
        }
    }

    private static boolean isValidAddress(String address) {
        return address.contains("Street") || address.contains("Avenue") 
        		|| address.contains("Road") || address.contains("Boulevard");
    }
}

