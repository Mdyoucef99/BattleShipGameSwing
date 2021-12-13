package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class FramebatailleNavale extends JMenuBar {


	JMenuBar Strategie;
	JMenu Menu;
	JCheckBoxMenuItem m1, m2, m3;

	InterfaceStrategie strategie = null;


    PanneauHaut panneauHautref;

	/*
	 * Create notre Menu pour choisir
	 * la difficulte de lordinateur
	 */
	public FramebatailleNavale(PanneauHaut panneau, JFrame f) {
		this.panneauHautref = panneau;
		setMenuBar(f);
	}

	public void setMenuBar(JFrame f) {
		Strategie = new JMenuBar();
		Menu = new JMenu("Strategie");
		m1 = new JCheckBoxMenuItem("Debutant");
		m2 = new JCheckBoxMenuItem("Intermediaire");
		m3 = new JCheckBoxMenuItem("Avance");
		Menu.add(m1);
		Menu.add(m2);
		Menu.add(m3);
		Strategie.add(Menu);
		f.setJMenuBar(Strategie);


		m1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Ordi ordi =  panneauHautref.getOrdi();
				strategie = new OrdiStrategieDebutant();
				ordi.setStrategie(strategie);
				m2.setSelected(false);
				m3.setSelected(false);
				JOptionPane.showMessageDialog(f,"Changement Ordi a Debutant","Alert",JOptionPane.WARNING_MESSAGE);


			}

		});
		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Ordi ordi =  panneauHautref.getOrdi();
				strategie = new OrdiStrategieIntermediaire();
				m1.setSelected(false);
				m3.setSelected(false);
				ordi.setStrategie(strategie);
				JOptionPane.showMessageDialog(f,"Changement Ordi a Intermediaire","Alert",JOptionPane.WARNING_MESSAGE);


			}
		});
		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ordi ordi =  panneauHautref.getOrdi();
				strategie = new OrdiStrategieAvance();
				ordi.setStrategie(strategie);
				m1.setSelected(false);
				m2.setSelected(false);
				JOptionPane.showMessageDialog(f,"Changement Ordi a Avance","Alert",JOptionPane.WARNING_MESSAGE);


			}
		});



	}

}