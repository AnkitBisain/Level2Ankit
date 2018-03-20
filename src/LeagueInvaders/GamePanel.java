package LeagueInvaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject gameObject;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		gameObject = new GameObject(10,10,100,100);
	}

	void startGame() {
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		gameObject.draw(g);
	}

	public void actionPerformed(ActionEvent e) {
		gameObject.update();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
