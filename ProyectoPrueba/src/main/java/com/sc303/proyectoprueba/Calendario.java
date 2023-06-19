package com.sc303.proyectoprueba;

 
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class Calendario {
 public static void mostrarCalendario() {
        int year = 2023; // Año del calendario
        int month = 5; // Mes del calendario (junio)
//1,5
        // Obtiene el nombre del mes y los días en él
        String monthName = obtenerNombreMes(month);
        int daysInMonth = obtenerDiasEnMes(year, month);

        // Crea una matriz de 6 filas y 7 columnas para representar el calendario
        String[][] calendario = new String[6][7];

        // Rellena la matriz con los días del mes
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < obtenerDiaSemana(year, month, 1)) {
                    calendario[i][j] = " ";
                } else if (day > daysInMonth) {
                    calendario[i][j] = " ";
                } else {
                    calendario[i][j] = String.valueOf(day);
                    day++;
                }
            }
        }

        // Crea el contenido del calendario con formato de tabla
        StringBuilder calendarioTable = new StringBuilder();
        calendarioTable.append(String.format("   %s %d\n", monthName, year));
        calendarioTable.append("  D    L    M    M    J    V    S   \n");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(i ==1){
                    calendarioTable.append(String.format(" %3s ", calendario[i][j]));               
                }else if(i == 0){
                    calendarioTable.append(String.format(" %4s ", calendario[i][j]));               
                }else{
                    calendarioTable.append(String.format(" %2s ", calendario[i][j]));               
                }
            }
            calendarioTable.append("\n");
        }

        // Muestra el calendario en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, calendarioTable.toString());
    }

    // Obtiene el nombre del mes
    public static String obtenerNombreMes(int month) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[month - 1];
    }

    // Obtiene la cantidad de días en un mes específico
    public static int obtenerDiasEnMes(int year, int month) {
        if (month == 2 && esAnioBisiesto(year)) {
            return 29;
        } else {
            int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            return diasPorMes[month - 1];
        }
    }

    // Comprueba si un año es bisiesto
    public static boolean esAnioBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Obtiene el día de la semana para una fecha específica (0 - Domingo, 1 - Lunes, ...)
    public static int obtenerDiaSemana(int year, int month, int day) {
        int a = (14 - month) / 12;
        int y = year - a;
        int m = month + 12 * a - 2;
        int d = (day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12) % 7;
        return d;
    }
}
