package org.example.Persistencia;

import org.example.Modelo.pCuerpoHumano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CuerpoHumanoBD implements InterfazBD {
    public CuerpoHumanoBD() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO PartesCuerpoHumano (seccion, pCuerpo, descipcion, funcion, url) " +
                "VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;

        PreparedStatement pstm = Conexion.getInstance("DB_PCuerpoHumano.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((pCuerpoHumano) obj).getSeccion());
        pstm.setString(2, ((pCuerpoHumano) obj).getpCuerpo());
        pstm.setString(3, ((pCuerpoHumano) obj).getDescripcion());
        pstm.setString(4, ((pCuerpoHumano) obj).getFuncion());
        pstm.setString(5, ((pCuerpoHumano) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE PartesCuerpoHumano SET seccion = ?, pCuerpo = ?, descipcion = ?, funcion = ?, url= ? WHERE id = ? ; ";
        int rowCount = 0;

        PreparedStatement pstm = Conexion.getInstance("DB_PCuerpoHumano.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setInt(1, ((pCuerpoHumano) obj).getId());
        pstm.setString(2, ((pCuerpoHumano) obj).getSeccion());
        pstm.setString(3, ((pCuerpoHumano) obj).getpCuerpo());
        pstm.setString(4, ((pCuerpoHumano) obj).getDescripcion());
        pstm.setString(5, ((pCuerpoHumano) obj).getFuncion());
        pstm.setString(6, ((pCuerpoHumano) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM PartesCuerpoHumano WHERE id = ?;";
        int rowCount = 0;
        PreparedStatement pstm = Conexion.getInstance("DB_PCuerpoHumano.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sqlTodo = "SELECT * FROM PartesCuerpoHumano";
        ArrayList<pCuerpoHumano> resultado = new ArrayList<>();
        Statement stm = Conexion.getInstance("DB_PCuerpoHumano.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sqlTodo);
        while (rst.next()) {
            resultado.add(new pCuerpoHumano(rst.getInt(1), rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarporId(String id) throws SQLException {
        String sql = "SELECT * FROM PartesCuerpoHumano WHERE id = ?;";
        pCuerpoHumano partecuerpo = null;

        PreparedStatement pstm = Conexion.getInstance("DB_PCuerpoHumano.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            partecuerpo = new pCuerpoHumano(rst.getInt(1), rst.getString(2), rst.getString(3),
                    rst.getString(4), rst.getString(5), rst.getString(6));
            return partecuerpo;
        }
        return null;
    }
}