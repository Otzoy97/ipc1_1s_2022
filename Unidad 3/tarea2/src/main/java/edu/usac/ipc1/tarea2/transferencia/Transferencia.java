/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.usac.ipc1.tarea2.transferencia;

import java.util.Date;

/**
 *
 * @author otzoy
 */
public class Transferencia {
    private String guidOrigen, guidDestino;
    private double monto;
    private Date fecha;

    public Transferencia(String guidOrigen, String guidDestino, double monto) {
        this.guidOrigen = guidOrigen;
        this.guidDestino = guidDestino;
        this.monto = monto;
        this.fecha = new Date();
    }

    public String getGuidOrigen() {
        return guidOrigen;
    }

    public String getGuidDestino() {
        return guidDestino;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
}
