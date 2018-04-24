package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip ship;
	static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	static ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer;
	int enemySpawnTime;
	int score;

	public ObjectManager(RocketShip ship) {
		this.ship = ship;
		enemyTimer = 0;
		enemySpawnTime = 2000;
		score = 0;
	}

	void update() {
		ship.update();
		for (Alien p : aliens) {
			p.update();
		}
		for (Projectile p : projectiles) {
			p.update();
		}
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (Alien p : aliens) {
			p.draw(g);
		}
		for (Projectile p : projectiles) {
			p.draw(g);
		}

	}

	static void addAlien(Alien p) {
		aliens.add(p);
	}

	static void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public int getScore() {
		return score;
	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(i);
				score++;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
	}

	void reset() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.remove(i);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.remove(i);
		}
		score = 0;
		ship.isAlive = true;
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (ship.collisionBox.intersects(aliens.get(i).collisionBox)) {
				ship.isAlive = false;
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {
				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(j).isAlive = false;
					aliens.get(i).isAlive = false;
				}
			}
		}
	}
}
