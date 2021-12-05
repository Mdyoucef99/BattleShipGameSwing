package pack;

public class Ordi extends Participant implements InterfaceOrdi {

	InterfaceStrategie strategieordi = null;

	public Ordi()
	{
		flotteparticipant = obtenirFlotteAleatoire();
		strategieordi = new OrdiStrategieDebutant();
	}

	@Override
	public InterfaceStrategie getStrategie()
	{
		return strategieordi;
	}

	@Override
	public void setStrategie(InterfaceStrategie strategie) {

		strategieordi = strategie;
	}


}
