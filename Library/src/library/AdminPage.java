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
    private int keepTime;
    private double feePayment;
    private int checkOutSize;
    private double dmgfees;
    
    public void setKeepTime(int l){
        keepTime=l;
    }
    public void setFeePayment(double f){
        feePayment=f;
    }
    public void setCheckOutSize(int c){
        checkOutSize=c;
    }
    public void setDmgFees(double d){
        dmgfees=d;
    }
    
    public int getKeepTime(){
        return keepTime;
    }
    public double getFee(){
        return feePayment;
    }
    public int getCheckOutSize(){
        return checkOutSize;
    }
    public double getDMGFees(){
        return dmgfees;
    }

    
    
    //need read write methods
}
