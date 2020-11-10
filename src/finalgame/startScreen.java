
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class startScreen extends BasicGameState {

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input in = gc.getInput();

        if (in.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

        }

        if (in.isKeyDown(Input.KEY_SPACE)) {

        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.red);
        g.drawString("This is the main game", 100, 200);
    }

    public int getID() {
        return 0;  //this id will be different for each screen
    }

}
