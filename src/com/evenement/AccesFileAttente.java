package com.evenement;

import java.util.List;

import com.model.*;

public class AccesFileAttente extends Evenement {
	
	
	
	public Evenement evenement;
	private List<Client>clients;
	
	public AccesFileAttente(TypeEvtTraite evt,Evenement event, List<Client>clients)
	{
		this.typeEvt=evt;
		this.evenement=event;
		this.clients=clients;
	}
	public void executer()
	{
		this.evenement.setQ(this.evenement.getQ()+1);
		
		if(this.evenement.getB()==0)
		{
			AccesService acc=new AccesService(TypeEvtTraite.AccSrv,evenement,clients);
			acc.setHs(evenement.getHs());
			acc.setB(evenement.getB());
			acc.setQ(evenement.getQ());
			acc.setAttenteGlobale(evenement.getAttenteGlobale());
			acc.setTotalClientNumber(evenement.getTotalClientNumber());
			acc.setTempMoyenAttente(evenement.getTempMoyenAttente());
			acc.setDureeService(evenement.getDureeService());
			acc.setInterArrivee(evenement.getInterArrivee());
			Echeancier.add(acc);
		}
		
	}

}
