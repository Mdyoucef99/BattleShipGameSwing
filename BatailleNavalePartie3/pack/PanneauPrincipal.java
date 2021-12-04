package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanneauPrincipal extends JPanel {

	public static PanneauHaut panneauhaut;

	public PanneauBas panneauBas;

	public Joueur joueur;

	public Ordi ordi;


	static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();


	/**
	 * Create the panel.
	 */

	public PanneauPrincipal(Participant Ordi,Participant joueur,JFrame frame)
	{
		 panneauhaut = new PanneauHaut(null, null,frame);
		 panneauBas= new PanneauBas(frame);

	}


	//POUR TESTER LES FONCTONNALITÉ
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {

                JFrame f = new JFrame();

                new PanneauPrincipal(null, null,f);


                String s =  JOptionPane.showInputDialog(f,"Enter Name").toString();
                panneauhaut.PlayerName.setText(s);


                f.pack();
                f.setVisible(true);
                f.setExtendedState(JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}



}