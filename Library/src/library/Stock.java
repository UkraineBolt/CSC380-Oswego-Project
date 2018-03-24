/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;

enum Availability{
    CheckedOut,Reserved,InStock
}
enum Condition{
    New,Good,Worned,Poor,Unacceptable,InRepair
}
enum Genres{
Science,Fiction,Satire,Drama,Action,Adventure,Romance,
Mystery,Horror,SelfHelp,Health,Guide,Travel,Childrens,
Religion,Spirituality,NewAge,History,Math, Anthology,
Poetry,Encyclopedias,Dictionaries,Comics,Art,CookBooks,
Diaries,Journals,PrayerBooks,Series,Trilogy,Biographies,
Autobiographies,Fantasy,Realism,Mythology,Tragedy,Comedy,
Classic,Folklore,PictureBook,Thiller,Maginzies
}
enum Location{
    Childrens, YoungAdult,Reference,Periodical, AdultFiction, AdultNonFiction,Archieves
}

/**
 *
 * @author alex
 */
class Stock {
    class Book{
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
            return title+author+crn+year+condition+genres.toString();
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
    //need a search functions
    
      
    
    
}
