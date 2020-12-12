
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
					
					JFrame evidentaProduse = new JFrame("EVIDENTA PRODUSE FARMACEUTICE");
					evidentaProduse.setLayout(new FlowLayout());
					JPanel panelProduse = new JPanel();

					Produs[] produse = { new Produs("Ceai musetel", "20", "3", "2023"),
							new Produs("Ceai tei", "10", "5", "2025"), new Produs("Ceai sunatoare", "10","3","2022"),new Produs("Rostopasca", "5", "15", "2025"),
							new Produs("Spirulina", "2", "10", "2026")};
					
					JComboBox produseList = new JComboBox(produse);
					panelProduse.add(produseList);
					
					JLabel  stocuriLabel = new JLabel("STOCURI");
					JTextField stocuriFeild = new JTextField(10);
					panelProduse.add(stocuriLabel);
					panelProduse.add(stocuriFeild);

					JLabel cantitateLabel = new JLabel("CANTITATE:");
					JTextField cantitateField = new JTextField(10);
					panelProduse.add(cantitateLabel);
					panelProduse.add(cantitateField);

					JLabel pretLabel = new JLabel("PRET:");
					JTextField pretField = new JTextField(10);
					panelProduse.add(pretLabel);
					panelProduse.add(pretField);

					JLabel valabilitateLabel = new JLabel("TERMEN VALABILITATE:");
					JTextField valabilitateField = new JTextField(10);
					panelProduse.add(valabilitateLabel);
					panelProduse.add(valabilitateField);
					evidentaProduse.add(panelProduse);
					panelProduse.setBackground(Color.orange);
					
					JPanel panelVanzare = new JPanel();
					JLabel vanzare = new JLabel("VANZARE");
					JTextField vanzareField = new JTextField(10);
					panelVanzare.add(vanzare);
					panelVanzare.add(vanzareField);
					
					JLabel produseLabel1 = new JLabel("PRODUSE:");
					JTextField produseField1 = new JTextField(10);
					panelVanzare.add(produseLabel1);
					panelVanzare.add(produseField1);
					
					
					JLabel cantitateLabel1 = new JLabel("CANTITATE:");
					JTextField cantitateField1 = new JTextField(10);
					panelVanzare.add(cantitateLabel1);
					panelVanzare.add(cantitateField1);
					
					JLabel incasat = new JLabel("TOTAL INCASAT:");
					JTextField incasatField = new JTextField(10);
					panelVanzare.add(incasat);
					panelVanzare.add(incasatField);
					
					JButton vindeButon = new JButton("VINDE");
					panelVanzare.add(vindeButon);
					evidentaProduse.add(panelVanzare);
					panelVanzare.setBackground(Color.red);
				
					
					
					JPanel panelAdaugaProdus = new JPanel();
					JLabel adaugaProdus = new JLabel("ADAUGA PRODUS:");
					JTextField adaugaProdusField = new JTextField(10);
					panelAdaugaProdus.add(adaugaProdus);
					panelAdaugaProdus.add(adaugaProdusField);
					
					JLabel numeLabel2 = new JLabel("NUME:");
					JTextField numeField2 = new JTextField(10);
					panelAdaugaProdus.add(numeLabel2);
					panelAdaugaProdus.add(numeField2);
					
					JLabel cantitateLabel2 = new JLabel("CANTITATE:");
					JTextField cantitateField2 = new JTextField(10);
					panelAdaugaProdus.add(cantitateLabel2);
					panelAdaugaProdus.add(cantitateField2);
					
					JLabel pretLabel2 = new JLabel("PRET:");
					JTextField pretField2 = new JTextField(10);
					panelAdaugaProdus.add(pretLabel2);
					panelAdaugaProdus.add(pretField2);
					
					JButton adaugaButon = new JButton("ADAUGA");
					panelAdaugaProdus.add(adaugaButon);
					panelAdaugaProdus.setBackground(Color.green);
					evidentaProduse.add(panelAdaugaProdus);
					
					
					
					

					produseList.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Produs selectedItem = (Produs) produseList.getSelectedItem();
							cantitateField.setText(selectedItem.cantitate);
							pretField.setText(selectedItem.pret);
							valabilitateField.setText(selectedItem.valabilitate);
						}
						
					});
					evidentaProduse.setVisible(true);
					evidentaProduse.pack();
				} else {
					errorLabel.setText("Incorect username sau password");
				}
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