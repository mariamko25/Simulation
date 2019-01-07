package Lois;

import java.util.Random;

import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;

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
	
	
	public  double getExponentielRandom(double lambda,float x) {
//		 Random rand = new Random();
//		 return -(1 / lambda) * Math.log( 1 - rand.nextDouble() );
		
		//lyy begin---
//		    return 1-Math.exp(-lambda*x);
		//methode 1 begin---
		ExponentialDistribution exponentialDistribution=new ExponentialDistribution(1/lambda);
		return exponentialDistribution.sample();
		//methode 1 end---
		//methode 2 begin---
//		double random=Math.random();
//		return -(1/lambda)*Math.log(random);
		//methode 2 end---
		//lyy end---
	}
	

	public double getLoibeta(float hs, float hf)
	{
		//lyy begin---
//		double alpha=2.5;
//		double beta= 6.4;
//		double res=0;
//		for(double x1=0; x1<hs/hf ; x1=x1+0.1)
//		{
//			res+=Math.pow(x1, alpha-1)*Math.pow((1-x1),beta-1);
//		}
//		return res;
		BetaDistribution betaDistribution=new BetaDistribution(2.5, 6.4);
		return betaDistribution.sample();
		//lyy end---
		
	}
	
	public  double getNormalRandom()
	{
		Random ran = new Random(); 
		  
        // generating integer 
        return  ran.nextGaussian(); 
	}

}
