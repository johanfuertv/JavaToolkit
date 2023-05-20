package MenuPrincipal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MostrarListados extends JFrame {
    private JTable table;

    public MostrarListados() {
        String csvFile = "students.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] columnNames = {"Nombre", "Apelido", "Gender"};

        // Create a 2D array to store the data
        Object[][] data = new Object[10][3];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int row = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] fields = line.split(cvsSplitBy);
                data[row][0] = fields[0];
                data[row][1] = fields[1];
                data[row][2] = fields[2];
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a JTable and add it to a JScrollPane
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        add(scrollPane);

        setTitle("CSV Reader");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MostrarListados csvReader = new MostrarListados();
        csvReader.setVisible(true);
    }
}