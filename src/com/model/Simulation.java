package com.model;

import com.evenement.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Simulation {
	
	private String filename;
	private float duree;
	private Evenement event;
	private List<Client> clients;
	
	public Simulation(Evenement evenement,String string,float f) {
		this.filename=string;
		this.duree=f;
		event=evenement;
		clients=new ArrayList<Client>();
	}

	//on commence � t=1 et pas 0
	public void simulate() throws IOException
	{
		int count=0;
		CSVWritter.startCsvWriting(filename);
		event.setHs(1);
		event.setAire_B(0);
		event.setAire_Q(0);
		
		Debut deb=new Debut(TypeEvtTraite.Deb,event,clients);
		deb.setHs((float)1);
		deb.setHeureDebut((float)1);
		Echeancier.add(deb);
		while(!Echeancier.evt.isEmpty() && count<duree)
		{
			
			Echeancier.sort();
			event.setAire_B(event.getAire_B() + (event.getHs()-event.getPrecHs())*event.getB());
			event.setAire_Q(event.getAire_Q() + (event.getHs()-event.getPrecHs())*event.getQ());
			System.out.println(Echeancier.evt.get(0).getTypeEvt().name());
			event.setPrecHs(event.getHs());
			double n= Echeancier.evt.get(0).getHeureDebut();
			event.setHs(Echeancier.evt.get(0).getHeureDebut());
			String evtCree=Echeancier.evt.get(0).executer(event.getHs());
			//Echeancier.evt.get(0).getTypeEvt().name()+" "+Float.toString(Echeancier.evt.get(0).getHeureDebut())
			CSVWritter.writeLine(Float.toString(Echeancier.evt.get(0).getHs()), Echeancier.evt.get(0).getTypeEvt().name(),evtCree, Integer.toString(Echeancier.evt.get(0).getB()), Integer.toString(Echeancier.evt.get(0).getQ()),"", Integer.toString(Echeancier.evt.get(0).getTotalClientNumber()), Float.toString(Echeancier.evt.get(0).getAttenteGlobale()));
			Echeancier.remove();
			count++;

		}
		CSVWritter.stopCsvWriting();
		Desktop d=Desktop.getDesktop();
		File file= new File(filename);
		if(file.exists())
		{
			d.open(file);
		}
	}	

	
}
