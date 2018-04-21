/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

enum AccountType implements java.io.Serializable{
    Employer, Employee, Client
}

/**
 *
 * @author alex
 */
public class Accounts {

    private AdminPage ap = new AdminPage();
    HashMap<String, String> user;
    HashMap<Integer, Account> accounts;

    Accounts() {
        try{
            readAccounts();
        }catch(ClassNotFoundException | IOException e){
            user = new HashMap();
            accounts = new HashMap();
            try {
                writeAccounts();
            } catch (IOException ex) {
                Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    boolean makeAccount(String uname, String pass, Account a) {
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            user.put(uname, pass);
            int accountMarker = uname.hashCode() + pass.hashCode();
            accounts.put(accountMarker, a);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Unable to make account. Null-Pointer exception occurred");
            return false;
        }
        
    }

    Account callAccount(String name, String pass) {
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        try {
            String temp = user.get(name);
            if (temp.equals(pass)) {
                int accountMarker = name.hashCode() + pass.hashCode();
                return accounts.get(accountMarker);
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println("Unable to call account. Null-Pointer exception occurred");
            return null;
        }
        
    }

    boolean deleteAccount(String name, String pass) {     
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Account temp = callAccount(name, pass);
            if (temp != null) {
                int key = name.hashCode() + pass.hashCode();
                accounts.remove(key, temp);
            }
        } catch (NullPointerException e) {
            System.out.println("Unable to delete account. Null-Pointer exception occurred");
            return false;
        }
        
        try {
            writeAccounts();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private void writeAccounts() throws FileNotFoundException, IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnAccountsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(accounts);
        oos.writeObject(user);
        oos.close();
        fos.close();
    }
    
    private void readAccounts() throws FileNotFoundException, IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnAccountsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        accounts = (HashMap<Integer, Account>) ois.readObject();
        user = (HashMap<String, String>) ois.readObject();
        ois.close();
        fis.close();
    }

}
