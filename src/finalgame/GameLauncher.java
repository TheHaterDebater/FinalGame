
import java.awt.Rectangle;
import org.newdawn.slick.*;

public class GameLauncher extends BasicGame {

    Image mole;
    Rectangle hitbox;
    int rx, ry;

    public GameLauncher(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        mole = new Image("images/mole.png");
        rx = (int) (Math.random() * 800);
        ry = (int) (Math.random() * 600 - 256);
        hitbox = new Rectangle(rx, ry, mole.getWidth(), mole.getHeight());
    }

    public void update(GameContainer gc, int i) throws SlickException {
        Input in = gc.getInput();
        int mx = in.getMouseX(), my = in.getMouseY();
        if (hitbox.contains(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            rx = (int) (Math.random() * 750);
            ry = (int) (Math.random() * 550);
            hitbox.setLocation(rx, ry);
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        mole.draw(rx, ry);
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
