package edu.usac.ipc1.ordenamiento;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Bubblesort extends Thread {

    private JLabel refLblPasos;
    private JPanel refLblPanel;
    private Dato[] datos;
    private volatile AtomicInteger pasos;

    public Bubblesort(JLabel refLblPasos, JPanel refLblPanel, Dato[] datos, AtomicInteger pasos) {
        this.refLblPasos = refLblPasos;
        this.refLblPanel = refLblPanel;
        this.datos = datos;
        this.pasos = pasos;
    }

    @Override
    public void run() {
        JPanel panel0 = new JPanel();
        panel0.setLayout(new GridLayout(0, 1));
        JLabel lbl = new JLabel(String.format("%02d - [ %s ]", 0, Dato.join(datos)));
        lbl.setFont(new Font("Courier New", Font.PLAIN, 24));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        panel0.add(lbl);
        this.refLblPanel.add(panel0);
        this.refLblPanel.validate();
        for (int i = 0; i < datos.length - 1; i++) {
            // Conforme avanza el ordenamiento, actualizará el título del panel
            panel0.setBorder(new TitledBorder(LineBorder.createBlackLineBorder(), String.format("Iteración No. %d", i + 1)));
            for (int j = 0; j < datos.length - i - 1; j++) {
                if (datos[j].getValor() > datos[j + 1].getValor()) {
                    Dato ref = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = ref;
                }
                /// Agrega un etiqueta con los datos del arreglo al panel0
                lbl.setText(String.format("%02d - [ %s ]", j, Dato.join(datos)));
                lbl.validate();
                panel0.validate();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            pasos.incrementAndGet();
            // Actualizar el número de pasos
            this.refLblPasos.setText(String.format("%d pasos", pasos.get()));
        }
    }
}
