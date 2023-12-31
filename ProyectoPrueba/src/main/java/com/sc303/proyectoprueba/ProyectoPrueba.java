package com.sc303.proyectoprueba;

import javax.swing.JOptionPane;


public class ProyectoPrueba {
    
    static Citas[] citasArray = new Citas[1000];
    static Medico[] medicosArray = new Medico[5];


    public static void main(String[] args) {
        Medico medico1 = new Medico(1,"Isaac","Cirugía Ambulatoria",12,true);
        Medico medico2 = new Medico(2,"Johan","Cirugía Especializada",13,true);
        Medico medico3 = new Medico(3,"Celes","Medicina General",13,true);
        medicosArray[0]=medico1;
        medicosArray[1]=medico2;
        medicosArray[2]=medico3;
        Citas cita1 = new Citas(1,"Alfonso","435243",1,1,"Medicina General",8,3,Math.round(40000*1.13),0);
        Citas cita2 = new Citas(1,"Andres","432443",1,1,"Medicina General",9,3,Math.round(40000*1.13),1);
        Citas cita3 = new Citas(1,"Victor","4243",1,1,"Medicina General",11,3,Math.round(40000*1.13),2);
        Citas cita4 = new Citas(1,"Victor","4243",1,1,"Medicina General",11,3,Math.round(40000*1.13),2);
        Citas cita5 = new Citas(1,"Victor","4243",1,1,"Medicina General",11,3,Math.round(40000*1.13),2);

        citasArray[0]=cita1;
        citasArray[1]=cita2;
        citasArray[2]=cita3;
        citasArray[3]=cita4;
        citasArray[4]=cita5;

        
        menuSelection();
        
    }
    
    public static void menuSelection(){
        try{
            String menuMessage="Bienvenido al Menu de opciones\n";
            menuMessage+="1. Administrar Medicos\n";        
            menuMessage+="2. Reservacion de espacio\n";        
            menuMessage+="3. Devolucion de espacio\n";        
            menuMessage+="4. Revision de agenda\n";                
            menuMessage+="5. Mostrar Reservaciones\n";        
            menuMessage+="0. Salir \n";
            String option = JOptionPane.showInputDialog(null, menuMessage);

            if(option == null){
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
            }else if(option.isEmpty()){
                JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
                menuSelection();
            }else{
                int integerOption = Integer.parseInt(option);
                // array quemado
               
                
                // validar que el input traiga un valor entre 1,2,3,4,5 o 0
                if(integerOption == 1 || integerOption == 2 || integerOption == 3 || integerOption == 4||integerOption == 5 || integerOption == 0){
                   switch (integerOption) {
                       case 1:
                            //Administrar Medicos
                            administrarMedicos();
                            break;
                        case 2:
                            Citas.reservarCita(citasArray, medicosArray);
                            //resercaciones de Espacio
                            break;
                        case 3:
                            //Devolucion de Espacios
                           citasArray =  Citas.devolucionCita(citasArray, medicosArray);
                           menuSelection();
                            break;

                        case 4:
                            //Revision de agenda
                            Citas.revisarAgenda(citasArray, medicosArray);
                            break;
                        case 5:
                            //Mostrar Reservaciones
                            Citas.mostrarCitas(citasArray, medicosArray);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                            break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
                    menuSelection();
                }
            }
        
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
             menuSelection();
        }
        
    }
    
    public static void administrarMedicos(){
        // creen el mensaje a mostrar
        String menuMessage="Menu Medicos \n";
        menuMessage+="1. Crear Medico\n";
        menuMessage+="2. Mostrar Medico\n";        
        menuMessage+="3. Eliminar Medico\n";        
        menuMessage+="4. Actualizar medico\n"; 
        menuMessage+="5. Volver a Menu principal\n"; 
        menuMessage+="0. Salir \n";
        
        // soliciten una de esas opciones
        String option = JOptionPane.showInputDialog(null, menuMessage);
        if(option == null){
            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
        }else if(option.isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecciona una opcion valida");
            administrarMedicos();
        }else{
            int integerOption = Integer.parseInt(option);
            // validen esa opcion 
           if(integerOption == 1 || integerOption == 2 || integerOption == 3 || integerOption == 4|| integerOption == 5||integerOption == 0){ 
        // llame a las Acciones del medico **HECHA
        switch (integerOption) {
                   case 1:
                       //crearMedico
                        Medico.crearMedico(medicosArray);
                        administrarMedicos();
                        break;
                    case 2:
                        //mostrar Medico
                        Medico.mostrarMedico(medicosArray );
                        administrarMedicos();
                        break;

                    case 3:
                        //eliminar Medico
                        Medico.mostrarMedico(medicosArray );
                        medicosArray = Medico.eliminarMedico(medicosArray);
                        administrarMedicos();
                        break;

                    case 4:
                        //actualizar medico
                        Medico.mostrarMedico(medicosArray );
                        medicosArray =  Medico.actualizarMedico(medicosArray);
                        administrarMedicos();
                        break;
                    case 5: 
                        menuSelection();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                        break;
                }

           }
        }
            }
    
    public static void option2(){
        JOptionPane.showMessageDialog(null, "it Works2");
        menuSelection();    
    }
}
