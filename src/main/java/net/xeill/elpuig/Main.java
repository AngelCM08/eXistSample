package net.xeill.elpuig;

import javax.xml.xquery.XQException;
import javax.xml.xquery.XQResultSequence;

public class Main {
    public static void main(String[] args) throws XQException {
        ExistController ec = new ExistController();
        String columna = "Nombre";
        String personajeId = "1";
        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje where $personaje/Id = '"+personajeId+"' return $personaje/"+columna);
        ec.printResultSequence(xqrs);
    }
}