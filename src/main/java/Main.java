import controllers.*;
import view.Menu;

public class Main {
    public static void main(String[] args){
        PersonajeController personajeController = new PersonajeController();
        MonstruoController monstruoController = new MonstruoController();
        ObjetoController objetoController = new ObjetoController();
        Menu menu = new Menu();

        int option = menu.mainMenu();

        while (option != 9) {
            switch (option) {
                case 1: // Mostrar tabla completa.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> personajeController.selectAllPersonajes();
                        case "monstruo" -> monstruoController.selectAllMonstruos();
                        case "objeto" -> objetoController.selectAllObjetos();
                    }
                    break;
                case 2: // Seleccionar una columna
                    switch (menu.TablesMenu()) {
                        case "personaje" -> personajeController.selectPersonajeTableColumn(menu.listHeader(personajeController.colsName));
                        case "monstruo" -> monstruoController.selectMonstruoTableColumn(menu.listHeader(monstruoController.colsName));
                        case "objeto" ->  objetoController.selectObjetoTableColumn(menu.listHeader(objetoController.colsName));
                    }
                    break;
                case 3: // Seleccionar elementos que contengan un texto.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> {
                            personajeController.selectAllPersonajes();
                            personajeController.selectRegisterByCondition(menu.listHeader(personajeController.colsName));
                        }
                        case "monstruo" -> {
                            monstruoController.selectAllMonstruos();
                            monstruoController.selectRegisterByCondition(menu.listHeader(monstruoController.colsName));
                        }
                        case "objeto" -> {
                            objetoController.selectAllObjetos();
                            objetoController.selectRegisterByCondition(menu.listHeader(objetoController.colsName));
                        }
                    }
                    break;
                case 4: // Insertar registro.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> personajeController.addPersonaje();
                        case "monstruo" -> monstruoController.addMonstruo();
                        case "objeto" -> objetoController.addObjeto();
                    }
                    break;
                case 5: // Modificar elementos de un registro.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> personajeController.updatePersonaje(menu.selectPersonajeId(), menu.listHeader(personajeController.colsName));
                        case "monstruo" -> monstruoController.updateMonstruo(menu.selectMonstruoId(), menu.listHeader(monstruoController.colsName));
                        case "objeto" -> objetoController.updateObjeto(menu.selectObjetoId(), menu.listHeader(objetoController.colsName));
                    }
                    break;
                case 6: // Modificar registros según condición.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> {
                            personajeController.selectAllPersonajes();
                            personajeController.updateRegistersByCondition(menu.listHeader(personajeController.colsName));
                        }
                        case "monstruo" -> {
                            monstruoController.selectAllMonstruos();
                            monstruoController.updateRegistersByCondition(menu.listHeader(monstruoController.colsName));
                        }
                        case "objeto" -> {
                            objetoController.selectAllObjetos();
                            objetoController.updateRegistersByCondition(menu.listHeader(objetoController.colsName));
                        }
                    }
                    break;
                case 7: // Eliminar registro de una tabla.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> personajeController.deletePersonaje(menu.selectPersonajeId());
                        case "monstruo" -> monstruoController.deleteMonstruo(menu.selectMonstruoId());
                        case "objeto" -> objetoController.deleteObjeto(menu.selectObjetoId());
                    }
                    break;
                case 8: // Eliminar registro de una tabla.
                    switch (menu.TablesMenu()) {
                        case "personaje" -> {
                            personajeController.selectAllPersonajes();
                            personajeController.eliminarPersonajePorCondicionDeTexto(menu.listHeader(personajeController.colsName));
                        }
                        case "monstruo" -> {
                            monstruoController.selectAllMonstruos();
                            monstruoController.eliminarMonstruoPorCondicionDeTexto(menu.listHeader(monstruoController.colsName));
                        }
                        case "objeto" -> {
                            objetoController.selectAllObjetos();
                            objetoController.eliminarObjetoPorCondicionDeTexto(menu.listHeader(objetoController.colsName));
                        }
                    }
                    break;
            }
            option = menu.mainMenu();
        }
        System.out.println("\n**** ADIÓS! ****");
    }
}