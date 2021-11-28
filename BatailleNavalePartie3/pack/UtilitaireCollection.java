package pack;
/**
 * Permet d'accepter plusieurs sortes de collection et de les traiter pour
 * obtenir les tirs (voir énoncé tp3 A21).
 *
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
import java.util.AbstractList;

public class UtilitaireCollection {

		/**
		 * Génère aléatoirement des coordonnées jusqu'à ce qu'une d'entre elles
		 * ne fasse pas partie du collection reçue.
		 *
		 * @param collection La collection (Un Vector, un ArrayList ou
		 *                                 un LinkedList).
		 *
		 * @return Un tir qui ne fait pas partie de la collection.
		 */
		public static  Coord obtenirCoupPasDejaJouer (AbstractList<Coord> collection){

			Coord c;

			do{

				c  = UtilitaireFonctions.coordAleatoire();

			// S'arrête avec un coup pas déjà joué.
			}while(collectionContientCoord(collection, c));

			return c;

		}

		/**
		 * Équivalent à contains sauf qu'on regarde le contenu des coordonnées
		 * et non seulement leur référence (deepContains)
		 *
		 * @param collection Une collection  coordonnées
		 * @param c La coordonnée cherchée
		 * @return Si une coordonnées dans la collection correspond à c.
		 */

		public static
		       boolean collectionContientCoord(AbstractList <Coord> collection,
			                                   Coord c){

			/*
			 * Stratégie : On recherche avec un while pour terminer dès
			 * qu'on a trouvé.
			 */

			boolean existe = false;

			// Itérateur.
			int  i = 0;

			// On regarde chaque coup du collection et s'il est identique au
			// coup la boucle s'arrête au prochain tour.
			while(i < collection.size() && !existe){

				existe = c.equals(collection.get(i));
				i++;
			}


			return existe;
		}

	/**
	 * Retourne le contenu des coordonnnées dans un tableau de String.
	 *
	 * @param tab Une liste de coordonnées.
	 *
	 * @return Les coordonnées en String.
	 */
	public static String[] obtenirTabString(AbstractList<Coord> tab){

		String[] tabStr = null;

		if(tab.size() != 0){

			tabStr = new String[tab.size()];

			for(int i  = 0; i < tabStr.length; i++){

				tabStr[i] = tab.get(i).toString();
			}
		}
		return tabStr;
	}
}