package com.mycompany.peluqueria_canina.logica;

import com.mycompany.peluqueria_canina.igu.VizualizarDatos;
import com.mycompany.peluqueria_canina.persistencia.ControladoraPersistencia;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ControladoraLogica {
    
    ControladoraPersistencia ctrlPersistencia = new ControladoraPersistencia();
 
    public void cargarDatos(String nombre, String raza, String color, String nomDuenio,
    String celDuenio, String observaciones, String alergico, String atencionEspecial) {
        
        //Creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nomDuenio);
        duenio.setCelular(celDuenio);
        
        //Creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
        mascota.setNom_perro(nombre);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atencionEspecial);
        mascota.setObservaciones(observaciones);
        mascota.setDuenio(duenio);
        
        ctrlPersistencia.guardar (duenio, mascota);
    }

    public List<Mascota> cargarDatosTabla() {
        return ctrlPersistencia.traerMascotas();
    }

    public void eliminarMascota(int numMascota) {
        ctrlPersistencia.eliminarMascota(numMascota);
    }

    public Mascota traerMascota(int numMascota) {
        return ctrlPersistencia.traerMascota(numMascota);
    }

    public void guardarDatosActualizados(int num_cliente, int id_duenio, 
        String nomMascota, String color, String raza, String observaciones, 
        String alergico, String atencion, String nomDuenio, String celDuenio) {
        
        Mascota mascota = new Mascota();
        Duenio duenio = new Duenio();
        VizualizarDatos visDatos = new VizualizarDatos();
        
        mascota.setNum_cliente(num_cliente);
        duenio.setId_duenio(id_duenio);
        mascota.setDuenio(duenio);
        mascota.setNom_perro(nomMascota);
        mascota.setColor(color);
        mascota.setRaza(raza);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atencion);
        duenio.setNombre(nomDuenio);
        duenio.setCelular(celDuenio);
        ctrlPersistencia.editarMascotaDuenio(mascota, duenio);
        visDatos.cargarTabla();
        
        JOptionPane optionPane = new JOptionPane("Los datos han sido actualizados correctamente");
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Actualizacion exitosa");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        
    }
}
