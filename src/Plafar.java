import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

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

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nume = username.getText();
				String parola = String.valueOf(password.getPassword());
				if (nume.equals(numeAdministrator) && parola.equals(parolaAdministrator)) {
					window.setVisible(false);

					JFrame evidentaProduse = new JFrame("EVIDENTA PRODUSE FARMACEUTICE");
					JPanel contentPane = new JPanel();
					contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
					evidentaProduse.add(contentPane);

					JPanel panelProduse = new JPanel(new GridLayout(0, 1));
					JLabel stocuriLabel = new JLabel("STOCURI");
					panelProduse.add(stocuriLabel);

					JComboBox<Produs> produseList = new JComboBox<Produs>(ManagerDeProduse.getProduse());
					panelProduse.add(produseList);

					JLabel cantitateLabel = new JLabel("CANTITATE:");
					JTextField cantitateField = new JTextField();
					panelProduse.add(cantitateLabel);
					panelProduse.add(cantitateField);
					cantitateField.setEditable(false);
					cantitateLabel.setBounds(50, 10, 50, 10);
					cantitateLabel.setBackground(Color.PINK);

					JLabel pretLabel = new JLabel("PRET:");
					JTextField pretField = new JTextField(10);
					panelProduse.add(pretLabel);
					panelProduse.add(pretField);
					pretField.setEditable(false);

					JLabel valabilitateLabel = new JLabel("TERMEN VALABILITATE:");
					JTextField valabilitateField = new JTextField(10);
					panelProduse.add(valabilitateLabel);
					panelProduse.add(valabilitateField);
					contentPane.add(panelProduse);
					valabilitateField.setEditable(false);
					panelProduse.setBackground(Color.orange);

					JPanel panelVanzare = new JPanel(new GridLayout(0, 1));
					JLabel vanzare = new JLabel("VANZARE");
					JComboBox<Produs> produseList1 = new JComboBox<Produs>(ManagerDeProduse.getProduse());
					panelVanzare.add(vanzare);
					panelVanzare.add(produseList1);

					JLabel cantitateLabel1 = new JLabel("CANTITATE:");
					JTextField cantitateField1 = new JTextField(10);
					panelVanzare.add(cantitateLabel1);
					panelVanzare.add(cantitateField1);

					JLabel incasat = new JLabel("TOTAL INCASAT:");
					JTextField incasatField = new JTextField(10);
					panelVanzare.add(incasat);
					panelVanzare.add(incasatField);
					incasatField.setEditable(false);

					JButton vindeButon = new JButton("VINDE");
					panelVanzare.add(vindeButon);
					contentPane.add(panelVanzare);
					panelVanzare.setBackground(Color.red);

					JPanel panelAdaugaProdus = new JPanel(new GridLayout(0, 1));
					JLabel adaugaProdus = new JLabel("ADAUGA PRODUS:");
					panelAdaugaProdus.add(adaugaProdus);

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

					JLabel valabilitateLabel2 = new JLabel("Valabilitate:");
					JTextField valabilitateField2 = new JTextField(10);
					panelAdaugaProdus.add(valabilitateLabel2);
					panelAdaugaProdus.add(valabilitateField2);

					JButton adaugaButon = new JButton("ADAUGA");
					panelAdaugaProdus.add(adaugaButon);
					panelAdaugaProdus.setBackground(Color.green);
					contentPane.add(panelAdaugaProdus);

					evidentaProduse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					vindeButon.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Produs produsVanzare = (Produs) produseList1.getSelectedItem();
							int cantitate = Integer.parseInt(cantitateField1.getText());
							incasatField.setText(produsVanzare.pret * cantitate + "");
							ManagerDeProduse.scadeCantitate(produsVanzare, cantitate);
						}
					});

					adaugaButon.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Produs produsAdaugat = new Produs(numeField2.getText(),
									Integer.parseInt(cantitateField2.getText()),
									Double.parseDouble(pretField2.getText()), valabilitateField2.getText());
							produseList.addItem(produsAdaugat);
							produseList1.addItem(produsAdaugat);
							ManagerDeProduse.adaugaProdus(produsAdaugat);
						}
					});

					produseList.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Produs selectedItem = (Produs) produseList.getSelectedItem();
							cantitateField.setText(selectedItem.cantitate + "");
							pretField.setText(selectedItem.pret + "");
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