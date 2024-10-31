// Entidad; Tarea; Objeto a ser modificado,obtenido, etc de la BDD
package com.poo_app.api.Models;
import jakarta.persistence.*;

// Creción de entidades: ID, título, descripción
@Entity
// Nombre tabla
@Table(name = "task")
public class Task {
    //Etiqueda de ID y Generated: Primary key, las propiedades de la tarea y son autoincrementables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Identificar una Primary key por medio de un ID;
    // ID: único para cada tarea
    private long id;
    // Crea una columna en la BDD; columna para "title" y "description"
    @Column
    private String title;
    @Column
    private String description;

    // Para obtener ID
    public long getId() {
        return id;
    }
    // Para enviar o colocar ID en BDD
    public void setId(long id) {
        this.id = id;
    }
    //Para obtener Título
    public String getTitle() {
        return title;
    }
    // Para enviar o colocar un Título en BDD
    public void setTitle(String title) {
        this.title = title;
    }
    // Para obtener la Descripción
    public String getDescription() {
        return description;
    }
    // Para enviar o colocar una Descripción en BDD
    public void setDescription(String description) {
        this.description = description;
    }
}
