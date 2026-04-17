package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement()){

            String sql = "INSERT INTO EMPLEADO (ID, NOMBRE, SALARIO) VALUES (?, ? , ?)";
            PreparedStatement ps  = conn.prepareStatement(sql);
            ps.setInt(1, 10);
            ps.setString(2, "Carlos");
            ps.setDouble(3, 3500.0);
            ps.executeUpdate();
            System.out.println("Empleado insertado");
        }catch(SQLException e ){
            System.out.println("Error al insertar" + e.getMessage());
        }

    }
}
