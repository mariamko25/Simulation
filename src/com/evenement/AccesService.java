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
		if(evenement.getQ()>0)
		{
			evenement.setQ(evenement.getQ()-1);

		}
		evenement.setB(1);
		DepartClient depart= new DepartClient(TypeEvtTraite.DepCl,evenement,clients);
		depart.setHs(evenement.getHs());
		//lyy begin---
		float temp1=evenement.getHs();
		float temp2=evenement.getDureeService();
		float temp=evenement.getHs()+evenement.getDureeService();
		//lyy end---
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
		}
		return evcree;
	}
	
}
