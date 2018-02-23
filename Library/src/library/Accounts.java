/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import java.util.HashMap;

enum AccountType{
     Employer,Employee,Client
}

/**
 *
 * @author alex
 */
public class Accounts {
    private AdminPage ap = new AdminPage();
  
    HashMap<String,String> user = new HashMap();
    HashMap<Integer,Account> accounts = new HashMap();
    
    boolean makeAccount(String uname,String pass,Account a){
        try{
            user.put(uname, pass);
            int accountMarker=uname.hashCode()+pass.hashCode();
            accounts.put(accountMarker, a);
            return true;
        }catch(Exception e){
            return false;
        }        
    }
    
    Account callAccount(String name, String pass){
        
        try{
        String temp=user.get(name);
        if(temp.equals(pass)){
            int accountMarker=name.hashCode()+pass.hashCode();
            return accounts.get(accountMarker);
        }else{
            return null;
        }
        
        }catch(Exception e){
            return null;
        }
    }
    
    String deleteAccount(String name,String pass){
        
        try{
        
        return "account removed";
        }catch(Exception e){
            return "failed deletion due to "+e;
        }
    }
    //need to read write for all accounts
    
}
