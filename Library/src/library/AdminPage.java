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
public class AdminPage implements java.io.Serializable{
    private int keepTime;
    private double lateFeePayment;
    private int checkOutSize;
    private double dmgfees;
 
    public void setConstants(int l,double f,int c,double d){
        keepTime=l;lateFeePayment=f;checkOutSize=c;dmgfees=d;
    }
    
    public int getKeepTime(){
        return keepTime;
    }
    public double getFee(){
        return lateFeePayment;
    }
    public int getCheckOutSize(){
        return checkOutSize;
    }
    public double getDMGFees(){
        return dmgfees;
    }
}
