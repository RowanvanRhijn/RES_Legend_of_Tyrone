package main.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture Idle1, Idle2;
	Texture PunchStraight, PunchHook, PunchUp;
	Texture KickStraight1, KickStraight2, KickJump1, KickJump2, KickLow1, KickLow2;
	int nFrame = 0, nIdle = 0, nJump = 0, nX = 250, nY = 50; //Hero's variables
	
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


		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && nX <= 540) {
			nX += 3;
			nFrame = 2;
		}
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && nX >= 0) {
			nX -= 3;
			nFrame = 3;
		}
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && nJump == 0) {
        	nJump = 49;
        	nFrame = 4;
		}
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && nJump == 0) {
			if (nFrame == 0 || nFrame == 2) nFrame = 5;
			if (nFrame == 1 || nFrame == 3) nFrame = 6;
		}


        if (nJump > 29) {
        	nY += 5;
		}
		else if (nJump <= 20 && nJump > 0) {
			nY -= 5;
		}
		hero (nIdle ,nX, nY);
		//Whole game's gonna run off this count, I may tweak numbers a bit but this is important I think
        //Maybe just tyrone idk
		if (nJump > 0) nJump--;
		if (nIdle == 50) nIdle = 0;
		nIdle++;
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		Idle1.dispose();
		Idle2.dispose();
	}

	public void hero (int nCount, int nX, int nY) {
        if (nCount <= 24) batch.draw(Idle1, nX, nY, 100, 250);
        if (nCount > 24) batch.draw(Idle2, nX, nY, 100, 250);
	}
}
