package pack;
/**
 * Contrat à remplir par la classe Participant du tp3 inf11 A2021 (voir énoncé).
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public interface InterfaceParticipant {
		
	/**
	 * Demande à l'ordi de se générer une nouvelle flotte.
	 * 
	 * @return ordi.super.flotte.clone();
	 */
	public void genereNouvelleFlotte();
	
	
	/**
	 * Retourne une copie de la flotte de l'ordi.  Une modification à
	 * cette flotte n'affecte pas la sienne.
	 * 
	 * @return ordi.super.flotte.clone();
	 */
	public Flotte getFlotte();
	
	/**
	 * Retourne si le tir reçu a touché à la flotte.
	 * 
	 * @param tir Le tir à considérer.
	 * 
	 * @return true si le tir touche à un des navires de la flotte.
	 */
	public boolean flotteARecuTirQuiATouche(Coord tir);


	/*
	 * Retourne si tous les navires du joueur sont coulés.
	 * 
	 * @return true si tous les navires sont coulés et que le jeu est terminé.
	 */
	public boolean jeuEstTermine();
	
	
	/**
	 * Retourne le nom du dernier navire qui a été coulé.
	 * 
	 * @return le nom du dernier navire qui a été coulé.
	 */
	public String getDernierNavireCoule();
	
	/**
	 * Retourne si le dernier tir a coulé un navire dans la flotte del'ordi.
	 * 
	 * @return true si le dernier tir a coulé un navire.
	 */
	public boolean dernierTirACoule();


	

}
