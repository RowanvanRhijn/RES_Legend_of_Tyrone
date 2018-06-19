package main.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.game.GamMenu;

public class ScrIdle implements Screen {
	GamMenu gamMenu;
	SpriteBatch batch;
	Texture Idle1, Idle2;
	int nCount = 0;

	public ScrIdle(GamMenu _GamMenu) {  //Referencing the main class.
		gamMenu = _GamMenu;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		Idle1 = new Texture ("OldIdle1.png");
		Idle2 = new Texture ("OldIdle2.png");
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) gamMenu.updateState(0);
		hero (nCount);
		if (nCount == 50) nCount = 0;
		nCount++;
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

	public void hero (int nCount) {
		if (nCount <= 24) batch.draw(Idle1, 250, 50, 100, 250);
		if (nCount > 24) batch.draw(Idle2, 250, 50, 100, 250);
	}
}
