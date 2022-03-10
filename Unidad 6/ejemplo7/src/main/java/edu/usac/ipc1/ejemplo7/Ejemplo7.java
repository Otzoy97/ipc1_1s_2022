package edu.usac.ipc1.ejemplo7;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Ejemplo7 {
    public static void main(String[] args) {
        // Ejecución asincrona de un hilo
        Thread runnable1 = new Thread(() -> {
            download("https://google.com", "google.html");
        });
        runnable1.start();

        // Ejecución asincrona de un hilo
        Thread runnable0 = new Thread(() -> {
            Download download2 = new Download("https://github.com/adoptium/temurin11-binaries/releases/download/jdk-11.0.14.1%2B1/OpenJDK11U-jdk_x64_windows_hotspot_11.0.14.1_1.msi", "jdk-11.msi");
            download2.run();
        });
        runnable0.start();

        // Ejecución asincrona de un hilo
        Thread runnable2 = new Thread(() -> {
            download("https://stackoverflow.com/questions/921262/how-can-i-download-and-save-a-file-from-the-internet-using-java","stackoverflow.html");
        });
        runnable2.start();

        Scanner sc = new Scanner(System.in);
        do {
            if (Math.random() < 0.25) {
                System.out.print("Uh uh! No dijiste la palabra mágica >>");
            } else {
                System.out.print("No terminaré mi ejecución hasta que escribas exit >>");
            }            
        } while (!sc.nextLine().equals("exit"));
        sc.close();
    }

    private static void download(String url, String path) {
        BufferedInputStream in = null;
        FileOutputStream fOutStream = null;
        try {
            in = new BufferedInputStream(new URL(url).openStream());
            fOutStream = new FileOutputStream(path);
            byte dBuffer[] = new byte[1024];
            int bytesRead;
            System.out.println("Descarga iniciada " + path);
            while ((bytesRead = in.read(dBuffer, 0, 1024)) != -1) {
                fOutStream.write(dBuffer, 0, bytesRead);
            }
            System.out.println("Descarga terminada " + path);
        } catch (IOException ex) {
            System.out.println("No se pudo descargar el archivo " + path);
        }
    }
}
