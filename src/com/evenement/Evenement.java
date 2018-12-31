package com.evenement;

import java.util.Random;

import com.model.TypeEvtTraite;

import Lois.Loi;

public  class Evenement implements Comparable{
	Loi loi= new Loi();
	/**
	 * @return the precHs
	 */
	public float getPrecHs() {
		return precHs;
	}
	/**
	 * @param precHs the precHs to set
	 */
	public void setPrecHs(float precHs) {
		this.precHs = precHs;
	}
	
	
	
	/**
	 * @return the interArrivee
	 * on applique la loi à chaque appel
	 */
	public float getInterArrivee() {
		//return interArrivee;
		if(LoiInterArrivee=="Loi exponentielle")
		{

			return (float) loi.getExponentielRandom(interArrivee);
		}
		else if(LoiInterArrivee=="Loi de poisson")
		{
			return (float) loi.getPoissonRandom(interArrivee);

		}
		else if(LoiInterArrivee=="Loi normale")
		{
			return (float) loi.getNormalRandom();
			
		}
		else if(LoiInterArrivee=="Loi uniforme")
		{
			return interArrivee;
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null,"aucune loi n'a été sélectionnée!"); 
			return (Float) null;
		}
		
	}
	/**
	 * @param interArrivee the interArrivee to set
	 */
	public void setInterArrivee(float interArrivee) {
		this.interArrivee = interArrivee;
	}
	public String getLoiInterArrivee() {
		return LoiInterArrivee;
	}
	public void setLoiInterArrivee(String loiInterArrivee) {
		LoiInterArrivee = loiInterArrivee;
	}
	
	public String getLoiDureeService() {
		return LoiDureeService;
	}
	public void setLoiDureeService(String loiDureeService) {
		LoiDureeService = loiDureeService;
	}
	public  float tempMoyenAttente;
	
	public Evenement()
	{
		
	}
	public void executer(float sh)
	{
		
	}
	/**
	 * @return the dureeService
	 * là aussi on utilise les lois
	 */
	public float getDureeService() {
		//return dureeService;
		if(LoiDureeService=="Loi exponentielle")
		{
			return (float) loi.getExponentielRandom(dureeService);
		}
		else if(LoiDureeService=="Loi de poisson")
		{
			return loi.getPoissonRandom(dureeService);
		}
		else if(LoiDureeService=="Loi normale")
		{
			return (float) loi.getNormalRandom();
			
		}
		else if(LoiDureeService=="Loi uniforme")
		{
			return dureeService;
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null,"aucune loi n'a été sélectionnée!"); 
			return (Float) null;
		}
	}
	/**
	 * @param dureeService the dureeService to set
	 */
	public void setDureeService(float dureeService) {
		this.dureeService = dureeService;
	}
	/**
	 * @return the tempMoyenAttente
	 */
	public float getTempMoyenAttente() {
		return tempMoyenAttente;
	}
	/**
	 * @param tempMoyenAttente the tempMoyenAttente to set
	 */
	public void setTempMoyenAttente(float tempMoyenAttente) {
		this.tempMoyenAttente = tempMoyenAttente;
	}
	public  float hs;
	public  float precHs;
	public  float heureDebut;
	public  TypeEvtTraite typeEvt;
	public  int b;
	public  int q;
	public  float aire_B;
	public  float aire_Q;
	public  int totalClientNumber;
	public  float attenteGlobale;
	public  float interArrivee;
	public  String LoiInterArrivee;
	public  float dureeService;
	public String LoiDureeService;

	
	
	/**
	 * @return the attenteGlobale
	 */
	public  float getAttenteGlobale() {
		return attenteGlobale;
	}


	/**
	 * @param attenteGlobale the attenteGlobale to set
	 */
	public  void setAttenteGlobale(float attenteGlobale) {
		this.attenteGlobale = attenteGlobale;
	}


	/**
	 * @return the totalClientNumber
	 */
	public  int getTotalClientNumber() {
		return totalClientNumber;
	}


	/**
	 * @param totalClientNumber the totalClientNumber to set
	 */
	public  void setTotalClientNumber(int totalClientNumber) {
		this.totalClientNumber = totalClientNumber;
	}


	/**
	 * @return the hs
	 */
	public  float getHs() {
		return hs;
	}
	/**
	 * @param hs the hs to set
	 */
	public  void setHs(float hs) {
		this.hs = hs;
	}
	/**
	 * @return the heureDebut
	 */
	public  float getHeureDebut() {
		return heureDebut;
	}
	/**
	 * @param heureDebut the heureDebut to set
	 */
	public  void setHeureDebut(float heureDebut) {
		this.heureDebut = heureDebut;
	}
	/**
	 * @return the typeEvt
	 */
	public  TypeEvtTraite getTypeEvt() {
		return typeEvt;
	}
	/**
	 * @param typeEvt the typeEvt to set
	 */
	public  void setTypeEvt(TypeEvtTraite typeEvt) {
		this.typeEvt = typeEvt;
	}
	/**
	 * @return the b
	 */
	public  int getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public  void setB(int b) {
		this.b = b;
	}
	/**
	 * @return the q
	 */
	public  int getQ() {
		return q;
	}
	/**
	 * @param q the q to set
	 */
	public  void setQ(int q) {
		this.q = q;
	}
	/**
	 * @return the aire_B
	 */
	public  float getAire_B() {
		return aire_B;
	}
	/**
	 * @param aire_B the aire_B to set
	 */
	public  void setAire_B(float aire_B) {
		this.aire_B = aire_B;
	}
	/**
	 * @return the aire_Q
	 */
	public  float getAire_Q() {
		return aire_Q;
	}
	/**
	 * @param aire_Q the aire_Q to set
	 */
	public  void setAire_Q(float aire_Q) {
		this.aire_Q = aire_Q;
	}
	
	
	
	
	@Override
	public int compareTo(Object o) {
		float compareHd=((Evenement)o).getHeureDebut();
        /* For Ascending order*/
        return Float.compare(heureDebut,compareHd);
	}
	
	

	
	

}
