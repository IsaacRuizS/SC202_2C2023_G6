package com.sc303.proyectoprueba;

 
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Calendario {
 public static int[] mostrarCalendario(int opc) {
        //Meses
        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};    
        //Ultimo dia de cada mes del 2023
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Menú desplegable",
                JOptionPane.QUESTION_MESSAGE, null, months, months[0]);
        
        // Obtener la posición del mes seleccionado
        int month = -1;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(seleccion)) {
                month = i;
                break;
            }
        }
        month += 1;
        
        // asignar el mes a mostrar y los dias
        String monthName =  months[month - 1];
        int daysInMonth =  daysPerMonth[month - 1];
        
        // Crea una matriz de 6 semanas como filas y 7 columnas como dias para representar el calendario
        String[][] calendario = new String[6][7];

        // Rellena la matriz con los días del mes
        int day = 01;
        for (int week = 0; week < 6; week++) {
            for (int days = 0; days < 7; days++) {
                //valida si esta en la primera semana y la posicion del dia, si el dia es menor a la primer dia obtenido en obtenerDiaSemana entonces devolvera un espacio en blaco
                if (week == 0 && days < obtenerDiaSemana(month, 1)) {
                    calendario[week][days] = "---";
                } else if (day > daysInMonth) {
                    //si el dia es mayor a los dias en el mes entonces tambien escribira espacios en blanco
                    calendario[week][days] = "---";
                } else {
                    //si no agrega los dias dentreo del arreglo en la posicion de la semana en dia.
                    calendario[week][days] = String.valueOf(day);
                    day++;
                }
            }
        }

        // Crea el contenido del calendario con formato de tabla
        StringBuilder calendarioTable = new StringBuilder();
        calendarioTable.append(String.format("   %s %d\n", monthName, 2023));
        calendarioTable.append(String.format("%8s %8s %8s %8s %8s %8s %8s \n", "DOM","LUN","MAR","MIE","JUE","VIE","SAB"));


        for (int week = 0; week < 6; week++) {
            for (int days = 0; days < 7; days++) {
                if(calendario[week][days].length() == 1 && !"---".equals(calendario[week][days])){
                    calendarioTable.append(String.format(" %-10s ", "0"+calendario[week][days]));
                }else if("---".equals(calendario[week][days])){
                    calendarioTable.append(String.format(" %-12s ", calendario[week][days]));
                }else{
                    calendarioTable.append(String.format(" %-10s ", calendario[week][days]));
                }
            }
                    calendarioTable.append("\n");
        }

        // Muestra el calendario en un cuadro de diálogo
        int dia = Integer.parseInt(JOptionPane.showInputDialog(null, calendarioTable.toString()));
        
        if(opc ==1){
            // Horas disponibles
            var horas = new Integer[]{8, 9, 10, 11, 12, 13, 14, 15, 16, 17};  

            // Mostrar el menú desplegable y obtener la selección del usuario
            Integer horaSeleccionada = (Integer) JOptionPane.showInputDialog(null, "Selecciona una hora", "Menú desplegable", 
                    JOptionPane.QUESTION_MESSAGE, null, horas, horas[0]);


            int[] diaYHoraCita = {dia, horaSeleccionada, month};
            return diaYHoraCita;
        
        }else{
            int[] diaYHoraCita = {dia, month};
            return diaYHoraCita;
        }
    }

    // Obtener el día de la semana correspondiente a esa fecha crada gracias al objeto LocalDate
    public static int obtenerDiaSemana(int month, int day) {
        LocalDate date = LocalDate.of(2023, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue();
    }
}
