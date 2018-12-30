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

	public void simulate() throws IOException
	{
		float hs;
		hs=0;
		CSVWritter.startCsvWriting(filename);
		event.setHs(0);
		event.setAire_B(0);
		event.setAire_Q(0);
		
		Debut deb=new Debut(TypeEvtTraite.Deb,event,clients);
		Echeancier.add(deb);
		while(!Echeancier.evt.isEmpty() && hs<duree)
		{
			
			
			CSVWritter.writeLine(Float.toString(Echeancier.evt.get(0).getHs()), Echeancier.evt.get(0).getTypeEvt().name(),Echeancier.evt.get(0).getTypeEvt().name()+" "+Float.toString(Echeancier.evt.get(0).getHs()), Integer.toString(Echeancier.evt.get(0).getB()), Integer.toString(Echeancier.evt.get(0).getQ()),"", Integer.toString(Echeancier.evt.get(0).getTotalClientNumber()), Float.toString(Echeancier.evt.get(0).getAttenteGlobale()));
			event.setAire_B(event.getAire_B() + (event.getHs()-event.getPrecHs())*event.getB());
			event.setAire_Q(event.getAire_Q() + (event.getHs()-event.getPrecHs())*event.getQ());

			event.setPrecHs(event.getHs());
			event.setHs(Echeancier.evt.get(0).getHs());
			hs=Echeancier.evt.get(0).getHs();
			Echeancier.evt.get(0).executer();
			Echeancier.remove();
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
