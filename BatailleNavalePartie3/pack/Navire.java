package pack;
import java.awt.Color;
import java.util.Vector;

/**
 * Repondre à l'énoncé du tp3 A21 pour cette partie.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public class Navire {

	// Calculer au constructeur.
	private int nbCases;

	// Le nom (pas vraiment utilisé).
	private String nom;

	// Le nombre de touche par l'ennemi.
	private int nbToucheEnnemi;

	// Les  Coord qui représente les cases sur
	// lesquelles le  navire a été placé.
	private Coord debut;
	private Coord fin;

	private Color couleur;

	private Vector<Coord> tabCoups;
	
	/**
	 * Les positions doivent être ordonnées.
	 * 
	 * Aucune validation.
	 * 
	 * @param nbCases
	 */
	public Navire(String nom, Coord debut, Coord fin, Color couleur)
			      throws Exception{


		int nbLignes = (fin.ligne - debut.ligne + 1);
		int nbColonnes = (fin.colonne - debut.colonne + 1);

		if(nbLignes > 1 && debut.colonne != fin.colonne) {
			
			throw new Exception("NORD_SUD invalide");
		}
			

		if(nbColonnes > 1 && debut.ligne != fin.ligne) {
			
			throw new Exception("EST_OUEST invalide");			
		}
			

		if(debut.ligne > fin.ligne || debut.ligne < 0) {
			
			throw new Exception("ligne invalide");
		}

		if(debut.colonne > fin.colonne || debut.colonne < 0) {
			
			throw new Exception("colonne invalide");
		}

		this.nom = nom;
		this.debut = debut;
		this.fin = fin;

		this.couleur = couleur;

		nbCases =  (nbLignes > 1)?nbLignes:nbColonnes; 

		tabCoups = new Vector<Coord>();

	}


	/**
	 * Accesseur de couleur
	 * 
	 * @return
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Mutateur de la couleur
	 * 
	 * @param couleur
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}



	// Un service boolean estCoule() qui retourne vrai si toutes les cases du  
	// ont été touchées.
	public  boolean estCoule(){	
		
		return nbToucheEnnemi == nbCases;
	}

	/**
	 * Fonction locale pour éviter la répétition de code
	 * qui retourne si le coup touche au navire actuel
	 * 
	 * Il touche s'il est sur la même ligne ou sur la même colonne
	 * dans l'intervalle entre debut et fin de l'autre dimension.
	 * 
	 * @param coup
	 * @return
	 */
	private boolean positionTouche(Coord coup){

		boolean touche = (coup.ligne >= debut.ligne && 
				coup.ligne <= fin.ligne && 
				coup.colonne == debut.colonne) || 
				(coup.colonne >= debut.colonne && 
				coup.colonne <= fin.colonne &&
				coup.ligne == debut.ligne);
		
		return touche;
	}


	/**
	 * Retourne si le coup en paramètre touche au navire.
	 * Le navire retient s'il a été touché.
	 * 
	 * @param coup Le coup reçu
	 * 
	 * @return Si le coup a touché le bateau
	 */
	public boolean tirAtouche(Coord coup){

		boolean touche = false;

		// Si le navire est coulé, il n'a pas été touché par ce dernier coup
		if(!estCoule()){

			// S'il a déjà été atteint, on ne fait rien
			if(!UtilitaireCollection.collectionContientCoord(tabCoups, coup))

				// Fonction locale qui regarde si le coup touche au navire 
				// actuel.
				if( positionTouche(coup))  {

					touche = true;		

					// On retient le coup et on compte un touché de plus.
					tabCoups.add(coup);

					// Un touché de plus.
					nbToucheEnnemi++;					
				}					
		}

		return touche;
	}

	/**
	 * Vérifie si le navire reçu et l'actuel se touchent
	 * 
	 * @param bateau le bateau à vérifier
	 * @return true s'ils se touchent et false sinon
	 */
	public boolean chevauche(Navire navire){

		/*
		 * Stratégie : Pour chaque coordonnée du navire reçu, on regarde q'il 
		 * touche au navire actuel (this) . La fonction se termine aussitôt que 
		 * la réponse est connue
		 */
		// Compte les coordonnées vérifiées.
		int compteur = 0;

		// Fini si on a vérifié toutes les coordonnées.
		boolean touche = false;

		Coord c = new Coord(0,0);
		
        // On veut arrêter si on s'aperçoit qu'il y a une touche.
		while(compteur < navire.nbCases && !touche){

			// NORD_SUD
			if(	navire.fin.ligne - navire.debut.ligne + 1 > 1){
				c.ligne = navire.debut.ligne + compteur;
				c.colonne = navire.debut.colonne;
			}

			// EST_OUEST
			else{
				c.ligne = navire.debut.ligne ;
				c.colonne = navire.debut.colonne + compteur;
			}					

			touche = positionTouche(c);

			compteur++;
		}
		return touche;
	}

	/**
	 * Reoturne si le tir a déjà été reçu par le navire.
	 * 
	 * @param coup
	 * @return
	 */
	public boolean dejaRecuCoup(Coord tir){
		
		return UtilitaireCollection.collectionContientCoord(tabCoups, tir);
	}
	
	/*
	 * @return les attributs du navire
	 */
	public String toString(){
		
		return nom + " :  (" + debut.ligne + "," + debut.colonne  + ")" + " " + 
		                  "(" + fin.ligne + "," + fin.colonne + ")"  + 
				           "longueur : " + nbCases;
	}

	/**
	 * Accesseur du nom
	 * 
	 * @return
	 */
	public String getNom() {
		
		return nom;
	}

	/**
	 * Mutateur du nom
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		
		this.nom = nom;
	}

	/**
	 * Acesseur de la coordonnée de début du navire.
	 * 
	 * @return
	 */
	public Coord getCoordDebut() {
		
		return debut;
	}

	/**
	 * Mutateur de la coordonnée de début du navire
	 * 
	 * @param debut
	 */
	public void setCoordDebut(Coord debut) {
		
		this.debut = debut;
	}

	/**
	 * Acesseur de la coordonnée de fin du navire.
	 * 
	 * @return
	 */
	public Coord getCoordFin() {
		
		return fin;
	}

	/**
	 * Mutateur de la coordonnée de fin du navire
	 * 
	 * @param debut
	 */
	public void setCoordFin(Coord fin) {
		
		this.fin = fin;
	}
	
	
	/**
	 * Retourne une copie du navire actuel.
	 * 
	 * @return Un navire avec les mêmes attributs à des adresses différentes.
	 */
	public Navire clone() {
		
		Navire n = null;
		
		try {

			// Il est important que clone() de Coord existe.
			n = new Navire(nom, debut.clone(), fin.clone(), couleur);
			
			// Calculer au constructeur.
			n.nbCases = nbCases;

			// Le nombre de touche par l'ennemi.
			n.nbToucheEnnemi = nbToucheEnnemi;
			
			n.tabCoups = (Vector<Coord>)tabCoups.clone();

		}catch(Exception e) {}
		
		

		return n;
	}
}