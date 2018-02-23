/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author alex
 */
public class AdminPage {
    private long keepTime;
    private double feePayment;
    private int checkOutSize;
    private double dmgfees;
    
    long getKeepTime(){
        return keepTime;
    }
    double getFee(){
        return feePayment;
    }
    int getCheckOutSize(){
        return checkOutSize;
    }
    double getDMGFees(){
        return dmgfees;
    }

    
    
    //need read write methods
}
