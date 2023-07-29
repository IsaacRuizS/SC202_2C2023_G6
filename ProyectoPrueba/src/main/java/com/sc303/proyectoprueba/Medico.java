
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
    public static Medico crearMedico(Medico[] listaMedicos) {
        Medico nuevoMedico = new Medico();
        int nuevoIdMedico = 0;
        
        for(int i = 0 ; i < listaMedicos.length; i++){
            if(listaMedicos[i] == null){
                nuevoIdMedico = i + 1;
                break;
            }
        }

        nuevoMedico.setIdMedico(nuevoIdMedico);

        String nombreMedico = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico:", "Crear médico",
                JOptionPane.QUESTION_MESSAGE);
        nuevoMedico.setNombre(nombreMedico);

        String[] opcionesEspecialidad = { "Medicina General", "Cirugía Ambulatoria", "Cirugía Especializada" };
        String especialidadSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona la especialidad del médico:",
                "Crear médico", JOptionPane.QUESTION_MESSAGE, null, opcionesEspecialidad, opcionesEspecialidad[0]);
        nuevoMedico.setEspecialidad(especialidadSeleccionada);

        Integer[] horas = { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        Integer horaSeleccionada = (Integer) JOptionPane.showInputDialog(null, "Selecciona una hora de almuerzo para el médico:",
                "Crear médico", JOptionPane.QUESTION_MESSAGE, null, horas, horas[0]);
        nuevoMedico.setHoraAlmuerzo(horaSeleccionada);

        nuevoMedico.setEstado(true);
        
        //agregar el nuevo medico dentro de lista medicos
        //llamar a proyectoprueba.administrarMedicos();
        
        for (int i = 0; i < listaMedicos.length; i++) {
            if (listaMedicos[i] == null) {
                listaMedicos[i] = nuevoMedico;
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Medico Agregado con éxito");
        ProyectoPrueba.administrarMedicos();
        
        return nuevoMedico;
    }
    
    public static void eliminarMedico(Medico[] listaMedicos) {
    String idMedicoEliminar = JOptionPane.showInputDialog(null, "Ingrese el ID del médico que desea eliminar:", "Eliminar médico", JOptionPane.QUESTION_MESSAGE);

    try {
        int idMedicoAEliminar = Integer.parseInt(idMedicoEliminar);

        boolean medicoEncontrado = false;
        for (int i = 0; i < listaMedicos.length; i++) {
            if (listaMedicos[i] != null && listaMedicos[i].getIdMedico() == idMedicoAEliminar) {
                listaMedicos[i] = null;
                medicoEncontrado = true;
                break;
            }
        }

        if (medicoEncontrado) {
            JOptionPane.showMessageDialog(null, "El médico con ID " + idMedicoAEliminar + " ha sido eliminado.", "Médico eliminado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún médico con el ID " + idMedicoAEliminar + ".", "Médico no encontrado", JOptionPane.ERROR_MESSAGE);
        }
        ProyectoPrueba.administrarMedicos();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "El ID del médico debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        ProyectoPrueba.administrarMedicos();
    }
}

    public static void actualizarMedico(Medico[] listaMedicos) {
        Medico medico = new Medico();
        
        int idMedico = Integer.parseInt(JOptionPane.showInputDialog("Indique el numero de id del medico a actualizar "));
        int contador = 6 ;
        for(int i = 0; i < listaMedicos.length; i++){
            JOptionPane.showMessageDialog(null, listaMedicos[i].getIdMedico());
            if(listaMedicos[i].getIdMedico() == idMedico){
                contador = i;
                break;
            }
        }
        String medicoViejo = "Nombre " + listaMedicos[contador].getNombre() + "\n Id "+ listaMedicos[contador].getIdMedico()+ "" + "\n Especialidad "+ listaMedicos[contador].getEspecialidad()+ ""  + "\n Hora Almuerzo "+ listaMedicos[contador].getHoraAlmuerzo()+ "";
        JOptionPane.showMessageDialog(null, medicoViejo);
        
        if (medico != null) {
            String[] opcionesEspecialidad = { "Medicina General", "Cirugía Ambulatoria", "Cirugía Especializada" };

            String nombreMedico = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del médico:", "Actualizar médico",
                    JOptionPane.QUESTION_MESSAGE);
            medico.setNombre(nombreMedico);

            String especialidadSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona la nueva especialidad del médico:",
                    "Actualizar médico", JOptionPane.QUESTION_MESSAGE, null, opcionesEspecialidad, medico.getEspecialidad());
            medico.setEspecialidad(especialidadSeleccionada);

            Integer[] horas = { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
            Integer horaSeleccionada = (Integer) JOptionPane.showInputDialog(null, "Selecciona una nueva hora de almuerzo para el médico:",
                   "Actualizar médico", JOptionPane.QUESTION_MESSAGE, null, horas, medico.getHoraAlmuerzo());
            medico.setHoraAlmuerzo(horaSeleccionada);
            medico.setIdMedico(contador);
            medico.setEstado(true);
            if (contador != 6) {
                listaMedicos[contador] = medico;
                ProyectoPrueba.administrarMedicos();
            }else{
                JOptionPane.showMessageDialog(null, "Medico no encontrado");
                ProyectoPrueba.administrarMedicos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El médico no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            ProyectoPrueba.administrarMedicos();
        }
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