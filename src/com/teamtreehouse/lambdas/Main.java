package com.teamtreehouse.lambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

//    SANJA this was introduced first
//    there was no way to define method outside the class
//    Sam = single abstract method

    public static void usingAnonymousInlineClass(){
        List<Book> books = Books.all();
        Collections.sort(books, new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2){
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });

        for (Book book : books){
            System.out.println(book);
        }
    }

//    method outside the class is called function
    public static void usingLambdasOnLongForm(){
        List<Book> books = Books.all();
        Collections.sort(books, (Book b1, Book b2) -> {
          return b1.getTitle().compareTo(b2.getTitle());
        });
        for (Book book : books){
            System.out.println(book);
        }
    }

    public static void usingLambdasOnShortForm(){
        List<Book> books = Books.all();
        Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        books.forEach((book)->System.out.println(book));
    }

    public static void usingMethodReferences(){
        List<Book> books = Books.all();
//        Collections.sort(books, Comparator.comparing(b -> b.getTitle()));
        Collections.sort(books, Comparator.comparing(Book::getTitle));
//        books.forEach((book)->System.out.println(book));
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
