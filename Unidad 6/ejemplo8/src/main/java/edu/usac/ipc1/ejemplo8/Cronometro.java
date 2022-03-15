package edu.usac.ipc1.ejemplo8;

import javax.swing.JLabel;

/**
 * Cuando se declara clase para ejecutar un subproceso
 * se debe extender desde la clase java.lang.Thread y
 * sobrecargar la función run() (sobrecargar es escribir la función run
 * dentro de nuestra propia clase)
 */
public class Cronometro extends Thread {
    private volatile Long miliSeconds;
    private volatile JLabel lblSeconds;

    public Cronometro(Long seconds, JLabel lblSeconds) {
        this.miliSeconds = seconds;
        this.lblSeconds = lblSeconds;
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
        while (Editor.running) {
            try {
                this.miliSeconds++;
                /// Pone a "dormir" al hilo 1 milisegundo
                Thread.sleep(1);
                minutes = (miliSeconds / 1000) / 60;
                seconds = (miliSeconds / 1000) % 60;
                milis = miliSeconds - (minutes * 60000 + seconds * 1000);
                /// Actualiza el valor de lblSeconds, de tal manera que el cronometro
                /// sea humanamente entendible 00:00.000
                lblSeconds.setText(String.format("%02d:%02d:%03d", minutes, seconds, milis));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
