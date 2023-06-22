package com.sc303.proyectoprueba;

 
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Calendario {
 public static void mostrarCalendario() {
        //Meses
        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};    
        //Ultimo dia de cada mes del 2023
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //solicitar el mes a consultar
        int month = 5; 
//1,5,7

        
        // asignar el mes a mostrar y los dias
        String monthName =  months[month - 1];
        int daysInMonth =  daysPerMonth[month - 1];

        // Crea una matriz de 6 semanas como filas y 7 columnas como dias para representar el calendario
        String[][] calendario = new String[6][7];

        // Rellena la matriz con los días del mes
        int day = 1;
        for (int week = 0; week < 6; week++) {
            for (int days = 0; days < 7; days++) {
                //valida si esta en la primera semana y la posicion del dia, si el dia es menor a la primer dia obtenido en obtenerDiaSemana entonces devolvera un espacio en blaco
                if (week == 0 && days < obtenerDiaSemana(month, 1)) {
                    calendario[week][days] = " ";
                } else if (day > daysInMonth) {
                    //si el dia es mayor a los dias en el mes entonces tambien escribira espacios en blanco
                    calendario[week][days] = " ";
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
        calendarioTable.append("  D    L    M    M    J    V    S   \n");

        for (int week = 0; week < 6; week++) {
            for (int days = 0; days < 7; days++) {
                if (week == 1) {
                    calendarioTable.append(String.format(" %3s ", calendario[week][days]));
                } else if (week == 0) {
                    calendarioTable.append(String.format(" %4s ", calendario[week][days]));
                } else {
                    calendarioTable.append(String.format(" %2s ", calendario[week][days]));
                }
            }
                    calendarioTable.append("\n");
        }



        // Muestra el calendario en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, calendarioTable.toString());
    }
 

    // Obtener el día de la semana correspondiente a esa fecha crada gracias al objeto LocalDate
    public static int obtenerDiaSemana(int month, int day) {
        LocalDate date = LocalDate.of(2023, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue();
    }
}
