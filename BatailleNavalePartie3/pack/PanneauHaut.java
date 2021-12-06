package pack;

import java.awt.BorderLayout;
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


	 private Ordi Ordi;

	 private Joueur joueur;


	 private static String[] elementsCombo = {"Strategie","Debutant","Avance","Intermediaire"};


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

     JPanel Strategie = new JPanel();


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

     panHaut.setLayout(new BorderLayout());
     panHaut.add(MainPannel);


	 panHaut.add(Strategie,BorderLayout.NORTH);
     Strategie.setPreferredSize(new Dimension(1920,25));

     JComboBox comboBox = new JComboBox();

		for(int i=0;i<elementsCombo.length;i++) {
			comboBox.addItem(elementsCombo[i]);
		}

		comboBox.setPreferredSize(new Dimension(100,25));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			}

		});

		Strategie.setLayout(new BorderLayout());
		Strategie.add(comboBox,BorderLayout.LINE_START);



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