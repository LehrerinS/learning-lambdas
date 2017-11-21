package com.teamtreehouse.lambdas;

// I thought I always have to inherit form the interface in order to use it but seems like I can simply only import interface I want ot use
// It is also probably optimal like that because then I don't have to override all methods as I would have to if I implement it
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

//    SANJA this was introduced first
//    there was no way to define method outside the class??? Ah, probably it means on method compare outside of class Book
//    Sam = single abstract method
//    Why is this named anonymous class???

    public static void usingAnonymousInlineClass(){
        List<Book> books = Books.all();
//        Interface Comparator takes type of Object it compares (in this case Book) and this is the type it is also used in compare method which is override below
//        Method sort takes always two arguments, first is a List and second one is Comparator (I think it means that compare method from Comparator has to be override always???)
        Collections.sort(books, new Comparator<Book>(){
            //            We have to specify for which field comparision will be done (if class Book would have only one field it would not be needed)
            @Override
            public int compare(Book b1, Book b2){
//                In this case we specified that we will compare with field title
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });

//        Here we just print output in using for loop
        for (Book book : books){
            System.out.println(book);
        }
    }

    //    method outside the class is called function???
    public static void usingLambdasOnLongForm(){
        List<Book> books = Books.all();
//        Here we don't have to specifyComparator interface and compare method. This sing refers to Comparator interface
        Collections.sort(books, (Book b1, Book b2) -> {
            return b1.getTitle().compareTo(b2.getTitle());
        });
        for (Book book : books){
            System.out.println(book);
        }
    }

    public static void usingLambdasOnShortForm(){
        List<Book> books = Books.all();
//        Here we don't even have to specify which type is b1 and b2. And also return is not needed
        Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
//        Another thing this is faster looping comparing to for loop. And this here is Lambda -> for System class
        books.forEach((book)->System.out.println(book));
    }

    //    Why is this named using method references???
    public static void usingMethodReferences(){
        List<Book> books = Books.all();
//        Collections.sort(books, Comparator.comparing(b -> b.getTitle()));
//        Here we compare using comparing method from Comparator interface. For comparing we need to specify Class and method from class that we want to use comparision with
//        This is the simplest!!! But I still don't get t fully :)))
        Collections.sort(books, Comparator.comparing(Book::getTitle));
//        books.forEach((book)->System.out.println(book));
//        Also this one is using the same principle, class and then :: method
        books.forEach(System.out::println);
    }

    public static void main(String[] args) {
        // write your code here
//        usingAnonymousInlineClass();
//        usingLambdasOnLongForm();
//        usingLambdasOnShortForm();
        usingMethodReferences();
    }
}
