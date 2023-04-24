package controllers;

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
     */
    public void selectAllObjetos() {
        XQResultSequence xqrs = ec.executeQuery("for $objeto in doc('/db/tboia/Objetos.xml')/Objetos/Objeto return $objeto");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método que permite introducir un objeto en la BBDD.
     */
    public void addObjeto() {
        String objeto = "<Objeto>\n";
        for (String col : colsName) {
            System.out.println();
            System.out.print("Valor para " + col + ": ");
            objeto = objeto.concat("   <" + col + ">" + sc.nextLine() + "</" + col + ">\n");
        }
        objeto = objeto.concat("</Objeto>");
        String query = "update insert \n" + objeto + " into doc('/db/tboia/Objetos.xml')/Objetos";
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

        System.out.print("Cuál es el valor que quieres seleccionar: ");
        String valor = sc.nextLine();

        XQResultSequence xqrs = ec.executeQuery("for $objeto in doc('/db/tboia/Objetos.xml')/Objetos/Objeto where $objeto/"+columna+" "+condicion+" '"+valor+"' return $objeto");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para seleccionar todos los campos de la columna seleccionada.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectObjetoTableColumn(String columna) {
        XQResultSequence xqrs = ec.executeQuery("for $objeto in doc('/db/tboia/Objetos.xml')/Objetos/Objeto return $objeto/"+columna);
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para actualizar los campos del registro seleccionado.
     *
     * @param objetoId Id del registro seleccionado.
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void updateObjeto(Integer objetoId, String columna) {
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
    public void updateRegistersByCondition(String columna) {
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
        ec.executeCommand("update delete doc('/db/tboia/Objetos.xml')/Objetos/Objeto[Id = "+objetoId+"]");
    }

    /**
     * Método para eliminar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void eliminarObjetoPorCondicionDeTexto(String columna) {
        System.out.print("Cuál es el valor que quieres eliminar: ");
        String valorAntiguo = sc.nextLine();

        ec.executeCommand("update delete doc('/db/tboia/Objetos.xml')/Objetos/Objeto["+columna+" = "+valorAntiguo+"]");
    }
}
