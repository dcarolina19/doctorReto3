/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoDoctor3.RetoDoctor3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioEspecialidad {
    @Autowired
    private InterfaceEspecialidad crud;
    public List<Especialidad> getAll(){
        return (List<Especialidad>) crud.findAll();
    }
    public Optional<Especialidad> getEspecialidad(int id){
        return crud.findById(id);
    }

    public Especialidad save(Especialidad especialidad){
        return crud.save(especialidad);
    }
    public void delete(Especialidad especialidad){
       crud.delete(especialidad);
    }
}
    
