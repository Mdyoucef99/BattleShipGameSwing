package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class CadreBatailleNavale extends JMenuBar {
	

	JMenuBar Strategie;
	JMenu Menu;
	JMenuItem m1, m2, m3;
	/*
	 * Create notre Menu pour choisir 
	 * la difficulte de lordinateur
	 */
	public CadreBatailleNavale(JFrame f) {
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
				InterfaceStrategie strategie = new OrdiStrategieDebutant();
			}
		});
		m2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				InterfaceStrategie strategie = new OrdiStrategieIntermediaire();
				Ordi ordi = new Ordi();
				ordi.setStrategie(strategie);
			}
		}); 	
		m3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InterfaceStrategie strategie = new OrdiStrategieAvance();
				Ordi ordi = new Ordi();
				ordi.setStrategie(strategie);

			}
		});
		
		
		
	}

}