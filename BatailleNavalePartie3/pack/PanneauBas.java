package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

		        Runnable code = new Runnable()
				{
					int nombretirJoueur=0;
					int nombreTirOrdi=0;

					@Override
					public void run() {

						nombreTirOrdi=0;
						nombretirJoueur=0;
						Joueur joueur = refPanneauHaut.getJoueur();
						Ordi ordi = refPanneauHaut.getOrdi();

						RemettreEtatNouvellePartie();
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

							for(int i=0;i<2;i++)//L'ordinateur a le droit a 2 tirs
							{
								Coord c = ordi.getStrategie().getTir();//Ordinateur place son tir

								AfficherTirJoueur(c);//tire afficher dans la case du joueur

								if(joueur.flotteARecuTirQuiATouche(c))//si le tir a touche un navire du joueur
								{
									MontrerCaseToucheJoueur(c);//changer la couleur de la case du navire touche en rouge
									ordi.getStrategie().aviserTouche();//aviser l'ordi que le tir a touche un navire

								}

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

		Containerbutton.setLayout(new BoxLayout(Containerbutton,BoxLayout.X_AXIS));


		Containerbutton.add(Box.createRigidArea(new Dimension((int)(d.getWidth()/2.0)-100,0)));
		Containerbutton.add(buttonMontrerFlotte);
		Containerbutton.add(Box.createRigidArea(new Dimension(5,0)));
		Containerbutton.add(buttonNouvellePartie);
		Containerbutton.add(Box.createRigidArea(new Dimension(0,250)));


		Container.setLayout(new BorderLayout());
		Container.setSize(Screen);
		Container.add(Containerbutton,BorderLayout.CENTER);
		Container.setAlignmentY(Component.CENTER_ALIGNMENT);



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


	       //Fonction qui s'occupe de cacher la flotte de l'ordinateur en affichant le panneau du haut
		public void CacherFlotteOrdi()
		{
			refPanneauHaut.paneauOrdiTop.setVisible(true);
		}

		//Fonction qui s'occupe de montrer la flotte du joueur
		public void montrerFlotteJoueur()
		{
			UtilitaireGrilleGui.montrerFlotte(refPanneauHaut.getJoueur().getFlotte(), refPanneauHaut.paneauJoueur);
			System.out.println("BUTTON PRESSED MONTRER FLOTTE JOUEUR");

		}

	          //fonction qui verifie si une case a ete clicker dans le panneau de l'ordi et retourne un boolean
		      public boolean estClique()
		      {
			   return refPanneauHaut.paneauOrdiTop.caseEstCliquee();
			  }


		      //fonction qui retourne la cases clicker par le joueur
			  public Coord getTirJoueur()
			  {
				  return refPanneauHaut.paneauOrdiTop.getPosition();
			  }

			  //fonction qui affiche le tir du joueur dans la grille de l'ordi
			  public void AfficherTirJoueur(Coord c)
			  {
				  refPanneauHaut.paneauJoueur.setValeur(c,Constantes.TOUCHE);

			  }


	        //fonction qui affiche le tir de l'ordi dans la grille de l'ordi  et sa copie
			  public void AfficherTirOrdi()
			  {
				  refPanneauHaut.paneauOrdiTop.setValeur(refPanneauHaut.paneauOrdiTop.getPosition(),Constantes.TOUCHE);
				  refPanneauHaut.paneauOrdiBottom.copierEtatCases(refPanneauHaut.paneauOrdiTop);

			  }


	         //foncion qui afficher le tir de l'ordi dans la grille du joueur si le tir touche un navire
			  public void MontrerCaseToucheJoueur(Coord c )
			  {

				refPanneauHaut.paneauJoueur.setCouleurFond(c,Color.red);

			  }

			 //foncion qui afficher le tir du joueur  dans la grille de  l'ordi si le tir touche un navire et dans sa copie
			  public void MontrerCaseToucheOrdi()
			  {
					  refPanneauHaut.paneauOrdiTop.setCouleurFond(refPanneauHaut.paneauOrdiTop.getPosition(),Color.red);
					  refPanneauHaut.paneauOrdiBottom.copierEtatCases(refPanneauHaut.paneauOrdiTop);

			  }

	         //Fonction qui desactive la case dans la grille de l'ordi
			  public void DesactiverCaseOrdi(Coord c)
			  {
				  refPanneauHaut.paneauOrdiTop.desactiverCase(c);
				  refPanneauHaut.paneauOrdiTop.copierEtatCases(refPanneauHaut.paneauOrdiBottom);

			  }

	         //Focntion qui reinitialise la grille de l'ordi
			  public void reinitialiserPanneauOrdi()//
			  {
				  refPanneauHaut.paneauOrdiTop.resetEstClique();
				  refPanneauHaut.paneauOrdiTop.reactiverCases();
				  UtilitaireGrilleGui.reinitialiserGui(refPanneauHaut.paneauOrdiBottom);
				  UtilitaireGrilleGui.reinitialiserGui(refPanneauHaut.paneauOrdiTop);
				  refPanneauHaut.paneauOrdiBottom.copierEtatCases(refPanneauHaut.paneauOrdiTop);

			  }


			  //Fonction qui reset le jeu en entier
			  public void RemettreEtatNouvellePartie()
			  {
				  refPanneauHaut.getJoueur().genereNouvelleFlotte();
				  refPanneauHaut.getOrdi().genereNouvelleFlotte();
				  reinitialiserPanneauOrdi();
				  UtilitaireGrilleGui.reinitialiserGui(refPanneauHaut.paneauJoueur);
				  montrerFlotteJoueur();
				  CacherFlotteOrdi();

			  }


	}








