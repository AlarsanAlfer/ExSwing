package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JComboBox<String> comboPais;
    private JComboBox<String> comboPlat;
    private JLabel labelInfo;
    private JButton buttonConfirm;
    private JButton buttonCancelar;
    private DefaultTableModel model;


    public Pantalla() {
    setContentPane(panel1);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Pantalla añadir");
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setSize(600, 400);

        String[] cabecera = {"Correo","País","Plataforma"};
        model = new DefaultTableModel(cabecera,0);
        table1.setModel(model);


        comboPais.addItem("España");
        comboPais.addItem("Alemania");
        comboPais.addItem("Francia");
        comboPais.addItem("Italia");
        comboPais.addItem("Holanda");
        comboPlat.addItem("Escritorio");
        comboPlat.addItem("Móvil");
        comboPlat.addItem("Desconocido");


        /**
         * El botón confirmar comprueba que el textfield no esté vacío. Si lo está, manda un mensaje de error,
         * si no, añade los datos a la tabla mostrando un jOption confirmandolo.
         * **/
        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    labelInfo.setText("Asegurate de rellenar todos los campos");
                }else {
                    Object[] row = {textField1.getText(), comboPais.getSelectedItem(), comboPlat.getSelectedItem()};
                    model.addRow(row);
                    JOptionPane.showMessageDialog(null, "Usuario "+ textField1.getText()+" almacenado correctamente");
                    textField1.setText("");
                    labelInfo.setText("");
                    comboPais.setSelectedIndex(0);
                    comboPlat.setSelectedIndex(0);
                }
            }
        });

        /**
         * Resetea todos los valores
         * * **/
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                comboPais.setSelectedIndex(0);
                comboPlat.setSelectedIndex(0);
            }
        });


}


}
