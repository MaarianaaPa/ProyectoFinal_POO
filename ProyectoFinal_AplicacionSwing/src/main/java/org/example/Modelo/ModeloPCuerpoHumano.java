package org.example.Modelo;

import org.example.Persistencia.CuerpoHumanoBD;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloPCuerpoHumano implements TableModel {
    private ArrayList<pCuerpoHumano> datos;
    //para la base de datos
    public static final int COLUMNAS = 6;
    private CuerpoHumanoBD cuerpoHumanoBD;

    //constructor que inicializa datos con un array vacio,
    // almacena y manipula datos
    public ModeloPCuerpoHumano() {
        datos = new ArrayList<>();
        cuerpoHumanoBD = new CuerpoHumanoBD();
    }

    public ModeloPCuerpoHumano(ArrayList<pCuerpoHumano> datos, CuerpoHumanoBD cuerpoHumanoBD) {

        //regresamos el numero de elementos en la lista almacenada en datos
        this.datos = datos;
        //regresamos la cantidad de filas de una tabla de datos
        this.cuerpoHumanoBD = cuerpoHumanoBD;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        //=6
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Seccion";
            case 2:
                return "Parte del Cuerpo";
            case 3:
                return "Descripcion";
            case 4:
                return "Funcion";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;

        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //obtenemos datos para mandarlos
        pCuerpoHumano pchtmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pchtmp.getId();
            case 1:
                return pchtmp.getSeccion();
            case 2:
                return pchtmp.getpCuerpo();
            case 3:
                return pchtmp.getDescripcion();
            case 4:
                return pchtmp.getFuncion();
            case 5:
                return pchtmp.getUrl();

        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setSeccion((String) o);
                break;
            case 2:
                datos.get(rowIndex).setpCuerpo((String) o);
                break;
            case 3:
                datos.get(rowIndex).setDescripcion((String) o);
                break;
            case 4:
                datos.get(rowIndex).setFuncion((String) o);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) o);
                break;
            default:
                System.out.println("Sin modificaciones");
        }
    }

    //AQUI VIDEO DE ACT DE TABLAS
    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    // obtener datos
    public void cargarParteCuerpoH() {
        try {
            //obtenemos de base de datos
            ArrayList<pCuerpoHumano> pch1 = cuerpoHumanoBD.obtenerTodo();
            System.out.println(pch1);
            datos = cuerpoHumanoBD.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public pCuerpoHumano obtenerParteCuerpoH(int rowIndex) throws IndexOutOfBoundsException {
        return datos.get(rowIndex);
    }

    //agregar datos
    public boolean agregarParteCuerpoHumano(pCuerpoHumano pch2) {
        boolean resultado = false;
        try {
            if (cuerpoHumanoBD.insertar(pch2)) {
                datos.add(pch2);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean actualizarParteCuerpoH(pCuerpoHumano pch3) {
        boolean result = false;
        try {
            if (cuerpoHumanoBD.update(pch3)) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return result;
    }

    public boolean eliminarParteCuerpoH(int id) {
        boolean result = false;
        try {
            if (cuerpoHumanoBD.delete(Integer.toString(id))) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return result;
    }

    public pCuerpoHumano buscarporId(int id) {
        pCuerpoHumano numero = null;
        try {
            numero = (pCuerpoHumano) cuerpoHumanoBD.buscarporId(Integer.toString(id));
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return numero;
    }

}