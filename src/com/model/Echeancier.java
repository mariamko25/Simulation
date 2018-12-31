package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.evenement.*;
public class Echeancier {
	
	public static List<Evenement> evt=new ArrayList<Evenement>();
	
	public static void add(Evenement e)
	{
		evt.add(e);
	}
	
	public static Evenement  remove()
	{
		return evt.remove(0);
	}
	
	@SuppressWarnings("unchecked")
	public static void sort()
	{
		Collections.sort(evt);
	}
}
