/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class Handler {

    public Account current;
    Accounts as;
    Logs log;
    Stock s;
    public AdminPage ap;

    public Handler() {
        try {
            loadAccounts();
            if (as == null) {
                as = new Accounts();
            }
            try {
                saveAccounts();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);

            }
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            as = new Accounts();
            try {
                saveAccounts();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        try {
            loadBooks();
            if (s == null) {
                s = new Stock();
            }
            try {
                saveBooks();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            s = new Stock();
            try {
                saveBooks();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        try {
            loadLogs();
            if (log == null) {
                log = new Logs();
            }
            try {
                saveLogs();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            log = new Logs();
            try {
                saveLogs();
            } catch (IOException ex1) {
                //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

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

    public String getCurrentName() {
        return current.getname();
    }

    public String getAccountData() {
        return current.toString();
    }

    public ArrayList<Account> callAllAccounts() {
        try {
            loadAccounts();
            return as.getListOfAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int aType() {
        return current.gettype();
    }

    public String getID(String x) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return as.emailToUserID(x);
    }

    public boolean changePassword(String user, String pass) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        boolean x = as.changePassword(user, pass);
        try {
            saveAccounts();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean makeBook(String title, String author, int year, int crn, ArrayList<String> g) {
        try {
            loadBooks();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean x = s.addBook(title, author, year, crn, Condition.New, g);
        try {
            saveBooks();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Stock.Book> callAllBooks() {
        try {
            loadBooks();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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

    public boolean editAllCheckoutSizes() {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        boolean x = as.realterCheckoutSize();
        try {
            saveAccounts();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
        try {
            loadAccounts();
            loadConstants();
            loadBooks();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        Account a = as.callByLibNum(libnum);
        if (dmg) {
            a.AddFee(ap.getDMGFees(), crn);
        }
        boolean x = a.ReturnBook(s.searchByCRN(crn));
        try {
            saveAccounts();
            saveBooks();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean checkOutBook(int crn, int libnum) {
        try {
            loadAccounts();
            loadBooks();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        Account a = as.callByLibNum(libnum);
        boolean d = a.CheckOutBook(s.searchByCRN(crn));
        try {
            saveBooks();
            saveAccounts();
            return d;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean signIn(String user, String pass) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        current = as.callAccount(user, pass);
        if (current != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean createAdmin(String u, String p, String fn, String ln, String add, String c, String em, String ph, String zip, String st) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Account a = new Account(AccountType.Employer, fn, ln, add, c, em, ph, zip, st, u, 100, 0);
        as.checkForNull();
        boolean x = as.makeAccount(u, p, a);
        try {
            saveAccounts();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean create(String u, String p, String fn, String ln, String add, String c, String em, String ph, String zip, String st) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random r = new Random();
        boolean temp = true;
        int libnum;
        do {//possible inf loop
            libnum = Math.abs(r.nextInt());
            if (as.checkNumber(libnum)) {
                temp = false;
            }
        } while (temp);

        Account a = new Account(AccountType.Client, fn, ln, add, c, em, ph, zip, st, u, ap.getCheckOutSize(), libnum);
        boolean x = as.makeAccount(u, p, a);
        try {
            saveAccounts();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /*public void deleteListOfBooks(ArrayList<String> x){
        p
        try {
            loadBooks();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean readFileOfBooks(String x) {
        p
        try {
            loadBooks();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File f = new File(x);
            Scanner sss = new Scanner(f);
            while (sss.hasNextLine()) {
                String[] db = sss.nextLine().split(":::");
                if (db.length==6) {
                    try {
                        int year = Integer.parseInt(db[2]);
                        int crn = Integer.parseInt(db[3]);
                        String[] genres = db[5].split(",");
                        ArrayList<String> g = new ArrayList<>();
                        g.addAll(Arrays.asList(genres));
                        Condition cod = s.callCondition(db[4]);
                        s.addBook(db[0], db[1], year, crn, cod, g);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            saveBooks();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }*/
    public Account callAccountByLibNum(int num) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return as.callByLibNum(num);
    }

    public boolean delete(Account o) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String u = o.getUsername();
        boolean x = as.deleteAccount(u, as.user.get(u));
        try {
            saveAccounts();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean changeStatus(String x) {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        boolean eo = as.changeStatus(x);
        try {
            saveAccounts();
            return eo;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete() {
        try {
            loadAccounts();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        String u = current.getUsername();
        boolean x = as.deleteAccount(u, as.user.get(u));
        try {
            saveAccounts();
            return x;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean addEvent(Date d, String title, String host, String where, String dis) {
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.addEvent(d, title, host, where, dis);

        try {
            saveLogs();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Logs.Event> callAllEvents() {
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        log.checkForCompletedEvents();
        return log.eventLog;
    }

    public boolean deleteEvent(Date d, String title, String host, String where, String dis) {
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        log.deleteEvent(log.searchEvent(d, title, host, where, dis));

        try {
            saveLogs();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean checkExpiredEvents() {
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        log.checkForCompletedEvents();

        try {
            saveLogs();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<Logs.Event> allWorkLogs(){
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return log.workLog;
    }
    public boolean addWork(int priority, Date sd, String name, String action) {
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        log.addWorkLog(priority, sd, name, action);
        
        try {
            saveLogs();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean completeRequest(int p, Date s, String name, String action){
        try {
            loadLogs();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        log.completeLog(log.searchLog(p, s, name, action));
        
        try {
            saveLogs();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //eveything below this point are read and write methods
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

    private void saveAccounts() throws IOException {
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnAccountsPath()), false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(as);
        oos.close();
        fos.close();
    }

    private void loadAccounts() throws IOException, ClassNotFoundException {
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnAccountsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        as = (Accounts) ois.readObject();
        ois.close();
        fis.close();

    }

    private void saveBooks() throws IOException {
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnBookDataPath()), false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.close();
        fos.close();
    }

    private void loadBooks() throws IOException, ClassNotFoundException {
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnBookDataPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        s = (Stock) ois.readObject();
        ois.close();
        fis.close();

    }

    private void saveLogs() throws IOException {
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnWorkLogsPath()), false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(log);
        oos.close();
        fos.close();
    }

    private void loadLogs() throws IOException, ClassNotFoundException {
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnWorkLogsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        log = (Logs) ois.readObject();
        ois.close();
        fis.close();

    }

}
