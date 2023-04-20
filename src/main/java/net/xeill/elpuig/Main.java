package net.xeill.elpuig;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;

public class Main {
    public static void main(String[] args) throws XQException {
        ExistController ec = new ExistController();
        XQResultSequence xqrs = ec.executeQuery("for $book in doc('/db/foaf/books.xml')/library/book where $book/author='Stephen King' return $book/title");
        ec.printResultSequence(xqrs);
        xqrs = ec.executeQuery("for $book in doc('/db/foaf/books.xml')/library/book where $book/year < 1960 return $book");
        ec.printResultSequence(xqrs);
    }
}