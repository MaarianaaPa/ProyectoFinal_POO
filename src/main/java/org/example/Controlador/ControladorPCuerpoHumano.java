package org.example.Controlador;

import org.example.Modelo.ModeloPCuerpoHumano;
import org.example.Modelo.pCuerpoHumano;
import org.example.Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorPCuerpoHumano extends MouseAdapter {

    private Ventana view;
    private ModeloPCuerpoHumano model;

    public ControladorPCuerpoHumano(Ventana view) {
        this.view = view;
        model = new ModeloPCuerpoHumano();
        this.view.getTblPCuerpoHumano().setModel(model);

        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnActualizacion().addMouseListener(this);
        this.view.getBtnEliminacion().addMouseListener(this);

        this.view.getTblPCuerpoHumano().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //agregar
        //boton agregar a la tabla
        if (e.getSource() == this.view.getBtnAgregar()) {
            if (view.getTxtSeccion().getText().equals("") && view.getTxtPCuerpo().getText().equals("") &&
                    view.getTxtDescripcion().getText().equals("") && view.getTxtFuncion().getText().equals("") &&
                    view.getTxturl().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Celdas vacias", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                pCuerpoHumano pch = new pCuerpoHumano();

                pch.setId(0);
                pch.setSeccion(this.view.getTxtSeccion().getText());
                pch.setpCuerpo(this.view.getTxtPCuerpo().getText());
                pch.setDescripcion(this.view.getTxtDescripcion().getText());
                pch.setFuncion(this.view.getTxtFuncion().getText());
                pch.setUrl(this.view.getTxturl().getText());

                if (model.agregarParteCuerpoHumano(pch)) {
                    JOptionPane.showMessageDialog(view, "Agregado", "Notificacion", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(view, "Error al agregar", "Error", JOptionPane.ERROR_MESSAGE);
                }
                this.view.limpiar();
                model.cargarParteCuerpoH();
                this.view.getTblPCuerpoHumano().setModel(model);
                this.view.getTblPCuerpoHumano().updateUI();

            }
        }

        //imagen
        if (e.getSource() == this.view.getTblPCuerpoHumano()) {
            System.out.println("Evento en Tabla");
            //el indice que se va a seleccionar
            int rowIndex = view.getTblPCuerpoHumano().getSelectedRow();
            pCuerpoHumano pchtbl = model.obtenerParteCuerpoH(rowIndex);
            view.getLblImagen().setText("");
            view.getLblImagen().setIcon(pchtbl.IconUrlImagen());
        }

        //eliminar
        if (e.getSource() == this.view.getBtnEliminacion()) {
            try {
                System.out.println("Evento en Btn Eliminar");
                if (model.buscarporId(Integer.parseInt(this.view.getTxtEliminarId().getText())) == null) {
                    JOptionPane.showMessageDialog(view, "El id no existe", "Notificacion", JOptionPane.ERROR_MESSAGE);
                    //limpar
                    this.view.getTxtEliminarId().setText("");
                } else {
                    int result = JOptionPane.showConfirmDialog(view, "¿Desea eliminar la fila? " +
                            this.view.getTxtEliminarId().getText() +
                            "\n Borrar fila", "Notificacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        if (model.eliminarParteCuerpoH(Integer.parseInt(this.view.getTxtEliminarId().getText()))) {
                            JOptionPane.showMessageDialog(view, "Elemento eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            this.view.getTxtEliminarId().setText("");
                            model.cargarParteCuerpoH();
                            this.view.getTblPCuerpoHumano().setModel(model);
                            this.view.getTblPCuerpoHumano().updateUI();
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Accion cancelada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        this.view.getTxtEliminarId().setText("");
                        model.cargarParteCuerpoH();
                        this.view.getTblPCuerpoHumano().setModel(model);
                        this.view.getTblPCuerpoHumano().updateUI();
                    }
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "El ID debe ser un numero entero", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //actualizar
        if (e.getSource() == this.view.getBtnActualizacion()) {
            System.out.println("Evento en Btn Actualizar");
            model.cargarParteCuerpoH();
            this.view.getTblPCuerpoHumano().setModel(model);
            this.view.getTblPCuerpoHumano().updateUI();
        }
        //cargar
        if (e.getSource() == this.view.getBtnCargar()) {
            try {
                System.out.println("Evento en Btn Cargar");

                pCuerpoHumano pch1 = new pCuerpoHumano();

                pch1.setId(Integer.parseInt(this.view.getTxtId().getText()));
                pch1 = model.buscarporId(Integer.parseInt(this.view.getTxtId1().getText()));
                /*//mejorando con operador ternario
                si el operador ternario ? esta vacio se asigna el valor existente en pch1, de lo contrario se asigna el nuevo valor de texto view
                condicion ? verdadero : falso;
                pch1.setSeccion(view.getTxtSeccion1().getText().equals("") ? pch1.getSeccion() : view.getTxtSeccion1().getText());
                pch1.setpCuerpo(view.getTxtPCuerpo1().getText().equals("") ? pch1.getpCuerpo() : view.getTxtPCuerpo1().getText());
                pch1.setDescripcion(view.getTxtDescripcion1().getText().equals("") ? pch1.getDescripcion() : view.getTxtDescripcion1().getText());
                pch1.setFuncion(view.getTxtFuncion1().getText().equals("") ? pch1.getFuncion() : view.getTxtFuncion1().getText());
                pch1.setUrl(view.getTxturl1().getText().equals("") ? pch1.getUrl() : view.getTxturl1().getText());
                */
                if (view.getTxtId().getText().equals("")) {

                } else {
                    pch1.setId(Integer.parseInt(view.getTxtId1().getText()));
                }
                if (view.getTxtSeccion().getText().equals("")) {

                } else {
                    pch1.setSeccion(view.getTxtSeccion1().getText());
                }
                if (view.getTxtPCuerpo().getText().equals("")) {

                } else {
                    pch1.setpCuerpo(view.getTxtPCuerpo1().getText());
                }
                if (view.getTxtDescripcion().getText().equals("")) {

                } else {
                    pch1.setDescripcion(view.getTxtDescripcion1().getText());
                }
                if (view.getTxtFuncion().getText().equals("")) {

                } else {
                    pch1.setFuncion(view.getTxtFuncion1().getText());
                }
                if (view.getTxturl().getText().equals("")) {

                } else {


                    pch1.setUrl(view.getTxturl1().getText());
                }

            //actualizacion podria salir mal
            if (pch1 == null) {
                JOptionPane.showMessageDialog(view, "No existe el ID", "Notificacion", JOptionPane.ERROR_MESSAGE);
                this.view.getTxtEliminarId().setText("");
            } else {
                if (model.actualizarParteCuerpoH(pch1)) {
                    JOptionPane.showMessageDialog(view, "Se actualizo", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
                    model.cargarParteCuerpoH();
                    this.view.getTblPCuerpoHumano().setModel(model);
                    this.view.getTblPCuerpoHumano().updateUI();
                    this.view.limpiar1();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo actualizar", "Notificacion", JOptionPane.ERROR_MESSAGE);
                    model.cargarParteCuerpoH();
                    this.view.getTblPCuerpoHumano().setModel(model);
                    this.view.getTblPCuerpoHumano().updateUI();
                    this.view.limpiar1();
                }
            }

        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(view, "El ID debe ser entero", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
        } catch(NullPointerException npe){
            System.out.println(npe.getMessage());
        }
    }
}
}
