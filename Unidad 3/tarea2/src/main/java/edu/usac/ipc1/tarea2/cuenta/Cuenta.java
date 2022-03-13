/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.usac.ipc1.tarea2.cuenta;

import java.util.UUID;

import edu.usac.ipc1.tarea2.transferencia.Transferencia;

/**
 *
 * @author otzoy
 */
public class Cuenta {
    private String guid;
    private String tipo;
    private Double fondos;
    
    // private Transferencia[] transferencias;

    public Cuenta(String tipo, Double fondos) {
        this.guid = UUID.randomUUID().toString();
        this.tipo = tipo;
        this.fondos = fondos;
        // this.transferencias = new Transferencia[10];
    }

    public String getGuid() {
        return guid;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getFondos() {
        return fondos;
    }

    public void addFondos(Double fondos) {
        this.fondos += fondos;
    }
}
