/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Main {
    AdminPage ap = new AdminPage();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start up protocal");
        System.out.println("This protocal is easily breakable as unique inputs are required"
        +"\nDivergence of type will cause program to fail");
        Scanner s = new Scanner(System.in);
        AdminPage ap = new AdminPage();
        System.out.println("Set Constants:");
        System.out.println("keepTime");
        ap.setKeepTime(Integer.parseInt(s.nextLine()));
        
        System.out.println("lateFeePayment");
        ap.setFeePayment(Double.parseDouble(s.nextLine()));
        
        System.out.println("checkOutSize");
        ap.setCheckOutSize(Integer.parseInt(s.nextLine()));
        
        System.out.println("dmgfees");
        ap.setDmgFees(Double.parseDouble(s.nextLine()));
        
        System.out.println("Saving");
        WR r = new WR();
        try{
        FileOutputStream fos = new FileOutputStream(new File(r.returnConstantsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ap);
        oos.close();
        fos.close();
        }catch(IOException e){
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, e);
            System.exit(-827);
        }
        System.out.println("Changes Saved");
        
        
        String fn = null;
        String ln = null;   
        String address = null;
        String city = null;
        String state = null;
        String zipcode = null;
        String email=null;
        String phone=null;
        String id = null;
        String pass = null;
        String repass = null;
        
        do{
        System.out.println("Time to make your admin account");
        System.out.println("First Name");
        fn = s.nextLine();
        System.out.println("Last Name");
        ln = s.nextLine();
        System.out.println("Address");
        address = s.nextLine();
        System.out.println("City");
        city = s.nextLine();
        System.out.println("State");
        state = s.nextLine();
        System.out.println("Zip Code");
        zipcode = s.nextLine();
        System.out.println("Email");
        email = s.nextLine();
        System.out.println("Phone #");
        phone = s.nextLine();
        System.out.println("Username");
        id = s.nextLine();
        System.out.println("Password");
        pass = s.nextLine();
        System.out.println("Re-enter password to make account");
        repass = s.nextLine();
        }while(!pass.equals(repass));
        
        System.out.println("making account");
        Account a = new Account(AccountType.Employer,fn,ln,address,city,
        email,phone,zipcode,state,id,100);
        System.out.println("account object made");
        
        System.out.println("adding account to database");
        Accounts as = new Accounts();
        try {
            as.makeAccount(id,pass,a);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-375);
        }
        System.out.println("account has been added");
        System.out.println("basic admin set up has been confirmed");
        System.out.println("Run program through LoginScreen");
        
        
        
    }
    /*
    private void save() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnConstantsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ap);
        oos.close();
        fos.close();
    }
    
    private void load() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnConstantsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        ap = (AdminPage) ois.readObject();
        ois.close();
        fis.close();
    }
    */
}
