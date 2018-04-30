/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Account implements java.io.Serializable, Comparable<Account> {

    @Override
    public int compareTo(Account o) {
        if(this.firstName.compareTo(o.firstName)>0){
            return 1;
        }else if(this.firstName.compareTo(o.firstName)<0){
            return -1;
        }else{
            if(this.lastName.compareTo(o.lastName)>0){
                return 1;
            }else if(this.lastName.compareTo(o.lastName)<0){
                return -1;
            }else{
                return 0;
            }
        }
    }

    private class Checkout implements java.io.Serializable {

        Stock.Book book;
        Date dueDay;
        Date startDay;

        Checkout(Stock.Book b, Date dd, Date sd) {
            book = b;
            dueDay = dd;
            startDay = sd;
        }
        Checkout(Checkout x){
            book=x.book;
            dueDay=x.dueDay;
            startDay=x.startDay;
        }

        @Override
        public String toString() {
            return book.toString() + " " + startDay + " <--> " + dueDay;
        }
    }
    private String username;
    private AccountType accountType;
    private String address;
    private String firstName;
    private String lastName;
    private String city;
    private String zipCode;
    private String email;
    private String phoneNumber;
    private String state;
    private Checkout[] checkouts;
    private int libraryNumber;
    private int checked;
    private double fee = 0;

    AdminPage ap;

    Account(AccountType at, String fname, String lname, String a, String c, String em, String ph, String zip, String st, String u, int checkOutSize, int lbnum) {
        state = st;
        address = a;
        firstName = fname;
        lastName = lname;
        city = c;
        email = em;
        phoneNumber = ph;
        zipCode = zip;
        checked = 0;
        accountType = at;
        checkouts = new Checkout[checkOutSize];
        username = u;
        libraryNumber = lbnum;
        loadC();
    }

    Account(Account x) {
        state = x.state;
        address = x.address;
        firstName = x.firstName;
        lastName = x.lastName;
        city = x.city;
        email = x.email;
        phoneNumber = x.phoneNumber;
        zipCode = x.zipCode;
        checked = x.checked;
        accountType = x.accountType;
        checkouts = x.checkouts;
        username = x.username;
        libraryNumber = x.libraryNumber;
    }
    
    boolean checkouts(){
        return checked==0;
    }
    
    String getname(){
        return firstName + " " + lastName;
    }
    
    private void loadC() {
        WR r = new WR();
        try {
            FileOutputStream fos = new FileOutputStream(new File(r.returnConstantsPath()), false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ap);
            oos.close();
            fos.close();
        } catch (IOException e) {
            //Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int gettype() {
        if (null == accountType) {
            return -1;
        } else {
            switch (accountType) {
                case Employer:
                    return 0;
                case Employee:
                    return 1;
                default:
                    return 2;
            }
        }
    }

    boolean addFee(double dmg, String crn) {
        Checkout b = null;
        for (int i = 0; i < checkouts.length; i++) {
            if (checkouts[i].book.getCRN().equals(crn)) {
                b = checkouts[i];
                break;
            }
        }
        if (b == null) {
            return false;
        }
        Date today = new Date();
        int p = 0;
        if(today.after(b.dueDay)){
            long temp = today.getTime() - b.dueDay.getTime();
            temp = TimeUnit.DAYS.convert(temp, TimeUnit.MILLISECONDS);
            p = (int) temp;
        }
        fee = fee + (ap.getFee() * p) + dmg;
        return true;
    }
    
    public boolean updateKeepLimit(){
        loadC();
        int newLimit = ap.getCheckOutSize();
        if(newLimit!=checkouts.length && newLimit>1&& libraryNumber>0){
            Checkout[] c = new Checkout[newLimit];
            int dex = 0;
            for(int i=0;i<checkouts.length;i++){
                if(checkouts[i]!=null){
                    c[dex]= new Checkout(checkouts[i]);
                    dex++;
                }
            }
            checkouts=c;
        }
        return true;
    }

    int getLibNum() {
        return libraryNumber;
    }

    void ClearFee() {
        fee = 0;
    }

    boolean compareEmail(String x) {
        return x.equals(email);
    }

    double getBill() {
        return fee;
    }

    public boolean CheckOutBook(Stock.Book b , int days) {
        if (checked == checkouts.length || b==null || b.count==0) {
            return false;
        }
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, days);
        Date due = c.getTime();
        Checkout co = new Checkout(b, due, today);
        checkouts[checked] = co;
        checked++;
        b.editAvilibility(false);
        return true;
    }

    public boolean ReturnBook(Stock.Book b,boolean fees, double dmg) {
        int temp = 0;
        boolean checker = false;
        for (int i = 0; i < checkouts.length; i++) {
            if (b.equals(checkouts[i].book)) {
                checkouts[i] = null;
                temp = i;
                checked--;
                checker = true;
                break;
            }
        }
        if (checker) {
            for (int i = temp; i<checkouts.length-1; i++) {
                if(checkouts[i+1]!=null){
                checkouts[i] = checkouts[i+1];
                }else{
                    temp = i;
                    break;
                }
            }
            checkouts[temp+1]=null;
        }else{
            return false;
        }
        b.editAvilibility(true);
        if(fees){
            addFee(dmg,b.getCRN());
        }
        return true;
    }

    String getUsername() {
        return username;
    }
    
    boolean changeType(){
        switch (accountType) {
            case Employee:
                accountType = AccountType.Client;
                break;
            case Client:
                accountType = AccountType.Employee;
            default:
                break;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstName + ":::" + lastName + ":::" + address + ":::" + city + ":::" + state + ":::" + zipCode + ":::" + phoneNumber + ":::" + email + ":::" + accountType.toString() + ":::" + username + ":::" + libraryNumber;
    }

}
