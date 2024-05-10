package Operaciones;

import java.io.*;
import java.util.ArrayList;

public class LecturaOEscrituraFicheros {

    public static void escribirInfo(ArrayList<String> informacion) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/ArchivoDeTextos/reserva.txt"))) {

            if (informacion != null && !informacion.isEmpty()) {
                // Write each element of the ArrayList on a separate line
                for (String line : informacion) {
                    bw.write(line + "\n");
                }
            } else {
                // Handle the case where informacion is null or empty (optional)
                 bw.write("No hay informacion adicional disponible.\n");  // Example handling
            }
        } catch (IOException e) {
            // Log the exception to a file or console for debugging
            System.err.println("Error writing to file: " + e.getMessage());
            throw e; // Re-throw the exception for proper error handling
        }
    }



    public static ArrayList<String> leerUsuarioContrasena(){

        FileWriter fw = null;
        BufferedWriter bW = null;
        FileReader fR = null;
        BufferedReader bR = null;
        String linea = "";
        String archivo = "";
        ArrayList<String> array = new ArrayList<>();


        try {

            fR = new FileReader("./src/ArchivoDeTextos/conexion.txt");
            bR = new BufferedReader(fR);


            while(linea != null) {
                linea = bR.readLine();
                if (linea != null) {
                    archivo = linea;
                    array.add(archivo);
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return array;

    }



}
