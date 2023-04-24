package controllers;

import models.Personaje;
import javax.xml.xquery.XQResultSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PersonajeController {
    ExistController ec = new ExistController();
    Scanner sc = new Scanner(System.in);
    public List<String> colsName = new ArrayList<>(Arrays.asList("Cadencia","Daño","Icono","Id","Nombre","Rango","Suerte","Vel_Proyectil","Velocidad","Vida"));

    /**
     * Constructor de la clase.
     */
    public PersonajeController() {}

    /**
     * Método para listar las entidades que existen en la tabla de la BBDD equivalente a la clase.
     *
     * @return Lista de objetos de la entidad que controla la clase.
     */
    public void selectAllPersonajes() {
        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje return $personaje");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método que permite introducir un objeto en la BBDD.
     *
     * @param personaje Objeto de la clase que se controla.
     */
    public void addPersonaje() {
        Personaje personaje = createPersonaje();
        String xquery = "update insert \n" +
                "   <Personaje>\n" +
                "        <Cadencia>"+personaje.getCadencia()+"</Cadencia>\n" +
                "        <Daño>"+personaje.getDaño()+"</Daño>\n" +
                "        <Icono>"+personaje.getIcono()+"</Icono>\n" +
                "        <Id>"+personaje.getId()+"</Id>\n" +
                "        <Nombre>"+personaje.getNombre()+"</Nombre>\n" +
                "        <Rango>"+personaje.getRango()+"</Rango>\n" +
                "        <Suerte>"+personaje.getSuerte()+"</Suerte>\n" +
                "        <Vel_Proyectil>"+personaje.getVel_proyectil()+"</Vel_Proyectil>\n" +
                "        <Velocidad>"+personaje.getVelocidad()+"</Velocidad>\n" +
                "        <Vida>"+personaje.getVida()+"</Vida>\n" +
                "    </Personaje> into doc('/db/tboia/Personajes.xml')/Personajes";
        ec.executeCommand(xquery);
    }

    private Personaje createPersonaje() {
        int id;
        String icono;
        String nombre;
        int vida;
        String daño;
        String cadencia;
        String vel_proyectil;
        String rango;
        String velocidad;
        int suerte;

        boolean rep;

        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);

        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


        do{
            rep = false;
            System.out.print("Indica el valor de la Id: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
                rep = true;
            }
        }while(rep);


    }

    /**
     * Método para seleccionar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectRegisterByCondition(int columna){
        System.out.print("Cuál es el valor que quieres seleccionar: ");
        String valor = sc.nextLine();

        System.out.print("Qué tipo de condición quieres comparar: ");
        String condicion = sc.nextLine();

        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje where $personaje/"+columna+" "+condicion+" '"+valor+"' return $personaje");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para seleccionar todos los campos de la columna seleccionada.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectPersonajeTableColumn(int columna) {
        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje return $personaje/"+columna);
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para actualizar los campos del registro seleccionado.
     *
     * @param personajeId Id del registro seleccionado.
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void updatePersonaje(Integer personajeId, int columna) {
        System.out.print("Cuál es el valor actualizado: ");
        String valor = sc.nextLine();
        ec.executeCommand("update value doc('/db/tboia/Personajes.xml')/Personajes/Personaje[Id = "+personajeId+"]/"+columna+" with '"+valor+"'");
    }

    /**
     * Método para actualizar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void updateRegistersByCondition(int columna) {
        System.out.print("Cuál es el valor que quieres actualizar: ");
        String valorAntiguo = sc.nextLine();
        System.out.print("Cómo será el valor actualizado: ");
        String valorNuevo = sc.nextLine();

        ec.executeCommand("update value doc('/db/tboia/Personajes.xml')/Personajes/Personaje["+columna+" = "+valorAntiguo+"]/"+columna+" with '"+valorNuevo+"'");
    }

    /**
     * Método para eliminar el registro seleccionado.
     *
     * @param personajeId Id del registro seleccionado.
     */
    public void deletePersonaje(int personajeId) {
        ec.executeCommand("update value doc('/db/tboia/Personajes.xml')/Personajes/Personaje[Id = "+personajeId+"]");
    }

    /**
     * Método para eliminar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void eliminarPersonajePorCondicionDeTexto(int columna) {
        System.out.print("Cuál es el valor que quieres eliminar: ");
        String valorAntiguo = sc.nextLine();

        ec.executeCommand("update value doc('/db/tboia/Personajes.xml')/Personajes/Personaje["+columna+" = "+valorAntiguo+"]");
    }
}
