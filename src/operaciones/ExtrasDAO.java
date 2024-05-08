package operaciones;

import java.sql.*;

public class ExtrasDAO {

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost/refugio_del_sol";
        try {
            con = DriverManager.getConnection(url, "root", "administrador");
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BBDD.");
        }

        return con;
    }

    public String create(Extras e) {
        String resultado = "";
        Connection con = conectar();
        //nombre, precio, ID
        String sql = "INSERT INTO Extras VALUES (?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, e.getID());
            sentencia.setString(2, e.getNombre());
            sentencia.setDouble(3, e.getPrecio());
        } catch (SQLException ex){
            ex.getErrorCode();
            return "error";

        } finally {
            try {
                con.close();
            } catch (SQLException error) {
                error.printStackTrace();
                return "error";
            }
        }


        return "Creacion de los extras ha sido correcta";
    }



    public Extras read(int id)  {
        String consulta = "SELECT * FROM refugio_del_sol.Habitacion WHERE ID = ?";
        Connection con = conectar();

        try(PreparedStatement ps = con.prepareStatement((consulta))){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Extras extras = new Extras();
                extras.setNombre(rs.getString("Nombre"));
                extras.setPrecio(rs.getDouble("Precio"));
                extras.setID(rs.getInt("ID"));
                return extras;
            }else {
                System.out.println("no existe el extra");
                return null;
            }


        }catch (Exception e){
            System.out.println(e);
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }


        return null;
    }


    public void update(Extras extra) {

    }


    public void delete(int id) {

    }
}
