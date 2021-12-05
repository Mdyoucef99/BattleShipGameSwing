package pack;

public class Participant extends Flotte implements InterfaceParticipant
{

   protected Flotte flotteparticipant;

	@Override
	public Flotte getFlotte()
	{
		return flotteparticipant;
	}


	@Override
	public void genereNouvelleFlotte()
	{
		flotteparticipant = obtenirFlotteAleatoire();
	}


	@Override
	public boolean flotteARecuTirQuiATouche(Coord tir)
	{
		return flotteparticipant.dejaRecuCoup(tir);
	}


	@Override
	public boolean jeuEstTermine() {

		return flotteparticipant.jeuEstTermine();
	}

	@Override
	public String getDernierNavireCoule()
	{
		return flotteparticipant.getDernierNavireCoule();
	}


	@Override
	public boolean dernierTirACoule() {

		return flotteparticipant.dernierTirACoule();
	}


}
