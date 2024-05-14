package Controlador;

import Operaciones.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//
public class claseControlador {

    public static ArrayList<String> leerReserva(){

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


    public static ArrayList<String> leerPrecios() throws SQLException {
        ArrayList<String> arrayList  = new ArrayList<>();

        ReservaDAO reservaDAO = new ReservaDAO();
        List<Reserva> reservas =  reservaDAO.listarReservas();
        Reserva reserva = reservas.getLast();
        System.out.println(reservas);
        System.out.println(reserva);
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        Habitacion habitacion = habitacionDAO.read(reserva.getHabitacionID());
        double precioHabitacion = habitacion.getPrecio();
        arrayList.add(String.valueOf(precioHabitacion));

        RegimenDAO regimenDAO = new RegimenDAO();
        Regimen regimen = regimenDAO.read(reserva.getRegimenID());
        double precioRegimen = regimen.getPrecio();
        arrayList.add(String.valueOf(precioRegimen));


        ExtrasDAO extrasDAO = new ExtrasDAO();
        Extras extras = extrasDAO.read(reserva.getExtrasID());
        double precioExtras = extras.getPrecio();
        arrayList.add(String.valueOf(precioExtras));

        arrayList.add(String.valueOf(reserva.getPrecioTotal()));






        return arrayList;
    }





}
