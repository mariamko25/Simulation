package com.evenement;

import java.util.List;

import com.model.Client;
import com.model.Echeancier;
import com.model.TypeEvtTraite;

public class DepartClient extends Evenement {
	
	private Evenement evenement;
	private List<Client> clients;
	
	
	public DepartClient(TypeEvtTraite evt,Evenement event,List<Client>clients)
	{
		typeEvt=evt;
		evenement=event;
		this.clients=clients;
	}
	public  String executer(float sh)
	{
		if(!clients.isEmpty())
		{
			evenement.setHs(sh);
			clients.get(0).setDateDepart(evenement.getHs());
			clients.get(0).setTempService(clients.get(0).getDateDepart()-clients.get(0).getDateAccSrv());
			evenement.setB(0);
			if(evenement.getQ()>=1)
			{
				AccesService acc=new AccesService(TypeEvtTraite.AccSrv,evenement,clients);
				acc.setHs(evenement.getHs());
				acc.setHeureDebut(evenement.getHs());
				acc.setB(evenement.getB());
				acc.setQ(evenement.getQ());
				acc.setAttenteGlobale(evenement.getAttenteGlobale());
				acc.setTotalClientNumber(evenement.getTotalClientNumber());
				acc.setTempMoyenAttente(evenement.getTempMoyenAttente());
				acc.setDureeService(evenement.getDureeService());
				acc.setInterArrivee(evenement.getInterArrivee());
				Echeancier.add(acc);
				String evcree= acc.getTypeEvt().toString()+" "+acc.getHeureDebut();
				return evcree;
			}
			clients.remove(0);
		}
		return "";
		
	}

}
