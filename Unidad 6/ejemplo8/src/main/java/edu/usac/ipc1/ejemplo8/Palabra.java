package edu.usac.ipc1.ejemplo8;

import java.util.concurrent.atomic.AtomicLong;

import javax.swing.JLabel;

public class Palabra extends Thread {
    private JLabel lblWords;
    private JLabel lblWordsPerMinute;
    private AtomicLong miliseconds;
    private AtomicLong wordsCount;
    private String[] wordsArray;

    public Palabra(JLabel lblWords, JLabel lblWordsPerMinute, AtomicLong miliseconds, AtomicLong wordsCount,
            String[] wordsArray) {
        this.lblWords = lblWords;
        this.lblWordsPerMinute = lblWordsPerMinute;
        this.miliseconds = miliseconds;
        this.wordsCount = wordsCount;
        this.wordsArray = wordsArray;
    }

    @Override
    public void run() {
        try {
            wordsCount.set(0);
            for (String string : wordsArray) {
                if (!string.isBlank()) {
                    wordsCount.incrementAndGet();
                }
            }
        } catch (Exception e) {
        }
        this.lblWords.setText(String.format("%03d palabras", wordsCount.get()));
        double minutes = (((double) miliseconds.get()) / 1000) / 60;
        double wordsPerMinute;
        if (minutes < 1) {
            wordsPerMinute = wordsCount.get();
        } else {
            wordsPerMinute = ((double) wordsCount.get()) / minutes;
        }
        this.lblWordsPerMinute
                .setText(String.format("%03g palabras por minuto", wordsPerMinute));
    }
}
