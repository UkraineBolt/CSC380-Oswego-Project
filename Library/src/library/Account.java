/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
class Account implements java.io.Serializable {

    private class Checkout implements java.io.Serializable {

        Stock.Book book;
        int dueDay;
        int startDay;

        Checkout(Stock.Book b, int dd, int sd) {
            book = b;
            dueDay = dd;
            startDay = sd;
            b.ChangeAvailability(Availability.CheckedOut);
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

    void loadC() {
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

    int gettype() {
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

    boolean AddFee(double dmg, int crn) {
        Checkout b = null;
        for (int i = 0; i < checkouts.length; i++) {
            if (checkouts[i].book.getCRN() == crn) {
                b = checkouts[i];
                break;
            }
        }
        if (b == null) {
            return false;
        }
        LocalDate ld = LocalDate.now();
        int p = b.dueDay - ld.getDayOfYear();
        if (p <= 0) {
            p = 1;
        } else {
            p++;
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

    boolean CheckOutBook(Stock.Book b) {
        if (checked == checkouts.length) {
            return false;
        }
        LocalDate ld = LocalDate.now();
        int today = ld.getDayOfYear();
        int due = ld.plusDays((long) ap.getKeepTime()).getDayOfYear();
        if (due > 365) {
            due = due - 365;
        }
        Checkout co = new Checkout(b, due, today);
        checkouts[checked] = co;
        checked++;
        return true;
    }

    boolean ReturnBook(Stock.Book b) {
        int temp = 0;
        boolean checker = false;
        for (int i = 0; i < checkouts.length; i++) {
            if (b.equals(checkouts[i].book)) {
                checkouts[i] = null;
                b.ChangeAvailability(Availability.InStock);
                temp = i;
                checked--;
                checker = true;
                break;
            }
        }
        if (checker) {
            for (int i = temp; i < checkouts.length - 1; i++) {
                checkouts[i] = checkouts[i + 1];
            }
        }
        return true;
    }

    String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return firstName + ":::" + lastName + ":::" + address + ":::" + city + ":::" + state + ":::" + zipCode + ":::" + phoneNumber + ":::" + email + ":::" + accountType.toString() + ":::" + username + ":::" + libraryNumber;
    }

}
