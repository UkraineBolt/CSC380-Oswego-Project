/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            loadConstants();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        s=new Stock();
        ap=new AdminPage();
    }
    public String getAccountData(){
        return current.toString();
    }
    public int aType(){
        return current.gettype();
    }
    public String getID(String x){
        return as.emailToUserID(x);
    }
    public boolean changePassword(String user, String pass){
        return as.changePassword(user, pass);
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
        Random r = new Random();
        boolean temp = true;
        int libnum;
        do{//possible inf loop
            libnum=r.nextInt();
            if(as.checkNumber(libnum)){
                temp=false;
            }
        }while(temp);
        
        Account a= new Account(AccountType.Client,fn,ln,add,c,em,ph,zip,st,u,ap.getCheckOutSize(),libnum);
        return as.makeAccount(u, p, a); 
    }
    
    public boolean delete(){
        String u = current.getUsername();
        return as.deleteAccount(u, as.user.get(u));
    }
    
    
    private void saveConstants() throws IOException {
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnConstantsPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ap);
        oos.close();
        fos.close();
        }
    
    private void loadConstants() throws IOException, ClassNotFoundException {
       WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnConstantsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        ap = (AdminPage) ois.readObject();
        ois.close();
        fis.close();
        
    }
    
    
}
