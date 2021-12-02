package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanneauHaut extends JPanel {

	 public JPanel paneau1;
	 public JPanel paneau2;
	 public JPanel paneau3;


	/**
	 * Create the panel.
	 */

	public PanneauHaut()
	{
		initializeComponent();
	}



	public void initializeComponent()
	{
		 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		 paneau1 = new PanneauGrilleGui(d);
		 paneau2 = new PanneauGrilleGui(d);
		 paneau3 = new PanneauGrilleGui(d);

	}





}
