package Lois;

import java.util.Random;

public class Loi {
	public Loi() {}
	
	public  int getPoissonRandom(double mean) {
	    Random r = new Random();
	    double L = Math.exp(-mean);
	    int k = 0;
	    double p = 1.0;
	    do {
	        p = p * r.nextDouble();
	        k++;
	    } while (p > L);
	    return k - 1;
	}
	
	
	public  double getExponentielRandom(double lambda) {
		 Random rand = new Random();
		    return -(1 / lambda) * Math.log( 1 - rand.nextDouble() );
	  
	}
	
	public  double getNormalRandom()
	{
		Random ran = new Random(); 
		  
        // generating integer 
        return  ran.nextGaussian(); 
	}

}
