package pack;
import java.util.Vector;

/**
 * Classe qui existe principalement pour éviter
 * la répétition de code dans les sous-classes concrètes de stratégie.
 *
 * Elle contient le code pour retenir les tirs joués et retourner
 * le dernier sur demande.
 *
 * @author Pierre Bélisle
 * @version Copyright A2021
 *
 */

// Vous devez écrire le code manquant pour que cete classe implémente
// InterfaceStratégie et permette de retenir les coups.

public abstract class StrategieOrdiAbstrait implements InterfaceStrategie  {

	// Retient les coups joués dans une collection.
	private Vector<Coord> tabTirsJoues =  new Vector<Coord> ();

   // Cinq méthodes à écrire (voir énoncé).

	public  Coord obtenirTirPasDejaJoue()
	{

		return null;

	}


	public void ajouterTir(Coord tir)
	{

	}



public boolean tirDejaJoue(Coord tir)
{
	return false;
}


public Coord getDernierTir()
{

	return null;

}


@Override
public void resetTirsJoues()
{


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
