/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.*;
import java.util.ArrayList;

enum Availability implements java.io.Serializable{
    CheckedOut,Reserved,InStock
}
enum Condition implements java.io.Serializable{
    New,Good,Worned,Poor,Unacceptable,InRepair
}
enum Genres implements java.io.Serializable{
Science,Fiction,Satire,Drama,Action,Adventure,Romance,
Mystery,Horror,SelfHelp,Health,Guide,Travel,Childrens,
Religion,Spirituality,NewAge,History,Math, Anthology,
Poetry,Encyclopedias,Dictionaries,Comics,Art,CookBooks,
Diaries,Journals,PrayerBooks,Series,Trilogy,Biographies,
Autobiographies,Fantasy,Realism,Mythology,Tragedy,Comedy,
Classic,Folklore,PictureBook,Thiller,Maginzies
}
enum Location implements java.io.Serializable{
    Childrens, YoungAdult,Reference,Periodical, AdultFiction, AdultNonFiction,Archieves
}

/**
 *
 * @author alex
 */
class Stock {
    class Book implements java.io.Serializable{
        private String title,author;
        private ArrayList<Genres> genres = new ArrayList<>();
        private int crn;
        private int year;
        private Availability av;
        private Condition condition;
        private double value;
        Book(String t,String a,int c,int y,Condition con,ArrayList<Genres>g,double v){
            title=t;
            author=a;
            crn=c;
            year=y;
            condition=con;
            av=Availability.InStock;
            value=v;
        }
        void ChangeAvailability(Availability a){
            av=a;
        }
        void ChangeCondition(Condition c){
            condition=c;
        }
        public String toString(){
            return "Title: "+title+" Author: "+author+" Year: "+year+"\nCRN#: "+crn+" Condition: "+condition+"\nGenres: "+genres.toString();
        }
        
    }
    ArrayList<Book> books = new ArrayList<>();
    
    void addBook(String t,String a,int year, int crn,Condition c,ArrayList<Genres> genres,double v){
        
        
        Book b = new Book(t,a,crn,year,c,genres,v);
        books.add(b);
    }
    void removeBook(Book b){
        books.remove(b);
    }
    
    private void writeBooks() throws FileNotFoundException, IOException{
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnBookDataPath()),false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(books);
        oos.close();
        fos.close();
    }
    
    private void readBooks() throws FileNotFoundException, IOException, ClassNotFoundException{
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnAccountsPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        books = (ArrayList<Book>) ois.readObject();
        ois.close();
        fis.close();
    } 
    
    
}
