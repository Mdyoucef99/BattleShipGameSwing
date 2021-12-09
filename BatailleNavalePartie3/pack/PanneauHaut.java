package pack;

import java.awt.BorderLayout;
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



	public PanneauHaut(Ordi Ordi,Joueur joueur,JFrame f)
	{
      this.joueur = joueur;
      this.Ordi = Ordi;

	  initializeComponent(f);
	}


	public void initializeComponent(JFrame f)
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

	 CadreBatailleNavale menuStrategie =  new CadreBatailleNavale(this,f);


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
     MainPannel.add(Box.createRigidArea(new Dimension(150,0)));
     MainPannel.add(playerPanel);
     MainPannel.add(Box.createRigidArea(new Dimension(5,0)));
     MainPannel.add(OrdiPanel);

     MainPannel.add(menuStrategie,BoxLayout.LINE_AXIS);
     panHaut.setLayout(new BorderLayout());
     panHaut.add(MainPannel);


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