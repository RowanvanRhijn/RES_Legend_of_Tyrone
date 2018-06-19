package main.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.game.GamMenu;

public class ScrEnemy2 implements Screen {
	GamMenu gamMenu;
	SpriteBatch batch;
	Texture txEnemyRight1, txEnemyLeft1, txEnemyFly;
	int nFrame = 0, nIdle = 0, nJump = 0, nX = 250, nY = 50; //Hero's variables
	int nXr = 750, nXl = -750, nY2 = 0, nXf = -750, nYf = 150;
	int nRandnumr;
	int nCycle = 0;
	boolean bAdvanceRight, bAdvanceLeft, bAdvanceFly;


	public ScrEnemy2(GamMenu _GamMenu) {  //Referencing the main class.
		gamMenu = _GamMenu;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		txEnemyRight1 = new Texture ("Enemy1.png");
		txEnemyLeft1 = new Texture ("Enemy2.png");
		txEnemyFly = new Texture ("EnemyFly.png");
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) gamMenu.updateState(0);
		nRandnumr = (int) (Math.random() * 150);
		if (bAdvanceRight == false && nCycle > 250){
			if (nRandnumr <= 50){
				bAdvanceRight = true;
				nCycle = 0;
			}
		}
		if (bAdvanceRight == true){
			nXr -=3;
		}
		if (nXr <= 100){
			bAdvanceRight = false;
			nXr = 750;
		}
		//right done

		if (bAdvanceLeft == false && nCycle > 250){
			if (nRandnumr > 50 && nRandnumr <= 100){
				bAdvanceLeft = true;
				nCycle = 0;
			}
		}
		if (bAdvanceLeft == true){
			nXl += 3;
		}
		if (nXl >= 500){
			bAdvanceLeft = false;
			nXl = -750;
		}
		//left done

		if (bAdvanceFly == false && nCycle > 250){
			if (nRandnumr > 100 && nRandnumr <= 150){
				bAdvanceFly = true;
				nCycle = 0;
			}
		}
		if (bAdvanceFly == true){
			nXf += 3;
		}
		if (nXf >= 500){
			bAdvanceFly = false;
			nXf = -750;
		}

		batch.draw(txEnemyRight1, nXr, nY2, 100, 250);
		batch.draw(txEnemyLeft1, nXl, nY2, 100, 250);
		batch.draw(txEnemyFly, nXf, nYf, 100, 250);
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
