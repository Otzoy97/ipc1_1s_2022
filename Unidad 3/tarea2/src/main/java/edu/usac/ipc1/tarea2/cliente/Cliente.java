package edu.usac.ipc1.tarea2.cliente;

import edu.usac.ipc1.tarea2.cuenta.Cuenta;

/**
 *
 * @author otzoy
 */
public class Cliente {
    private String CUI, nombre, apellido;
    private Cuenta[] cuentas;

    public Cliente(String CUI, String nombre, String apellido) {
        this.CUI = CUI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentas = new Cuenta[10];
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public String getCUI() {
        return CUI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }  
    
    public boolean addCuenta(Cuenta cuenta) {
        for(int i = 0 ; i < this.cuentas.length ; i++) {
            if (this.cuentas[i] == null) {
                this.cuentas[i] = cuenta;
                return true;
            }
        }
        return false;
    }
    
    public Cuenta findCuenta(String guid) {
        for(int i = 0 ; i < this.cuentas.length ; i++) {
            if (this.cuentas[i] != null && this.cuentas[i].getGuid().equals(guid)) {
                return this.cuentas[i];
            }
        }
        return null;
    }
}
