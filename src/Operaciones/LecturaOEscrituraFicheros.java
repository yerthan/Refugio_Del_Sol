package Operaciones;

import java.io.*;
import java.util.ArrayList;

public class LecturaOEscrituraFicheros {

    public static void escribirInfo(ArrayList<String> info){
        String resultado = "Reserva Realizada";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./src/ArchivoDeTextos/reserva.txt"));
            if(info != null){
                bw.write(info.toString());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
