package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update(){
		y++;
		if( this.y >800) {
			this.isAlive = false;
		}

	}
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
}