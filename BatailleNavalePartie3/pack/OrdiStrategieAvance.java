package pack;
import java.util.LinkedList;

/**
 * Joueur qui joue depuis longtemps et a une assez bonne stratégie.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public class OrdiStrategieAvance extends StrategieOrdiAbstrait{

	
	/*
	 * Stratégie : Les coups sont joué sur la première diagonale jusqu'à un
	 * touché.
	 * 
	 * Ensuite, les cases vosines sont enfilés et tantqu'il y a des coups dans 
	 * la file, on joue un des coups qui s'y trouve.  Si la file redevient vide, 
	 * on continue sur la diagonale.
	 *                  
	 * Lorsqu'on a tout visité les cases de la première diagonale, 
	 * on fait l'autre.  Si on fait toutwe la deuxième diagonale, les coups
	 * sont joués au hasard sur une des cases vides restantes 
	 * (coup pas déjà joué).
	 *                  
	 */
	
	// Les coups retenus après un touché.
	private LinkedList<Coord> fileCoupAJoue;
	
	
	// Quelle diagonale on est rendu.
	boolean premiereDiagonale = true;
	boolean deuxiemeDiagonale = false;
	
	// Utiliseé globalement entre getTir et aviseTouche pour se rappeler où on 
	// est rendu en diagonale lorsque la file est vide.
	Coord cDiag;


	/**
	 * Constructeur par défaut
	 * 
	 */
	public OrdiStrategieAvance(){
		
		// Une file vide au départ.
		fileCoupAJoue = new LinkedList<Coord>();
		
		// La première case de la première diagonale.
		cDiag = new Coord(0,0);
	}

	/**
	 * Retourne le coup de l'ordi
	 * 
	 * @return
	 */
	public Coord getTir(){

		/*
		 * Stratégie.  On utilise le booléen premiereDiagonale qu'on met
		 * à faux si toute la première diagonale a été visitée.   
		 * Même chose pour la deuxième. 
		 */

		Coord cRetour = new Coord(0,0);

		// Si on a pas de coup à jouer, on joue sur les diagonales.
		if(fileCoupAJoue.isEmpty()){

			// Première diagonale.
			if(premiereDiagonale){

				// Cherche un coup pas joué sur la diagonale.
				while(super.tirDejaJoue(cDiag) &&	
					cDiag.ligne < Constantes.TAILLE){
					
					cDiag.ligne++;
					cDiag.colonne++;
				}
				
				// On a fini de regarder la première diagonale.
				if(cDiag.ligne == Constantes.TAILLE){
					
					// ¨osition de la première case de la deuxième diagonale.
					cDiag.ligne = 0;
					cDiag.colonne = Constantes.TAILLE - 1;

					premiereDiagonale = false;
					deuxiemeDiagonale = true;
				}
			}

			// Toujours vérifié car il est possible qu'on n'ait pas de coup 
			// de la première diagonale, il faut continuer sur la deuxième.
			if(deuxiemeDiagonale){

				// Cherche un coup pas joué sur la 2e diagonale.
				while(super.tirDejaJoue(cDiag) && 
					  cDiag.ligne < Constantes.TAILLE){
					
					cDiag.ligne++;
					cDiag.colonne--;
				}

				// On a fini de regarder la deuxième  et on a rien trouver alors 
				// on joue dans une case pas dÉjà joué au hasard.
				if(cDiag.ligne == Constantes.TAILLE){
					
					deuxiemeDiagonale = false;
					cDiag = super.obtenirTirPasDejaJoue();
				}
			}

			
			if(!premiereDiagonale && !deuxiemeDiagonale){
				
				cDiag = super.obtenirTirPasDejaJoue();
			}

			// On affecte la variable de retour.
			cRetour.ligne = cDiag.ligne;
			cRetour.colonne = cDiag.colonne;
		}

		else{

			// On enlève les coup qui ont déjà été joué.
			do{
				cRetour = (Coord)fileCoupAJoue.poll();
			}while(super.tirDejaJoue(cRetour) && !fileCoupAJoue.isEmpty());

			// Si la file redevient vide, on joue un coup pas déjà joué.
			if(fileCoupAJoue.isEmpty() &&  super.tirDejaJoue(cRetour))
				cRetour =  super.obtenirTirPasDejaJoue();
		}

		super.ajouterTir(cRetour);

		return cRetour;

	}

	
	public void aviserTouche(){		

		/*
		 * Stratégie, on vérifie les limites avant d'enfiler.
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