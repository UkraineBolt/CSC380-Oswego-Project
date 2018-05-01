/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

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
public class Accounts implements java.io.Serializable{

    HashMap<String, String> user;
    HashMap<String, Account> accounts;
    ArrayList<Integer> libraryNumbers;
    
    Accounts() {
        user = new HashMap<>();
        accounts = new HashMap<>();
        libraryNumbers=new ArrayList<>();
    }
    boolean checkForNull(){
        if(user==null){
            user = new HashMap<>();
        }
        if(accounts==null){
            accounts = new HashMap<>();
        }
        if(libraryNumbers==null){
            libraryNumbers=new ArrayList<>();
        }
        return true;
    }
    
    Account callByLibNum(int libnum){
        for(String k :accounts.keySet()){
            if(accounts.get(k).getLibNum()==libnum){
                return accounts.get(k);
            }
        }
        return null;
    }
    boolean checkNumber(int x){//checks for dup lib#
        return !libraryNumbers.contains(x);
    }
    
    ArrayList<Account> getListOfAccounts(){
        ArrayList<Account> t = new ArrayList<>();
        for(String x:accounts.keySet()){
            t.add(accounts.get(x));
        }
        return t;
    }
    
    boolean realterCheckoutSize(int checkoutSize){
        for(String key:accounts.keySet()){
            Account temp = accounts.get(key);
            temp.updateKeepLimit(checkoutSize);
        }
        return true;
    }

    boolean makeAccount(String uname, String pass, Account a) {
        libraryNumbers.add(a.getLibNum());
        
        if(user.get(uname)!=null){//checks if the username exists
            return false;
        }
        
        try {
            user.put(uname, pass);
            String accountkey = uname.trim()+pass.trim();
            accounts.put(accountkey, a);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Unable to make account. Null-Pointer exception occurred");
            return false;
        }
        
    }
    
    boolean changeStatus(String u){
        String pass = user.get(u);
        Account x = callAccount(u,pass);
        if(x!=null){
        return x.changeType();
        }else{
            return false;
        }
    }
    
    String emailToUserID(String x){
        for(String key: accounts.keySet()){
            Account temp = accounts.get(key);
            if(temp.compareEmail(x)){
                return temp.getUsername();
            }
        }
        return null;
        
    }
    
    boolean changePassword(String username,String newpass){
        String oldp = user.get(username);
        Account oldAccount=callAccount(username,oldp);
        Account newAccount = new Account(oldAccount);
        if(deleteAccount(username,oldp)){
            return makeAccount(username,newpass,newAccount);
            
        }else{
            return false;
        }
    }

    Account callAccount(String name, String pass) {
        
        try {
            String temp = user.get(name);
            if (temp.equals(pass)) {
                String accountMarker = name.trim() + pass.trim();
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
            Account temp = callAccount(name, pass);
            if (temp != null && temp.checkoutIsEmpty()) {
                String key = name + pass;
                for(int i=0;i<libraryNumbers.size();i++){
                    if(libraryNumbers.get(i)==temp.getLibNum()){
                        libraryNumbers.remove(i);
                    }
                }
                accounts.remove(key);
                user.remove(name);
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("Unable to delete account. Null-Pointer exception occurred");
            return false;
        }
        
    }

}
