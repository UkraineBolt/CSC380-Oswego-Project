/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Handler {
    private Account current;
    Accounts as;
    Logs log;
    Stock s;
    AdminPage ap;
    public Handler(){
        as=new Accounts();
        log=new Logs();
        s=new Stock();
        ap=new AdminPage();
    }
    public int aType(){
        return current.gettype();
    }
    public boolean signIn(String user,String pass){
        current=as.callAccount(user, pass);
        if(current!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean create(String u,String p,String fn,String ln,String add,String c,String em, String ph, String zip,String st) {
        Account a= new Account(AccountType.Client,fn,ln,add,c,em,ph,zip,st,u,ap.getCheckOutSize());
        try {
            return as.makeAccount(u, p, a);
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(){
        String u = current.getUsername();
        as.deleteAccount(u, as.user.get(u));
        return true;
    }
    
    
}
