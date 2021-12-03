package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class PanneauHaut extends JPanel {


	 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
     Dimension Screen =  new Dimension(700,(int)(d.getHeight()*0.60));

	 public PanneauGrilleGui  paneauJoueur = new PanneauGrilleGui(Screen);

	 public PanneauGrilleGui paneauOrdiTop = new PanneauGrilleGui(Screen);

	 public PanneauGrilleGui paneauOrdiBottom= new PanneauGrilleGui(Screen);

    // JFrame f = new JFrame();


     public JLabel PlayerName = new JLabel("No name");
     public JLabel OrdiName = new JLabel("Ordi name ");

	 JPanel panel = new JPanel();

	 JPanel playerPanel = new JPanel();

	 JPanel OrdiPanel = new JPanel();

	 JPanel OrdiPanelFlotte = new JPanel();

	/**
	 * Create the panel.
	 */

	public PanneauHaut(Participant Ordi,Participant joueur)
	{
		initializeComponent();
	}



	public void initializeComponent()
	{


	 playerPanel.setLayout(new BoxLayout(playerPanel,BoxLayout.PAGE_AXIS)); // create panel for player
     playerPanel.add(PlayerName);
     playerPanel.add(paneauJoueur);

     OrdiPanel.setLayout(new BoxLayout(OrdiPanel,BoxLayout.PAGE_AXIS));//create panel for ordi
     OrdiPanel.add(OrdiName);

     OrdiPanelFlotte.setLayout(new OverlayLayout(OrdiPanelFlotte));//create layout for both ordi flotte panels
     OrdiPanelFlotte.add(paneauOrdiTop);
     OrdiPanelFlotte.add(paneauOrdiBottom);
     OrdiPanel.add(OrdiPanelFlotte);


     panel.setLayout(new BoxLayout(panel,BoxLayout.LINE_AXIS));
     panel.add(playerPanel);
     panel.add(Box.createRigidArea(new Dimension(5,0)));
     panel.add(OrdiPanel);


/*

 //Juste pout tester
  *
     f.getContentPane().add(panel,BorderLayout.NORTH);
     f.pack();
     f.setVisible(true);
 * */


	}


/*//juste pour tester
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

	}*/


}
