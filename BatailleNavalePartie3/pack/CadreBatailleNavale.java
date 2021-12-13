package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CadreBatailleNavale extends JFrame {


	/*
	 * Auteur du projet :
	 * Auteur : Youcef mekki daouadji
     * Auteur : Rada Leng
     * Auteur : Antoine Bolduc

	 * */

	public static void main(String[] args)
	{

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {

					CadreBatailleNavale MainFrame = new CadreBatailleNavale();//Creation du main frame

					String s =  JOptionPane.showInputDialog(MainFrame,"Enter Name").toString(); // POP up pour assigner le nom du joueur

					Joueur mainplayer = new Joueur(s);//creation du nom du joueur

					Ordi ordi = new Ordi();//creation de l'ordi

					PanneauPrincipal panneau = new PanneauPrincipal(ordi, mainplayer, MainFrame); //creation du panneau

					MainFrame.setVisible(true);
					MainFrame.getContentPane().add(panneau);//Ajout du panneau principal dans le main frame
					MainFrame.setTitle("Jeu Bataille Navale");



				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.

	 */
	public CadreBatailleNavale() {
	/**
		 * Launch the application.
		 */
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);


	}


}
