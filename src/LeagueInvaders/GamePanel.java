package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font stringFont;
	RocketShip rocket;
	ObjectManager obj;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		stringFont = new Font("Arial", Font.PLAIN, 24);
		rocket = new RocketShip(225, 700, 50, 50);
		obj = new ObjectManager(rocket);
	}

	void startGame() {
		timer.start();

	}

	void updateMenuState() {
	}

	void updateGameState() {
		obj.update();
		obj.manageEnemies();
		obj.checkCollision();
		obj.purgeObjects();

	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.drawString("League Invaders", 80, 200);
		g.setFont(stringFont);
		g.drawString("Press ENTER to start", 130, 500);
		g.drawString("Press SPACE for instructions", 90, 650);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		obj.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 130, 200);
		g.setFont(stringFont);
		g.drawString("You killed (#) enemies", 130, 500);
		g.drawString("Press ENTER to restart", 120, 650);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState >= END_STATE) {

				currentState = MENU_STATE;

			} else {
				currentState++;
			}
			System.out.println(currentState);

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (currentState == GAME_STATE) {
				rocket.y += -rocket.speed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (currentState == GAME_STATE) {
				rocket.y += rocket.speed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (currentState == GAME_STATE) {
				rocket.x += -rocket.speed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (currentState == GAME_STATE) {
				rocket.x += rocket.speed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			ObjectManager.addProjectile(new Projectile(rocket.x + 20, rocket.y + 20, 10, 10));
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
