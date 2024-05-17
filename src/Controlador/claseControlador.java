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

            return formatearLista(arrayList);
        }catch (Exception e){
            System.out.println(e);

        }
        return null;

    }


    public static ArrayList<String> formatearLista(ArrayList<String> lista) {

        ArrayList<String> listaFormateada = new ArrayList<>();

        for (String elemento : lista) {
            int index = elemento.indexOf(" (");
            if (index != -1) {
                elemento = elemento.substring(0, index);
            }
            listaFormateada.add(elemento.trim());
        }

        return listaFormateada;
    }


    public static ArrayList<String> leerPrecios() throws SQLException {
        ArrayList<String> arrayList  = new ArrayList<>();

        ReservaDAO reservaDAO = new ReservaDAO();

        ArrayList<String> datosReserva = leerReserva();
        System.out.println(datosReserva);

        Reserva reserva = new Reserva();
        reservaDAO.create(reserva);

        //List<Reserva> reservas =  reservaDAO.listarReservas();
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

        //reservaDAO.create(reserva);
        // ESTA BIEN > System.out.println("desde leerPrecios()+ "+reserva);

        System.out.println("el arrayList que devuelve leerprecios() + "+arrayList);





        return arrayList;
    }






}
