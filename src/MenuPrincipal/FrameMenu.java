package MenuPrincipal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameMenu extends JFrame {
    
    JButton jbtxt;
    AcercaDe acd;

    public FrameMenu(){
        super("MENU");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        crearGUI();
        acd = new AcercaDe(this);
        setVisible(true);
    }
    

    private void crearGUI() {

        jbtxt = new JButton("Nuevo Usuario");
        jbtxt.setBounds((500-200)/2, 30, 200, 50);
        jbtxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainMenu obj = new MainMenu();
		
				
				
			}
		});
        add(jbtxt);
    
        jbtxt = new JButton("Consulta por ID");
        jbtxt.setBounds((500-200)/2, 90, 200, 50);
        jbtxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				
			}
		});
        add(jbtxt);

        
        jbtxt = new JButton("Listados");
        jbtxt.setBounds((500-200)/2, 150, 200, 50);
        jbtxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
        add(jbtxt);
       
        jbtxt = new JButton("Estadisticas");
        jbtxt.setBounds((500-200)/2, 210, 200, 50);
        jbtxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//evento_jbAcerca();
			}
			
			
		});
        add(jbtxt);
        
        jbtxt = new JButton("Acerca de...");
        jbtxt.setBounds((500-200)/2, 270, 200, 50);
        jbtxt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AcercaDe obj = new AcercaDe(null);
				
			}
			
			
		});
        add(jbtxt);
    }
    
    
    
}