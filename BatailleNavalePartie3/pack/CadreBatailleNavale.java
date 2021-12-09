package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class CadreBatailleNavale extends JMenuBar {


	JMenuBar Strategie;
	JMenu Menu;
	JMenuItem m1, m2, m3;
	InterfaceStrategie strategie = null;


    PanneauHaut panneauHautref;

	/*
	 * Create notre Menu pour choisir
	 * la difficulte de lordinateur
	 */
	public CadreBatailleNavale(PanneauHaut panneau, JFrame f) {

		this.panneauHautref = panneau;
		setMenuBar(f);
	}



	public void setMenuBar(JFrame f) {
		Strategie = new JMenuBar();
		Menu = new JMenu("Strategie");
		m1 = new JMenuItem("Debutant");
		m2 = new JMenuItem("Intermediaire");
		m3 = new JMenuItem("Avance");
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
			}

		});
		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Ordi ordi =  panneauHautref.getOrdi();
				strategie = new OrdiStrategieIntermediaire();

				ordi.setStrategie(strategie);
			}
		});
		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ordi ordi =  panneauHautref.getOrdi();
				strategie = new OrdiStrategieAvance();
				ordi.setStrategie(strategie);

			}
		});



	}

}