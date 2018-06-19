package main.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.game.GamMenu;

public class ScrMenu implements Screen {
	GamMenu gamMenu;
	SpriteBatch batch;
	Texture txMenuBack;

	public ScrMenu(GamMenu _GamMenu) {  //Referencing the main class.
		gamMenu = _GamMenu;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		txMenuBack = new Texture ("MenuBack.png");
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(txMenuBack, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_1) || Gdx.input.isKeyPressed(Input.Keys.NUMPAD_1)){
			gamMenu.updateState(1);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_2) || Gdx.input.isKeyPressed(Input.Keys.NUMPAD_2)){
            gamMenu.updateState(2);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_3) || Gdx.input.isKeyPressed(Input.Keys.NUMPAD_3)){
            gamMenu.updateState(3);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_4) || Gdx.input.isKeyPressed(Input.Keys.NUMPAD_4)){
            gamMenu.updateState(4);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.NUM_5) || Gdx.input.isKeyPressed(Input.Keys.NUMPAD_5)){
			gamMenu.updateState(5);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		txMenuBack.dispose();
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
