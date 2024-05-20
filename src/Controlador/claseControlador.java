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

        Reserva reserva = new Reserva();
        reservaDAO.create(reserva);

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

//
//    public static boolean comprobarHabitacion() throws SQLException {
//        ReservaDAO reservaDAO = new ReservaDAO();
//        List<Reserva> reservas = reservaDAO.listarReservas();
//
//        HabitacionDAO habitacionDAO = new HabitacionDAO();
//        List<Habitacion> habitaciones = habitacionDAO.listarHabitaciones();
//
//        // comprobar tipo y capacidad = saca ID de habitacion
//        // busca en reseva
//
//        ArrayList<String> datos = leerReserva();
//        boolean existeHabitacion = true;
//        System.out.println(datos.get(0));
//        System.out.println(datos.get(1));
//        //List<Habitacion> habitacionesDelMismoTipo = habitacionDAO.listarHabitacionesMismotipo(datos.get(0), Integer.parseInt(datos.get(1)));
//
////        for (Habitacion h : habitaciones){
////            if (h.getTipo().equalsIgnoreCase(datos.get(0)) && h.getCapacidad()==(Integer.parseInt(datos.get(1)))){
////                for (Reserva r : reservas){
////                    if (r.getHabitacionID() == h.getID()){
////                        habitacionesDelMismoTipo.add(habitacionDAO.read(h.getID()));
////
////                        System.out.println("hab id"+ h.getID());
////                        existeHabitacion = false;
////                    }
////                }
////            }
////        }
//
//        List<Habitacion> habitacionesDelMismoTipo = new ArrayList<Habitacion>();
//        for (Habitacion h : habitaciones){
//            if (h.getTipo().equalsIgnoreCase(datos.get(0))){
//                System.out.println("entra");
//
//                if (h.getCapacidad()==Integer.parseInt(datos.get(1))){
//                    habitacionesDelMismoTipo.add(h);
//
//                }
//            }
//        }
//
//        System.out.println(habitacionesDelMismoTipo);
//
//        for (Habitacion h : habitacionesDelMismoTipo){
//            for (Reserva r : reservas){
//                if (h.getID() == r.getHabitacionID()){
//                    System.out.println("hab id"+ h.getID());
//                    existeHabitacion = false;
//                } else {
//                    existeHabitacion = true;
//                }
//            }
//
//        }
//
//        return existeHabitacion;
//    }
//







}
