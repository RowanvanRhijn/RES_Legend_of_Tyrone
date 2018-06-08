package main.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture Idle1, Idle2, Walk1, Walk2, Crouch, Jump, Dead, Active;
	Texture PunchStraight1, PunchStraight2, PunchDown, PunchUp;
	Texture BlockUp, BlockStraight, BlockDown;
	Texture KickStraight1, KickStraight2, KickJump, KickLow1, KickLow2;
	int nFrame = 0, nIdle = 0, nX = 250, nY = 50, nHealth = 3; //Hero's variables
	boolean isRight = true;
	int nPunchStraight = 0, nPunchUp = 0, nPunchDown = 0, nKickStraight = 0, nKickDown = 0, nJump = 0,
			nBlockStraight = 0, nBlockUp = 0, nBlockDown = 0; //Counts for moves
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Active = new Texture ("Idle1.png");
		Idle1 = new Texture ("Idle1.png");
		Idle2 = new Texture ("Idle2.png");
		Walk1 = new Texture ("Walk1.png");
		Walk2 = new Texture ("Walk2.png");
		Crouch = new Texture ("Crouch.png");
		Jump = new Texture ("Crouch.png");
		Dead = new Texture ("Dead.png");
		PunchStraight1 = new Texture ("PunchStraight1.png");
		PunchStraight2 = new Texture ("PunchStraight2.png");
		PunchDown = new Texture ("PunchDown.png");
		PunchUp = new Texture ("PunchUp.png");
		BlockStraight = new Texture ("BlockStraight.png");
		BlockDown = new Texture ("BlockDown.png");
		BlockUp = new Texture ("BlockUp.png");
		KickStraight1 = new Texture ("KickStraight1.png");
		KickStraight2 = new Texture ("KickStraight2.png");
		KickJump = new Texture ("KickJump.png");
		KickLow1 = new Texture ("KickLow1.png");
		KickLow2 = new Texture ("KickLow2.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		nFrame = 0;
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && nX <= 540) {
			nFrame = 1;
			isRight = true;
			nX += 3;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && nX >= 0) {
			nFrame = 1;
			isRight = false;
			nX -= 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && nJump == 0) {
			nFrame = 2;
		}

		if (nPunchStraight == 0 && nPunchUp == 0 && nPunchDown == 0 &&
				nBlockStraight == 0 && nBlockUp == 0 && nBlockDown == 0 &&
				nKickStraight == 0 && nKickDown == 0 && nJump == 0){

			if (Gdx.input.isKeyPressed(Input.Keys.UP)){
				nJump = 49;
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.Q)){
				if (nFrame == 0 || nFrame == 1){
					nPunchStraight = 49;
				}
				if (nFrame == 2){
					nPunchDown = 49;
				}
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.W)){
				if (nFrame == 0 || nFrame == 1){
					nBlockStraight = 49;
				}
				if (nFrame == 2){
					nBlockDown = 49;
				}
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.E)){
				if (nFrame == 0 || nFrame == 1){
					nKickStraight = 49;
				}
				if (nFrame == 2){
					nKickDown = 49;
				}
			}

		}
		if (nJump > 44){
			if (Gdx.input.isKeyPressed(Input.Keys.Q)){
				nPunchUp = 49;
				nJump = 0;
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.W)){
				nBlockUp = 49;
				nJump = 0;
			}
			if (nJump > 0 && Gdx.input.isKeyPressed(Input.Keys.E)){
				nFrame = 14;
			}
		}

		//Jumping structures
		if (nJump <= 44 && nJump > 5) {
			nFrame = 3;
		}
        if (nJump > 29 && nJump <= 44) {
        	nY += 5;
		}
		else if (nJump <= 20 && nJump > 5) {
			nY -= 5;
		}

		//PunchStraight structures
		if (nPunchStraight > 5 && nPunchStraight <= 44) {
			nFrame = 4;
		}

		//PunchDown structures
		if (nPunchDown > 5 && nPunchDown <= 44) {
			nFrame = 5;
		}

		//PunchUp structures
		if (nPunchUp > 5 && nPunchUp <= 44) {
			nFrame = 6;
		}

		//BlockStraight structures
		if (nBlockStraight > 5 && nBlockStraight <= 44) {
			nFrame = 7;
		}

		//BlockDown structures
		if (nBlockDown > 5 && nBlockDown <= 44) {
			nFrame = 8;
		}

		//BlockUp structures
		if (nBlockUp > 5 && nBlockUp <= 44) {
			nFrame = 9;
		}

		//KickStraight structures
		if (nKickStraight >= 33 && nKickStraight < 49) {
			nFrame = 10;
		}
		else if (nKickStraight < 33 && nKickStraight >= 17) {
			nFrame = 11;
		}
		else if (nKickStraight < 17 && nKickStraight >= 1) {
			nFrame = 10;
		}

		//KickDown structures
		if (nKickDown >= 33 && nKickDown < 49) {
			nFrame = 12;
		}
		else if (nKickDown < 33 && nKickDown >= 17) {
			nFrame = 13;
		}
		else if (nKickDown < 17 && nKickDown >= 1) {
			nFrame = 12;
		}

		//He can die now
		if (nHealth <= 0) nFrame = 15;

		hero (nIdle, nX, nY, nFrame, isRight);
		if (nJump > 0) nJump--;
		if (nPunchStraight > 0) nPunchStraight--;
		if (nPunchUp > 0) nPunchUp--;
		if (nPunchDown > 0) nPunchDown--;
		if (nBlockStraight > 0) nBlockStraight--;
		if (nBlockUp > 0) nBlockUp--;
		if (nBlockDown > 0) nBlockDown--;
		if (nKickStraight > 0) nKickStraight--;
		if (nKickDown > 0) nKickDown--;

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
	//Tomorrow work on flipping based on isRight
	public void hero (int nIdle, int nX, int nY, int nFrame, boolean isRight) {
		if (nFrame == 0){
			if (nIdle <= 24) Active = Idle1;
			if (nIdle > 24) Active = Idle2;
		}
		if (nFrame == 1){
			if (nIdle <= 24) Active = Walk1;
			if (nIdle > 24) Active = Walk2;
		}
		if (nFrame == 2){
			Active = Crouch;
		}
		if (nFrame == 3){
			Active = Jump;
		}
		if (nFrame == 4){
			if (nIdle <= 24) Active = PunchStraight1;
			if (nIdle > 24) Active = PunchStraight2;
		}
		if (nFrame == 5){
			Active = PunchDown;
		}
		if (nFrame == 6){
			Active = PunchUp;
		}
		if (nFrame == 7){
			Active = BlockStraight;
		}
		if (nFrame == 8){
			Active = BlockDown;
		}
		if (nFrame == 9){
			Active = BlockUp;
		}
		if (nFrame == 10){
			Active = KickStraight1;
		}
		if (nFrame == 11){
			Active = KickStraight2;
		}
		if (nFrame == 12){
			Active = KickLow1;
		}
		if (nFrame == 13){
			Active = KickLow2;
		}
		if (nFrame == 14){
			Active = KickJump;
		}
		if (nFrame == 15){
			Active = Dead;
		}
		isRight = !isRight;
		//The problem may be here
		batch.draw(Active, nX, nY, 100, 250, 50, 0, 1, 1, isRight, false);
	}
}
