package finalgame;

import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class GameLauncher extends BasicGame {

    ArrayList<Rectangle> molelist;
    Image mole;
    Rectangle hitbox;
    int rx, ry;

    public GameLauncher(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        molelist = new ArrayList();
        mole = new Image("images/mole.png");
        rx = (int) (Math.random() * 750);
        ry = (int) (Math.random() * 550);        
        hitbox = new Rectangle(rx, ry, mole.getWidth(), mole.getHeight());
        molelist.add(new Rectangle(rx, ry, mole.getWidth(), mole.getHeight()));
    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = in.getMouseX(), my = in.getMouseY();
        while (true){
            if (hitbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                rx = (int) (Math.random() * 750);
                ry = (int) (Math.random() * 550);                
                hitbox.setLocation(rx, rx);
                break;
            }
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        mole.draw(hitbox.getX(), hitbox.getY());
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
