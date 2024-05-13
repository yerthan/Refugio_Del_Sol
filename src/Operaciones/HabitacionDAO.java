package Operaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO implements I_HabitacionDAO{
    private static Connection con;
    private ArrayList<String> datos;

 /*modelo*/
    public HabitacionDAO() throws SQLException {
        String url = "jdbc:mysql://localhost/refugio_del_sol";
        ArrayList<String> datos = LecturaOEscrituraFicheros.leerUsuarioContrasena();

        try {
            System.out.println(datos.get(0) + " " + datos.get(1));
            con = DriverManager.getConnection(url, datos.get(0), datos.get(1));

        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BBDD.");
            ex.printStackTrace();
        }
    }

//    private static Connection conectar() {
//        //Connection con = null;
//
//        String url = "jdbc:mysql://localhost/refugio_del_sol";
//        try {
//            ArrayList<String> datos = LecturaOEscrituraFicheros.leerUsuarioContrasena();
//
//            con = DriverManager.getConnection(url, datos.get(0), datos.get(1));
//
//        } catch (SQLException ex) {
//            System.out.println("Error al conectar a la BBDD.");
//        }
//
//        return con;
//    }

    public List<Habitacion> listarHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<>();
        String consulta = "SELECT * FROM refugio_del_sol.Habitacion";
        //Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Habitacion habitacion = new Habitacion();
                habitacion.setID(rs.getInt("ID"));
                habitacion.setNumero(rs.getInt("Numero"));
                habitacion.setTipo(rs.getString("Tipo"));
                habitacion.setCapacidad(rs.getInt("Capacidad"));
                habitacion.setPrecio(rs.getDouble("Precio"));


                habitaciones.add(habitacion);

            }
            return habitaciones;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
    public String create(Habitacion habitacion) {
        String resultado = "";
        //Connection con = conectar();
        //ID, numero, tipo, capacidad, precio
        String sql = "INSERT INTO refugio_del_sol.Habitacion VALUES (?, ?, ?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, habitacion.getID());
            sentencia.setInt(2, habitacion.getNumero());
            sentencia.setString(3, habitacion.getTipo());
            sentencia.setInt(4, habitacion.getCapacidad());
            sentencia.setDouble(5, habitacion.getPrecio());



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


        return "Creacion de Habitacion correcta";
    }

    @Override
    public Habitacion read(int id) {
        String consulta = "SELECT * FROM refugio_del_sol.Habitacion WHERE ID = ?";
        //Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta)){
            ps.setInt(1, id); // Establecer el parámetro ID en la consulta SQL
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setID(rs.getInt("ID"));
                habitacion.setNumero(rs.getInt("Numero"));
                habitacion.setTipo(rs.getString("Tipo"));
                habitacion.setCapacidad(rs.getInt("Capacidad"));
                habitacion.setPrecio(rs.getDouble("Precio"));

                return habitacion;
            } else {
                System.out.println("No existe esa habitacion");
                return null; // Si no hay ninguna habitación con ese ID, devolver null
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
    public void update(Habitacion habitacion, double precio) {
        List<Habitacion> habitaciones = listarHabitaciones();
        //Connection con = conectar();

        String consulta = "UPDATE refugio_del_sol.Habitacion SET Habitacion.Precio = ? WHERE Habitacion.ID = ?";

        if (habitaciones.contains(habitacion)){
            try (PreparedStatement ps = con.prepareStatement(consulta)) {
                ps.setDouble(5, precio);

                int filasActualizadas = ps.executeUpdate();
                System.out.println("Habitacion actualizada");

            } catch (SQLException e) {
                e.printStackTrace();

            }
        } else {
            System.out.println("No existe la habitacion.");

        }

    }

    @Override
    public void delete(int id) {

        String consulta = "DELETE FROM refugio_del_sol.Habitacion WHERE ID = ?";
        //Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            ps.setInt(1, id);

            int filasBorradas = ps.executeUpdate();
            System.out.println("filasBorradas: " + filasBorradas);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al borrar habitación");

        }

    }
}
