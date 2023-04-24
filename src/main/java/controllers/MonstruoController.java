package controllers;

import models.Monstruo;

import javax.xml.xquery.XQResultSequence;
import java.util.*;

/**
 *  Clase que permite realizar una serie de acciones sobre la entidad Monstruo.
 */
public class MonstruoController {
    ExistController ec = new ExistController();
    Scanner sc = new Scanner(System.in);
    public List<String> colsName = new ArrayList<>(Arrays.asList("Descripcion","Icono","Id","Nombre","Vida"));

    /**
     * Constructor de la clase.
     */
    public MonstruoController() {}

    /**
     * Método para listar las entidades que existen en la tabla de la BBDD equivalente a la clase.
     *
     * @return Lista de objetos de la entidad que controla la clase.
     */
    public void selectAllMonstruos() {
        XQResultSequence xqrs = ec.executeQuery("for $monstruo in doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo return $monstruo");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método que permite introducir un objeto en la BBDD.
     *
     * @param monstruo Objeto de la clase que se controla.
     */
    public void addMonstruo(Monstruo monstruo) {
        String xquery = "update insert \n" +
                "   <Monstruo>\n" +
                "        <Descripcion>"+monstruo.getDescripcion()+"</Descripcion>\n" +
                "        <Icono>"+monstruo.getIcono()+"</Icono>\n" +
                "        <Id>"+monstruo.getId()+"</Id>\n" +
                "        <Nombre>"+monstruo.getNombre()+"</Nombre>\n" +
                "        <Vida>"+monstruo.getVida()+"</Vida>\n" +
                "    </Monstruo>" + " into doc('/db/tboia/Monstruos.xml')/Monstruos" ;
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

        XQResultSequence xqrs = ec.executeQuery("for $monstruo in doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo where $monstruo/"+columna+" "+condicion+" '"+valor+"' return $monstruo");
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para seleccionar todos los campos de la columna seleccionada.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void selectMonstruoTableColumn(int columna) {
        XQResultSequence xqrs = ec.executeQuery("for $monstruo in doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo return $monstruo/"+columna);
        ec.printResultSequence(xqrs);
    }

    /**
     * Método para actualizar los campos del registro seleccionado.
     *
     * @param monstruoId Id del registro seleccionado.
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void updateMonstruo(Integer monstruoId, int columna) {
        System.out.print("Cuál es el valor actualizado: ");
        String valor = sc.nextLine();
        ec.executeCommand("update value doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo[Id = "+monstruoId+"]/"+columna+" with '"+valor+"'");
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

        ec.executeCommand("update value doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo["+columna+" = "+valorAntiguo+"]/"+columna+" with '"+valorNuevo+"'");
    }

    /**
     * Método para eliminar el registro seleccionado.
     *
     * @param monstruoId Id del registro seleccionado.
     */
    public void deleteMonstruo(int monstruoId) {
        ec.executeCommand("update value doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo[Id = "+monstruoId+"]");
    }

    /**
     * Método para eliminar todos los registros que cumplan una condición
     * cuya columna seleccionada coincida con el valor indicado.
     *
     * @param columna Columna seleccionada para hacer la selección.
     */
    public void eliminarMonstruoPorCondicionDeTexto(int columna) {
        System.out.print("Cuál es el valor que quieres eliminar: ");
        String valorAntiguo = sc.nextLine();

        ec.executeCommand("update value doc('/db/tboia/Monstruos.xml')/Monstruos/Monstruo["+columna+" = "+valorAntiguo+"]");
    }
}