package Project;

/**
NetworkInterface class of java.net package provides a static method getNetworkInterfaces() 
* that retrieves list of all the network interfaces and returns it as an enumeration. 
* Each network interface is this list is an instance of the NetworkInterface class which 
* in turn can have list of sub interfaces and can be retrieved by calling the getSubInterfaces() method.
* java.util.Enumeration interface is one of the predefined interfaces, whose object is used for retrieving the data from collections 
* framework variable( like Stack, Vector, HashTable etc.) in a forward direction only and not in the backward direction. 
* This interface has been superceded by an iterator.
The Enumeration Interface defines the functions by which we can enumerate the elements in a collection of elements. 
* For new code, Enumeration is considered obsolete. However, several methods of the legacy classes such as vectors and properties,
* several API classes, application codes use this Enumeration interface.
*@author shree
**/
//To print all the netwrok interfaces of the localhost.
import java.util.*;
import java.lang.*; 
import java.net.*; 
public class Netinterface
{
public static void main(String[] args)
{ 
try
{ 
Enumeration n = NetworkInterface.getNetworkInterfaces();
while(n.hasMoreElements()) 
System.out.println(n.nextElement()); 
}
catch(SocketException e)
{ 
System.out.println("Error.");
}
}
}
