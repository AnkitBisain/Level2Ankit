package LeagueInvaders;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	GamePanel panel;
	final static int width = 500;
	final static int height = 800;

	public LeagueInvaders() {
		panel = new GamePanel();
		frame = new JFrame();
		setup();
	}

	void setup() {
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.pack();
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}

	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
	}

}
