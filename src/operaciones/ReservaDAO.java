package operaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements I_ReservaDAO{

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost/refugio_del_sol";
        try {
            con = DriverManager.getConnection(url, "root", "root");
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
                reserva.setFechaInicio(rs.getDate("FechaInicio"));
                reserva.setFechaFin(rs.getDate("FechaFin"));
                reserva.setHabitacionID(rs.getInt("HabitacionID"));
                reserva.setExtrasID(rs.getInt("ExtrasID"));
                reserva.setRegimenID(rs.getInt("RegimenID"));


                reservas.add(reserva);
            }
            return reservas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String create(Reserva reserva) {
        //hay que crear la habitacionDAO, regimenDAO y extrasDAO para crear una Reserva con los datos reales
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        RegimenDAO regimenDAO = new RegimenDAO();
        ExtrasDAO extrasDAO = new ExtrasDAO();

        //necesitamos los datos recogidos en fichero para rellenar la bbdd!!!


        String resultado = "";
        Connection con = conectar();
                                                    //ID, fechaInicio, fechaFin, habitacionID, extrasID, regimenID
        String sql = "INSERT INTO refugio_del_sol.Reserva VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, reserva.getID());
            sentencia.setDate(2, Date.valueOf(String.valueOf(reserva.getFechaInicio())));
            sentencia.setDate(3, Date.valueOf(String.valueOf(reserva.getFechaFin())));
            sentencia.setInt(4, reserva.getHabitacionID());
            sentencia.setInt(5, reserva.getExtrasID());
            sentencia.setInt(6, reserva.getRegimenID());
            return "Creacion de Reserva correcta";

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
                reserva.setFechaInicio(rs.getDate("FechaInicio"));
                reserva.setFechaFin(rs.getDate("FechaFin"));
                reserva.setHabitacionID(rs.getInt("HabitacionID"));
                reserva.setExtrasID(rs.getInt("ExtrasID"));
                reserva.setRegimenID(rs.getInt("RegimenID"));
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

    }

    @Override
    public void delete(int id) {

    }
}
