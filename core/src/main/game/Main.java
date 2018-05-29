package main.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture Idle1, Idle2;
	int nCount = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Idle1 = new Texture ("Idle1.png");
		Idle2 = new Texture ("Idle2.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		hero (nCount);
		if (nCount == 50) nCount = 0;
		nCount++;
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		Idle1.dispose();
		Idle2.dispose();
	}

	public void hero (int nCount) {
        if (nCount <= 24) batch.draw(Idle1, 250, 50, 100, 250);
        if (nCount > 24) batch.draw(Idle2, 250, 50, 100, 250);
	}
}
