package main.game;

import com.badlogic.gdx.Game;
import main.game.Screens.*;

public class GamMenu extends Game {
    //ScrMenu scrMenu;
    ScrMovement scrMovement;
    ScrMenu scrMenu;
    ScrEnemy1 scrEnemy1;
    ScrEnemy2 scrEnemy2;
    ScrImage scrImage;
    ScrIdle scrIdle;
    int nScreen;

    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if ( nScreen == 0) {
            setScreen(scrMenu);
        } else if (nScreen == 1) {
            setScreen(scrMovement);
        } else if (nScreen == 2) {
            setScreen(scrEnemy1);
        } else if (nScreen == 3) {
            setScreen(scrEnemy2);
        } else if (nScreen == 4) {
            setScreen(scrImage);
        } else if (nScreen == 5) {
            setScreen(scrIdle);
        }
    }

    @Override
    public void create() {
        nScreen = 0;
        scrMovement = new ScrMovement(this);
        scrMenu = new ScrMenu(this);
        scrEnemy1 = new ScrEnemy1(this);
        scrEnemy2 = new ScrEnemy2(this);
        scrImage = new ScrImage(this);
        scrIdle = new ScrIdle (this);
        updateState(0);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
