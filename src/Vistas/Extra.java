package Vistas;

import Operaciones.LecturaOEscrituraFicheros;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Extra extends JDialog {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static boolean boleano;
    private static ArrayList<String> info = new ArrayList<>();


    /**
     * Create the frame.
     */
    public Extra(JPanel contentPanel, boolean boleano, ArrayList<String> infoEnviar) {

        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] {30, 0, 0, 30, 30, 30, 0, 0, 0, 0, 0, 0, 30};
        gbl_contentPane.rowHeights = new int[] {0, 52, 30, 30, 30, 30, 30, 30, 30, 66};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        contentPane.setLayout(gbl_contentPane);

        JLabel nombre = new JLabel("Refugio del Sol");
        nombre.setFont(new Font("Tahoma", Font.BOLD, 15));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridheight = 3;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridwidth = 17;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(nombre, gbc_lblNewLabel);

        JLabel extras = new JLabel("Elige tus extras");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.gridwidth = 17;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 3;
        contentPane.add(extras, gbc_lblNewLabel_1);

        JRadioButton cuna = new JRadioButton("Cuna (20€)");
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.gridwidth = 17;
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton.gridx = 0;
        gbc_rdbtnNewRadioButton.gridy = 4;
        contentPane.add(cuna, gbc_rdbtnNewRadioButton);

        JRadioButton gimansio = new JRadioButton("Gimnasio (30€)");
        GridBagConstraints gbc_rdbtnGimnasio = new GridBagConstraints();
        gbc_rdbtnGimnasio.gridwidth = 17;
        gbc_rdbtnGimnasio.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnGimnasio.gridx = 0;
        gbc_rdbtnGimnasio.gridy = 5;
        contentPane.add(gimansio, gbc_rdbtnGimnasio);

        JRadioButton parking = new JRadioButton("Parking (10€)");
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.gridwidth = 17;
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_1.gridx = 0;
        gbc_rdbtnNewRadioButton_1.gridy = 6;
        contentPane.add(parking, gbc_rdbtnNewRadioButton_1);

        JRadioButton cama = new JRadioButton("Cama supletoria (20€)");
        GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_2.gridwidth = 17;
        gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_2.gridx = 0;
        gbc_rdbtnNewRadioButton_2.gridy = 7;
        contentPane.add(cama, gbc_rdbtnNewRadioButton_2);

        JRadioButton sinExtra = new JRadioButton("No quiero ningún extra");
        GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_3.gridwidth = 17;
        gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNewRadioButton_3.gridx = 0;
        gbc_rdbtnNewRadioButton_3.gridy = 8;
        contentPane.add(sinExtra, gbc_rdbtnNewRadioButton_3);

        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridheight = 3;
        gbc_btnNewButton.gridwidth = 17;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 9;


        sinExtra.addActionListener(e -> {
            if (sinExtra.isSelected()) {
                cuna.setEnabled(false);
                gimansio.setEnabled(false);
                parking.setEnabled(false);
                cama.setEnabled(false);
            } else {
                cuna.setEnabled(true);
                gimansio.setEnabled(true);
                parking.setEnabled(true);
                cama.setEnabled(true);
            }
        });

        aceptar.addActionListener(e -> {
            if (cuna.isSelected()) {
                infoEnviar.add("Cuna");
            } else if (gimansio.isSelected()) {
                infoEnviar.add("Gimnasio");
            } else if (parking.isSelected()){
                infoEnviar.add("Parking");
            } else if (cama.isSelected()){
                infoEnviar.add("Cama supletoria");
            } else if (sinExtra.isSelected()){
                infoEnviar.add("Null");
            } else {
                JOptionPane.showMessageDialog(contentPane, "Debes elegir un extra o marcar ninguno");
            }

            try {
                LecturaOEscrituraFicheros.escribirInfo(infoEnviar);
                Factura f = new Factura();
                f.setVisible(true);
            } catch (IOException | SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
        contentPane.add(aceptar, gbc_btnNewButton);
    }
}
