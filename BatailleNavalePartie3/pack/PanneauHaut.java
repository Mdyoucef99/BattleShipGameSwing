package pack;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

	 private Ordi Ordi;

	 private Joueur joueur;


	public PanneauHaut(Ordi Ordi,Joueur joueur,JFrame f) //Contructeur panneau haut
	{
      this.joueur = joueur;
      this.Ordi = Ordi;
	  initializeComponent(f);
	}


	public void initializeComponent(JFrame f) //Fonction qui s'occupe de initialiser et creer tous les components et ajouter cella au frame en parametre
	{

	 Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	 Dimension Screen =  new Dimension(800,(int)(d.getHeight()*0.60));

	 PlayerName = new JLabel(joueur.getNom());

	 OrdiName = new JLabel("Ordi");

	 JPanel panHaut = new JPanel();

	 JPanel MainPannel = new JPanel();

     JPanel playerPanel = new JPanel();

     JPanel OrdiPanel = new JPanel();

	 JPanel OrdiPanelFlotte = new JPanel();

	 MenuBarStrategie menuStrategie =  new MenuBarStrategie(this,f);


	 paneauJoueur = new PanneauGrilleGui(Screen);//Creation panneau Joueur
	 paneauOrdiTop = new PanneauGrilleGui(Screen);//Creation panneau Ordi
	 paneauOrdiBottom= new PanneauGrilleGui(Screen);//Creation copie du paneau Ordi


	 playerPanel.setLayout(new BoxLayout(playerPanel,BoxLayout.PAGE_AXIS)); // create panel for player
     playerPanel.add(PlayerName);
     playerPanel.add(paneauJoueur);

     OrdiPanel.setLayout(new BoxLayout(OrdiPanel,BoxLayout.PAGE_AXIS));//create panel for ordi
     OrdiPanel.add(OrdiName);

     OrdiPanelFlotte.setLayout(new OverlayLayout(OrdiPanelFlotte));//create layout for both ordi flotte panels
     OrdiPanelFlotte.add(paneauOrdiTop);
     OrdiPanelFlotte.add(paneauOrdiBottom);
     OrdiPanel.add(OrdiPanelFlotte);


     MainPannel.setLayout(new BoxLayout(MainPannel,BoxLayout.LINE_AXIS));//create main pannel for PanneauGrilleGui player and Ordi
     MainPannel.add(Box.createRigidArea(new Dimension(150,0)));
     MainPannel.add(playerPanel);
     MainPannel.add(Box.createRigidArea(new Dimension(5,0)));
     MainPannel.add(OrdiPanel);

     MainPannel.setAlignmentX(Component.CENTER_ALIGNMENT);

     MainPannel.add(menuStrategie,BoxLayout.LINE_AXIS);//Ajout menu strategie au main pannel



     panHaut.setLayout(new BorderLayout());
     panHaut.add(MainPannel); //Ajout Main panneau au panneau Haut


        f.getContentPane().add(panHaut,BorderLayout.NORTH);//ajout du panneau au frame

	}


	public Joueur getJoueur()
	{
		return joueur;

	}


	public Ordi getOrdi()
	{
        return Ordi;
	}


}