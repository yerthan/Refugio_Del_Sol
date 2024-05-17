package Operaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements I_ReservaDAO{

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost:3306/refugio_del_sol";
        try {
            ArrayList<String> datos = LecturaOEscrituraFicheros.leerUsuarioContrasena();

            con = DriverManager.getConnection(url, datos.get(0), datos.get(1));
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BBDD.");
        }

        return con;
    }

    public List<Reserva> listarReservas(){
        List<Reserva> reservas = new ArrayList<>();
        String consulta = "SELECT * FROM refugio_del_sol.Reserva";
        Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Reserva reserva = new Reserva();
                reserva.setID(rs.getInt("ID"));
                reserva.setHabitacionID(rs.getInt("HabitacionID"));
                reserva.setExtrasID(rs.getInt("ExtrasID"));
                reserva.setRegimenID(rs.getInt("RegimenID"));
                reserva.setPrecioTotal(rs.getDouble("PrecioTotal"));


                reservas.add(reserva);
            }
            return reservas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

    }


    @Override
    public String create(Reserva reserva) throws SQLException {
        //hay que crear la habitacionDAO, regimenDAO y extrasDAO para crear una Reserva con los datos reales
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        RegimenDAO regimenDAO = new RegimenDAO();
        ExtrasDAO extrasDAO = new ExtrasDAO();

        //necesitamos los datos recogidos en fichero para rellenar la bbdd
        List<Habitacion> habitaciones= habitacionDAO.listarHabitaciones();
        List<Regimen> regimens = regimenDAO.listarRegimen();
        List<Extras> extras = extrasDAO.listarExtras();

        ArrayList<String> datosReserva = Controlador.claseControlador.leerReserva();
        double precioHabitacion = 0;
        double precioRegimen = 0;
        double precioExtra = 0;

        System.out.println("desde create"+datosReserva);

        if (datosReserva!= null){
            for (Habitacion h : habitaciones){
                if (h.getTipo().equalsIgnoreCase(datosReserva.get(0))
                    && String.valueOf(h.getCapacidad()).equals(datosReserva.get(1))){
                    reserva.setHabitacionID(h.getID());
                    precioHabitacion = h.getPrecio();

                    for (Regimen r : regimens){
                        if (r.getTipo().equals(datosReserva.get(2))){
                            reserva.setRegimenID(r.getID());
                            precioRegimen = r.getPrecio();

                            //prueba3

                            for (Extras e : extras){
                                if (e.getNombre().equals(datosReserva.get(3))){
                                    reserva.setExtrasID(e.getID());
                                    precioExtra = e.getPrecio();

                                    /*Hay que arreglar que no mande null cuando el usuario no marque ningun extra*/
                                } else {
                                    precioExtra = 0;
                                }
                            }

                        }
                    }




                }
            }

            //hacer cálculos para calcular el total
            reserva.setPrecioTotal(precioRegimen + precioExtra + precioHabitacion);
            System.out.println(reserva);

        } else{
            System.out.println("error");
        }


        Connection con = conectar();
                                                    //ID, habitacionID, extrasID, regimenID
        String sql = "INSERT INTO refugio_del_sol.Reserva (ID, HabitacionID, ExtrasID, RegimenID, PrecioTotal) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, reserva.getID());
            sentencia.setInt(2, reserva.getHabitacionID());
            sentencia.setInt(3, reserva.getExtrasID());
            sentencia.setInt(4, reserva.getRegimenID());
            sentencia.setDouble(5, reserva.getPrecioTotal());
            int filasInsertadas = sentencia.executeUpdate();

            return "Creacion de Reserva correcta" + filasInsertadas;

        } catch (SQLException ex){
            ex.getErrorCode();
            return "error";

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return "error";
            }
        }


    }

    @Override
    public Reserva read(int id) {
        String consulta = "SELECT * FROM refugio_del_sol.Reserva WHERE ID = ?";
        Connection con = conectar();
        Reserva reserva = new Reserva();

        try (PreparedStatement ps = con.prepareStatement(consulta)){
            ps.setInt(1, id); // Establecer el parámetro ID en la consulta SQL
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                reserva.setID(rs.getInt("ID"));
                reserva.setHabitacionID(rs.getInt("HabitacionID"));
                reserva.setExtrasID(rs.getInt("ExtrasID"));
                reserva.setRegimenID(rs.getInt("RegimenID"));
                reserva.setPrecioTotal(rs.getDouble("PrecioTotal"));
                return reserva;
            } else {
                System.out.println("No existe esa reserva");
                return null; // Si no hay ninguna reserva con ese ID, devolver null
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Asegúrate de cerrar la conexión aquí en el bloque finally
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Manejar cualquier error al cerrar la conexión
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(Reserva reserva, double precio) {
        List<Reserva> reservas = listarReservas();
        Connection con = conectar();

        String consulta = "UPDATE refugio_del_sol.Reserva SET Reserva.PrecioTotal = ? WHERE ID = ?";

        if (reservas.contains(reserva)){
            try(PreparedStatement ps = con.prepareStatement(consulta)){
                int filasActualizadas = ps.executeUpdate();
                System.out.println("Reserva actualizada");
            } catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("No existe la reserva");
        }
    }

    @Override
    public void delete(int id) {
        String consulta = "DELETE FROM refugio_del_sol.Reserva WHERE ID = ?";
        Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setInt(1, id);

            int filasBorradas = ps.executeUpdate();
            System.out.println("filasBorradas: " + filasBorradas);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al borrar reserva");

        }
    }
}
