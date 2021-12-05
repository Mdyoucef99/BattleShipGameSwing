package pack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauBas extends JPanel {

    public boolean IsGamePlaying=false;

    int incrementorFlotteVisible=0;

    String button= "Montrer flotte";

    public PanneauHaut refPanneauHaut;

    public boolean TourJoueur=false;

    JButton buttonNouvellePartie = new JButton("Nouvelle Partie");

	JButton buttonMontrerFlotte = new JButton(button);



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

			System.out.println("BUTTON PRESSED NOUVELLE PARTIE ");

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



	public void montrerFlotteOrdi()
	{

		UtilitaireGrilleGui.montrerFlotte(refPanneauHaut.getOrdi().getFlotte(), refPanneauHaut.paneauOrdiBottom);

		System.out.println("BUTTON PRESSED MONTRER FLOTTE ORDI");
		if(incrementorFlotteVisible%2==0)
		{
			refPanneauHaut.paneauOrdiTop.setVisible(false);
			buttonMontrerFlotte.setText("Cacher flotte");

		}

		else if (incrementorFlotteVisible%2==1)
		{

			refPanneauHaut.paneauOrdiTop.setVisible(true);
			buttonMontrerFlotte.setText("Montrer flotte");
		}

		incrementorFlotteVisible++;

	}




	public void montrerFlotteJoueur()
	{
		UtilitaireGrilleGui.montrerFlotte(refPanneauHaut.getJoueur().getFlotte(), refPanneauHaut.paneauJoueur);
		System.out.println("BUTTON PRESSED MONTRER FLOTTE JOUEUR");

	}



}








