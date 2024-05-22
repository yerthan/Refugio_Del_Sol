package Vistas;

import Controlador.claseControlador;
import Operaciones.LecturaOEscrituraFicheros;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.SpinnerListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

public class Vista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ArrayList<String> infoEnviar = new ArrayList<>();
    JSpinner spinner = new JSpinner();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vista frame = new Vista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Vista() throws SQLException {
        ButtonGroup bg = new ButtonGroup();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        contentPane = new BackgroundPanel("src/Vistas/Fondo.jpg");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());

        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{30, 30, 95, 106, 49, 0, 45};
        gbl_contentPane.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        contentPane.setLayout(gbl_contentPane);

        JLabel nombre = new JLabel("Refugio Del Sol ");
        nombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridheight = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridwidth = 7;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(nombre, gbc_lblNewLabel);

        JLabel habitacion = new JLabel("Elige tu habitación");
        habitacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.gridwidth = 7;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 2;
        contentPane.add(habitacion, gbc_lblNewLabel_1);

        JRadioButton suite = new JRadioButton("Suite (200€)");
        suite.setOpaque(false);
        GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
        gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.EAST;
        gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton.gridx = 2;
        gbc_rdbtnNewRadioButton.gridy = 3;
        bg.add(suite);
        contentPane.add(suite, gbc_rdbtnNewRadioButton);

        JRadioButton turista = new JRadioButton("Turista (100€)");
        turista.setOpaque(false);
        GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
        gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNewRadioButton_1.gridx = 3;
        gbc_rdbtnNewRadioButton_1.gridy = 3;
        bg.add(turista);
        contentPane.add(turista, gbc_rdbtnNewRadioButton_1);

        JLabel numCamas = new JLabel("Elige el número de camas");
        numCamas.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_lblEligeElNmero = new GridBagConstraints();
        gbc_lblEligeElNmero.insets = new Insets(0, 0, 5, 5);
        gbc_lblEligeElNmero.gridx = 2;
        gbc_lblEligeElNmero.gridy = 5;
        contentPane.add(numCamas, gbc_lblEligeElNmero);

        GridBagConstraints gbc_spinner = new GridBagConstraints();
        gbc_spinner.fill = GridBagConstraints.BOTH;
        gbc_spinner.insets = new Insets(0, 0, 5, 5);
        gbc_spinner.gridx = 3;
        gbc_spinner.gridy = 5;
        String[] camas = {"1 (0€)", "2 (50€)", "3 (80€)"};
        SpinnerListModel listaCamas = new SpinnerListModel(camas);
        spinner = new JSpinner(listaCamas);
        contentPane.add(spinner, gbc_spinner);

        JLabel regimen = new JLabel("Elige tu régimen");
        regimen.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 2;
        gbc_lblNewLabel_2.gridy = 7;
        contentPane.add(regimen, gbc_lblNewLabel_2);

        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.gridx = 3;
        gbc_comboBox.gridy = 7;
        JComboBox regimenes = new JComboBox();
        regimenes.addItem("Todo incluido (50€)");
        regimenes.addItem("Media pensión (25€)");
        regimenes.addItem("Desayuno (10€)");
        regimenes.setSelectedIndex(0);
        contentPane.add(regimenes, gbc_comboBox);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridwidth = 7;
        gbc_btnNewButton.gridheight = 2;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 9;
        contentPane.add(aceptar, gbc_btnNewButton);

        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                try {
//                    if (ComprobarReserva()) {

                        infoEnviar.clear();
                        if (Comprobar()) {
                            infoEnviar.add(String.valueOf(spinner.getModel().getValue()));
                            infoEnviar.add(String.valueOf(regimenes.getSelectedItem()));

                            Extra ex = new Extra(contentPane, true, infoEnviar);
                            ex.setVisible(true);
                            Vista.this.dispose();
                        }
//                    }
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
            }

            private boolean Comprobar() {
                boolean esValido = true;
                while (true) {
                    if (suite.isSelected()) {
                        infoEnviar.add("Suite");
                        break;
                    } else if (turista.isSelected()) {
                        infoEnviar.add("Turista");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Debes elegir una habitación", "Aviso", JOptionPane.WARNING_MESSAGE);
                        esValido = false;
                        return esValido;
                    }
                }
                return esValido;
            }

//            private boolean ComprobarReserva() throws SQLException {
//                boolean existeReserva = claseControlador.comprobarHabitacion();
//                System.out.println(existeReserva);
//                if (!existeReserva) {
//                    JOptionPane.showMessageDialog(contentPane, "No hay habitaciones disponibles", "Aviso", JOptionPane.WARNING_MESSAGE);
//                    Vista.this.dispose();
//                    return false;
//                }
//                return true;
//            }
        });

        contentPane.add(aceptar, gbc_btnNewButton);
    }
}

