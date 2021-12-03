package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauBas extends JPanel {

	/**
	 * Create the panel.
	 */

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension Screen =  new Dimension((int)(d.getWidth()*0.40),(int)(d.getHeight()*0.40));


    JPanel Containerbutton = new JPanel();

    public boolean IsGamePlaying=false;

    String button= "Montrer flotte";


    JFrame f = new JFrame();



	public PanneauBas()
	{

		JButton buttonNouvellePartie = new JButton("Nouvelle Partie");
		buttonNouvellePartie.setBounds(50,100,95,30);


		JButton buttonMontrerFlottte = new JButton(button);
		buttonMontrerFlottte.setBounds(50,100,95,30);

		Containerbutton.setSize(Screen);
		Containerbutton.setLayout(new BoxLayout(Containerbutton,BoxLayout.LINE_AXIS));

		Containerbutton.add(buttonMontrerFlottte);
		Containerbutton.add(Box.createRigidArea(new Dimension(5,0)));
		Containerbutton.add(buttonNouvellePartie);



	}








}
