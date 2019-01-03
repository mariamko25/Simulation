package com.evenement;

import java.util.List;

import com.model.Client;
import com.model.Echeancier;
import com.model.TypeEvtTraite;

public class AccesService extends Evenement {

	public Evenement evenement;
	private List<Client>clients;
	public AccesService(TypeEvtTraite evt,Evenement event,List<Client>clients)
	{
		
		typeEvt=evt;
		evenement=event;
		this.clients=clients;
	}
	public  String executer(float sh)
	{
		evenement.setHs(sh);
		evenement.setAttenteGlobale(evenement.getAttenteGlobale()+(evenement.getHs()-clients.get(0).getDateArrivee()));
		clients.get(0).setDateAccSrv(evenement.getHs());
		if(evenement.getQ()>0)
		{
			evenement.setQ(evenement.getQ()-1);

		}
		evenement.setB(1);
		DepartClient depart= new DepartClient(TypeEvtTraite.DepCl,evenement,clients);
		depart.setHs(evenement.getHs());
		depart.setHeureDebut(evenement.getHs()+evenement.getDureeService());
		depart.setB(0);
		depart.setQ(evenement.getQ());
		depart.setAttenteGlobale(evenement.getAttenteGlobale());
		depart.setTotalClientNumber(evenement.getTotalClientNumber());
		depart.setTempMoyenAttente(evenement.getTempMoyenAttente());
		depart.setDureeService(evenement.getDureeService());
		depart.setInterArrivee(evenement.getInterArrivee());
		if(evenement.getAttenteGlobale()<(evenement.getHs()-clients.get(0).getDateArrivee()))
		{
			evenement.setAttenteGlobale(evenement.getHs()-clients.get(0).getDateArrivee());
			depart.setAttenteGlobale(evenement.getAttenteGlobale());
		}
		Echeancier.add(depart);
		String evcree= depart.getTypeEvt().toString()+" "+depart.getHeureDebut();
		for(int i=0;i<Echeancier.evt.size();i++)
		{
			Echeancier.evt.get(i).setTotalClientNumber(evenement.getTotalClientNumber());
			Echeancier.evt.get(i).setHs(evenement.getHs());
			Echeancier.evt.get(i).setB(evenement.getB());
			Echeancier.evt.get(i).setQ(evenement.getQ());
			Echeancier.evt.get(i).setAttenteGlobale(evenement.getAttenteGlobale());
			Echeancier.evt.get(i).setTempMoyenAttente(evenement.getTempMoyenAttente());
		}
		return evcree;

	}

}
