package edu.usac.ipc1.ejemplo8;

import javax.swing.JLabel;

/**
 * Cuando se declara clase para ejecutar un subproceso
 * se debe extender desde la clase java.lang.Thread y
 * sobrecargar la función run() (sobrecargar es escribir la función run
 * dentro de nuestra propia clase)
 */
public class Cronometro extends Thread {
    private volatile Double miliSeconds;
    private volatile JLabel lblSeconds;

    public Cronometro(Double seconds, JLabel lblSeconds) {
        this.miliSeconds = seconds;
        this.lblSeconds = lblSeconds;
    }

    @Override
    public void run() {
        Long minutes;
        Long seconds;
        while(Editor.running) {
            try {
                this.miliSeconds++;
                Thread.sleep(1);
                minutes = Math.round(miliSeconds / 1000) / 60;
                seconds = Math.round((miliSeconds / 1000) % 60);
                lblSeconds.setText(String.format("%02d:%02d",minutes,seconds));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }   
}
