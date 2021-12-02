package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class PanneauHaut extends JPanel {

	 public PanneauGrilleGui paneauJoueur;
	 public PanneauGrilleGui paneauOrdi;
	 public PanneauGrilleGui paneauFlotteOrdi;



	/**
	 * Create the panel.
	 */

	public PanneauHaut(Participant Ordi,Participant joueur)
	{
		initializeComponent();
	}



	public void initializeComponent()
	{
		 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

/*
 * 	     paneauJoueur = new PanneauGrilleGui(d);
		 paneauOrdi = new PanneauGrilleGui(d);
		 paneauFlotteOrdi = new PanneauGrilleGui(d);
 * */



	}





}
