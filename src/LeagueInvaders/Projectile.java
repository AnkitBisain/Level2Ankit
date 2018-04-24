package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	int speed;

	public Projectile(int x, int y, int width, int height) {

		super(x, y, width, height);
		speed = 5;
	}
	void update() {
		 super.update();
		this.y += -speed;
		if( this.y <0) {
			this.isAlive = false;
		}
	}

	void draw(Graphics g) {
		 g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}

}
