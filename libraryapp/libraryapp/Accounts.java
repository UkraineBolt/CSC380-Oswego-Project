/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.time.LocalDate;
import java.util.HashMap;
import libraryapp.Stock.Book;

enum AccountType{
     Employer,Employee,Client
}

/**
 *
 * @author alex
 */
public class Accounts {
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
        return (13*x)+(y*31)+19;        
    }
    }
    private class Account {
        private class Checkout{
            Book book;
            LocalDate dueDate;
            LocalDate dateCheckedOut;
            Checkout(Book b, LocalDate dd, LocalDate dco){
                book=b;
                dueDate=dd;
                dateCheckedOut=dco;
                b.ChangeAvailability(Availability.CheckedOut);
            }
        }
        private User user;        
        private AccountType accountType;
        private String address;
        private int age;
        private Checkout[] checkouts;
        private int checked;
        private double fee = 0;

        Account(User u, String a, int ag, AccountType at) {
            user=u;
            address = a;
            age = ag;
            checked=0;
            accountType=at;
            checkouts = new Checkout[ap.getCheckOutSize()];
        }

        String ChangeCheckOutMax(int s) {
            if (s>0&&s>checked) {
                Checkout[] co = new Checkout[s];
                for (int i = 0; i < checkouts.length; i++) {
                    co[i]=checkouts[i];                    
                }
                checkouts = co;
                return "max checked out changed to "+s;
            }else{
                String x;
                int j=s-checked;
                if(j<0){
                    x="too many books checked";
                }else if(s<=0){
                    x="inserting 0 or negative number";
                }else{
                    x="unknown problem";
                }
                return "Change failed due to "+x;
            }
        }

        void AddFee(double dmg,int days) {
            fee = fee + (ap.getFee()*days) + dmg;
        }
        
        void ClearFee() {
            fee = 0;
        }
        
        void CheckOutBook(Book b){
            LocalDate today = LocalDate.now();
            LocalDate due = today.plusDays(ap.getKeepTime());
            Checkout co = new Checkout(b,today,due);
            checkouts[checked]=co;
            checked++;
        }
        void ReturnBook(Book b){
            int temp=0;
            boolean checker=false;
            for(int i=0;i<checkouts.length;i++){
                if(b.equals(checkouts[i].book)){
                    checkouts[i]=null;
                    b.ChangeAvailability(Availability.InStock);
                    temp=i;
                    checked--;
                    checker=true;
                    break;
                }
            }
            if(checker==true){
                for(int i=temp;i<checkouts.length-1;i++){
                    checkouts[i]=checkouts[i+1];
                }
            }
        }
    }
    
    HashMap<Integer,Account> allAccounts = new HashMap();
    
    String makeAccount(String name,String pass,String add, int age, AccountType a){
        try{
            User us = new User(name,pass);
            Account newaccount = new Account(us,add,age,a);
            allAccounts.put(us.hashCode(), newaccount);
            return "account made & added";
        }catch(Exception e){
            return "account was not made because of "+e;
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
