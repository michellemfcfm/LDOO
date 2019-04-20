/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

/**
 *
 * @author michelle
 */
import java.sql.*;

public class BaseDeDatos {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/practica8";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void agregar(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String nombre = usuario.getNombre();
            String contraseña = usuario.getContrasena();
            String fechaDeNacimiento = usuario.getFechaDeNacimiento();
            String correo = usuario.getCorreo();

            String sql = "INSERT INTO usuarios(username,email, password, FechaDeNacimiento) VALUES('" + nombre + "', '" + correo + "', '" + contraseña + "','" + fechaDeNacimiento + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

    public static Usuario seleccionar(String user) {
        Connection conn = null;
        Statement stmt = null;
        Usuario usuario = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM usuarios WHERE username = '" + user + "'";
            System.out.println("Ejecutando query...");
            ResultSet rs = stmt.executeQuery(sql);
            System.out.print("OK");

            while (rs.next()) {
                Integer i = rs.getInt("id");
                String id = i.toString();
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String FechaDeNacimiento = rs.getString("FechaDeNacimiento");
                usuario = new Usuario(id, username, email, password, FechaDeNacimiento);
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return usuario;
    }//end main

}
