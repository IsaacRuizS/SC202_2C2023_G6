package com.sc303.proyectoprueba;

import java.time.LocalTime;

public class Citas {
    //atributos
    public LocalTime cantidadHoras;
    public String nombreCliente;
    public String telefonoCliente;
    public LocalTime dia;
    public String servicio;
    public LocalTime horas;
    public int idMedico;
    public double cobro;
    public boolean estado;

    //getters and setters 
    public LocalTime getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(LocalTime cantidadHoras) {
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

    public LocalTime getDia() {
        return dia;
    }

    public void setDia(LocalTime dia) {
        this.dia = dia;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public LocalTime getHoras() {
        return horas;
    }

    public void setHoras(LocalTime horas) {
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
    public static void crearCita(){
    }
    public static void eliminarCita(){
    }
    public static void actualizarCita(){
    }
    public static void mostrarCita(){
    }
    public static void mostrarEspacioCitaCita(){
    }
    
}
