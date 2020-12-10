
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Plafar {
	public static void main(String[] args) {

		JFrame window = new JFrame("AlinaPlant");
		window.setSize(300, 220);
		JTextField username = new JTextField(15);
		JPasswordField password = new JPasswordField(15);
		JButton ok = new JButton("OK");
		String numeAdministrator = "alina";
		String parolaAdministrator = "diana";

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pane = new JPanel();
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		JLabel errorLabel = new JLabel();
		pane.add(usernameLabel);
		pane.add(username);
		pane.add(passwordLabel);
		pane.add(password);
		pane.add(errorLabel);
		pane.add(ok);
		window.add(pane);
		window.setVisible(true);
		Plafar.setLookAndFeel();
		Plafar auth = new Plafar();

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nume = username.getText();
				String parola = String.valueOf(password.getPassword());
				if (nume.equals(numeAdministrator) && parola.equals(parolaAdministrator)) {
					window.setVisible(false);
					
					JFrame evidentaProduse = new JFrame("Evidenta produse parafarmaceutice");
					JLabel produseLabel = new JLabel("Produse:");
					JTextField produseField = new JTextField();
					evidentaProduse.add(produseLabel);
					evidentaProduse.add(produseField);
				
					JLabel cantitateLabel = new JLabel("Cantitate:");
					JTextField cantitateField = new JTextField();
					evidentaProduse.add(cantitateLabel);
					evidentaProduse.add(cantitateField);
					
					JLabel valabilitateLabel = new JLabel("Termen valabilitate:");
					JTextField valabilitateField = new JTextField();
					evidentaProduse.add(valabilitateLabel);
	                evidentaProduse.add(valabilitateField);				
					
					String[] produseStrings = { "Ceai musetel", "Ceai tei", "Ceai paducel", "Rostopasca", "Galbenele" };
					JComboBox produseList = new JComboBox(produseStrings);
					produseList.setBounds(90, 90,130,50); 
					evidentaProduse.add(produseList);
				    evidentaProduse.setLayout(new FlowLayout());    
				    evidentaProduse.setSize(4000,5000);    
				    evidentaProduse.setVisible(true);  
				    evidentaProduse.pack();
					
					
				} else {
					errorLabel.setText("Incorect username sau password");

				}

				// a luat valuarea parolei si o transforma in
			}

		});

	}

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}

}