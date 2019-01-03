package com.evenement;

import com.model.*;

public class Fin extends Evenement{

	public Evenement evenement;
	
	public Fin(TypeEvtTraite evt,Evenement event)
	{
		typeEvt=evt;
		evenement=event;
	}
	public  String executer(float sh)
	{
		Echeancier.evt.clear();
		evenement.setHs(sh);
		evenement.setTempMoyenAttente(evenement.getAttenteGlobale()/evenement.getTotalClientNumber());
		this.setB(evenement.getB());
		this.setQ(evenement.getQ());
		this.setAttenteGlobale(evenement.getAttenteGlobale());
		this.setTotalClientNumber(evenement.getTotalClientNumber());
		this.setTempMoyenAttente(evenement.getTempMoyenAttente());
		this.setDureeService(evenement.getDureeService());
		this.setInterArrivee(evenement.getInterArrivee());
		return "";
	}
}
