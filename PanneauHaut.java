package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class PanneauHaut extends JPanel{


	 public PanneauGrilleGui  paneauJoueur;

	 public PanneauGrilleGui paneauOrdiTop;

	 public PanneauGrilleGui paneauOrdiBottom;

	 public JLabel PlayerName;

	 public JLabel OrdiName;
	 
	 
	 private static String[] elementsCombo = {"Strategie","Debutant","Avance","Intermediaire"};



	public PanneauHaut(Participant Ordi,Participant joueur,JFrame f)
	{
		initializeComponent(f);
	}



	public void initializeComponent(JFrame f)
	{

	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension Screen =  new Dimension(800,(int)(d.getHeight()*0.60));


	     PlayerName = new JLabel("No name");
	     OrdiName = new JLabel("Ordi name ");
	     
	     JPanel panHaut = new JPanel();

		 JPanel MainPannel = new JPanel();

		 JPanel playerPanel = new JPanel();

		 JPanel OrdiPanel = new JPanel();

		 JPanel OrdiPanelFlotte = new JPanel();
		 



		 paneauJoueur = new PanneauGrilleGui(Screen);
		 paneauOrdiTop = new PanneauGrilleGui(Screen);
		 paneauOrdiBottom= new PanneauGrilleGui(Screen);




	 playerPanel.setLayout(new BoxLayout(playerPanel,BoxLayout.PAGE_AXIS)); // create panel for player
     playerPanel.add(PlayerName);
     playerPanel.add(paneauJoueur);

     OrdiPanel.setLayout(new BoxLayout(OrdiPanel,BoxLayout.PAGE_AXIS));//create panel for ordi
     OrdiPanel.add(OrdiName);

     OrdiPanelFlotte.setLayout(new OverlayLayout(OrdiPanelFlotte));//create layout for both ordi flotte panels
     OrdiPanelFlotte.add(paneauOrdiTop);
     OrdiPanelFlotte.add(paneauOrdiBottom);
     OrdiPanel.add(OrdiPanelFlotte);


     MainPannel.setLayout(new BoxLayout(MainPannel,BoxLayout.LINE_AXIS));
     MainPannel.add(Box.createRigidArea(new Dimension(200,0)));
     MainPannel.add(playerPanel);
     MainPannel.add(Box.createRigidArea(new Dimension(5,0)));
     MainPannel.add(OrdiPanel);
     
     panHaut.setLayout(new BorderLayout());
     panHaut.add(MainPannel);



		

     f.getContentPane().add(panHaut,BorderLayout.NORTH);//ajout du panneau au frame


     
     
	}


	public PanneauGrilleGui getJoueur() {
		return paneauJoueur;
	}



	public PanneauGrilleGui getOrdiTop() {
		return paneauOrdiTop;
	}



	public PanneauGrilleGui getOrdiBottom() {
		return paneauOrdiBottom;
	}


}