/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoDoctor3.RetoDoctor3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosDoctor {
    @Autowired
    private RepositorioDoctor metodoCrud;

    public List<Doctor> getAll() {
        return metodoCrud.getAll();
    }

    public Optional<Doctor> getDoctor(int doctorId) {
        return metodoCrud.getDoctor(doctorId);
    }

    public Doctor save(Doctor doctor) {
        if (doctor.getId() == null) {
            return metodoCrud.save(doctor);
        } else {
            Optional<Doctor> e = metodoCrud.getDoctor(doctor.getId());
            if (e.isEmpty()) {
                return metodoCrud.save(doctor);
            } else {
                return doctor;
            }
        }
    }

    public Doctor update(Doctor doctor) {
        if (doctor.getId() != null) {
            Optional<Doctor> e = metodoCrud.getDoctor(doctor.getId());
            if (!e.isEmpty()) {
                if (doctor.getName() != null) {
                    e.get().setName(doctor.getName());
                }
                if (doctor.getDepartment() != null) {
                    e.get().setDepartment(doctor.getDepartment());
                }
                if (doctor.getYear() != null) {
                    e.get().setYear(doctor.getYear());
                }
                if (doctor.getDescription() != null) {
                    e.get().setDescription(doctor.getDescription());
                }
                if (doctor.getSpecialty() != null) {
                    e.get().setSpecialty(doctor.getSpecialty());
                }
                 metodoCrud.save(e.get());
                 return e.get();
             }else {
                   return doctor;
            }
        }else{
            return doctor;
        }
    }   

    

    public boolean deleteDoctor(int doctorId) {
        Boolean aBoolean = getDoctor(doctorId).map(doctor -> {
            metodoCrud.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}


