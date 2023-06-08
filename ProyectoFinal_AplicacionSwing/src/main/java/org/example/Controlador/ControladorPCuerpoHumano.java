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
        //boton agregar a la tabla
        if (e.getSource() == this.view.getBtnAgregar()) {
            try {
                model.cargarParteCuerpoH();
                this.view.getTblPCuerpoHumano().setModel(model);
                this.view.getTblPCuerpoHumano().updateUI();
                pCuerpoHumano pch1 = new pCuerpoHumano();
                pch1.setId(0);
                pch1.setSeccion(this.view.getTxtSeccion().getText());
                pch1.setpCuerpo(this.view.getTxtPCuerpo().getText());
                pch1.setDescripcion(this.view.getTxtDescripcion().getText());
                pch1.setFuncion(this.view.getTxtFuncion().getText());
                pch1.setUrl(this.view.getTxturl().getText());
                //esto me lo duplica
                //modelo.agregarElemento(etp);
                //this.view.getTabla().updateUI();
                //this.view.limpiar();
                if (model.agregarParteCuerpoHumano(pch1)) {
                    JOptionPane.showMessageDialog(view, "Elemento agregado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.limpiar();
                    model.cargarParteCuerpoH();
                    this.view.getTblPCuerpoHumano().setModel(model);
                    this.view.getTblPCuerpoHumano().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "Error al agregar el elemento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe) {
                this.view.limpiar();
                JOptionPane.showMessageDialog(view, "La celda \"num atomico\" solo permite numeros enteros",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        //para la imagen
        if (e.getSource() == this.view.getTblPCuerpoHumano()) {
            System.out.println("clic tabla");
            //el indice que se va a seleccionar
            int rowIndex = view.getTblPCuerpoHumano().getSelectedRow();
            pCuerpoHumano pchtbl = model.obtenerParteCuerpoH(rowIndex);
            view.getLblImagen().setText("");
            view.getLblImagen().setIcon(pchtbl.IconImagen());
        }

        //actualizar
        if (e.getSource() == this.view.getBtnActualizacion()) {
            model.cargarParteCuerpoH();
            this.view.getTblPCuerpoHumano().setModel(model);
            this.view.getTblPCuerpoHumano().updateUI();
        }
        //eliminar
        if (e.getSource() == this.view.getBtnEliminacion()) {
            try {
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
        //para el boton cargar del panel 4
        if (e.getSource() == this.view.getBtnCargar()) {
            try {
                pCuerpoHumano pch1 = new pCuerpoHumano();
                pch1.setId(Integer.parseInt(this.view.getTxtId().getText()));
                pch1 = model.buscarporId(Integer.parseInt(this.view.getTxtId1().getText()));
                //mejorando con operador ternario
                // si el operador ternario ? esta vacio se asigna el valor existente en pch2, de lo contrario se asigna el nuevo valor de texto view
                pch1.setSeccion(view.getTxtSeccion().getText().equals("") ? pch1.getSeccion() : view.getTxtSeccion1().getText());
                pch1.setpCuerpo(view.getTxtPCuerpo().getText().equals("") ? pch1.getpCuerpo() : view.getTxtPCuerpo1().getText());
                pch1.setDescripcion(view.getTxtDescripcion().getText().equals("") ? pch1.getDescripcion() : view.getTxtDescripcion1().getText());
                pch1.setFuncion(view.getTxtFuncion().getText().equals("") ? pch1.getFuncion() : view.getTxtFuncion1().getText());
                pch1.setUrl(view.getTxturl().getText().equals("") ? pch1.getUrl() : view.getTxturl1().getText());
                //actualizacion podria salir mal
                if (pch1 == null) {
                    JOptionPane.showMessageDialog(view, "No existe el ID", "Aviso", JOptionPane.ERROR_MESSAGE);
                    this.view.getTxtEliminarId().setText("");
                } else {
                    if (model.actualizarParteCuerpoH(pch1)) {
                        JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        model.cargarParteCuerpoH();
                        this.view.getTblPCuerpoHumano().setModel(model);
                        this.view.getTblPCuerpoHumano().updateUI();
                        this.view.limpiar1();
                    } else {
                        JOptionPane.showMessageDialog(view, "No se pudo actualizar", "Aviso", JOptionPane.ERROR_MESSAGE);
                        model.cargarParteCuerpoH();
                        this.view.getTblPCuerpoHumano().setModel(model);
                        this.view.getTblPCuerpoHumano().updateUI();
                        this.view.limpiar1();
                    }
                }

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "El ID debe ser un numero entero", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
            }
        }
    }
}