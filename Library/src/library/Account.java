/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.time.LocalDate;

/**
 *
 * @author alex
 */
class Account {
        private class Checkout{
            Stock.Book book;
            LocalDate dueDate;
            LocalDate dateCheckedOut;
            Checkout(Stock.Book b, LocalDate dd, LocalDate dco){
                book=b;
                dueDate=dd;
                dateCheckedOut=dco;
                b.ChangeAvailability(Availability.CheckedOut);
            }
        }        
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
        private int checked;
        private double fee = 0;

        AdminPage ap = new AdminPage();
        Account( AccountType at, String fname, String lname,String a,String c,String em, String ph, String zip,String st) {
            state=st;
            address = a;
            firstName=fname;
            lastName=lname;
            city=c;
            email=em;
            phoneNumber=ph;
            zipCode=zip;
            checked=0;
            accountType=at;
            checkouts = new Checkout[ap.getCheckOutSize()];
        }
        int gettype(){
            if(null==accountType){
                return -1;
            }else switch (accountType) {
                case Employer:
                    return 0;
                case Employee:
                    return 1;
                default:
                    return 2;
            }
        }
        void AddFee(double dmg,int days) {
            fee = fee + (ap.getFee()*days) + dmg;
        }        
        void ClearFee() {
            fee = 0;
        }        
        void CheckOutBook(Stock.Book b){
            LocalDate today = LocalDate.now();
            LocalDate due = today.plusDays(ap.getKeepTime());
            Checkout co = new Checkout(b,today,due);
            checkouts[checked]=co;
            checked++;
        }
        void ReturnBook(Stock.Book b){
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
            if(checker){
                for(int i=temp;i<checkouts.length-1;i++){
                    checkouts[i]=checkouts[i+1];
                }
            }
        }
    }
