
//Name: Tianqi Ren
//USC NetID: 4080641619
//CS 455 PA1
//Fall 2017

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class CoinSimComponent extends JComponent{
	
	private static final int BAR_WIDTH = 50;
	private static final int BUFFER = 50;
	
	private int numTrials;
	private CoinTossSimulator sm;
	private double maxHeightBar;  		//the highest bar(100%)
	private double betweenBar;    		//gap between bars
	
	
	/**
    construct a CoinSimComponent
    run the CoinTossSimulator in order to get the number of two heads, head-and-tails, and two tails.
    @param numTrials		the total Trials for Coin Tossing
	*/
	public CoinSimComponent(int numTrials) {
		this.numTrials = numTrials;
		sm = new CoinTossSimulator();
		sm.run(numTrials);
	}
	
	/**
    override paintComponent. 
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		int twoHeads = sm.getTwoHeads();
		int headTails = sm.getHeadTails();
		int twoTails = sm.getTwoTails();
		
		maxHeightBar = getHeight() - 2 * BUFFER;      	    //2 buffers
		betweenBar = (getWidth() - 3 * BAR_WIDTH) / 4.0;//4 gaps in frame
		
		//all bars have same bottom value and scale
		int bottom = (int)(BUFFER + maxHeightBar);
		double scale = maxHeightBar / numTrials;
		
		//parameters
		int twoHeadsLeft = (int)betweenBar;
		int headTailsLeft = (int)(2*betweenBar + BAR_WIDTH);
		int twoTailsLeft = (int)(3*betweenBar + 2*BAR_WIDTH);
		String twoHeadsLabel = ("Two Heads: "+twoHeads+"("+Math.round((double) twoHeads/numTrials*100)+"%)");
		String headTailsLabel = ("A Head and a Tail: "+headTails+"("+Math.round((double) headTails/numTrials*100)+"%)");
		String twoTailsLabel = ("Two Tails: "+twoTails+"("+Math.round((double) twoTails/numTrials*100)+"%)");
		
		//construct bars
		Bar bar1 = new Bar(bottom, twoHeadsLeft, BAR_WIDTH, twoHeads, scale, Color.RED, twoHeadsLabel);
		Bar bar2 = new Bar(bottom, headTailsLeft, BAR_WIDTH, headTails, scale, Color.GREEN, headTailsLabel);
		Bar bar3 = new Bar(bottom, twoTailsLeft, BAR_WIDTH, twoTails, scale, Color.BLUE, twoTailsLabel);
		
		//draw
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);
		

	}
}
