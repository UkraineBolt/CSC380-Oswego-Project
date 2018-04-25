/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

enum Availability implements java.io.Serializable {
    CheckedOut, Reserved, InStock
}

enum Condition implements java.io.Serializable {
    New, Good, Worned, Poor, Unacceptable
}

/*enum Genres implements java.io.Serializable {
    Science, Fiction, Satire, Drama, Action, Adventure, Romance,
    Mystery, Horror, SelfHelp, Health, Guide, Travel, Childrens,
    Religion, Spirituality, NewAge, History, Math, Anthology,
    Poetry, Encyclopedias, Dictionaries, Comics, Art, CookBooks,
    Diaries, Journals, PrayerBooks, Series, Trilogy, Biographies,
    Autobiographies, Fantasy, Realism, Mythology, Tragedy, Comedy,
    Classic, Folklore, PictureBook, Thiller, Maginzies
}*/

/*enum Location implements java.io.Serializable {
    Childrens, YoungAdult, Reference, Periodical, AdultFiction, AdultNonFiction, Archieves
}*/

/**
 *
 * @author alex
 */
public class Stock {

    public class Book implements java.io.Serializable, Comparable<Book> {

        private String title, author;
        //private ArrayList<Genres> genres;
        private ArrayList<String> genres;
        private int crn;
        private int year;
        private Availability av;
        private Condition condition;

        Book(String t, String a, int c, int y, Condition con, /*ArrayList<Genres> g*/ ArrayList<String> genre) {
            title = t;
            author = a;
            crn = c;
            year = y;
            condition = con;
            av = Availability.InStock;
            genres=genre;
        }

        void ChangeAvailability(Availability a) {
            av = a;
        }
        
        int getCRN(){
            return crn;
        }

        void ChangeCondition(Condition c) {
            condition = c;
        }

        @Override
        public String toString() {
            return title + ":::" + author + ":::" + year + ":::" + crn + ":::" + condition + ":::" + genres.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            /*if (this.getClass() != obj.getClass()) {
                return false;
            }*/
            Book t = (Book) obj;
            if (!this.title.equals(t.title) || !this.author.equals(t.author)) {
                return false;
            }
            /*if (!this.author.equals(t.author)) {
                return false;
            }*/
            if (this.crn!=t.crn || this.year!=t.year) {
                return false;
            }
            /*if (this.year!=t.year) {
                return false;
            }*/
            return true;
        }

        @Override
        public int compareTo(Book o) {
            if(this.title.compareTo(o.title)>0){
                return 1;
            }else if(this.title.compareTo(o.title)<0){
                return -1;
            }else{
               if(this.author.compareTo(o.author)>0){
                   return 1;
               }else if(this.author.compareTo(o.author)<0){
                   return -1;
               }else{
                   return -1;
               }
            }
        }
    }
    ArrayList<Book> books;
    
    Stock(){
        books = new ArrayList<>();
    }
    
    Condition callCondition(String x){
        //New, Good, Worned, Poor, Unacceptable, InRepair
        switch (x.trim().toLowerCase()) {
            case "new":
                return Condition.New;
            case "good":
                return Condition.Good;
            case "worned":
                return Condition.Worned;
            case "poor":
                return Condition.Poor;
            case "unacceptable":
                return Condition.Unacceptable;
            default:
                return null;
        }
    }
    
    boolean editAvilibility(Availability a, Book b){
        for(int i=0;i<books.size();i++){
            if(books.get(i).equals(b)){
                books.get(i).av=a;
                return true;
            }
        }
        
        return false;
    }
    ArrayList<Book> callAll(){
        return books;
    }
    
    Book searchBook(String title, String author, int crn, int year){
        Book fake = new Book(title,author,crn,year,null,null);
        for(int i=0;i<books.size();i++){
            if(books.get(i).equals(fake)){
                return books.get(i);
            }
        }
        return null;
    }
    
    Book searchByCRN(int crn){
        for(int i=0;i<books.size();i++){
            if(books.get(i).crn==crn){
                return books.get(i);
            }
        }
        return null;
    }

    boolean addBook(String t, String a, int year, int crn, Condition c, ArrayList<String> genres) {
        Book b = new Book(t, a, crn, year, c, genres);
        return books.add(b);
    }

    void removeBook(Book b) {
        books.remove(b);
    }
    /*
    public boolean save(){
        try {
            writeBooks();
            return true;
        } catch (IOException ex) {
            //Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean load(){
        try {
            readBooks();
            return true;
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void writeBooks() throws IOException {
        WR r = new WR();
        FileOutputStream fos = new FileOutputStream(new File(r.returnBookDataPath()), false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(books);
        oos.close();
        fos.close();
    }

    private void readBooks() throws IOException, ClassNotFoundException {
        WR r = new WR();
        FileInputStream fis = new FileInputStream(new File(r.returnBookDataPath()));
        ObjectInputStream ois = new ObjectInputStream(fis);
        books = (ArrayList<Book>) ois.readObject();
        ois.close();
        fis.close();
    }*/

}
