package MenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listados extends JFrame implements ActionListener {
    // Componentes y variables necesarias
    private JComboBox<String> opciones;
    private JPanel panelDatos;

    public Listados() {
        // Configuración básica del JFrame
        setTitle("Submenú");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear JComboBox con las opciones
        opciones = new JComboBox<>();
        opciones.addItem("Datos a nivel general");
        opciones.addItem("Consulta por código de plan");
        opciones.addItem("Consulta por ciudad");
        opciones.addItem("Consulta por correo");
        opciones.addActionListener(this);

        // Crear JPanel para mostrar los datos
        panelDatos = new JPanel();

        // Añadir componentes al JFrame
        add(opciones, BorderLayout.NORTH);
        add(panelDatos, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Limpiar el panel de datos
        panelDatos.removeAll();

        // Obtener la opción seleccionada
        String opcion = (String) opciones.getSelectedItem();

        // Mostrar los datos correspondientes a la opción seleccionada
        if (opcion.equals("Datos a nivel general")) {
            // Mostrar datos a nivel general
        	
        	
        } else if (opcion.equals("Consulta por código de plan")) {
            // Mostrar consulta por código de plan
        } else if (opcion.equals("Consulta por ciudad")) {
            // Mostrar consulta por ciudad
        } else if (opcion.equals("Consulta por correo")) {
            // Mostrar consulta por correo
        }

        // Actualizar el panel de datos
        panelDatos.revalidate();
        panelDatos.repaint();
    }

    public static void main(String[] args) {
        Listados ventana = new Listados();
        ventana.setVisible(true);
    }
}