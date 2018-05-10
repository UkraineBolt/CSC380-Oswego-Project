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
    CheckedOut, InStock
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
public class Stock implements java.io.Serializable {

    public class Book implements java.io.Serializable, Comparable<Book> {

        private String title, author;
        //private ArrayList<Genres> genres;
        private ArrayList<String> genres;
        private String crn;
        private int year;
        private Availability av;
        private Condition condition;
        int count;

        Book(String t, String a, int y, String c, Condition con, ArrayList<String> genre) {
            title = t;
            author = a;
            crn = c;
            year = y;
            condition = con;
            av = Availability.InStock;
            genres = genre;
            count = 1;
        }

        private void changeAvailability() {
            if (av == Availability.InStock) {
                av = Availability.CheckedOut;
            } else {
                av = Availability.InStock;
            }
        }

        boolean editAvilibility(boolean add) {
            if(add){
                if(count>0){
                    count++;
                }else{
                    count++;
                    changeAvailability();
                }
            }else{
                if(count>1){
                    count--;
                }else{
                    count--;
                    changeAvailability();
                }
            }
            return true;
            
        }

        String getCRN() {
            return crn;
        }

        void ChangeCondition(Condition c) {
            condition = c;
        }

        @Override
        public String toString() {
            String temp = "";
            for (int i = 0; i < genres.size(); i++) {
                temp = temp + genres.get(i) + ",";
            }
            return temp.substring(0, temp.length() - 1) + ":::" + title + ":::" + author + ":::" + year + ":::" + crn + ":::" + condition.toString() + ":::" + av.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Book t = (Book) obj;
            if (!this.title.equals(t.title) || !this.author.equals(t.author) || !this.crn.equals(t.crn)) {
                return false;
            }
            if (this.year != t.year) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Book o) {
            if (this.title.compareTo(o.title) > 0) {
                return 1;
            } else if (this.title.compareTo(o.title) < 0) {
                return -1;
            } else {
                if (this.author.compareTo(o.author) > 0) {
                    return 1;
                } else if (this.author.compareTo(o.author) < 0) {
                    return -1;
                } else {
                    return -1;
                }
            }
        }
    }
    ArrayList<Book> books;
    ArrayList<String> crnList;

    Stock() {
        books = new ArrayList<>();
        crnList = new ArrayList<>();
    }

    Condition callCondition(String x) {
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

    ArrayList<Book> callAll() {
        return books;
    }

    Book searchBook(String title, String author, int year, String crn) {
        Book fake = new Book(title, author, year, crn, null, null);
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(fake)) {
                return books.get(i);
            }
        }
        return null;
    }

    Book searchByCRN(String crn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).crn.equals(crn)) {
                return books.get(i);
            }
        }
        return null;
    }
    
    boolean changeCondition(String crn,Condition c){
        Book x = searchByCRN(crn);
        if(x!=null&&c!=null){
            x.ChangeCondition(c);
            return true;
        }
        return false;
    }

    ArrayList<Book> limitedSearch(String title, String author, int year, String crn) {
        ArrayList<Book> list = new ArrayList<>();
        Book fake = new Book(title, author, year, crn, null, null);
        for (int i = 0; i < books.size(); i++) {
            if (compareBooksWithLimitedInfo(fake, books.get(i))) {
                list.add(books.get(i));
            }
        }
        return list;
    }

    boolean compareBooksWithLimitedInfo(Book a, Book b) {
        if(a==null || b==null){
            return false;
        }
        if (a.equals(b)) {
            return true;
        }
        if (!a.title.equals("")) {
            if (!a.title.contains(b.title)) {
                return false;
            }
        }
        if (!a.author.equals("")) {
            if (!a.author.contains(b.author)) {
                return false;
            }
        }
        if (a.year != -1) {
            if (a.year != b.year) {
                return false;
            }
        }
        if (!a.crn.equals("")) {
            if (!a.crn.contains(b.crn)) {
                return false;
            }
        }

        return true;
    }

    boolean addBook(String t, String a, int year, String crn, Condition c, ArrayList<String> genres) {
        Book b = new Book(t, a, year, crn, c, genres);
        Book temp = searchBook(t, a, year, crn);
        if (temp == null && !crnList.contains(crn)) {
            crnList.add(crn);
            return books.add(b);
        } else if(temp != null &&crnList.contains(crn)){
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).equals(temp)) {
                    books.get(i).count++;
                }
            }
            return true;
        }else{
            return false;
        }
        

    }

    void removeBook(Book b) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(b)) {
                if(books.get(i).count > 1){
                    books.get(i).count--;
                    break;
                }
                books.remove(books.get(i));
                break;
            }
        }
    }

}
