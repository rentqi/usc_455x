
//Name: Tianqi Ren
//USC NetID: 4080641619
//CS 455 PA1
//Fall 2017

import javax.swing.JFrame;
import java.util.Scanner;

public class CoinSimViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.setSize(800, 500);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("Enter number of trials: ");
		Scanner in = new Scanner(System.in);
		int numTrials = in.nextInt();
		while(numTrials<=0) {
			System.out.println("ERROR: Number entered must be greater than 0");
			numTrials = in.nextInt();
		}
		
		CoinSimComponent component = new CoinSimComponent(numTrials);
		frame.add(component);
		
		frame.setVisible(true);
		
		
	}
}
