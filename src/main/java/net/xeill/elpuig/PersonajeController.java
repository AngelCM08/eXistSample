package net.xeill.elpuig;

import javax.xml.xquery.XQResultSequence;
import java.util.Scanner;

public class PersonajeController {
    ExistController ec = new ExistController();
    Scanner sc = new Scanner(System.in);

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
    public void addPersonaje(Personaje personaje) {

    }

    /**
     * Método para insertar un nuevo elemento a la BBDD.
     */
    public void addNewPersonaje(){

    }

    /**
     * Método para seleccionar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectRegisterByCondition(String columna){
        System.out.print("Cuál es el valor que quieres seleccionar: ");
        String valor = sc.nextLine();

        XQResultSequence xqrs = ec.executeQuery("for $personaje in doc('/db/tboia/Personajes.xml')/Personajes/Personaje where $personaje/"+columna+" > '"+valor+"' return $personaje");
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

    }

    /**
     * Método para actualizar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param numColumna Columna seleccionada para hacer la selección.
     */
    public void updateRegistersByCondition(int numColumna) {

    }

    /**
     * Método para eliminar el registro seleccionado.
     *
     * @param personajeId Id del registro seleccionado.
     */
    public void deletePersonaje(int personajeId) {

    }


    /**
     * Método para eliminar la relación entre un personaje y un objeto.
     *
     * @param personajeId Id del personaje que se tiene que eliminar de la relación.
     */
    public void deleteRelation(int personajeId){

    }

    /**
     * Método para eliminar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param numColumna Columna seleccionada para hacer la selección.
     */
    public void eliminarPersonajePorCondicionDeTexto(int numColumna) {

    }
}
