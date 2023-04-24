package controllers;

import models.Objeto;
import javax.xml.xquery.XQResultSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ObjetoController {
    ExistController ec = new ExistController();
    Scanner sc = new Scanner(System.in);
    public List<String> colsName = new ArrayList<>(Arrays.asList("Descripcion","Icono","Id","Nombre"));

    /**
     * Constructor de la clase.
     */
    public ObjetoController() {}

    /**
     * Método para listar las entidades que existen en la tabla de la BBDD equivalente a la clase.
     *
     * @return Lista de objetos de la entidad que controla la clase.
     */
    public void selectAllObjetos() {
        XQResultSequence xqrs = ec.executeQuery("for $objeto in doc('/db/tboia/Objetos.xml')/Objetos/Objeto return $objeto");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método que permite introducir un objeto en la BBDD.
     *
     * @param objeto Objeto de la clase que se controla.
     */
    public void addObjeto(Objeto objeto) {
        String xquery = "update insert \n" +
                "   <Objeto>\n" +
                "        <Descripcion>"+objeto.getDescripcion()+"</Descripcion>\n" +
                "        <Icono>"+objeto.getIcono()+"</Icono>\n" +
                "        <Id>"+objeto.getId()+"</Id>\n" +
                "        <Nombre>"+objeto.getNombre()+"</Nombre>\n" +
                "    </Objeto>" + " into doc('/db/tboia/Objetos.xml')/Objetos" ;
        ec.executeCommand(xquery);
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

        XQResultSequence xqrs = ec.executeQuery("for $objeto in doc('/db/tboia/Objetos.xml')/Objetos/Objeto where $objeto/"+columna+" "+condicion+" '"+valor+"' return $objeto");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para seleccionar todos los campos de la columna seleccionada.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectObjetoTableColumn(int columna) {
        XQResultSequence xqrs = ec.executeQuery("for $objeto in doc('/db/tboia/Objetos.xml')/Objetos/Objeto return $objeto/"+columna);
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para actualizar los campos del registro seleccionado.
     *
     * @param objetoId Id del registro seleccionado.
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void updateObjeto(Integer objetoId, int columna) {
        System.out.print("Cuál es el valor actualizado: ");
        String valor = sc.nextLine();
        ec.executeCommand("update value doc('/db/tboia/Objetos.xml')/Objetos/Objeto[Id = "+objetoId+"]/"+columna+" with '"+valor+"'");
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

        ec.executeCommand("update value doc('/db/tboia/Objetos.xml')/Objetos/Objeto["+columna+" = "+valorAntiguo+"]/"+columna+" with '"+valorNuevo+"'");
    }

    /**
     * Método para eliminar el registro seleccionado.
     *
     * @param objetoId Id del registro seleccionado.
     */
    public void deleteObjeto(int objetoId) {
        ec.executeCommand("update value doc('/db/tboia/Objetos.xml')/Objetos/Objeto[Id = "+objetoId+"]");
    }

    /**
     * Método para eliminar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void eliminarObjetoPorCondicionDeTexto(int columna) {
        System.out.print("Cuál es el valor que quieres eliminar: ");
        String valorAntiguo = sc.nextLine();

        ec.executeCommand("update value doc('/db/tboia/Objetos.xml')/Objetos/Objeto["+columna+" = "+valorAntiguo+"]");
    }
}
