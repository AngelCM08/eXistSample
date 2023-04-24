package view;

import controllers.MonstruoController;
import controllers.ObjetoController;
import controllers.PersonajeController;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que comunica al usuario con la aplicación.
 */
public class Menu {
    private int option;
    Scanner sc = new Scanner(System.in);
    public Menu() {
        super();
    }

    /**
     * Menú con las opciones principales de la aplicación.
     *
     * @return valor entero introducido por el usuario para seleccionar la opción deseada.
     */
    public int mainMenu() {
        do{
            option = 0;
            System.out.println(" \nMENU PRINCIPAL \n");

            System.out.println("1. Mostrar tabla completa.");
            System.out.println("2. Seleccionar una columna.");
            System.out.println("3. Seleccionar elementos que contengan un texto.");
            System.out.println("4. Insertar registro.");
            System.out.println("5. Modificar atributos de un registro.");
            System.out.println("6. Modificar registros según condición.");
            System.out.println("7. Eliminar registro de una tabla.");
            System.out.println("8. Eliminar registro por condicion.");
            System.out.println("9. Salir.");
            System.out.print("Escoger opción: ");
            try{
                option = Integer.parseInt(sc.nextLine());
                if(option < 1 || option > 9){
                    System.out.println("\n*** Indica un valor númerico válido. ***");
                }
            }catch(Exception e){
                System.out.println("\n*** Selecciona una opción válida. ***");
            }
        }while(option < 1 || option > 9);
        return option;
    }

    /**
     * Menú para seleccionar una de las tablas de la BBDD.
     *
     * @return nombre de la tabla escogida por el usuario a través de un valor entero.
     */
    public String TablesMenu() {
        do {
            option = 0;
            System.out.println(" \nSOBRE QUE TABLA QUIERES REALIZAR LA ACCIÓN\n");

            System.out.println("1. Personaje.");
            System.out.println("2. Monstruo.");
            System.out.println("3. Objeto.");
            System.out.println("4. Atrás.");
            System.out.print("Escoger opción: ");

            try{
                option = Integer.parseInt(sc.nextLine());
                if(option < 1 || option > 4){
                    System.out.println("\n*** Indica un valor númerico válido. ***");
                }
            }catch(Exception e){
                System.out.println("\n*** Selecciona una opción válida. ***");
            }
        } while (option < 1 || option > 4);
        switch (option) {
            case 1 -> { return "personaje"; }
            case 2 -> { return "monstruo"; }
            case 3 -> { return "objeto"; }
        }
        return "";
    }

    /**
     * Función que muestra un listado de todas las columnas de una tabla.
     * Permite al usuario escoger que columna quiere seleccionar.
     *
     * @param colsName Lista de columnas de la tabla las cuáles se quieren listar.
     */
    public String listHeader(List<String> colsName){
        int opt = -1;
        do {
            for (int i = 0; i < colsName.size(); i++) {
                System.out.println(i+1+". "+colsName.get(i));
            }
            System.out.print("Selecciona la columna a gestionar: ");
            try {
                opt = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" ** ERROR. Formato erróneo **");
            }
        } while (opt < 1 || opt > colsName.size());
        return colsName.get(opt-1);
    }

    /**
     * Función que muestra un listado de todos los registros de una tabla.
     * Permite al usuario escoger que registro quiere seleccionar.
     */
    public int selectPersonajeId() {
        PersonajeController pc = new PersonajeController();
        pc.selectAllPersonajes();
        Scanner sc = new Scanner(System.in);
        boolean rep;
        do {
            rep = false;
            System.out.print("Indica el ID del registro que quieres seleccionar: ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("\n*** Indica un valor númerico válido. ***");
                rep = true;
            }
        } while (rep);
        return option;
    }

    /**
     * Función que muestra un listado de todos los registros de una tabla.
     * Permite al usuario escoger que registro quiere seleccionar.
     */
    public int selectMonstruoId() {
        MonstruoController mc = new MonstruoController();
        mc.selectAllMonstruos();
        Scanner sc = new Scanner(System.in);
        boolean rep;
        do {
            rep = false;
            System.out.print("Indica el ID del registro que quieres seleccionar: ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("\n*** Indica un valor númerico válido. ***");
                rep = true;
            }
        } while (rep);
        return option;
    }

    /**
     * Función que muestra un listado de todos los registros de una tabla.
     * Permite al usuario escoger que registro quiere seleccionar.
     */
    public int selectObjetoId() {
        ObjetoController oc = new ObjetoController();
        oc.selectAllObjetos();
        Scanner sc = new Scanner(System.in);
        boolean rep;
        do {
            rep = false;
            System.out.print("Indica el ID del registro que quieres seleccionar: ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("\n*** Indica un valor númerico válido. ***");
                rep = true;
            }
        } while (rep);
        return option;
    }
}