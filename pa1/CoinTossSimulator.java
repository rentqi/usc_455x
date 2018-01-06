

// Name: Tianqi Ren
// USC NetID: 4080641619
// CS 455 PA1
// Fall 2017

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */




public class CoinTossSimulator {

   /**
      Creates a coin toss simulator with no trials done yet.
   */
	// instance variables
	private int twoHeads;
	private int twoTails;
	private int headTails;
	private int totalTrials;
	private Random rand;
	
	public CoinTossSimulator() {
		twoHeads = 0;
		twoTails = 0;
		headTails = 0;
		totalTrials = 0;
		rand = new Random();
	}


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
    public void run(int numTrials) {
	for(int i=0;i<numTrials;i++) {
	    int first = rand.nextInt(2);    	//0 for head, 1 for tail
	    int second = rand.nextInt(2);
	    if(first+second==0) {	     	//two heads
		twoHeads++;
	    }else if(first+second==1) {	      	//head and Tail
		headTails++;
	    }else {	     		     	//two tails
		twoTails++;
	    }
	}
	totalTrials += numTrials;
    }
    
    
   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return totalTrials; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTails;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTails;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   twoHeads = 0;
	   twoTails = 0;
	   headTails = 0;
	   totalTrials = 0;
   }
}
