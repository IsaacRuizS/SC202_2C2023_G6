
package com.sc303.proyectoprueba;

import java.time.LocalTime;
import javax.swing.JOptionPane;


public class Medico {
    //atributos
    public String idMedico;    
    public String nombre;
    public String especialidad;
    public LocalTime horaAlmuerzo;
    public boolean estado;

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
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
    public static void prueba1(){
        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
    }
    
    public static void crearMedico(){
        
    }
    public static void eliminarMedico(){
    
    }
    public static void actualizarMedico(){
    
    }
    public static void mostrarMedico(){
    
    }
}
