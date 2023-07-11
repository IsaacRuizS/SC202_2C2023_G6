package com.sc303.proyectoprueba;

import javax.swing.JOptionPane;

public class Citas {
    //atributos
    private int cantidadHoras;
    private String nombreCliente;
    private String telefonoCliente;
    private int dia;
    private String servicio;
    private int horas;
    private int idMedico;
    private double cobro;
    private boolean estado;

    public Citas(int cantidadHoras, String nombreCliente, String telefonoCliente, int dia, String servicio, int horas, int idMedico, double cobro, boolean estado) {
        this.cantidadHoras = cantidadHoras;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.dia = dia;
        this.servicio = servicio;
        this.horas = horas;
        this.idMedico = idMedico;
        this.cobro = cobro;
        this.estado = estado;
    }

    public Citas() {
    }
    
    //getters and setters 
    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //metodos
    public static void reservarCita(Citas[] citasArray) {
        int[] diaYHoraCita = Calendario.mostrarCalendario();
        int diaSeleccionado = diaYHoraCita[0];
        int horaSeleccionada = diaYHoraCita[1];
        
         // Crear una nueva instancia de Citas y asignar los valores correspondientes
        Citas nuevaCita = new Citas();
        nuevaCita.setDia(diaSeleccionado);
        nuevaCita.setHoras(horaSeleccionada);


        // Mostrar el menú desplegable y obtener la selección del usuario
        String[] opcionesServicio = { "Medicina General", "Cirugía Ambulatoria", "Cirugía Especializada" };
        int duracion;

        // Mostrar el menú desplegable y obtener la selección del usuario
        String servicioSeleccionado = (String) JOptionPane.showInputDialog(null, "Selecciona el tipo de servicio:",
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, opcionesServicio, opcionesServicio[0]);

        // Asignar la duración según el servicio seleccionado
        if (servicioSeleccionado.equals("Medicina General")) {
            nuevaCita.setServicio("Medicina General");
            duracion = 1;
        } else if (servicioSeleccionado.equals("Cirugía Ambulatoria")) {
            nuevaCita.setServicio("Cirugía Ambulatoria");
            duracion = 2;
        } else if (servicioSeleccionado.equals("Cirugía Especializada")) {
            nuevaCita.setServicio("Cirugía Especializada");
            duracion = 3;
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválida");
            return; // Salir del método si la opción es inválida
        }
        

        nuevaCita.setCantidadHoras(duracion);

        // Solicitar nombre y teléfono del cliente
        String nombreCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
        String telefonoCliente = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");
        nuevaCita.setNombreCliente(nombreCliente);
        nuevaCita.setTelefonoCliente(telefonoCliente);

        // Calcular el cobro según el tipo de servicio y día de la semana
        double cobro;
        if (diaSeleccionado >= 1 && diaSeleccionado <= 5) {
            // Entre semana (lunes a viernes)
            cobro = duracion * 25000;
        } else {
            // Fines de semana (sábado y domingo)
            cobro = duracion * 40000;
        }
        // Calcular el IVA
        double iva = cobro * 0.13;
        cobro += iva;
        nuevaCita.setCobro(cobro);

        // Establecer el estado como "activo"
        nuevaCita.setEstado(true);

        // Agregar la nueva cita al arreglo de citas
        for (int i = 0; i < citasArray.length; i++) {
            if (citasArray[i] == null) {
                citasArray[i] = nuevaCita;
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Cita reservada con éxito");
        ProyectoPrueba.menuSelection();
    }



    
    public static void mostrarCitas(Citas[] citasArray) {

        StringBuilder citasText = new StringBuilder();

        for (Citas cita : citasArray) {
            if (cita != null) {
                citasText.append("Cliente: ").append(cita.getNombreCliente()).append("\n");
                citasText.append("Teléfono: ").append(cita.getTelefonoCliente()).append("\n");
                citasText.append("Día: ").append(cita.getDia()).append("\n");
                citasText.append("Servicio: ").append(cita.getServicio()).append("\n");
                citasText.append("Hora: ").append(cita.getHoras()).append("\n");
                citasText.append("Duración: ").append(cita.getCantidadHoras()).append(" horas").append("\n");
                citasText.append("ID Médico: ").append(cita.getIdMedico()).append("\n");
                citasText.append("Cobro: ").append(cita.getCobro()).append("\n");
                citasText.append("Estado: ").append(cita.isEstado() ? "Activa" : "Cancelada").append("\n");
                citasText.append("----------------------------------------\n");
                
            }
        }
        if (citasText.length() == 0) {
            citasText.append("No hay citas registradas.");
        }

        JOptionPane.showMessageDialog(null, citasText.toString());
        ProyectoPrueba.menuSelection();
    }
    
    public static void devolucionCita(){
    }

    public static void mostrarEspacioCita(){
    }
    public static void actualizarCita(){
    }
    
}
