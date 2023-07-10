
package com.sc303.proyectoprueba;

import javax.swing.JOptionPane;


public class Medico {
    //atributos
    private int idMedico;    
    private String nombre;
    private String especialidad;
    private int horaAlmuerzo;
    private boolean estado;

    public Medico(int idMedico, String nombre, String especialidad, int horaAlmuerzo, boolean estado) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horaAlmuerzo = horaAlmuerzo;
        this.estado = estado;
    }

    public Medico() {
    }
    
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

    public int getHoraAlmuerzo() {
        return horaAlmuerzo;
    }

    public void setHoraAlmuerzo(int horaAlmuerzo) {
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
        JOptionPane.showMessageDialog(null, "Crear Medico");
        //arreglo a almacenar medicos 
        //Solicitar Datos del medito
        // instanciar el objeto
        // settear valores
        // agregar al arreglo de objetos 
        
    }
    public static void eliminarMedico(){
        JOptionPane.showMessageDialog(null, "Eliminar Medico");
        ProyectoPrueba.administrarMedicos();

    }
    public static void actualizarMedico(){
        JOptionPane.showMessageDialog(null, "Actualizar Medico");
        ProyectoPrueba.administrarMedicos();
    }
    public static void mostrarMedico(){
        JOptionPane.showMessageDialog(null, "Mostrar Medico");
        ProyectoPrueba.administrarMedicos();
                         
   
   
   
    }
}
