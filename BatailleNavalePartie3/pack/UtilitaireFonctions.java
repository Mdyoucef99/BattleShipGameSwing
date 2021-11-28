package pack;
/**
 * Contient quelques fontions de calcul mathématique.
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public class UtilitaireFonctions {

	/**
	 * Retourne un nombre aléatoire entre min et mas inclusivement.
	 */
	public static int nbAlea(int min, int max){

  	    /*
  	     * Stratégie, on utilise le générateur de Java qui retourne une valeur 
  	     * réelle entre 0 et 1[  ensuite, on le ramène dans l'intervalle 
  	     * min..max et on le transforme en entier
  	     */
  		return (int) (Math.random() * (max - min + 1) + min); 
  	}
    
 
   /**
    * Retourne une coordonnée entre 0 + longueurNavire -1 et 
    * Constantes.TAILLE - longueurNavire
    */
   public static Coord coordAleatoire(int longueurNavire){
  	 
  	 return new Coord(
  			 
  			 nbAlea(longueurNavire - 1, Constantes.TAILLE - longueurNavire), 
  			 nbAlea(longueurNavire - 1, Constantes.TAILLE - longueurNavire));
   }
   


   /**
    * Retourne une coordonnée dans la grille entre 0 et  Constantes.TAILLE - 1.
    */
   public static Coord coordAleatoire(){
  	 
  	 return new Coord(
  			 
  			 nbAlea(0, Constantes.TAILLE - 1), 
  			 nbAlea(0, Constantes.TAILLE - 1));
   }
}
