package edu.usac.ipc1.ejemplo8;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.JLabel;

/**
 * Cuando se declara clase para ejecutar un subproceso
 * se debe extender desde la clase java.lang.Thread y
 * sobrecargar la función run() (sobrecargar es escribir la función run
 * dentro de nuestra propia clase)
 */
public class Cronometro extends Thread {
    private JLabel lblSeconds;
    private AtomicLong miliseconds;
    private AtomicBoolean running;

    public Cronometro(AtomicLong miliseconds, JLabel lblSeconds, AtomicBoolean running) {
        this.miliseconds = miliseconds;
        this.lblSeconds = lblSeconds;
        this.running = running;
    }

    @Override
    public void run() {
        Long minutes;
        Long seconds;
        Long milis;
        /// Este while mantendrá al hilo vivo
        /// Si Editor.running cambia a falso, el while
        /// terminará y el hilo finalizará su ejecución y "morirá", liberando
        /// los recursos que se la habían asignado (espacio de memoria, tiempo de reloj del CPU, etc)
        while (this.running.get()) {
            try {
                this.miliseconds.incrementAndGet();
                /// Pone a "dormir" al hilo 1 milisegundo
                Thread.sleep(1);
                minutes = (miliseconds.get() / 1000) / 60;
                seconds = (miliseconds.get() / 1000) % 60;
                milis = miliseconds.get() - (minutes * 60000 + seconds * 1000);
                /// Actualiza el valor de lblSeconds, de tal manera que el cronometro
                /// sea humanamente entendible 00:00.000
                lblSeconds.setText(String.format("%02d:%02d:%03d", minutes, seconds, milis));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
