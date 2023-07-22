
package com.sc303.proyectoprueba;

import java.time.LocalTime;
import javax.swing.JOptionPane;


public class Medico {
    //atributos
    public int idMedico;    
    public String nombre;
    public String especialidad;
    public LocalTime horaAlmuerzo;
    public boolean estado;

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
    
     /*public static void mostrarMedico(Medico medico) {
        if (medico != null) {
            JOptionPane.showMessageDialog(null, "Detalles del médico:\nID: " + medico.getIdMedico() + "\nNombre: " + medico.getNombre() +
                    "\nEspecialidad: " + medico.getEspecialidad() + "\nHora de almuerzo: " + medico.getHoraAlmuerzo().toString() +
                    "\nEstado: " + (medico.isEstado() ? "Activo" : "Inactivo"), "Información del médico", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El médico no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
     }*/
}