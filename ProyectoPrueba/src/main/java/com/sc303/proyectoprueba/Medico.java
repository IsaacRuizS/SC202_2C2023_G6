
package com.sc303.proyectoprueba;

import java.time.LocalTime;
import javax.swing.JOptionPane;


public class Medico {
    //atributos
    private int idMedico;    
    private String nombre;
    private String especialidad;
    private LocalTime horaAlmuerzo;
    private boolean estado;

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalTime getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(LocalTime horaAlmuerzo) {
        this.horaAlmuerzo = horaAlmuerzo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
  
    //Metodos
    public static void crearMedico(){
        
    }
    public static void eliminarMedico(){
    
    }
    public static void actualizarMedico(){
    
    }
    public static void mostrarMedico(){
    
    }
}
