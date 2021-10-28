
package RetoDoctor3.RetoDoctor3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDoctor {
    @Autowired
    private InterfaceDoctor crud;
    
    public List<Doctor> getAll(){
        return (List<Doctor>) crud.findAll();
    }
        
    public Optional <Doctor> getDoctor (int id){
        return crud.findById(id);     
    }
    public Doctor save(Doctor doctor){
        return crud.save(doctor);
    }

    void delete(Doctor doctor) {
        crud.delete(doctor);
       
    }
}
    
