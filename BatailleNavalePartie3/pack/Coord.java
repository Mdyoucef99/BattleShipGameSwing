package pack;
/**
 * Cet enregistrement représente les coordonnées 
 * possible dans différents jeux de grille.
 * 
 *@author Pierre Bélisle
 *@version Copyright A2021
 */
public class Coord {

	/*
	 * Les coordonnées du jeu.
	 */
	int ligne;
	int colonne;

	/**
	 * Constructeur par défaut (0,0)
	 */
	public Coord(){
		
		ligne = 0;
		colonne = 0;
	}
	
	/**
	 * Constructeurs par ciopie d'attributs,
	 * 
	 * @param ligne
	 * @param colonne
	 */
	public Coord(int ligne,int colonne){
		
		this.ligne = ligne;
		this.colonne = colonne;
	}

	/**
	 * Méthode qui compare les lignes et les colonnes des deux coordonnées
	 * (this et coord)
	 * 
	 * @param coord
	 * @return Si coord est égal à this (deep equals)
	 */
	public boolean equals(Coord coord){
		
		return coord.ligne == ligne && coord.colonne == colonne;
	}
	
	/**
	 * Une version String d'un Coord.	
	 */
	public String toString(){
		
		return "(" + ligne + "," + colonne + ")";
	}	
	
	/**
	 * Obtenir une copie de this à une adresse différente.
	 * 
	 * @return Une instance de Coord != this && .equals(this).
	 */
	public Coord clone(){
		
		return new Coord(this.ligne, this.colonne);
	}
	
}
