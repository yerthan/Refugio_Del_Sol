package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;

//
public class claseControlador {
    /*public String escribirInfo(ArrayList<String> arrayList){
        String resultado = "Reserva realizada";
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter("./src/ArchivoDeTextos/infoReserva.txt"));
            if(arrayList != null){
                arrayList = arrayList.substring(0, informacion.length() - 1);

            }

        }catch (Exception e){
            System.out.println("error");
            System.out.println(e);
        }


        return resultado;
    }


    public String enviarInformacion(String nombreFichero) {
        String resultado="Pedido almacenado correctamente";
        PedidoDao pdDao=new PedidoDao();
        resultado = pdDao.procesarPedido(nombreFichero);
        return resultado;

    }
    */

    public ArrayList<String> leerReserva(){

        String linea = "";
        String archivo = "";

        FileReader fR = null;
        ArrayList<String> arrayList  = new ArrayList<>();

        try {

            fR = new FileReader("./src/ArchivoDeTextos/reserva.txt");
            BufferedReader bR = new BufferedReader(fR);
            while(linea != null) {
                linea = bR.readLine();
                if (linea != null) {
                    archivo = linea;
                    arrayList.add(archivo);
                }
            }
            return arrayList;
        }catch (Exception e){
            System.out.println(e);

        }


        return null;

    }

}
