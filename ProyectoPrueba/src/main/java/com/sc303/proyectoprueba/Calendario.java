package com.sc303.proyectoprueba;

import javax.swing.JOptionPane;


public class Calendario {

     public static void mostrarCalendario() {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDias = 0;
        for (int i = 0; i < diasPorMes.length; i++) {
            totalDias += diasPorMes[i];
        }

        String[] calendario = new String[totalDias];
        int indice = 0;

        for (int i = 0; i < meses.length; i++) {
            for (int dia = 1; dia <= diasPorMes[i]; dia++) {
                String fecha = dia + " " + meses[i];
                calendario[indice] = fecha;
                indice++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String fecha : calendario) {
            sb.append(fecha).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Calendario", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
