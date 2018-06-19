package main.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.game.GamMenu;

public class ScrImage implements Screen {
	GamMenu gamMenu;
	SpriteBatch batch;
	Texture txIdle1;

	public ScrImage(GamMenu _GamMenu) {  //Referencing the main class.
		gamMenu = _GamMenu;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		txIdle1 = new Texture ("Idle1.png");
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) gamMenu.updateState(0);
		batch.draw(txIdle1, 100, 100, 100, 250, 0, 0, 2048, 4096, false, false);
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
