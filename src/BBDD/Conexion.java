package BBDD;

import java.sql.*;

public class Conexion {

    public static Connection conectar (String tabla, String user, String password){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + tabla, user, password);
        }catch (SQLException e){
            System.out.println("No se pudo conectar con la BBDD.");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void desconectar(Connection conexion){
        try{
            conexion.close();
        }catch(SQLException e){
            System.out.println("No se ha pudo desconectar de la BBDD.");
            e.printStackTrace();
        }
    }




}

