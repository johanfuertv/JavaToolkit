package MenuPrincipal;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu extends JFrame {

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JMenuItem queryMenuItem;
    private JMenuItem listsMenuItem;
    private JMenuItem statisticsMenuItem;
    private JMenuItem exitMenuItem;

    public  JPanel personalDataPanel;
    public JPanel academicDataPanel;
    public JButton jbGuardar;
    
    public MainMenu() {
        super("Datos del estudiante");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        queryMenuItem = new JMenuItem("Query by ID number");
        listsMenuItem = new JMenuItem("Lists");
        statisticsMenuItem = new JMenuItem("Statistics");
        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(newMenuItem);
        fileMenu.add(queryMenuItem);
        fileMenu.add(listsMenuItem);
        fileMenu.add(statisticsMenuItem);
        fileMenu.add(exitMenuItem);
        crearGUI();
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        personalDataPanel = new JPanel();
        academicDataPanel = new JPanel();


        personalDataPanel.setLayout(new GridLayout(0, 2));
        personalDataPanel.add(new JLabel("ID type:"));
        personalDataPanel.add(new JComboBox(new String[]{"Person ID", "Student ID"}));
        personalDataPanel.add(new JLabel("ID number:"));
        personalDataPanel.add(new JTextField(10));
        personalDataPanel.add(new JLabel("Apellido:"));
        personalDataPanel.add(new JTextField(10));
        personalDataPanel.add(new JLabel("Nombre:"));
        personalDataPanel.add(new JTextField(10));
        personalDataPanel.add(new JLabel("Gender:"));
        personalDataPanel.add(new JComboBox(new String[]{"Hombre", "Mujer"}));
        personalDataPanel.add(new JLabel("Fecha de nacimiento:"));
        personalDataPanel.add(new JSpinner(new SpinnerDateModel()));
        personalDataPanel.add(new JLabel("Ciudad de residencia:"));
        personalDataPanel.add(new JTextField(10));
        personalDataPanel.add(new JLabel("Direccion de residencia:"));
        personalDataPanel.add(new JTextField(10));
        personalDataPanel.add(new JLabel("Email:"));
        personalDataPanel.add(new JTextField(10));
        personalDataPanel.add(new JLabel("Observer:"));
        personalDataPanel.add(new JTextArea(10, 30));

        academicDataPanel.setLayout(new GridLayout(0, 2));
        academicDataPanel.add(new JLabel("Codigo de plan:"));
        academicDataPanel.add(new JComboBox(new String[]{"Plan 1", "Plan 2", "Plan 3"}));
        personalDataPanel.add(new JLabel("Dia:"));
        personalDataPanel.add(new JComboBox(new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"}));
        personalDataPanel.add(new JLabel("Ingresa la fecha del dia:"));
        personalDataPanel.add(new JSpinner(new SpinnerDateModel()));

        getContentPane().add(personalDataPanel, BorderLayout.WEST);
        getContentPane().add(academicDataPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        newMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBoxIDType = null;
				// Get the data from the form
            	String idType = comboBoxIDType.getSelectedItem().toString();
            	AbstractButton textFieldIDNumber = null;
				String idNumber = textFieldIDNumber.getText();
            	AbstractButton textFieldSurname = null;
				String surname = textFieldSurname.getText();
            	AbstractButton textFieldName = null;
				String name = textFieldName.getText();
            	JComboBox comboBoxGender = null;
				String gender = comboBoxGender.getSelectedItem().toString();
            	JSpinner spinnerDateOfBirth;
				//Date dateOfBirth = (Date) spinnerDateOfBirth.getValue();
            	AbstractButton textFieldCityOfResidence = null;
				String cityOfResidence = textFieldCityOfResidence.getText();
            	AbstractButton textFieldAddressOfResidence = null;
				String addressOfResidence = textFieldAddressOfResidence.getText();
            	AbstractButton textFieldEmail = null;
				String email = textFieldEmail.getText();
            	AbstractButton textAreaObserver = null;
				String observer = textAreaObserver.getText();
                // Validate the data
                if (idNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ID number is required.");
                    return;
                }

                if (surname.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Surname is required.");
                    return;
                }

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name is required.");
                    return;
                }

                // Save the data to a file
                try {
                    File file = new File("students.csv");
                    FileWriter writer = new FileWriter(file);
                    String dateOfBirth = null;
					writer.write(idType + "," + idNumber + "," + surname + "," + name + "," + gender + "," + dateOfBirth + "," + cityOfResidence + "," + addressOfResidence + "," + email + "," + observer + "\n");
                    writer.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

                // Display a confirmation message
                JOptionPane.showMessageDialog(null, "Student data saved successfully.");

                // Clear the form
                textFieldCityOfResidence.setText("");
            }
        });
    }

    private void crearGUI() {
		jbGuardar = new JButton("Guardar");
		jbGuardar.setBounds(699, 250, 150, 30);
		jbGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				evento_jbguardar();
		}
		});
		add(jbGuardar);
		
	}

	private void evento_jbguardar() {
		
	}

	public static void main(String[] args) {
        new MainMenu();
    }}