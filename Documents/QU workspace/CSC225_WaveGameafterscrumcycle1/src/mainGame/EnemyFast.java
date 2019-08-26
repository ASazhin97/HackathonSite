package mainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * A type of enemy in the game
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class EnemyFast extends GameObject {

	private Handler handler;

	public EnemyFast(double x, double y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velX = 2;
		velY = 9;
	}

	public void tick() {
		this.x += velX;
		this.y += velY;

		if (this.y <= Game.scaleY(90) || this.y >= (Game.scaleY(1080) - 60)){	
			velY *= -1;
		}
		if (this.x <= 0 || this.x >= (Game.scaleX(1920) - 40)){
			velX *= -1;
		}

		handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 16, 16, 0.025, this.handler));

	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int) x, (int) y, (int) Game.scaleX(16), (int) Game.scaleY(16));

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) this.x, (int) this.y, (int) Game.scaleX(16), (int) Game.scaleY(16));
	}

}
