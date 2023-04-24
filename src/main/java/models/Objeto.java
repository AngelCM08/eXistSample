package models;

import java.io.Serializable;

/**
 * Clase que almacena la entidad del UML Objeto.
 *
 * @author Ángel Castro Merino
 */
public class Objeto implements Serializable {
    private int id;
    private String icono;
    private String nombre;
    private String descripcion;

    /**
     * Constrctor simple de la Clase necesario para el formateado a XML.
     */
    public Objeto(){}

    /**
     * Constructor para crear todos los objetos.
     *
     * @param id
     * @param icono
     * @param nombre
     * @param descripcion
     */
    public Objeto(int id, String icono, String nombre, String descripcion) {
        this.id = id;
        this.icono = icono;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Función que devuelve una cadena de texto con los nombres de los atributos y los valores
     * de la clase en un formato específico para evitar errores y pérdidas de información.
     *
     * @return Cadena de texto con los nombres de los atributos y sus valores.
     */
    @Override
    public String toString() {
        return "idObjeto: "+id+"\t|\t" +
                "nombre: "+nombre+"\t|\t" +
                "descripcion: "+descripcion+"\t|\t" +
                "icono: "+icono+"\t|\t";
    }
}