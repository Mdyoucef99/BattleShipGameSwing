package pack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FramebatailleNavale extends JFrame {


	public static void main(String[] args)
	{

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {

					FramebatailleNavale MainFrame = new FramebatailleNavale();
					String s =  JOptionPane.showInputDialog(MainFrame,"Enter Name").toString();

					Joueur mainplayer = new Joueur(s);
					Ordi ordi = new Ordi();

					mainplayer.genereNouvelleFlotte();
					ordi.genereNouvelleFlotte();



					PanneauPrincipal panneau = new PanneauPrincipal(ordi, mainplayer, MainFrame);

					MainFrame.setVisible(true);
					MainFrame.getContentPane().add(panneau);





				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.

	 */
	public FramebatailleNavale() {

		/**
		 * Launch the application.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}


}
