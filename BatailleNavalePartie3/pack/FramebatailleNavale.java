package pack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class FramebatailleNavale extends JFrame {

	private PanneauPrincipal contentPane;

	public static void main(String[] args)
	{

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FramebatailleNavale frame = new FramebatailleNavale();

					JOptionPane.showInputDialog(frame,"Enter Name");

					frame.setVisible(true);


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.

	 */
	public FramebatailleNavale() {

		/**
		 * Launch the application.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new PanneauPrincipal();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}


}
