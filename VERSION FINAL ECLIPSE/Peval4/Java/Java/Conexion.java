package Java;
import java.sql.*;

public class Conexion {

    Statement stm;
    Connection con;
    ResultSet rs=null;

    public Conexion() {

        try {
            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("ERROR REGISTRANDO EL DRIVER");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:h2:C:\\Users\\USUARIO\\Desktop\\h2 database", "", "");
            System.out.println("BASE DE DATOS CREADA!");
            stm = con.createStatement();
            String sentencia = "CREATE TABLE IF NOT EXISTS USUARIOS "
                    + "(usuario VARCHAR(30), "
                    + " contrase�a VARCHAR(30),"
                    + " correo VARCHAR(30))";
            stm.executeUpdate(sentencia);
            System.out.println("Tabla creada con �xito");

        } catch (SQLException e) {
            System.out.println("ERROR CREANDO LA BASE DE DATOS");
            e.printStackTrace();
        }


    }

    public void CheckLogin(String usuario, String contrase�a){
                String sentencia = "select " + "'" +usuario + "'"+ " from USUARIOS where contrase�a=" + "'"+contrase�a+"'"+";";
        try {
            rs = stm.executeQuery(sentencia);
        } catch (SQLException e) {
            System.out.println("Se ha producido un error realizando la consulta ala base de datos usuarios");
            System.out.println("DETALLES : ");
            System.out.println(e.getMessage());
        }
    }
    public void InsertNewUsuario(String usuario, String contrase�a, String correo){
        String sentencia = "insert into usuarios values("+"'"+usuario+"'"+","+"'"+contrase�a+"'"+","+"'"+correo+"'"+");";
        try {
            stm.executeUpdate(sentencia);
            System.out.println("Insercci�n realizada con �xito");
        } catch (SQLException e) {
            System.out.println("Se ha producido un error insertando los datos a la base de datos");
            e.printStackTrace();
        }
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }


}
