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
