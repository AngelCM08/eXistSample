package controllers;

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
     */
    public void addPersonaje() {
        String personaje = "<Personaje>\n";
        for (String col : colsName) {
            System.out.println();
            System.out.print("Valor para " + col + ": ");
            personaje = personaje.concat("   <" + col + ">" + sc.nextLine() + "</" + col + ">\n");
        }
        personaje = personaje.concat("</Personaje>");
        String query = "update insert \n" + personaje + " into doc('/db/tboia/Personajes.xml')/Personajes";
        System.out.println(query);
        ec.executeCommand(query);
    }

    /**
     * Método para seleccionar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectRegisterByCondition(String columna){
        List<String> condiciones = new ArrayList<>(Arrays.asList("<",">","=","!="));
        String condicion;
        boolean rep;
        do{
            rep = false;
            System.out.print("Qué tipo de condición quieres comparar (>, >, =, !=): ");
            condicion = sc.nextLine();
            if(!condiciones.contains(condicion)){
                System.out.println("ERROR, Indica una condición válida.");
                rep = true;
            }
        }while(rep);

        System.out.print("Cuál es el valor a seleccionar: ");
        String valor = sc.nextLine();

        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje where $personaje/"+columna+" "+condicion+" '"+valor+"' return $personaje");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para seleccionar todos los campos de la columna seleccionada.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectPersonajeTableColumn(String columna) {
        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje return $personaje/"+columna);
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para actualizar los campos del registro seleccionado.
     *
     * @param personajeId Id del registro seleccionado.
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void updatePersonaje(Integer personajeId, String columna) {
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
    public void updateRegistersByCondition(String columna) {
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
        ec.executeCommand("update delete doc('/db/tboia/Personajes.xml')/Personajes/Personaje[Id = "+personajeId+"]");
    }

    /**
     * Método para eliminar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void eliminarPersonajePorCondicionDeTexto(String columna) {
        System.out.print("Cuál es el valor que quieres eliminar: ");
        String valor = sc.nextLine();
        ec.executeCommand("update delete doc('/db/tboia/Personajes.xml')/Personajes/Personaje["+columna+" = "+valor+"]");
    }
}
