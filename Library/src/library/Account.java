/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;
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
        if (this.firstName.compareTo(o.firstName) > 0) {
            return 1;
        } else if (this.firstName.compareTo(o.firstName) < 0) {
            return -1;
        } else {
            if (this.lastName.compareTo(o.lastName) > 0) {
                return 1;
            } else if (this.lastName.compareTo(o.lastName) < 0) {
                return -1;
            } else {
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

        Checkout(Checkout x) {
            book = x.book;
            dueDay = x.dueDay;
            startDay = x.startDay;
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
    private ArrayList<Checkout> checkouts;
    private int cos;
    private int libraryNumber;
    private double fee = 0;

    //AdminPage ap;

    Account(AccountType at, String fname, String lname, String a, String c, String em, String ph, String zip, String st, String u, int checkOutSize, int lbnum) {
        state = st;
        address = a;
        firstName = fname;
        lastName = lname;
        city = c;
        email = em;
        phoneNumber = ph;
        zipCode = zip;
        accountType = at;
        username = u;
        cos = checkOutSize;
        libraryNumber = lbnum;
        checkouts = new ArrayList<>();
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
        accountType = x.accountType;
        checkouts = x.checkouts;
        username = x.username;
        libraryNumber = x.libraryNumber;
    }

    String getname() {
        return firstName + " " + lastName;
    }
    boolean checkoutIsEmpty(){
        return checkouts.isEmpty();
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

    boolean addFee(double dmg, String crn, double f) {
        Checkout b = null;
        for (int i = 0; i < checkouts.size(); i++) {
            if (checkouts.get(i).book.getCRN().equals(crn)) {
                b = checkouts.get(i);
                break;
            }
        }
        if (b == null) {
            return false;
        }
        Date today = new Date();
        int p = 0;
        if (today.after(b.dueDay)) {
            long temp = today.getTime() - b.dueDay.getTime();
            temp = TimeUnit.DAYS.convert(temp, TimeUnit.MILLISECONDS);
            p = (int) temp;
        }
        fee = fee + (f * p) + dmg;
        return true;
    }

    public boolean updateKeepLimit(int x) {
        int newLimit = x;
        if (newLimit != checkouts.size() && newLimit > 1 && libraryNumber > 0) {
            cos = newLimit;
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

    public boolean CheckOutBook(Stock.Book b, int days) {
        if (cos >= checkouts.size() || b == null || b.count == 0) {
            return false;
        }
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, days);
        Date due = c.getTime();
        Checkout co = new Checkout(b, due, today);
        checkouts.add(co);
        return true;
    }

    public boolean ReturnBook(Stock.Book b, boolean fees, double dmg, double checkoutfee) {
        boolean te = false;
        for (int i = 0; i < checkouts.size(); i++) {
            if (b.equals(checkouts.get(i).book)) {
                checkouts.remove(i);
                te = true;
                break;
            }
        }
        if (te) {
            if (fees) {
                addFee(dmg, b.getCRN(),checkoutfee);
            }
            return true;
        }
        return false;
    }

    String getUsername() {
        return username;
    }

    boolean changeType() {
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
