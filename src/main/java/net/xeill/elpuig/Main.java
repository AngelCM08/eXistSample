package net.xeill.elpuig;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;

public class Main {
    public static void main(String[] args) throws XQException {
        ExistController ec = new ExistController();
        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje where $personaje/Nombre='Isaac' return $personaje/Nombre");
        ec.printResultSequence(xqrs);
        xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje where $personaje/Vida > 3 return $personaje");
        ec.printResultSequence(xqrs);
    }
}