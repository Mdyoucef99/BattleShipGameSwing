package pack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanneauBas extends JPanel {


	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension Screen =  new Dimension((int)(d.getWidth()),(int)(d.getHeight()*0.40));

    public boolean IsGamePlaying=false;

    String button= "Montrer flotte";

    JPanel Container = new JPanel();

    JPanel Containerbutton = new JPanel();



    /**
	 * Create the panel.
	 */


	public PanneauBas(JFrame f)
	{

		JButton buttonNouvellePartie = new JButton("Nouvelle Partie");
		buttonNouvellePartie.setBounds(50,100,95,30);


		JButton buttonMontrerFlottte = new JButton(button);
		buttonMontrerFlottte.setBounds(50,100,95,30);


		Containerbutton.setSize(Screen);
		Containerbutton.setLayout(new BoxLayout(Containerbutton,BoxLayout.LINE_AXIS));


		Containerbutton.add(Box.createRigidArea(new Dimension((int)(d.getWidth()/2.0)-100,0)));
		Containerbutton.add(buttonMontrerFlottte);
		Containerbutton.add(Box.createRigidArea(new Dimension(5,0)));
		Containerbutton.add(buttonNouvellePartie);


		Container.setLayout(new BorderLayout());
		Container.setSize(Screen);
		Container.add(Containerbutton,BorderLayout.CENTER);


		f.getContentPane().add(Container,BorderLayout.SOUTH);


	}


}








