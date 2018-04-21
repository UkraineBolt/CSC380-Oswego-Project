/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import java.io.*;
import java.util.Scanner;

/**
 *
 * @author alex
 */
public class AdminPage {
    private int keepTime;
    private double lateFeePayment;
    private int checkOutSize;
    private double dmgfees;
    
    AdminPage(){
        boolean a = load();
        if(!a){
            keepTime=2;
            lateFeePayment=0.5;
            checkOutSize=2;
            dmgfees=5.0;
            save();
        }
    }
    
    public void setKeepTime(int l){
        keepTime=l;
    }
    public void setFeePayment(double f){
        lateFeePayment=f;
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
        return lateFeePayment;
    }
    public int getCheckOutSize(){
        return checkOutSize;
    }
    public double getDMGFees(){
        return dmgfees;
    }
    public boolean save(){
        try{
            saveConstants();
            return true;
        }catch(IOException e){
            return false;
        }
    }
    public boolean load(){
        try{
            loadConstants();
            return true;
        }catch(IOException e){
            return false;
        }
    }
    
    
    private void saveConstants() throws FileNotFoundException, IOException{
        WR paths = new WR();
        String cPath = paths.returnConstantsPath();
        File f = new File(cPath);
        f.delete();
        File fn = new File(cPath);
        fn.createNewFile();
        PrintWriter pw = new PrintWriter(fn);
        pw.println(keepTime);
        pw.println(lateFeePayment);
        pw.println(checkOutSize);
        pw.println(dmgfees);
    }
    
    private void loadConstants() throws FileNotFoundException{
        WR paths = new WR();
        String cPath = paths.returnConstantsPath();
        Scanner s = new Scanner(new File(cPath));
        keepTime=Integer.parseInt(s.nextLine());
        lateFeePayment=Double.parseDouble(s.nextLine());
        checkOutSize=Integer.parseInt(s.nextLine());
        dmgfees=Double.parseDouble(s.nextLine());
        
    }

}
