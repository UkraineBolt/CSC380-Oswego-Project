/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Scanner;

/**
 *
 * @author alex
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Handler x = new Handler();
        System.out.println("Start up protocal");
        System.out.println("This protocal is easily breakable as unique inputs are required"
        +"\nDivergence of type will cause program to fail");
        Scanner s = new Scanner(System.in);
        System.out.println("do you want to set constants: y or n?");
        if(s.nextLine().contains("y")){
        System.out.println("Set Constants:");
        System.out.println("keepTime");
        int aa = Integer.parseInt(s.nextLine());
        
        System.out.println("lateFeePayment");
        double fee = Double.parseDouble(s.nextLine());
        
        System.out.println("checkOutSize");
        int cos =Integer.parseInt(s.nextLine());
        
        System.out.println("dmgfees");
        double sdf=Double.parseDouble(s.nextLine());
        x.saveConstants(aa, sdf, cos, sdf);
        System.out.println("Saving");
        System.out.println("Changes Saved");
        }
        
        String fn;
        String ln;   
        String address;
        String city;
        String state;
        String zipcode;
        String email;
        String phone;
        String id;
        String pass;
        String repass;
        
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
        x.createAdmin(id, pass, fn, ln, address, city, email, phone, zipcode, state);
        System.out.println("account object made");
        
        System.out.println("adding account to database");
        System.out.println("account has been added");
        System.out.println("basic admin set up has been confirmed");
        System.out.println("Run program through LoginScreen");
        
        
        
    }
}
