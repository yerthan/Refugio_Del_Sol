package operaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class LecturaOEscrituraFicheros {

    public String escribirInfo(String info){
        String resultado = "Reserva Realizada";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("reserva.txt"));
            if(info != null){
                info=info.substring(0, info.length()-1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        System.out.println("jsjs");
    }

}
