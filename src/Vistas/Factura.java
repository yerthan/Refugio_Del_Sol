package Vistas;

import Controlador.claseControlador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Factura extends JDialog {

    private static final long serialVersionUID = 1L;
    private ArrayList<String> precios = claseControlador.leerPrecios();
    private static JPanel contentPane;

    public static void main(String[] args) {
        try {
            Factura dialog = new Factura();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Factura() throws SQLException {
        setBounds(100, 100, 500, 400);

        contentPane = new BackgroundPanel("./src/Vistas/Fondo.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());
        setContentPane(contentPane);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        contentPane.setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Refugio Del Sol ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel.gridheight = 3;
        gbc_lblNewLabel.gridwidth = 17;
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        gbc_lblNewLabel.anchor = GridBagConstraints.CENTER;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Habitación ............................ " + precios.get(0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.CENTER;
        gbc_lblNewLabel_1.gridwidth = 11;
        gbc_lblNewLabel_1.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel_1.gridx = 4;
        gbc_lblNewLabel_1.gridy = 3;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

        // Empty row for spacing
        GridBagConstraints gbc_emptyRow_1 = new GridBagConstraints();
        gbc_emptyRow_1.gridx = 0;
        gbc_emptyRow_1.gridy = 4;
        gbc_emptyRow_1.gridwidth = 19;
        gbc_emptyRow_1.weighty = 0.1;
        contentPane.add(Box.createVerticalStrut(10), gbc_emptyRow_1);

        JLabel lblNewLabel_2 = new JLabel("Régimen ............................ " + precios.get(1));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.CENTER;
        gbc_lblNewLabel_2.gridwidth = 11;
        gbc_lblNewLabel_2.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel_2.gridx = 4;
        gbc_lblNewLabel_2.gridy = 5;
        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

        // Empty row for spacing
        GridBagConstraints gbc_emptyRow_2 = new GridBagConstraints();
        gbc_emptyRow_2.gridx = 0;
        gbc_emptyRow_2.gridy = 6;
        gbc_emptyRow_2.gridwidth = 19;
        gbc_emptyRow_2.weighty = 0.1;
        contentPane.add(Box.createVerticalStrut(10), gbc_emptyRow_2);

        JLabel lblNewLabel_3 = new JLabel("Extras ............................ " + precios.get(2));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.CENTER;
        gbc_lblNewLabel_3.gridwidth = 11;
        gbc_lblNewLabel_3.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel_3.gridx = 4;
        gbc_lblNewLabel_3.gridy = 7;
        contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

        GridBagConstraints gbc_emptyRow_3 = new GridBagConstraints();
        gbc_emptyRow_3.gridx = 0;
        gbc_emptyRow_3.gridy = 8;
        gbc_emptyRow_3.gridwidth = 19;
        gbc_emptyRow_3.weighty = 0.1;
        contentPane.add(Box.createVerticalStrut(10), gbc_emptyRow_3);

        JLabel lblNewLabel_4 = new JLabel("TOTAL ............................ " + precios.get(3));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.CENTER;
        gbc_lblNewLabel_4.gridwidth = 11;
        gbc_lblNewLabel_4.insets = new Insets(5, 5, 5, 5);
        gbc_lblNewLabel_4.gridx = 4;
        gbc_lblNewLabel_4.gridy = 9;
        contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

        JButton cerrar = new JButton("Cerrar");
        cerrar.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridheight = 3;
        gbc_btnNewButton.gridwidth = 11;
        gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 12;
        gbc_btnNewButton.anchor = GridBagConstraints.CENTER;

        cerrar.addActionListener(e -> dispose());

        contentPane.add(cerrar, gbc_btnNewButton);
    }
}
