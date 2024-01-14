package com.mycompany.peluqueria_canina.persistencia;

import com.mycompany.peluqueria_canina.logica.Duenio;
import com.mycompany.peluqueria_canina.logica.Mascota;
import com.mycompany.peluqueria_canina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJPActrl = new DuenioJpaController();
    MascotaJpaController mascotaJPActrl = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
        
        //crear en la DB el Dueño
        duenioJPActrl.create(duenio);
        
        //crear en la DB la Mascota
        mascotaJPActrl.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotaJPActrl.findMascotaEntities();
    }

    public void eliminarMascota(int numMascota) {
        try {
            mascotaJPActrl.destroy(numMascota);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public Mascota traerMascota(int numMascota) {
        return mascotaJPActrl.findMascota(numMascota);
    }

    public void editarMascotaDuenio(Mascota mascota, Duenio duenio) {
        try {
            mascotaJPActrl.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            duenioJPActrl.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
