package pack;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		
	}

}
