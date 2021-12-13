package pack;
import java.util.Vector;

/**
 * Classe qui existe principalement pour �viter
 * la r�p�tition de code dans les sous-classes concr�tes de strat�gie.
 *
 * Elle contient le code pour retenir les tirs jou�s et retourner
 * le dernier sur demande.
 *
 * @author Pierre B�lisle
 * @version Copyright A2021
 *
 */

// Vous devez �crire le code manquant pour que cete classe impl�mente
// InterfaceStrat�gie et permette de retenir les coups.

public abstract class StrategieOrdiAbstrait implements InterfaceStrategie  {


	// Retient les coups jou�s dans une collection.
	private Vector<Coord> tabTirsJoues =  new Vector<Coord> ();


   // Cinq m�thodes � �crire (voir �nonc�).


	//Fonction  qui s'occupe de retourner une coordonner qui n'est aps deja ajouter dans la collection TabtirJoues
	public  Coord obtenirTirPasDejaJoue()
	{
		Coord c = UtilitaireCollection.obtenirCoupPasDejaJouer(tabTirsJoues);
		return c;

	}

/*
 * Fonction qui ajoute un tir dans la collection tabTirsJoues
 *
 * */
	public void ajouterTir(Coord tir)
	{
		tabTirsJoues.add(tir);

	}


	/*
	 * Fonction qui retoune un boolean si la la collection contient la coordonner tir
	 *
	 * */
public boolean tirDejaJoue(Coord tir)
{

	return UtilitaireCollection.collectionContientCoord(tabTirsJoues, tir);


}

/*'
 * Fonction qui retoune le dernier tir dans la collection tabTirsJoues
 * */
public Coord getDernierTir()
{
	return  tabTirsJoues.lastElement();

}

/*'
 * Fonction qui vide la collection tabTirsJoues
 *
 * */
@Override
public void resetTirsJoues()
{
	tabTirsJoues.clear();
}



@Override
public Coord getTir() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void aviserTouche() {
	// TODO Auto-generated method stub

}


}
