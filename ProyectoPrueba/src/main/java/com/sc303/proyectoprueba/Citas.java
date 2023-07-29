package com.sc303.proyectoprueba;

import javax.swing.JOptionPane;

public class Citas {
    //atributos
    private int cantidadHoras;
    private String nombreCliente;
    private String telefonoCliente;
    private int dia;
    private int mes;
    private String servicio;
    private int horas;
    private int idMedico;
    private double cobro;
    private boolean estado;
    

    public Citas(int cantidadHoras, String nombreCliente, String telefonoCliente, int dia, int mes, String servicio, int horas, int idMedico, double cobro, boolean estado) {
        this.cantidadHoras = cantidadHoras;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.dia = dia;
        this.mes = mes;
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

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
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
    public static void reservarCita(Citas[] citasArray, Medico[] medicosArray) {
         // Crear una nueva instancia de Citas 
        Citas nuevaCita = new Citas();

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
     
        // Mostrar los mnedicos que tengan relacion con el servicio/especialidad y que el usuario seleccione el id del medico a reservar
        int idMedico = Medico.medicoEspecialidad(medicosArray, servicioSeleccionado);
        
        //seleccionar el dia y la hora del calendario
        int[] diaYHoraCita = Calendario.mostrarCalendario();
        int diaSeleccionado = diaYHoraCita[0];
        int horaSeleccionada = diaYHoraCita[1];
        int mesSeleccionada = diaYHoraCita[2];
        
        //Validar el horario del medico 
        // de citasArray mostrar/validar los espacios disponibles  para que el cliente pueda seleccionar solo una hora disp
        /*Citas[] citasFiltradas = filtrarCitasPorMedico(citasArray, idMedico);
        String filtrarCitas="";
        // Mostrar las citas filtradas
        for (Citas cita : citasFiltradas) {
            if (cita != null) {
                filtrarCitas+=cita+"\n";        
            }
        }*/
        //validar que la hora, dia y mes seleccionado esten libres 
        //for para recorrer citas filtradas[i] y dentro de esefor un if que valide que el dia, mes y hora no esten seleccionadas
        // el else de ese if necesita un mensaje de error y luego hacer esto idMedico = Medico.medicoEspecialidad(medicosArray, servicioSeleccionado)
        
        //citasFiltradas[0].getMes();

        
        nuevaCita.setDia(diaSeleccionado);
        nuevaCita.setMes(mesSeleccionada);
        nuevaCita.setHoras(horaSeleccionada);
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
       // Método para filtrar citas por idMedico
    public static Citas[] filtrarCitasPorMedico(Citas[] citas, int idMedico) {
        Citas[] citasFiltradas = new Citas[citas.length];
        int count = 0;
        for (Citas cita : citas) {
            if (cita.getIdMedico() == idMedico) {
                citasFiltradas[count++] = cita;
             }
          }
        return citasFiltradas;
    }
    
    public static void devolucionCita(){
    }

    public static void mostrarEspacioCita(){
    }
    public static void actualizarCita(){
    }
    
}
