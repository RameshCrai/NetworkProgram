/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calc_RMI_GUI;

import java.rmi.Remote;

/**
 *
 * @author Bedo
 */
public interface Calculator_Interface extends Remote{
    
    public int Calculator(int num1, int num2, int operator) throws Exception;
    
}
