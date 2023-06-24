package com.sc303.proyectoprueba;

import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Citas {
    //atributos
    private LocalTime cantidadHoras;
    private String nombreCliente;
    private String telefonoCliente;
    private LocalTime dia;
    private String servicio;
    private LocalTime horas;
    private int idMedico;
    private double cobro;
    private boolean estado;

    public Citas(LocalTime cantidadHoras, String nombreCliente, String telefonoCliente, LocalTime dia, String servicio, LocalTime horas, int idMedico, double cobro, boolean estado) {
        this.cantidadHoras = cantidadHoras;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.dia = dia;
        this.servicio = servicio;
        this.horas = horas;
        this.idMedico = idMedico;
        this.cobro = cobro;
        this.estado = estado;
    }

    public Citas() {
    }
    
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
    public static void reservarCita(){
    }
    public static void devolucionCita(){
    }
    public static void mostrarCita(){
    }
    public static void mostrarEspacioCita(){
    }
    public static void actualizarCita(){
    }
    
}
