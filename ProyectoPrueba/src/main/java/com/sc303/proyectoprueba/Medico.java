
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
    public static void mostrarMedico(Medico[]medicoArray){
        StringBuilder medicoText = new StringBuilder();
        for ( Medico medico: medicoArray) {
            if ( medico != null) {
                medicoText.append("Id: ").append(medico.getIdMedico()).append("\n");
                medicoText.append("Nombre: ").append(medico.getNombre()).append("\n");
                medicoText.append("Especialidad: ").append(medico.getEspecialidad()).append("\n");
                medicoText.append("Hora de Almuerzo: ").append(medico.getHoraAlmuerzo()).append("\n");
                medicoText.append("Estado: ").append(medico.isEstado() ? "Activa" : "Cancelada").append("\n");
                medicoText.append("----------------------------------------\n");
   }
        }
        if (medicoText.length() == 0) {
            medicoText.append("No hay medico registrado.");
        }
        JOptionPane.showMessageDialog(null, medicoText);
        ProyectoPrueba.menuSelection();
    }
    
    public static String medicoEspecialidad(Medico[]medicoArray, String especialidad ){
         StringBuilder medicoEspecialidad = new StringBuilder();
         Integer[] idsMedicosEspecialidadObject = new Integer[medicoArray.length];
        //filtro de medico segun la especilidad que traemos por parametros 
        int contador = 0;
        for ( Medico medico: medicoArray) {
            if(medico != null && medico.getEspecialidad().equalsIgnoreCase(especialidad)) {
                idsMedicosEspecialidadObject[contador] = medico.getIdMedico();
                contador++;
                medicoEspecialidad.append("Id: ").append(medico.getIdMedico()).append("\n");
                medicoEspecialidad.append("Nombre: ").append(medico.getNombre()).append("\n");
                medicoEspecialidad.append("Especialidad: ").append(medico.getEspecialidad()).append("\n");
                medicoEspecialidad.append("Hora de Almuerzo: ").append(medico.getHoraAlmuerzo()).append("\n");
                medicoEspecialidad.append("Estado: ").append(medico.isEstado() ? "Activa" : "Cancelada").append("\n");
                medicoEspecialidad.append("----------------------------------------\n");
                
            }
        }
            if (medicoEspecialidad.length() == 0) {
                medicoEspecialidad.append("No hay medico registrado.");
            }
        //int idMedico = JOptionPane.showInputDialog(null, medicoEspecialidad);
          String servicioSeleccionado = (String) JOptionPane.showInputDialog(null, medicoEspecialidad,
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, idsMedicosEspecialidadObject, idsMedicosEspecialidadObject[0]);
        //validar que no vaya vacio   
              return servicioSeleccionado;
          

        
    }

}