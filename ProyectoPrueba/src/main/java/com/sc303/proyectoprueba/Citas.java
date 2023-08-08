package com.sc303.proyectoprueba;

import java.time.YearMonth;
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
    private int id;
    

    public Citas(int cantidadHoras, String nombreCliente, String telefonoCliente, int dia, int mes, String servicio, int horas, int idMedico, double cobro, int id) {
        this.cantidadHoras = cantidadHoras;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.dia = dia;
        this.mes = mes;
        this.servicio = servicio;
        this.horas = horas;
        this.idMedico = idMedico;
        this.cobro = cobro;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        nuevaCita.setIdMedico(idMedico);
        
        //seleccionar el dia y la hora del calendario
        int[] diaYHoraCita = Calendario.mostrarCalendario(1);
        int diaSeleccionado = diaYHoraCita[0];
        int horaSeleccionada = diaYHoraCita[1];
        int mesSeleccionada = diaYHoraCita[2];
        
        boolean esDiaValido = validarDiaMes(diaSeleccionado, mesSeleccionada, 2023);

        if (esDiaValido) {
            //Validar el horario del medico 
            // de citasArray mostrar/validar los espacios disponibles  para que el cliente pueda seleccionar solo una hora disp
            if (verificarCitaDisponible(citasArray, medicosArray, idMedico, diaSeleccionado, mesSeleccionada, horaSeleccionada, duracion)) {
                // Solicitar nombre y teléfono del cliente
                String nombreCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:");
                String telefonoCliente = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");
                if((nombreCliente == null || nombreCliente.length() == 0)&&(telefonoCliente == null || telefonoCliente.length() == 0)){
                    JOptionPane.showMessageDialog(null, "Lo siento, formato incorrecto.");
                    ProyectoPrueba.menuSelection();
                }else{
                    // Calcular el cobro según el tipo de servicio y día de la semana
                    double cobro=0;

                    //llamar a una nueva funcion y validar si es fin de semana o no.

                    //Se debe manejar un precio entre semana de 25000 colones la hora y fines de semana de 40000 colones la hora. A ese precio se le debe sumar el IVA del 13%. 

                    nuevaCita.setCobro(cobro);
                    nuevaCita.setDia(diaSeleccionado);
                    nuevaCita.setMes(mesSeleccionada);
                    nuevaCita.setHoras(horaSeleccionada);
                    nuevaCita.setCantidadHoras(duracion);
                    nuevaCita.setNombreCliente(nombreCliente);
                    nuevaCita.setTelefonoCliente(telefonoCliente);
                    // Agregar la nueva cita al arreglo de citas
                    for (int i = 0; i < citasArray.length; i++) {
                        if (citasArray[i] == null) {
                            //set id
                            nuevaCita.setId(i);
                            citasArray[i] = nuevaCita;
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Cita reservada con éxito");
                    ProyectoPrueba.menuSelection();
                }
            }else {
                JOptionPane.showMessageDialog(null, "Lo siento, esa cita no está disponible.");
                 ProyectoPrueba.menuSelection();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Lo siento, formato incorrecto.");
            ProyectoPrueba.menuSelection();
        }
    }

    public static void mostrarCitas(Citas[] citasArray) {
        StringBuilder citasText = new StringBuilder();
        for (Citas cita : citasArray) {
            if (cita != null) {
                citasText.append("Id: ").append(cita.getId()).append("\n");
                citasText.append("Cliente: ").append(cita.getNombreCliente()).append("\n");
                citasText.append("Teléfono: ").append(cita.getTelefonoCliente()).append("\n");
                citasText.append("Día: ").append(cita.getDia()).append("\n");
                citasText.append("Servicio: ").append(cita.getServicio()).append("\n");
                citasText.append("Hora: ").append(cita.getHoras()).append("\n");
                citasText.append("Duración: ").append(cita.getCantidadHoras()).append(" horas").append("\n");
                citasText.append("ID Médico: ").append(cita.getIdMedico()).append("\n");
                citasText.append("Cobro: ").append(cita.getCobro()).append("\n");
                citasText.append("----------------------------------------\n");
            }
        }
        if (citasText.length() == 0) {
            citasText.append("No hay citas registradas.");
        }

        JOptionPane.showMessageDialog(null, citasText.toString());
        ProyectoPrueba.menuSelection();
    }
    
    public static Citas[] devolucionCita(Citas[] citasArray){
        String nombreClienteEliminar = JOptionPane.showInputDialog("Digite el nombre del cliente que desea realizar la devolucion de la cita");
        // Filtrar y mostrar los objetos con el mismo nombre de cliente
        String citasEncontradas="";
        int idEliminar = -1;
        for (Citas cita : citasArray) {
            if(cita != null){
                if (cita.getNombreCliente().equals(nombreClienteEliminar)) {
                    citasEncontradas += "Id: "+ cita.getId() +", Cliente: " + cita.getNombreCliente() + ", Fecha: " + cita.getDia() + "/" + cita.getMes() +"/23\n" ;
                }
            }
        }
        if(!"".equals(citasEncontradas)){
            idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a eliminar: \n"+ citasEncontradas));
        }else{
            JOptionPane.showMessageDialog(null, "No hay citas registradas al cliente insertado.");
            ProyectoPrueba.menuSelection();
        }
        if (idEliminar != -1) {
            // Crear un nuevo array para almacenar las citas restantes después de la eliminación
            Citas[] citasActualizadas = new Citas[citasArray.length - 1];
            int nuevoIndice = 0;

            // Copiar todas las citas de citasArray a citasActualizadas excepto la cita con idEliminar
            for (Citas cita : citasArray) {
                if(cita != null){
                    if (cita.getId() != idEliminar) {
                        citasActualizadas[nuevoIndice] = cita;
                        nuevoIndice++;
                    }
                }
            }
            // Ahora, citasArray está actualizado con la cita eliminada
            citasArray = citasActualizadas;
            JOptionPane.showMessageDialog(null, "Ha devuelto la cita con exito");
            return citasArray;
            //ProyectoPrueba.menuSelection();
        }else{
            JOptionPane.showMessageDialog(null, "Id Incorrecto.");
        }
        return citasArray;
    }
    
    public static void revisarAgenda(Citas[] citasArray, Medico[] medicosArray){
        try{
            //solicitar medico
            Medico.mostrarMedico(medicosArray);
            int idMedico = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ID del médico que desea consultar:", "Consultar médico", JOptionPane.QUESTION_MESSAGE));
            int horaAlmuerzo = 0;
            boolean medicoEncontrado = false;
            for (int i = 0; i < medicosArray.length; i++) {
                if (medicosArray[i] != null && medicosArray[i].getIdMedico() == idMedico) {
                    medicoEncontrado = true;
                    horaAlmuerzo = medicosArray[i].getHoraAlmuerzo();
                    break;
                }
            }
            if (!medicoEncontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún médico con el ID " + idMedico + ".", "Médico no encontrado", JOptionPane.ERROR_MESSAGE);
                revisarAgenda(citasArray, medicosArray);
            }
            
            //solicitar dia
            int[] mesYDia = Calendario.mostrarCalendario(2);
            int mesSeleccionada = mesYDia[1];
            int diaSeleccionado = mesYDia[0];
            int ganancias = 0;
            
            // Crear la tabla HTML para la agenda
            String tablaHTML = "<html><body><table border='1'>";
            tablaHTML += "<tr><th>Hora</th><th>Paciente</th><th>Teléfono</th></tr>";

            for (Citas cita : citasArray) {
                if (cita != null && cita.getDia() == diaSeleccionado && cita.getMes() == mesSeleccionada && cita.getIdMedico() == idMedico) {
                    tablaHTML += "<tr>";
                    for (int hora = 8; hora <= 17; hora++) {
                        tablaHTML += "<td>" + hora + ":00 - " + (hora + cita.getCantidadHoras()) + ":00</td>";
                        if (hora == cita.getHoras() || (hora >= cita.getHoras() && hora < cita.getHoras() + cita.getCantidadHoras())) {
                            ganancias += cita.getCobro();
                            tablaHTML += "<td>" + cita.getNombreCliente() + "</td>";
                            tablaHTML += "<td>" + cita.getTelefonoCliente() + "</td>";
                        } else if(hora == horaAlmuerzo){
                            tablaHTML += "<td colspan='2'>— Almuerzo ––</td>";
                        }
                        else {
                            tablaHTML += "<td colspan='2'>— VACIO ––</td>";
                        }
                        tablaHTML += "</tr>";
                    }
                }
            }

            tablaHTML += "</table></body></html>";

            // Mostrar la tabla en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, tablaHTML, "Agenda del Médico", JOptionPane.PLAIN_MESSAGE);
            
            //ganacias del dia
            JOptionPane.showMessageDialog(null, "Las ganancias a recaudar el dia: "+ diaSeleccionado+ " es de: " + ganancias);

            ProyectoPrueba.menuSelection();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Algo salio mal!");
            ProyectoPrueba.menuSelection();
        }

        
        
         
    }
    
     public static boolean verificarCitaDisponible(Citas[] citasArray,Medico[] medicosArray, int idMedico, int dia, int mes, int horas, int cantidadHoras) {
         // Obtener el médico correspondiente al idMedico
        Medico medico = null;
        for (Medico cMedico : medicosArray) {
            if (cMedico != null && cMedico.getIdMedico() == idMedico) {
                medico = cMedico;
                break;
            }
        }
        
        if (medico != null) {
            // Verificar si la hora deseada está dentro del horario de almuerzo del médico
            int horaAlmuerzo = medico.getHoraAlmuerzo();
            
            if(horas == horaAlmuerzo || (horaAlmuerzo >= horas && horaAlmuerzo<= horas+cantidadHoras) ){
                // La cita está en el rango de almuerzo del doctor
                return false; 
            }

            
            for (Citas cita : citasArray) {
                if(cita != null){
                    if (cita.getIdMedico() == idMedico && cita.getDia() == dia && cita.getMes() == mes) {
                       // Verificar si las horas se superponen
                       if (horas >= cita.getHoras() && horas < cita.getHoras() + cita.getCantidadHoras()) {
                           // La cita está ocupada
                           return false; 
                       }
                       
                   }   
                }
            }   
        }
         
        // La cita está disponible
        return true; 
    }

     public static boolean validarDiaMes(int dia, int mes, int anio) {
        YearMonth yearMonthObject = YearMonth.of(anio, mes);

        if (dia >= 1 && dia <= yearMonthObject.lengthOfMonth()) {
            return true;
        }
        return false;
    }
    
}
