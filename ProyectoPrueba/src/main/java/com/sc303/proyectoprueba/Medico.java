
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
    public static Medico crearMedico() {
        Medico nuevoMedico = new Medico();

        int idMedico = obtenerIdMedicoDesdeBaseDeDatos();
        nuevoMedico.setIdMedico(idMedico);

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
        nuevoMedico.setHoraAlmuerzo(LocalTime.of(horaSeleccionada, 0));

        nuevoMedico.setEstado(true);

        return nuevoMedico;
    }
    public static int obtenerIdMedicoDesdeBaseDeDatos() {
        
        return 12345;
    }
    public static void eliminarMedico(Medico[] listaMedicos) {
        int idMedicoAEliminar=0;
        //pedir el idmedico aqui
        for (int i = 0; i < listaMedicos.length; i++) {
            if (listaMedicos[i] != null && listaMedicos[i].getIdMedico() == idMedicoAEliminar) {
                listaMedicos[i] = null;
                break;        
            }    
        }
    }

    public static void actualizarMedico(Medico medico) {
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
                    "Actualizar médico", JOptionPane.QUESTION_MESSAGE, null, horas, medico.getHoraAlmuerzo().getHour());
            medico.setHoraAlmuerzo(LocalTime.of(horaSeleccionada, 0));

            int opcionEstado = JOptionPane.showConfirmDialog(null, "¿Deseas cambiar el estado del médico?", "Actualizar médico", JOptionPane.YES_NO_OPTION);
            if (opcionEstado == JOptionPane.YES_OPTION) {
                boolean nuevoEstado = !medico.isEstado();
                medico.setEstado(nuevoEstado);
            }
            JOptionPane.showMessageDialog(null, "Médico actualizado exitosamente.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El médico no existe.", "Error", JOptionPane.ERROR_MESSAGE);
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