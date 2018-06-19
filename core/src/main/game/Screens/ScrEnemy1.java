package main.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.game.GamMenu;

public class ScrEnemy1 implements Screen {
	GamMenu gamMenu;
	SpriteBatch batch;
	Texture txEnemyIdle1, txEnemyIdle2, txActive;
	int nXr = 750, nXl = -750, nY2 = 0, nIdle1 = 0, nIdle2 = 0;
	int nRandnumr = (int) (Math.random() * 6), nRandnuml = (int) (Math.random() * 6);
	int nCycle = 0;
	boolean bAdvanceRight, bAdvanceLeft, isRight = true;
	//Sprite sprEnemyIdle1, sprEnemyIdle2, sprActive;


	public ScrEnemy1(GamMenu _GamMenu) {  //Referencing the main class.
		gamMenu = _GamMenu;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		txActive = new Texture ("Enemy1.png");
		//sprActive = new Sprite(txActive);
		txEnemyIdle1 = new Texture ("Enemy1.png");
		//sprEnemyIdle1 = new Sprite(txEnemyIdle1);
		txEnemyIdle2 = new Texture ("Enemy2.png");
		//sprEnemyIdle2 = new Sprite(txEnemyIdle2);
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) gamMenu.updateState(0);
		if (bAdvanceRight == false && nCycle > 500){
			if (nRandnumr <= 4){
				bAdvanceRight = true;
				//nCycle = 0;
			}
		}
		if (bAdvanceRight == true){
			nXr -= 3;
		}
		if (nXr <= 100){
			bAdvanceRight = false;
			nXr = 750;
		}
		//right done

		if (bAdvanceLeft == false && nCycle > 500){
			//if (nRandnumr >= 4){
			bAdvanceLeft = true;
			nCycle = 0;
			//}
		}
		if (bAdvanceLeft == true){
			nXl += 3;
			//sprActive = sprEnemyIdle1;
			//sprActive = sprEnemyIdle2;
		}
		if (nXl >= 500){
			bAdvanceLeft = false;
			nXl = -750;
		}

		//batch.draw(txEnemyIdle1, nXr, nY2, 100, 250);
		batch.draw(txEnemyIdle2, nXl, nY2, 100, 250, 0, 0, 2048, 4096, false, false);
		batch.draw(txEnemyIdle1, nXr, nY2, 100, 250, 0, 0, 2048, 4096, isRight, false);
		nCycle++;
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}
}
