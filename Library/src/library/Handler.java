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
    WR w;
    Accounts as;
    public Handler(){
    as=new Accounts();
    w=new WR();
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
    
    public boolean create(String u,String p,String fn,String ln,String add,String c,String em, String ph, String zip,String st){
        Account a= new Account(AccountType.Client,fn,ln,add,c,em,ph,zip,st,u);
        return as.makeAccount(u, p, a);
    }
    
    public boolean delete(){
        String u = current.getUsername();
        as.deleteAccount(u, as.user.get(u));
        return true;
    }
    
    
}
