/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.time.LocalDate;
import java.util.HashMap;
import library.Stock.Book;

enum AccountType{
     Employer,Employee,Client
}

/**
 *
 * @author alex
 */
class Accounts {
    private AdminPage ap = new AdminPage();
    private class User{
        private final String username, password;
        User(String u,String p){
            username=u;password=p;
        }
        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User key = (User) o;
        //return username == key.username && password == key.password;
        return username.equals(key.username) && password.equals(key.password);
    }
        @Override
    public int hashCode() {
        int x=username.hashCode();
        int y=password.hashCode();
        return (x+y)-((13*username.length())+(password.length()*31));        
    }
    }
   
    
    HashMap<Integer,Account> allAccounts = new HashMap();
    
    boolean makeAccount(String uname,String pass,Account a){
        try{
            User us = new User(uname,pass);           
            allAccounts.put(us.hashCode(), a);
            return true;
        }catch(Exception e){
            return false;
        }        
    }
    
    Account callAccount(String name, String pass){
        User u = new User(name,pass);
        try{
        Account account=allAccounts.get(u.hashCode());
        return account;
        }catch(Exception e){
            return null;
        }
    }
    
    String deleteAccount(String name,String pass){
        User u = new User(name,pass);
        try{
        allAccounts.remove(u.hashCode());
        return "account removed";
        }catch(Exception e){
            return "failed deletion due to "+e;
        }
    }
    //need to read write for all accounts
    
}
