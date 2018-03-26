/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.HashMap;

enum AccountType {
    Employer, Employee, Client
}

/**
 *
 * @author alex
 */
public class Accounts {

    private AdminPage ap = new AdminPage();
    HashMap<String, String> user;
    HashMap<Integer, Account> accounts;

    Accounts() {
        user = new HashMap();
        accounts = new HashMap();
    }

    boolean makeAccount(String uname, String pass, Account a) {
        try {
            user.put(uname, pass);
            int accountMarker = uname.hashCode() + pass.hashCode();
            accounts.put(accountMarker, a);
            return true;
        } catch (NullPointerException e) {
            System.out.println("Unable to make account. Null-Pointer exception occurred");
            return false;
        }
    }

    Account callAccount(String name, String pass) {

        try {
            String temp = user.get(name);
            if (temp.equals(pass)) {
                int accountMarker = name.hashCode() + pass.hashCode();
                return accounts.get(accountMarker);
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println("Unable to call account. Null-Pointer exception occurred");
            return null;
        }
    }

    boolean deleteAccount(String name, String pass) {
        try {
            Account temp = callAccount(name, pass);
            if (temp != null) {
                int key = name.hashCode() + pass.hashCode();
                accounts.remove(key, temp);
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            System.out.println("Unable to delete account. Null-Pointer exception occurred");
            return false;
        }
    }
    //need to read write for all accounts

}
