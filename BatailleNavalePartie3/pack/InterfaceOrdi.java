package pack;
/**
 * Contrat à remplir par la classe Ordi du tp3 inf11 A2021 (voir énoncé).
 * 
 * @author Pierre Bélisle
 * @version Copyright A2021
 */
public interface InterfaceOrdi {
	
	
	
	
	
	/**
	 * Accesseur de la stratégie de l'ordi.
	 * 
	 * @return La stratégie de l'ordi.
	 */
	public InterfaceStrategie getStrategie() ;

	/**
	 * Mutateur de la stratégie.
	 * 
	 * @param strategie La nouvelle strategie de l'ordi.
	 */
	public void setStrategie(InterfaceStrategie strategie);

}
