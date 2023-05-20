package MenuPrincipal;

import javax.swing.*;
import java.awt.*;

public class AcercaDe extends JDialog {

    private JLabel imageLabel;
    private JLabel nameLabel;
    private JLabel codeLabel;
    private JLabel emailLabel;
    private JLabel versionLabel;
    FrameMenu fm;
    
    public AcercaDe(FrameMenu obj) {
    	fm = obj;
        // Set the dialog's size and location.
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the components.
        imageLabel = new JLabel(new ImageIcon("image.png"));
        nameLabel = new JLabel("Johan Ossa Serna");
        codeLabel = new JLabel("2257642");
        emailLabel = new JLabel("johanossa697@gmail.com");
        versionLabel = new JLabel("Version 1.0");

        // Add the components to the dialog.
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        contentPane.add(imageLabel, constraints);
        constraints.gridy++;
        contentPane.add(nameLabel, constraints);
        constraints.gridy++;
        contentPane.add(codeLabel, constraints);
        constraints.gridy++;
        contentPane.add(emailLabel, constraints);
        constraints.gridy++;
        contentPane.add(versionLabel, constraints);

        // Set the dialog's visible property to true.
        setVisible(true);
    }

}