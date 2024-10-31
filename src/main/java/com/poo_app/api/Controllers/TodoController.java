package com.poo_app.api.Controllers;

import com.poo_app.api.Models.Task;
import com.poo_app.api.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Etiqueta: Sigue especificaciones Rest
@RestController
public class TodoController {
    // Inyección automática del repositorio;
    // Dismunuye líneas de cóodigo al omitir el constructor y la creación de instancia manualmente
    @Autowired
    private TodoRepository todoRepository;

    // Etiqueta Get: Lee datos del servidor ; valor "/": visualizar primer valor al entrar al localhost
    @GetMapping(value = "/")
    public String holamundo(){
        return "Hola Mundo";
    }
    // Obtener todos los datos (listas)
    @GetMapping(value= "/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    // Enviar datos al servidor
    @PostMapping(value= "/savetask")
    public String savetask(@RequestBody Task task){
        todoRepository.save(task);
        return "saved task";
    }

    // Actualizar datos
    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        // Encontrar el id descrita en la cabecera del endpoint en la BDD
        Task updateTask = todoRepository.findById(id).get();
        // Obtener el título del JSON
        updateTask.setTitle(task.getTitle());
        // Obtiene la descripción del JSON
        updateTask.setDescription(task.getDescription());
        // Se guardan los nuevos datos ; Actualización por medio del id
        todoRepository.save(updateTask);
        return "Update Task";
    }

    // Eliminar una lista por medio del id
    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        // Se obtiene el id y se pasa a "deleteTask"
        Task deleteTask = todoRepository.findById(id).get();
        // Se eliminar toda la lista con id determinado
        todoRepository.delete(deleteTask);
        // Mensaje de eliminación exitosa
        return "Delete Task";
    }
}
