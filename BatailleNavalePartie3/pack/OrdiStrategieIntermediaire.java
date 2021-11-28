package pack;
import java.util.LinkedList;

/**
 * Joueur qui joue depuis un bout de temps et a commencé à se développer une 
 * stratégie pas si mal mais pas excellente.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public class OrdiStrategieIntermediaire extends StrategieOrdiAbstrait{

	// Retient les tirs à l'entours d'un tir qui a touché.
	private LinkedList<Coord> fileCoupAJoue;
	
	/*
	 * Stratégie : Lorsqu'on est avisé d'un touché, on retient les quatre 
	 * coordonnées voisines dans une file.
	 *                  
	 * Au moment de jouer, si la file n'est pas vide, 
	 * on y prend le prochain tir.
	 *                  
	 */

	/**
	 * Constructeur par défaut
	 */
	public OrdiStrategieIntermediaire(){
		
		// Aucun coup joué mais file initialisée.
		fileCoupAJoue = new LinkedList<Coord>();
	}

	/**
	 * Retourne le tir de l'ordi
	 * 
	 * @return
	 */
		public Coord getTir(){

		/*
		 *  Stratégie.  Retourne un coup au hasard qui n'a pas déjà té joué à 
		 *  l'aide de l'utilitaire sur les collections.
		 *                   
		 *  Si la file n'est pas vide, il joue un de ces tirs qui n'a pas déjà 
		 *  été joués.
		 *                               
		 *  Dans aviserTouche, il retient dans la file les coups adjacents
		 *  au dernier tir qui a touché.
		 */
		Coord c;

		if(fileCoupAJoue.isEmpty()){
			
			c =  super.obtenirTirPasDejaJoue();
		}

		else{
			

			// On passe les tirs qui ont déjà été joués qui peuvent se trouver
			// dans la file.
			do{
			      c = fileCoupAJoue.poll();
			      
			}while(super.tirDejaJoue(c) && !fileCoupAJoue.isEmpty());
			
			// Si la file redevient vide, on joue un coup pas déjà joué.
			if(fileCoupAJoue.isEmpty() &&  super.tirDejaJoue(c)) {
				
				c = super.obtenirTirPasDejaJoue();
			}
		}

		super.ajouterTir(c);
		

		return c;

	}

	public void aviserTouche(){		

		/*
		 * Stratégie, on vérifie les limites avant d'empiler.
		 * 
		 * Juste 4 voisins possibles alors on a pas fait de boucle.
		 */

		Coord c = super.getDernierTir();
		Coord cPush = null;

		//NORD
		if(c.ligne>0){
			
			cPush = new Coord(c.ligne-1, c.colonne);
			fileCoupAJoue.add(cPush);
		}		

		//SUD
		if(c.ligne < Constantes.TAILLE - 1){
			
			cPush = new Coord(c.ligne+1, c.colonne);		
			fileCoupAJoue.add(cPush);
		}

		//EST
		if(c.colonne < Constantes.TAILLE - 1){
			
			cPush = new Coord(c.ligne, c.colonne+1);		
			fileCoupAJoue.add(cPush);
		}

		//OUEST
		if(c.colonne>0){
			
			cPush = new Coord(c.ligne, c.colonne - 1);		
			fileCoupAJoue.add(cPush);
		}
	}	
}