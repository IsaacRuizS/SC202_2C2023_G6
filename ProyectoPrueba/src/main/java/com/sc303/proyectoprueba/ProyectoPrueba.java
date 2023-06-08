package com.sc303.proyectoprueba;

import javax.swing.JOptionPane;


public class ProyectoPrueba {

    public static void main(String[] args) {
        menuSelection();
    }
    public static void menuSelection(){
        String menuMessage="Bienvenido al Menu de opciones\n";
        menuMessage+="1. Administrar Medicos\n";        
        menuMessage+="2. Reservacion de espacio\n";        
        menuMessage+="3. Devolucion de espacio\n";        
        menuMessage+="4. Revision de agenda\n";                
        menuMessage+="5. Mostrar Reservaciones\n";        
        menuMessage+="Salir 0\n";
        String option = JOptionPane.showInputDialog(null, menuMessage);
        
        if(option == null){
            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
        }else if(option.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
            menuSelection();
        }else{
            int integerOption = Integer.parseInt(option);
            if(integerOption == 1 || integerOption == 2 || integerOption == 0){
                switch(integerOption){
                    case 1 -> option1();            
                    case 2 -> option2();                      
                    case 3 -> option2();            
                    case 4 -> option2();            
                    case 5 -> option2();            
                    case 0 -> JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    default -> JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                }
            }
        }
    }
    
    public static void option1(){
        JOptionPane.showMessageDialog(null, "it Works");
        Medico.prueba1();
    }
    
    public static void option2(){
        JOptionPane.showMessageDialog(null, "it Works2");
    }
}