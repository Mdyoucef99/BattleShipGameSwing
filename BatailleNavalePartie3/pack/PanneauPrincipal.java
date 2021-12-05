package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauPrincipal extends JPanel {

	public static PanneauHaut panneauhaut;
	
	public CadreBatailleNavale Strategie;

	public PanneauBas panneauBas;

	public Joueur joueur;

	public Ordi ordi;
	
	public CadreBatailleNavale MenuBar;


	static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();


	/**
	 * Create the panel.
	 */

	public PanneauPrincipal(Ordi Ordi,Joueur joueur,JFrame frame)
	{
		 panneauhaut = new PanneauHaut(Ordi, joueur,frame);
		 panneauBas= new PanneauBas(panneauhaut,frame);


	}




}