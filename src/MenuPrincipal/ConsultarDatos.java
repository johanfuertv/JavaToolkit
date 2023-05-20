package MenuPrincipal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultarDatos {

    private JFrame frame;
    private JPanel mainPanel;
    private JButton consultButton;
    private JTextArea textArea;

    public ConsultarDatos() {
        frame = new JFrame("Consult CSV Data");
        mainPanel = new JPanel();
        consultButton = new JButton("Consult");
        textArea = new JTextArea();

        mainPanel.add(consultButton);
        mainPanel.add(textArea);

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        consultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the ID number from the user
                String idNumber = JOptionPane.showInputDialog("Enter the ID number:");

                // Check if the ID number is empty
                if (idNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID number is required.");
                    return;
                }

                // Try to read the data from the CSV file
                File file = new File("students.csv");
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);

                    // Iterate over the data in the file
                    while (scanner.hasNextLine()) {
                        String[] data = scanner.nextLine().split(",");

                        // Check if the ID number matches the data in the file
                        if (data[0].equals(idNumber)) {
                            // Display the data to the user
                            textArea.setText(data.toString());
                            System.out.println(data.toString());
                            break;
                        }
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println(ex.getMessage());
                } finally {
                    if (scanner != null) {
                        scanner.close();
                    }
                }

                // Check if the ID number is found in the file
                String[] data = obtenerDatosDelCSV(); // Reemplaza esto con tu lógica para obtener los datos del CSV
                if (!data[0].equals(idNumber)) {
                    JOptionPane.showMessageDialog(null, "The ID number is not in the CSV file.");
                }
            }
            private String[] obtenerDatosDelCSV() {
                String archivoCSV = "students.csv"; // Reemplaza con la ubicación real de tu archivo CSV
                String[] data = null;

                try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
                    String linea;
                    if ((linea = br.readLine()) != null) {
                        data = linea.split(","); // Suponiendo que el separador en tu archivo CSV es una coma (",")
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return data;
            }

        });
    }

    public static void main(String[] args) {
        new ConsultarDatos();
    }
}