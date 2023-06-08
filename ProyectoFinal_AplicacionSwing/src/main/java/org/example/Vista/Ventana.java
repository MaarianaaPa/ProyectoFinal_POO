package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarFile;

public class Ventana extends JFrame {
    //etiquetas
    private JLabel lblId;
    private JLabel lblSeccion;
    private JLabel lblPCuerpo;
    private JLabel lblDescripcion;
    private JLabel lblFuncion;
    private JLabel lblurl;
    private JLabel lblImagen;
    //texto
    private JTextField txtId;
    private JTextField txtSeccion;
    private JTextField txtPCuerpo;
    private JTextField txtDescripcion;
    private JTextField txtFuncion;
    private JTextField txturl;
    //boton
    private JButton btnAgregar;
    private JButton btnEliminacion;
    private JButton btnActualizacion;
    private JButton btnCargar;
    //tabla
    private JScrollPane srcTabla;
    private JTable tblPCuerpoHumano;
    private GridLayout layout;
    //paneles
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    //para panel 4
    private JLabel lblId1;
    private JLabel lblEliminarId;
    private JLabel lblSeccion1;
    private JLabel lblPCuerpo1;
    private JLabel lblDescripcion1;
    private JLabel lblFuncion1;
    private JLabel lblurl1;
    //texto
    private JTextField txtId1;
    private JTextField txtEliminarId;
    private JTextField txtSeccion1;
    private JTextField txtPCuerpo1;
    private JTextField txtDescripcion1;
    private JTextField txtFuncion1;
    private JTextField txturl1;

    // - - - - - - - - - - - - - - - - - - - -

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(1200, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //panel1

        panel1 = new JPanel(new GridLayout(7, 2));
        panel1.setBackground(new Color(102, 165, 173));
        this.getContentPane().add(panel1, 0);

        //componentes
        lblId = new JLabel("Id ");
        txtId = new JTextField(3);
        panel1.add(lblId);
        panel1.add(txtId);

        lblSeccion = new JLabel("Seccion");
        txtSeccion = new JTextField(15);
        panel1.add(lblSeccion);
        panel1.add(txtSeccion);

        lblPCuerpo = new JLabel("Parte del Cuerpo");
        txtPCuerpo = new JTextField(20);
        panel1.add(lblPCuerpo);
        panel1.add(txtPCuerpo);

        lblDescripcion = new JLabel("Descripcion");
        txtDescripcion = new JTextField(20);
        panel1.add(lblDescripcion);
        panel1.add(txtDescripcion);

        lblFuncion = new JLabel("Funcion");
        txtFuncion = new JTextField(20);
        panel1.add(lblFuncion);
        panel1.add(txtFuncion);

        lblurl = new JLabel("URL");
        txturl = new JTextField(30);
        panel1.add(lblurl);
        panel1.add(txturl);

        // agregamos el boton para agregar
        btnAgregar = new JButton("Agregar");
        //para que aparezca a la derecha
        panel1.add(new JLabel());
        panel1.add(btnAgregar);

        //panel2

        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(196, 223, 230));
        this.getContentPane().add(panel2, 1);

        //componentes
        btnActualizacion = new JButton("Actualizar");
        panel2.add(btnActualizacion);

        panel2.add(btnCargar);
        tblPCuerpoHumano = new JTable();
        srcTabla = new JScrollPane(tblPCuerpoHumano);
        //el scroll ya contiene la tabla
        panel2.add(srcTabla);

        // a partir de aqui se manda desde el controlador

        //panel3

        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(235, 245, 238));
        this.getContentPane().add(panel3, 2);
        //componentes
        //instanciamos la imagen
        lblImagen = new JLabel();
        this.panel3.add(lblImagen);

        //panel4
        // implementar eliminacion y actualizacion
        panel4 = new JPanel(new GridLayout(10, 2));
        panel4.setBackground(new Color(232, 232, 232));
        this.getContentPane().add(panel4, 3);

        lblId1 = new JLabel("Id ");
        txtId1 = new JTextField(3);
        panel4.add(lblId1);
        panel4.add(txtId1);

        lblSeccion1 = new JLabel("Seccion");
        txtSeccion1 = new JTextField(15);
        panel4.add(lblSeccion1);
        panel4.add(txtSeccion1);

        lblPCuerpo1 = new JLabel("Parte del Cuerpo");
        txtPCuerpo1 = new JTextField(20);
        panel4.add(lblPCuerpo1);
        panel4.add(txtPCuerpo1);

        lblDescripcion1 = new JLabel("Descripcion");
        txtDescripcion1 = new JTextField(20);
        panel4.add(lblDescripcion1);
        panel4.add(txtDescripcion1);

        lblFuncion1 = new JLabel("Funcion");
        txtFuncion1 = new JTextField(20);
        panel4.add(lblFuncion1);
        panel4.add(txtFuncion1);

        lblurl1 = new JLabel("URL");
        txturl1 = new JTextField(30);
        panel4.add(lblurl1);
        panel4.add(txturl1);

        btnCargar = new JButton("Cargar");
        panel4.add(btnCargar);

        lblEliminarId = new JLabel("Id de la fila a eliminar");
        txtEliminarId = new JTextField(3);

        btnEliminacion = new JButton("Eliminar");
        panel4.add(btnEliminacion);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblSeccion() {
        return lblSeccion;
    }

    public void setLblSeccion(JLabel lblSeccion) {
        this.lblSeccion = lblSeccion;
    }

    public JLabel getLblPCuerpo() {
        return lblPCuerpo;
    }

    public void setLblPCuerpo(JLabel lblPCuerpo) {
        this.lblPCuerpo = lblPCuerpo;
    }

    public JLabel getLblDescripcion() {
        return lblDescripcion;
    }

    public void setLblDescripcion(JLabel lblDescripcion) {
        this.lblDescripcion = lblDescripcion;
    }

    public JLabel getLblFuncion() {
        return lblFuncion;
    }

    public void setLblFuncion(JLabel lblFuncion) {
        this.lblFuncion = lblFuncion;
    }

    public JLabel getLblurl() {
        return lblurl;
    }

    public void setLblurl(JLabel lblurl) {
        this.lblurl = lblurl;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtSeccion() {
        return txtSeccion;
    }

    public void setTxtSeccion(JTextField txtSeccion) {
        this.txtSeccion = txtSeccion;
    }

    public JTextField getTxtPCuerpo() {
        return txtPCuerpo;
    }

    public void setTxtPCuerpo(JTextField txtPCuerpo) {
        this.txtPCuerpo = txtPCuerpo;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextField getTxtFuncion() {
        return txtFuncion;
    }

    public void setTxtFuncion(JTextField txtFuncion) {
        this.txtFuncion = txtFuncion;
    }

    public JTextField getTxturl() {
        return txturl;
    }

    public void setTxturl(JTextField txturl) {
        this.txturl = txturl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnEliminacion() {
        return btnEliminacion;
    }

    public void setBtnEliminacion(JButton btnEliminacion) {
        this.btnEliminacion = btnEliminacion;
    }

    public JButton getBtnActualizacion() {
        return btnActualizacion;
    }

    public void setBtnActualizacion(JButton btnActualizacion) {
        this.btnActualizacion = btnActualizacion;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JScrollPane getSrcTabla() {
        return srcTabla;
    }

    public void setSrcTabla(JScrollPane srcTabla) {
        this.srcTabla = srcTabla;
    }

    public JTable getTblPCuerpoHumano() {
        return tblPCuerpoHumano;
    }

    public void setTblPCuerpoHumano(JTable tblPCuerpoHumano) {
        this.tblPCuerpoHumano = tblPCuerpoHumano;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblId1() {
        return lblId1;
    }

    public void setLblId1(JLabel lblId1) {
        this.lblId1 = lblId1;
    }

    public JLabel getLblEliminarId() {
        return lblEliminarId;
    }

    public void setLblEliminarId(JLabel lblEliminarId) {
        this.lblEliminarId = lblEliminarId;
    }

    public JLabel getLblSeccion1() {
        return lblSeccion1;
    }

    public void setLblSeccion1(JLabel lblSeccion1) {
        this.lblSeccion1 = lblSeccion1;
    }

    public JLabel getLblPCuerpo1() {
        return lblPCuerpo1;
    }

    public void setLblPCuerpo1(JLabel lblPCuerpo1) {
        this.lblPCuerpo1 = lblPCuerpo1;
    }

    public JLabel getLblDescripcion1() {
        return lblDescripcion1;
    }

    public void setLblDescripcion1(JLabel lblDescripcion1) {
        this.lblDescripcion1 = lblDescripcion1;
    }

    public JLabel getLblFuncion1() {
        return lblFuncion1;
    }

    public void setLblFuncion1(JLabel lblFuncion1) {
        this.lblFuncion1 = lblFuncion1;
    }

    public JLabel getLblurl1() {
        return lblurl1;
    }

    public void setLblurl1(JLabel lblurl1) {
        this.lblurl1 = lblurl1;
    }

    public JTextField getTxtId1() {
        return txtId1;
    }

    public void setTxtId1(JTextField txtId1) {
        this.txtId1 = txtId1;
    }

    public JTextField getTxtEliminarId() {
        return txtEliminarId;
    }

    public void setTxtEliminarId(JTextField txtEliminarId) {
        this.txtEliminarId = txtEliminarId;
    }

    public JTextField getTxtSeccion1() {
        return txtSeccion1;
    }

    public void setTxtSeccion1(JTextField txtSeccion1) {
        this.txtSeccion1 = txtSeccion1;
    }

    public JTextField getTxtPCuerpo1() {
        return txtPCuerpo1;
    }

    public void setTxtPCuerpo1(JTextField txtPCuerpo1) {
        this.txtPCuerpo1 = txtPCuerpo1;
    }

    public JTextField getTxtDescripcion1() {
        return txtDescripcion1;
    }

    public void setTxtDescripcion1(JTextField txtDescripcion1) {
        this.txtDescripcion1 = txtDescripcion1;
    }

    public JTextField getTxtFuncion1() {
        return txtFuncion1;
    }

    public void setTxtFuncion1(JTextField txtFuncion1) {
        this.txtFuncion1 = txtFuncion1;
    }

    public JTextField getTxturl1() {
        return txturl1;
    }

    public void setTxturl1(JTextField txturl1) {
        this.txturl1 = txturl1;
    }

    public void limpiar() {
        txtId.setText("");
        txtSeccion.setText("");
        txtPCuerpo.setText("");
        txtDescripcion.setText("");
        txtFuncion.setText("");
        txturl.setText("");
    }

    public void limpiar1() {
        txtId1.setText("");
        txtSeccion1.setText("");
        txtPCuerpo1.setText("");
        txtDescripcion1.setText("");
        txtFuncion1.setText("");
        txturl1.setText("");
    }
}