/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sc303.proyectoprueba;

import static com.sc303.proyectoprueba.ProyectoPrueba.menuSelection;
import javax.swing.JOptionPane;

/**
 *
 * @author María Celeste
 */
public class practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String menuMessage="Bienvenido al Menu de opciones\n";
        menuMessage+="1. Administrar Medico\n";
        menuMessage+="2. Reservacion de espacio\n";        
        menuMessage+="3. Devolucion de espacio\n";        
        menuMessage+="4. Revision de agenda\n";                
        menuMessage+="5. Mostrar Reservaciones\n";        
        menuMessage+="0. Salir \n";
        String option = JOptionPane.showInputDialog(null, menuMessage);
        // soliciten una de esas opciones
        if(option == null){
            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
        }else if(option.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
            menuSelection();
        }else{
            int integerOption = Integer.parseInt(option);
            // validar que el input traiga un valor entre 1,2,3,4,5 o 0
            if(integerOption == 1 || integerOption == 2 || integerOption == 3 || integerOption == 4||integerOption == 5 || integerOption == 0){
               switch (integerOption) {
               }
        int opcionSelecionada = 0;
        opcionSelecionada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion"));
            
            
        switch (opcionSelecionada) {
                   case 1:
                       //crearMedico
                       Medico.crearMedico();
                        break;
                    case 2:
                        //mostrar Medico
                       Medico.mostrarMedico();
                        break;

                    case 3:
                        //eliminar Medico
                       Medico.eliminarMedico();
                        break;

                    case 4:
                        //actualizar medico
                       Medico.actualizarMedico();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                        break;
                }
    }
     }
        }
    }
    

