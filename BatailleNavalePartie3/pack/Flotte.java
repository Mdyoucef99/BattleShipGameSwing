package pack;
import java.util.Vector;

import java.awt.Color;

/**
 * Collection de navires dans l'implémentation d'un jeu de Bataille Navale 
 * 
 * Elle conserve les navires pour une aire de jeu.  Le contructeur doit recevoir 
 * la taille de la grille carrée qui contient les navires.
 * 
 * Si les coordonnées d'un navire ajouté sont invalides, le navire n'est pas 
 * ajouté et un code d'erreur est retourné.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public class Flotte{

	/*
	 * Stratégie : On ne crée pas de grille 2D, on ne retient que la 
	 * taille pour la validation des coordonnées des navires ajoutés.
	 */

	//**********************************
	//CONSTANTES DE BATTLESHIP
	//**********************************           
	/**message lorsqu'une position n'est pas dans la grille*/
	public static final int POSITIONINVALIDE = 0;

	/**message lorsqu'un navire a été correctement ajouté*/
	public static final int NAVIREAJOUTE = 7;

	/**message lorsqu'un navire est déjà à une position donnée*/
	public static final int NAVIREEXISTANT = 8;

	/**haut*/
	public static final int NORD = 1;

	/**bas*/
	public static final int SUD = 2;

	/**droite*/
	public static final int EST = 3;

	/**gauche*/
	public static final int OUEST = 4;           

	//******************************
	// ATTRIBUTS DE LA FLOTTE
	//******************************

	// On conserve les navires dans java.util.Vector (voir api)
	// pour utiliser ses méthodes déjà écrites (add, contains).
	private Vector<Navire> tabNavires;


	// Sert à retenir si le dernier tir sur la flotte a coulé un bateau.
	private boolean coule;

	private String dernierNavireCoule;

	//******************
	// CONSTRUCTEURS
	//******************
	/**
	 * Constructeur par défaut  qui crée une flotte sans navire
	 * 
	 */
	public Flotte(){

		// On crée la collection de navires vide.
		this.tabNavires = new Vector<Navire>();
	}


	/**
	 * Retourne si le dernier tir que la flotte a reçu
	 * a coulé un navire.
	 * @return Le dernier tir  reçu a coulé un navire de la flotte
	 */
	public boolean dernierTirACoule(){        	   

		// On retourne la valeur de l'attribut qui est affecté dans
		// la méthode leTirTouche.
		return coule;
	}

	/**
	 * Ajoute le navire dans la grille à sa position en tenant compte de
	 * la taille en constante.  La position doit être valide et ne rien 
	 * chevaucher.
	 * 
	 * @param navire le navire à ajouter
	 * 
	 * @return NAVIREAJOUTE si l'ajout a été effectué <p>
	 *         NAVIREEXISTANT s'il y avait déjà un navire
	 *         POSITIONINVALIDE si la position n'est pas dans la grille
	 */           
	public int ajouterNavire(Navire navire){               

		/*
		 * Stratégie : On ajoute le navire à la fin du vecteur navires
		 * à moins que la position soit invalide.
		 *
		 * La tâche de vérifier le chevauchement et la valitidé des 
		 * coordonnées est délégué à la classe Navire.
		 *
		 * La vérification de la validité est faite localement 
		 * (pourrait être une fonction)
		 */

		// Code retourne si ajouté.
		int codeErreur = NAVIREAJOUTE;

		// On vérifie que le navire n'en chevauche pas un autre.
		for(int i = 0; i <tabNavires.size();i++)
			if(navire.chevauche((Navire)tabNavires.get(i)))
				codeErreur =  NAVIREEXISTANT;

		// S'il n'a rien chevauché, la position doit être valide.
		if(codeErreur == NAVIREAJOUTE){

			if(navire.getCoordDebut().ligne < 0 || 
					navire.getCoordDebut().ligne  >= Constantes.TAILLE ||
					navire.getCoordFin().colonne  < 0 ||
					navire.getCoordFin().colonne >= Constantes.TAILLE){

				codeErreur = POSITIONINVALIDE;
			}

			else{

				// On peut ajouter le navire.
				tabNavires.add(navire);                          
			}
		}

		return codeErreur;
	}


	/**
	 * Retourne si tous les navires de la flotte sont coulés.
	 * 
	 * La partie est alors terminée.
	 * 
	 * @return true si tous les navires ont été coulés.
	 */
	public boolean jeuEstTermine(){
		
		int nb = 0;

		for (int i = 0; i < tabNavires.size(); i++){

			if(tabNavires.get(i).estCoule()) {

				nb++;
			}
		}

		return tabNavires.size() == nb;
	}           

	/**
	 * Retourne une copie du tableau de navires
	 * 
	 * @return Une copie du tableau de navires
	 */
	public Navire[] getTabNavires(){
		
		// Simplement.
		
		return  tabNavires.toArray(new Navire[tabNavires.size()]);
	}

	/**
	 * Fabrique d'une flotte avec des navires positionné aléatoirement.
	 * 
	 * @return Une flotte avec des navires ayant des positions valides
	 */
	public static Flotte obtenirFlotteAleatoire(){

		Flotte flotte = new Flotte();

		// Ajouter les navires dans la grille de jeu est fait localement.
		flotte.genererPosNavireAleaInsererDsGrille();

		return flotte;
	}


	//************************************************
	//GENERER NAVIRE ET INSERER DANS GRILLE
	//************************************************
	/*
	 * Génère 5 bateaux aléatoirement qui ne se chevauchent pas
	 */
	private void genererPosNavireAleaInsererDsGrille() {

		/*
		 * Stratégie : le SP ajouterNavire ajoute un navire seulement si
		 * sa position est valide (coord valide et pas de chevauchement).
		 *                  
		 * obtenirNavireAleatoire retourne un navire avec le nom
		 * et la longueur demandé positionné au hasard sur la grille.
		 */

		// On crée un porte-avion tant que ce n'est pas valide.

		// On met sur pls lignes pour respecter la norme du 80 colonnes
		// même si cela s'écrit en 1 ligne.  On évite de déclarer des 
		// variables inutilement.
		while(ajouterNavire(
				obtenirNavireAleatoire(Constantes.PORTE_AVION, 
						5,
						Color.BLUE)) != NAVIREAJOUTE);

		while(ajouterNavire(
				obtenirNavireAleatoire(Constantes.CUIRASSE, 
						4, 
						Color.YELLOW)) != NAVIREAJOUTE);

		while(ajouterNavire(
				obtenirNavireAleatoire(Constantes.SOUS_MARIN, 
						3, 
						Color.CYAN)) != NAVIREAJOUTE);

		while(ajouterNavire(
				obtenirNavireAleatoire(Constantes.DESTROYER, 
						3,
						Color.GREEN)) != NAVIREAJOUTE);

		while(ajouterNavire(
				obtenirNavireAleatoire(Constantes.CROISEUR, 
						2, 
						Color.GRAY)) !=NAVIREAJOUTE);


	}

	/**
	 * Retourne si un des navires de la flotte a déjà reçu un tir.
	 * 
	 * @param tir
	 * @return
	 */
	public boolean dejaRecuCoup(Coord tir){

		/*
		 * Stratégie : On délègue cela aux navires, en boucle.
		 */
		int i = 0;

		boolean dejaRecu = false;

		while(i < tabNavires.size() && !dejaRecu){

			dejaRecu = tabNavires.get(i).dejaRecuCoup(tir);
			i++;
		}

		return dejaRecu;
	}

	/**
	 * Crée un bateau avec le nom reçu de la longueur voulue 
	 * à une position aléatoire.
	 * 
	 * @param nom
	 * @param longueur
	 * @return
	 */
	private Navire obtenirNavireAleatoire(String nom,
			int longueur, 
			Color couleur){

		/*
		 * Stratégie : On génère une position dans la grille et on choisit 
		 * une direction au hasard (NORD, SUD, EST ou OUEST).
		 *                  
		 * Tant que la position + la longueur dans la direction est 
		 * impossible, on génère une nouvelle position et une autre 
		 * direction.
		 *                  
		 */

		// Coordonnées valide à générer.
		Coord debut = new Coord(0,0);
		Coord fin = new Coord(0,0);

		// À générer au hasard.
		int direction;

		// Navire à retourner.
		Navire navire = null;

		// Mis vrai lorsque le constructeur de navire arrête d'envoyer 
		// des exceptions.
		boolean navireAjoute = false;

		while(!navireAjoute){

			try {

				// Cette fonction retourne une position dans la grille où 
				// ça rentre
				debut = UtilitaireFonctions.coordAleatoire(longueur);

				// Retourne NORD, EST, OUEST ou SUD.
				direction = UtilitaireFonctions.nbAlea(NORD, OUEST);

				// Ajuste la fin par rapport au début et les ordonne.
				ajusterPosition(debut, fin, direction, longueur);

				// On tente un nouveau navire qui l;èverea une exception
				// si les coordonnées sont invalides.
				navire =  new Navire(nom, debut, fin, couleur);

				// Si on est ici, il n'y a pas eu de message d'exception.
				navireAjoute = true;

			} catch (Exception e) {

				// On affiche la trace et la boucle recommence.
				e.printStackTrace();
			}
		}

		// C'est certain que les coordonnées du navire sont dans la grille.
		return navire;
	}          

	/**
	 * Procédure privée locale pour ajuster le début et la fin selon la
	 * direction et la longueur.  Principale pour le détirage en SP.
	 * 
	 * On veut les donner en ordre de la ligne et la colonne.
	 * debut vient avant fin de haut en bas et de gauche à droite
	 * 
	 * @param debut Doit avoir une coordonnée valide
	 * @param fin Sera calculé
	 * @param direction NORD SUD EST ou OUEST
	 * @param longueur longueur valide selon la taille des navires
	 */
	private static void ajusterPosition(Coord debut, 
			                            Coord fin, 
			                            int direction, 
			                            int longueur){

		/*
		 * Stratégie : Selon la direction, on ajuste la fin pour que le 
		 * début vienne avant en ligne ou en colonne.
		 */
		fin.ligne = debut.ligne;

		switch(direction){

		case NORD : {
			fin.colonne = debut.colonne;
			debut.colonne = debut.colonne - longueur + 1;
			break;
		}
		case EST :{
			fin.ligne = debut.ligne;
			fin.colonne = debut.colonne  + longueur - 1;
			break;
		}
		case OUEST : {
			fin.colonne = debut.colonne;
			debut.ligne = debut.ligne - longueur + 1;
			break;
		}
		case SUD : {
			fin.colonne = debut.colonne + longueur - 1;
		}
		}
	}
	/**
	 * Reçoit un tir sur la flotte.  Retourne si un navire est touché.
	 * 
	 * @param tir Le tir à considéré
	 * 
	 * @return true si le tir a touché à un des navires.
	 */
	public boolean leTirTouche(Coord tir){

		/*
		 * Stratégie : On regarde si le tir touche à un des navires à 
		 * l'aide d'un while et la boucle se termine dès qu'on a 
		 * la réponse.
		 *                  
		 * On délègue la tâche de vérifier si le  tirAtouche à la classe 
		 * Navire.
		 *                                    
		 */
		boolean touche = false;

		int i = 0;

		while (i < tabNavires.size() && !touche){

			Navire nav = tabNavires.get(i);

			touche = nav.tirAtouche(tir);

			// On retient si le dernier tir a coulé un navire.
			// Utile au déroulement du jeu.
			coule = nav.estCoule();

			dernierNavireCoule = nav.getNom();

			i++;
		}


		return touche;

	}


	/**
	 * Retourne le nom du dernier bateau coulé.
	 * 
	 * @return Le nom du dernier bateau coulé.
	 */
	public String getDernierNavireCoule() {


		return dernierNavireCoule;
	}


	/**
	 * Retourne une copie de la flotte actuelle à une nouvelle adresse.
	 * 
	 * @return Une nouvelle flotte avec les mêmes attributs que
	 *         la flotte actuelle
	 */
	public Flotte clone() {

		Flotte f = new Flotte();

		f.tabNavires = (Vector<Navire>)tabNavires.clone();

		f.coule = coule;

		f.dernierNavireCoule = dernierNavireCoule;

		return f;
	}           
}
