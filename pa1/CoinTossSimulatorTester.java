
//Name: Tianqi Ren
//USC NetID: 4080641619
//CS 455 PA1
//Fall 2017

public class CoinTossSimulatorTester {
	public static void main(String[] args) {
	    //After construction
	    CoinTossSimulator sm = new CoinTossSimulator();
	    System.out.println("After constructor:");
	    System.out.println("Number of trials [exp:0]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    boolean flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
		
	    //After run(1)
	    sm.run(1);
	    System.out.println("After run(1)");
	    System.out.println("Number of trials [exp:1]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //After run(10)
	    sm.run(10);
	    System.out.println("After run(10)");
	    System.out.println("Number of trials [exp:11]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //After run(100)
	    sm.run(100);
	    System.out.println("After run(100)");
	    System.out.println("Number of trials [exp:111]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //After run(1000)
	    sm.run(1000);
	    System.out.println("After run(1000)");
	    System.out.println("Number of trials [exp:1111]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //After reset:
	    sm.reset();
	    System.out.println("After reset");
	    System.out.println("Number of trials [exp:0]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //After run(2000)
	    sm.run(2000);
	    System.out.println("After run(2000)");
	    System.out.println("Number of trials [exp:2000]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //After run(3000)
	    sm.run(3000);
	    System.out.println("After run(3000)");
	    System.out.println("Number of trials [exp:5000]:" + sm.getNumTrials());
	    System.out.println("Two-head tosses: " + sm.getTwoHeads());
	    System.out.println("Two-tail tosses: "+ sm.getTwoTails());
	    System.out.println("One-head one-tail tosses: "+ sm.getHeadTails());
	    flag = sm.getTwoHeads()+sm.getTwoTails()+sm.getHeadTails()==sm.getNumTrials();
	    System.out.println("Tosses add up correctly? " + flag);
	    System.out.println("");
	    
	    //ERROR: After run(-5)
	    System.out.println("After run(-5)");
	    System.out.println("exp: ERROR message");
	    sm.run(-5);
		
	}
}
