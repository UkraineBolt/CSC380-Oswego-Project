/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;
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
    public AdminPage ap;

    public Handler() {
        as = new Accounts();
        s = new Stock();
        try {
            loadConstants();
            if (ap == null) {
                ap = new AdminPage();
                ap.setConstants(7, .5, 2, 5.0);
                try {
                    saveConstants();
                } catch (IOException ex1) {
                    //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            ap = new AdminPage();
            ap.setConstants(7, .5, 2, 5.0);
            try {
                saveConstants();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public String getAccountData() {
        return current.toString();
    }

    public int aType() {
        return current.gettype();
    }

    public String getID(String x) {
        return as.emailToUserID(x);
    }

    public boolean changePassword(String user, String pass) {
        return as.changePassword(user, pass);
    }

    public boolean makeBook(String title, String author, int year, int crn, ArrayList<String> g) {
        return s.addBook(title, author, year, crn, Condition.New, g);
    }

    public ArrayList<Stock.Book> callAllBooks() {
        return s.callAll();
    }

    public boolean reloadConstants() {
        try {
            loadConstants();
            return true;
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean editAllCheckoutSizes(){
        return as.realterCheckoutSize();
    }

    public boolean saveConstants(int l, double f, int c, double d) {
        try {
            loadConstants();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        ap.setConstants(l, f, c, d);

        try {
            saveConstants();
            return true;
        } catch (IOException ex) {
            return false;//Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean returnBook(boolean dmg, int crn, int libnum) {
        Account a = as.callByLibNum(libnum);
        if (dmg) {
            a.AddFee(ap.getDMGFees(), crn);
        }
        return a.ReturnBook(s.searchByCRN(crn));
    }

    public boolean checkOutBook(int crn, int libnum) {
        if (!s.load()) {
            return false;
        }
        Account a = as.callByLibNum(libnum);
        boolean d = a.CheckOutBook(s.searchByCRN(crn));
        if (d) {
            s.save();
            return true;
        }
        return d;
    }

    public boolean signIn(String user, String pass) {
        current = as.callAccount(user, pass);
        if (current != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean create(String u, String p, String fn, String ln, String add, String c, String em, String ph, String zip, String st) {
        Random r = new Random();
        boolean temp = true;
        int libnum;
        do {//possible inf loop
            libnum = r.nextInt();
            if (as.checkNumber(libnum)) {
                temp = false;
            }
        } while (temp);

        Account a = new Account(AccountType.Client, fn, ln, add, c, em, ph, zip, st, u, ap.getCheckOutSize(), libnum);
        return as.makeAccount(u, p, a);
    }

    public boolean delete() {
        String u = current.getUsername();
        return as.deleteAccount(u, as.user.get(u));
    }

    private void saveConstants() throws IOException {
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnConstantsPath()), false);
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
