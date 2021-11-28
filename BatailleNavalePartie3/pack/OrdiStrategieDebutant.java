package pack;
import java.util.Vector;

/**
 * Joueur qui a déjà joué.  Sa stratégie est un peu meilleure que la première
 * fois qu'il a  joué.
 *
 * Il retient ses coups et ne joue pas deux fois le même.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public class OrdiStrategieDebutant extends StrategieOrdiAbstrait{
	
	/**
	 * 
	 * @return
	 */
	public Coord getTir(){
		
		/*
		 * Stratégie : La méthode a été mise dans UtilitaireCollection pour 
		 * réutilisation. 
		 */
		Coord c =super.obtenirTirPasDejaJoue();
				
		// Ajoute le tir dans le tirs joué du parent.
		super.ajouterTir(c);
		
		return c; 
		
	}
	
	public void aviserTouche(){}	
}
