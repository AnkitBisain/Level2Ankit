package LeagueInvaders;

import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame;
	final int width = 500;
	final int height = 800;

	public LeagueInvaders() {
		frame = new JFrame();
		setup();
	}
	
	void setup() {
		frame.pack();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
	}

}
