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
	
	public ObjectManager(RocketShip ship) {
		this.ship = ship;
		enemyTimer = 0;
		enemySpawnTime = 2000;
	}
	void update(){
		ship.update();
		for(Alien p : aliens){
			p.update();
		}
		for(Projectile p : projectiles){
			p.update();
		}
	}
	void draw(Graphics g) {
		ship.draw(g);
		for(Alien p : aliens){
			p.draw(g);
		}
		for(Projectile p : projectiles){
			p.draw(g);
		}
		
	}
	static void addAlien(Alien p) {
		aliens.add(p);
	}
	static void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	public void manageEnemies() {
		
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}
	
	void purgeObjects() {
		for(Alien p : aliens){
			if(p.isAlive = false) {
				projectiles.remove(p);
			}
		}
		for(Projectile p : projectiles){
			if(p.isAlive = false) {
				projectiles.remove(p);
			}
		}
	}
}
