import controlador.claseControlador;
import operaciones.LecturaOEscrituraFicheros;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame{

    public static void main(String[]args){
        ArrayList<String> datos = LecturaOEscrituraFicheros.leerUsuarioContrasena();
        System.out.println(datos);

    }




//    private static final long serialVersionUID = 1L;
//    private JPanel contentPane;
//    private claseControlador controlador = new claseControlador();
//    private String infoEnviar = "";
//
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//
//    }
//
//    public Main () {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//        setContentPane(contentPane);
//        GridBagLayout gbl_contentPane = new GridBagLayout();
//        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
//        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
//
//        contentPane.setLayout(gbl_contentPane);
//
//        ButtonGroup bg = new ButtonGroup();
//
//        JLabel lblNewLabel = new JLabel("Elige tu habitación");
//        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
//        gbc_lblNewLabel.gridx = 0;
//        gbc_lblNewLabel.gridy = 0;
//        contentPane.add(lblNewLabel, gbc_lblNewLabel);
//
//        JLabel lblNewLabel_1 = new JLabel("Elige el tipo de habitación");
//        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
//        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
//        gbc_lblNewLabel_1.gridx = 4;
//        gbc_lblNewLabel_1.gridy = 0;
//        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
//
//        JLabel lblNewLabel_2 = new JLabel("Elige la capacidad");
//        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
//        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
//        gbc_lblNewLabel_2.gridx = 4;
//        gbc_lblNewLabel_2.gridy = 1;
//        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
//    }
}