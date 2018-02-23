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
public class Handler {
    private Account current;
    public Handler(){}
    public boolean signIn(String user,String pass){
        Accounts a = new Accounts();
        current=a.callAccount(user, pass);
        if(current!=null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean create(String u,String p,String fn,String ln,String add,String c,String em, String ph, String zip,String st){
        Accounts as = new Accounts();
        Account a= new Account(AccountType.Client,fn,ln,add,c,em,ph,zip,st);
        if(as.makeAccount(u, p, a)){
            return true;
        }else{
            return false;
        }
    }
    
    
}
