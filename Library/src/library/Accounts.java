/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;
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

    HashMap<String, String> user;
    HashMap<Integer, Account> accounts;
    ArrayList<Integer> libraryNumbers = new ArrayList<>();
    
    Accounts() {
        try{
            readAccounts();
        }catch(ClassNotFoundException | IOException e){
            user = new HashMap();
            accounts = new HashMap();
            try {
                writeAccounts();
            } catch (IOException ex) {
                //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            readLibraryNumbers();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            libraryNumbers=new ArrayList<>();
        }
        
    }
    
    boolean checkNumber(int x){//checks for dup lib#
        return !libraryNumbers.contains(x);
    }

    boolean makeAccount(String uname, String pass, Account a) {
        try {
            readLibraryNumbers();
        } catch (IOException|ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        libraryNumbers.add(a.getLibNum());
        
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(callAccount(uname,pass)!=null){//checks if the account exists
            return false;
        }
        
        try {
            user.put(uname, pass);
            int accountMarker = uname.hashCode() + pass.hashCode();
            accounts.put(accountMarker, a);
            writeLibraryNumbers();
            writeAccounts();
            return true;
        } catch (NullPointerException | IOException e) {
            System.out.println("Unable to make account. Null-Pointer exception occurred");
            return false;
        }
        
    }
    
    String emailToUserID(String x){
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        for(Integer key: accounts.keySet()){
            Account temp = accounts.get(key);
            if(temp.compareEmail(x)){
                return temp.getUsername();
            }
        }
        return null;
        
    }
    
    boolean changePassword(String username,String newpass){
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String oldp = user.get(username);
        Account oldAccount=callAccount(username,oldp);
        Account newAccount = new Account(oldAccount);
        if(deleteAccount(username,oldp)){
            if(makeAccount(username,newpass,newAccount)){
                return true;
            }else{
                return false;
            }
            
        }else{
            return false;
        }
    }

    Account callAccount(String name, String pass) {
        try {
            readAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
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
            readLibraryNumbers();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            Account temp = callAccount(name, pass);
            if (temp != null) {
                int key = name.hashCode() + pass.hashCode();
                libraryNumbers.remove(accounts.get(key).getLibNum());
                accounts.remove(key, temp);
                user.remove(name);
                
            }
        } catch (NullPointerException e) {
            System.out.println("Unable to delete account. Null-Pointer exception occurred");
            return false;
        }
        
        try {
            writeAccounts();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private void writeAccounts() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnAccountsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(accounts);
        oos.writeObject(user);
        oos.close();
        fos.close();
    }
    
    private void readAccounts() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnAccountsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        accounts = (HashMap<Integer, Account>) ois.readObject();
        user = (HashMap<String, String>) ois.readObject();
        ois.close();
        fis.close();
    }
    private void writeLibraryNumbers() throws IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnLibraryNumberPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(libraryNumbers);
        oos.close();
        fos.close();
    }
    
    private void readLibraryNumbers() throws IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnLibraryNumberPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        libraryNumbers = (ArrayList<Integer>) ois.readObject();
        ois.close();
        fis.close();
    }

}
