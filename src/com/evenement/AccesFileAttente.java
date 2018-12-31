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
	public void executer(float sh)
	{
		this.evenement.setQ(this.evenement.getQ()+1);
		
		if(this.evenement.getB()==0)
		{
			evenement.setHs(sh);
			AccesService acc=new AccesService(TypeEvtTraite.AccSrv,evenement,clients);
			acc.setHs(evenement.getHs());
			acc.setHeureDebut(evenement.getHs());
			acc.setB(1);
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
