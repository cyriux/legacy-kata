package fr.arolla.atelier.legacy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookManager {

    List<Model.Book> data = Arrays.asList(
            getBook("le petit vers de terre","J carpat"),
            getBook("les comptes de l'ouest","Joe cowboy"),
            getBook("le dernier pancake","jimmy cake"),
            getBook("le petit poucet","J carpat"));

    public List<Model.Book> maj(String input){

        List<Model.Book> list= new ArrayList<Model.Book>();
        list.addAll(data);
        return list;
    }


    private static Model.Book getBook(String s,String a) {
        Model.Book book=new Model.Book();
        book.setName(s);
        Model.Author author=new Model.Author();
        author.setName(a.split(" ")[0]);
        author.setPrename(a.split(" ")[1]);
        book.setAuthor(author);
        return book;
    }

}
