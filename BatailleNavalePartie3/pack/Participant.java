package pack;

public class Participant extends Flotte implements InterfaceParticipant
{

	@Override
	public Flotte getFlotte()
	{
		return super.clone();
	}


	@Override
	public void genereNouvelleFlotte()
	{
		super.obtenirFlotteAleatoire();
	}


	@Override
	public boolean flotteARecuTirQuiATouche(Coord tir)
	{
		return super.dejaRecuCoup(tir);
	}


	@Override
	public boolean jeuEstTermine() {

		return super.jeuEstTermine();
	}

	@Override
	public String getDernierNavireCoule()
	{
		return super.getDernierNavireCoule();
	}


	@Override
	public boolean dernierTirACoule() {

		return super.dernierTirACoule();
	}


}
