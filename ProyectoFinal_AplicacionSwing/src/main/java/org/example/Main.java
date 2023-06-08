package org.example;

import org.example.Controlador.ControladorPCuerpoHumano;
import org.example.Vista.Ventana;

import java.sql.*;

import org.sqlite.JDBC;

public class Main {
    public static void main(String[] args) {
        Ventana view = new Ventana("Partes del Cuepro");
        ControladorPCuerpoHumano controller = new ControladorPCuerpoHumano(view);

        /*//driver de conexion
        String DB_URL = "jdbc:sqlite:l.DB_PCuerpoHumano.db";
        //obj tipo connection
        Connection conexion = null;

        //cargar driver
        try{
            Class.forName("org.sqlite.JDBC");
            //realizamos la conexion
            conexion = DriverManager.getConnection(DB_URL);
            //obj tipo statement
            Statement stm= conexion.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM DB_PCuerpoHumano;");
            //iteramos sobre la tabla
            while (rst.next()){
                System.out.println(rst.getString(1) + "" + rst.getString(2)
                        + "" + rst.getString(3) + "" + rst.getString(4)
                        + "" + rst.getString(5) + "" + rst.getString(6));
            }

        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        */

    }
}