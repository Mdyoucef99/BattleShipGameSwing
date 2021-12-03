package pack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanneauHaut extends JPanel {


	 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

     Dimension Screen =  new Dimension(500,(int)(d.getHeight()*0.60));

	 public PanneauGrilleGui  paneauJoueur = new PanneauGrilleGui(Screen);

	 public PanneauGrilleGui paneauOrdi = new PanneauGrilleGui(Screen);

	 public PanneauGrilleGui paneauFlotteOrdi= new PanneauGrilleGui(Screen);

     JFrame f = new JFrame();
	 JPanel panel = new JPanel();

	/**
	 * Create the panel.
	 */

	public PanneauHaut(Participant Ordi,Participant joueur)
	{
		initializeComponent();
	}



	public void initializeComponent()
	{

      panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));
      panel.add(paneauJoueur);
      panel.add(Box.createRigidArea(new Dimension(5,0)));
      panel.add(paneauOrdi);




      //Juste pout tester
      f.getContentPane().add(panel,BorderLayout.NORTH);
      f.pack();
      f.setVisible(true);

	}


	//juste pour tester
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {

                 new PanneauHaut(null, null);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}



}
