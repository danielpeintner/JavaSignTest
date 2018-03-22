package com.mycompany.helloworld.jaxb;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.mycompany.helloworld.jaxb.Book;
import com.mycompany.helloworld.jaxb.Bookstore;

public class BookMain {

    private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {

        // create bookstore, assigning book
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Fraport Bookstore");
        bookstore.setLocation("Frankfurt Airport");

        // create books
        Book book1 = new Book();
        book1.setIsbn("978-0060554736");
        book1.setTitle("The Game");
        book1.setAuthor("Neil Strauss");
        book1.setPublisher("Harpercollins");
        bookstore.getBook().add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-3832180577");
        book2.setTitle("Feuchtgebiete");
        book2.setAuthor("Charlotte Roche");
        book2.setPublisher("Dumont Buchverlag");
        bookstore.getBook().add(book2);




        // bookstore.setBookList(bookList);

        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class); // , Book.class// Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(bookstore, System.out);

        // Write to File
        m.marshal(bookstore, new File(BOOKSTORE_XML));

        // write to deflate outputstream
        DeflaterOutputStream dos = new DeflaterOutputStream(new FileOutputStream(BOOKSTORE_XML + ".def"));
        m.marshal(bookstore, dos);
        dos.close();

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(
                BOOKSTORE_XML));
        List<Book> list = bookstore2.getBook();
        for (Book book : list) {
            System.out.println("Book: " + book.getTitle() + " from "
                    + book.getAuthor());
        }


        // EXIficient
        // EXIFactory exiFactory = DefaultEXIFactory.newInstance();
    }
}
