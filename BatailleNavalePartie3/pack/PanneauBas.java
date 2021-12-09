package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanneauBas extends JPanel {

    public boolean IsGamePlaying=false;

    public boolean TourJoueur=false;

    int incrementorFlotteVisible=0;

    String buttonText= "Montrer flotte Ordinateur";

    public PanneauHaut refPanneauHaut;

    JButton buttonNouvellePartie = new JButton("Nouvelle Partie");

	JButton buttonMontrerFlotte = new JButton(buttonText);


	public PanneauBas(PanneauHaut panneauhaut,JFrame f)
	{
		this.refPanneauHaut = panneauhaut;
		InitialiseComponent(f);

	}

	public void InitialiseComponent(JFrame f)
	{

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	    Dimension Screen =  new Dimension((int)(d.getWidth()),(int)(d.getHeight()*0.40));

	    JPanel Container = new JPanel();

	    JPanel Containerbutton = new JPanel();

		buttonNouvellePartie.setBounds(50,100,95,30);
		buttonMontrerFlotte.setBounds(50,100,95,30);

		buttonNouvellePartie.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(f,"La partie actuelle est annulée","Alert",JOptionPane.WARNING_MESSAGE);
				reinitialiserPanneauOrdi();
				RemettreEtatNouvellePartie();

		        Runnable code = new Runnable()
				{
					int nombretirJoueur=0;
					int nombreTirOrdi=0;

					@Override
					public void run() {		
							
						Joueur joueur = refPanneauHaut.getJoueur();
						Ordi ordi = refPanneauHaut.getOrdi();

						montrerFlotteJoueur();

                        int nombre = UtilitaireFonctions.nbAlea(1,2);

                        if(nombre==1)
                        {
                        	TourJoueur=true;
                        	 JOptionPane.showMessageDialog(f,"Le joueur a ete choisie au hazard pour commencer ","Alert",JOptionPane.WARNING_MESSAGE);
                        }

                        else
                        {
                        	TourJoueur=false;
                       	    JOptionPane.showMessageDialog(f,"L'ordi a ete choisie au hazard pour commencer ","Alert",JOptionPane.WARNING_MESSAGE);
                        }

						while(joueur.jeuEstTermine()==false && ordi.jeuEstTermine()==false)
						{
							if(TourJoueur==true)
							{
								if(estClique()==true) // Si le joueur a clique sur le panneau de ordi en haut
								{

								   nombretirJoueur++;
								   AfficherTirOrdi();

								   if(ordi.flotteARecuTirQuiATouche(getTirJoueur())==true)//Si le tir a touche la flotte de lï¿½ordinateur
								   {
									   MontrerCaseToucheOrdi();
									   if(ordi.dernierTirACoule()==true) // si le navire est coule
									   {
										   JOptionPane.showMessageDialog(f,"Le Navire "+ ordi.getDernierNavireCoule() + " a coule","Alert",JOptionPane.WARNING_MESSAGE);
									   }

								   }
								   refPanneauHaut.paneauOrdiTop.desactiverCase(getTirJoueur());
								   TourJoueur=false;
								}
							}

							else if (TourJoueur==false)
							{

							nombreTirOrdi++;
							Coord c = ordi.getStrategie().getTir();

							AfficherTirJoueur(c);

							if(joueur.flotteARecuTirQuiATouche(c))
							{
								MontrerCaseToucheJoueur(c);
								ordi.getStrategie().aviserTouche();

							}


							TourJoueur=true;
						}

					}
						if (joueur.jeuEstTermine()==true)
						{

						 JOptionPane.showMessageDialog(f,"le gagnant est l'ordinateur avec " + nombreTirOrdi +" tirs","Alert",JOptionPane.WARNING_MESSAGE);

						}

						else if(ordi.jeuEstTermine()==true)
						{
						 JOptionPane.showMessageDialog(f,"le gagnant est le joueur avec " + nombretirJoueur + " tirs" ,"Alert",JOptionPane.WARNING_MESSAGE);
						}

					}

				};

			Thread t = new Thread(code);
			t.start();
			}

		});

		buttonMontrerFlotte.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				montrerFlotteOrdi();
			}
		});

		Containerbutton.setSize(Screen);
		Containerbutton.setLayout(new BoxLayout(Containerbutton,BoxLayout.LINE_AXIS));

		Containerbutton.add(Box.createRigidArea(new Dimension((int)(d.getWidth()/2.0)-100,0)));
		Containerbutton.add(buttonMontrerFlotte);
		Containerbutton.add(Box.createRigidArea(new Dimension(5,0)));
		Containerbutton.add(buttonNouvellePartie);

		Container.setLayout(new BorderLayout());
		Container.setSize(Screen);
		Container.add(Containerbutton,BorderLayout.CENTER);

		f.getContentPane().add(Container,BorderLayout.SOUTH);

	}



	//Fonction qui s'occupe de montrer la flotte de l'ordi et aussi la cacher en changeant le texte du button
	public void montrerFlotteOrdi()
	{
		UtilitaireGrilleGui.montrerFlotte(refPanneauHaut.getOrdi().getFlotte(), refPanneauHaut.paneauOrdiBottom);
		if(incrementorFlotteVisible%2==0)
		{
			refPanneauHaut.paneauOrdiTop.setVisible(false);

			buttonMontrerFlotte.setText("Cacher flotte Ordinateur");

		}
		else if (incrementorFlotteVisible%2==1)
		{
			refPanneauHaut.paneauOrdiTop.setVisible(true);
			buttonMontrerFlotte.setText(buttonText);
		}
		incrementorFlotteVisible++;
	}



	public void CacherFlotteOrdi()
	{
		refPanneauHaut.paneauOrdiTop.setVisible(true);
	}


	public void montrerFlotteJoueur()
	{
		UtilitaireGrilleGui.montrerFlotte(refPanneauHaut.getJoueur().getFlotte(), refPanneauHaut.paneauJoueur);
		System.out.println("BUTTON PRESSED MONTRER FLOTTE JOUEUR");

	}



	      public boolean estClique()
	      {
		   return refPanneauHaut.paneauOrdiTop.caseEstCliquee();
		  }



		  public Coord getTirJoueur()
		  {
			  return refPanneauHaut.paneauOrdiTop.getPosition();
		  }

		  public void AfficherTirJoueur(Coord c)
		  {
			  refPanneauHaut.paneauJoueur.setValeur(c,Constantes.TOUCHE);

		  }



		  public void AfficherTirOrdi()
		  {
			  refPanneauHaut.paneauOrdiTop.setValeur(refPanneauHaut.paneauOrdiTop.getPosition(),Constantes.TOUCHE);
			  refPanneauHaut.paneauOrdiBottom.copierEtatCases(refPanneauHaut.paneauOrdiTop);

		  }



		  public void MontrerCaseToucheJoueur(Coord c )
		  {

				  refPanneauHaut.paneauJoueur.setCouleurFond(c,Color.red);

		  }




		  public void MontrerCaseToucheOrdi()
		  {
				  refPanneauHaut.paneauOrdiTop.setCouleurFond(refPanneauHaut.paneauOrdiTop.getPosition(),Color.red);
				  refPanneauHaut.paneauOrdiBottom.copierEtatCases(refPanneauHaut.paneauOrdiTop);

		  }


		  public void DesactiverCaseOrdi(Coord c)
		  {
			  refPanneauHaut.paneauOrdiTop.desactiverCase(c);
			  refPanneauHaut.paneauOrdiTop.copierEtatCases(refPanneauHaut.paneauOrdiBottom);

		  }


		  public void reinitialiserPanneauOrdi()// probleme mineur je vais regarder ca lundi en pm il y a seulement une case qui est enlever
		  {
			  refPanneauHaut.paneauOrdiTop.resetEstClique();
			  refPanneauHaut.paneauOrdiTop.reactiverCases();
			  UtilitaireGrilleGui.reinitialiserGui(refPanneauHaut.paneauJoueur);
			  UtilitaireGrilleGui.reinitialiserGui(refPanneauHaut.paneauOrdiBottom);
			  UtilitaireGrilleGui.reinitialiserGui(refPanneauHaut.paneauOrdiTop);
			  refPanneauHaut.paneauOrdiTop.copierEtatCases(refPanneauHaut.paneauOrdiBottom);

		  }

		  public void RemettreEtatNouvellePartie()
		  {

			  refPanneauHaut.getJoueur().genereNouvelleFlotte();
			  refPanneauHaut.getOrdi().genereNouvelleFlotte();
			  montrerFlotteJoueur();
			  CacherFlotteOrdi();

		  }

}








