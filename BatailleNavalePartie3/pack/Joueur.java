package pack;
import java.util.Vector;
/**
 * Classe qui repr�sente un joueur d'une partie de bataille navale
 * 
 * Le joueur a un nom, une flotte et retient les tirs qu'il a effectu�s.
 * 
 * @author Pierre B�lisle
 * @version Copyright A2021
 */
public class Joueur extends Participant{

	/*
	 * Strat�gie : On conserve les tirs dans un vecteur et les t�ches sont 
	 * d�l�gu�es � l'utilitaire de collections.
	 */
	private String nom;
	
	/**
	 * Constructeur par copie de l'attribut nom.
	 * 
	 * Un flotte al�atoire et aucun tirs jou�s.
	 * 
	 * @param nom
	 */
	public Joueur(String nom){		
		
		this.nom = nom;
	}

	
	/**
	 * Accesseur du nom.
	 * 
	 * @return 
	 */
	public String getNom() {
		
		return nom;
	}
	
	
}
