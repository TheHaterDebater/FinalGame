package finalgame;

import java.awt.Rectangle;
import org.newdawn.slick.*;

public class GameLauncher extends BasicGame {

    Image mole, lose, win;
    Rectangle hitbox;
    int rx, ry, hits;
    double time;

    public GameLauncher(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        mole = new Image("images/molesm.png");
        lose = new Image("images/lose.jpg");
        win = new Image("images/win.jpg");
        rx = (int) (Math.random() * 750 + 100);
        ry = (int) (Math.random() * 550 + 100);
        hitbox = new Rectangle(rx, ry, mole.getWidth(), mole.getHeight());
    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = in.getMouseX(), my = in.getMouseY();
        if (hitbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            rx = (int) (Math.random() * 800 - mole.getWidth());
            ry = (int) (Math.random() * 600 - mole.getHeight());
            hits++;
            hitbox.setLocation(rx, ry);
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {

        if (time / 100 == 30 && hits >= 30) {
            win.draw(0, 0);
        } else if (time / 100 == 30 && hits < 30) {
            lose.draw(0, 0);
        } else {
            mole.draw((int) hitbox.getX(), (int) hitbox.getY());
            g.drawString("Hits: " + hits, 5, 5);
            time++;
            g.drawString("Time: " + (time / 100), 5, 20);
        }
    }

    public static void main(String args[]) throws SlickException {
        GameLauncher game = new GameLauncher("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
