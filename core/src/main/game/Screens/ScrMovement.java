package main.game.Screens;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.game.GamMenu;

public class ScrMovement implements Screen {
	GamMenu gamMenu;
	SpriteBatch batch;
	Texture txIdle1, txIdle2, txWalk1, txWalk2, txCrouch, txJump, txDead, txActive;
	Texture txPunchStraight1, txPunchStraight2, txPunchDown, txPunchUp;
	Texture txBlockUp, txBlockStraight, txBlockDown;
	Texture txKickStraight1, txKickStraight2, txKickJump, txKickLow1, txKickLow2;
	Texture txBackground;
	int nFrame = 0, nIdle = 0, nX = 250, nY = 50, nHealth = 3; //Hero's variables
	boolean isRight = true;
	int nPunchStraight = 0, nPunchUp = 0, nPunchDown = 0, nKickStraight = 0, nKickDown = 0, nJump = 0,
			nBlockStraight = 0, nBlockUp = 0, nBlockDown = 0; //Counts for moves

	public ScrMovement(GamMenu _GamMenu) {  //Referencing the main class.
		gamMenu = _GamMenu;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		txActive = new Texture ("Idle1.png");
		txIdle1 = new Texture ("Idle1.png");
		txIdle2 = new Texture ("Idle2.png");
		txWalk1 = new Texture ("Walk1.png");
		txWalk2 = new Texture ("Walk2.png");
		txCrouch = new Texture ("Crouch.png");
		txJump = new Texture ("Crouch.png");
		txDead = new Texture ("Dead.png");
		txPunchStraight1 = new Texture ("PunchStraight1.png");
		txPunchStraight2 = new Texture ("PunchStraight2.png");
		txPunchDown = new Texture ("PunchDown.png");
		txPunchUp = new Texture ("PunchUp.png");
		txBlockStraight = new Texture ("BlockStraight.png");
		txBlockDown = new Texture ("BlockDown.png");
		txBlockUp = new Texture ("BlockUp.png");
		txKickStraight1 = new Texture ("KickStraight1.png");
		txKickStraight2 = new Texture ("KickStraight2.png");
		txKickJump = new Texture ("KickJump.png");
		txKickLow1 = new Texture ("KickLow1.png");
		txKickLow2 = new Texture ("KickLow2.png");
		txBackground = new Texture ("Background.jpg");
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) gamMenu.updateState(0);
		batch.draw(txBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
		//Jumping structures
		if (nJump <= 40 && nJump > 9) {
			nFrame = 3;
		}
        if (nJump > 29 && nJump <= 44) {
        	nY += 5;
		}
		else if (nJump <= 20 && nJump > 5) {
			nY -= 5;
		}
		if (nJump > 44) {
			if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
				nPunchUp = 49;
				nJump = 0;
			} else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
				nBlockUp = 49;
				nJump = 0;
			}
		}
		else if (nJump > 0 && Gdx.input.isKeyPressed(Input.Keys.E)){
			nFrame = 14;
		}


		//PunchStraight structures
		if (nPunchStraight > 5 && nPunchStraight <= 44) {
			nFrame = 4;
		}

		//txPunchDown structures
		if (nPunchDown > 5 && nPunchDown <= 44) {
			nFrame = 5;
		}

		//txPunchUp structures
		if (nPunchUp > 5 && nPunchUp <= 44) {
			nFrame = 6;
		}

		//txBlockStraight structures
		if (nBlockStraight > 5 && nBlockStraight <= 44) {
			nFrame = 7;
		}

		//txBlockDown structures
		if (nBlockDown > 5 && nBlockDown <= 44) {
			nFrame = 8;
		}

		//txBlockUp structures
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
		txIdle1.dispose();
		txIdle2.dispose();
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

	public void hero (int nIdle, int nX, int nY, int nFrame, boolean isRight) {
		if (nFrame == 0){
			if (nIdle <= 24) txActive = txIdle1;
			if (nIdle > 24) txActive = txIdle2;
		}
		if (nFrame == 1){
			if (nIdle <= 24) txActive = txWalk1;
			if (nIdle > 24) txActive = txWalk2;
		}
		if (nFrame == 2){
			txActive = txCrouch;
		}
		if (nFrame == 3){
			txActive = txJump;
		}
		if (nFrame == 4){
			if (nIdle <= 24) txActive = txPunchStraight1;
			if (nIdle > 24) txActive = txPunchStraight2;
		}
		if (nFrame == 5){
			txActive = txPunchDown;
		}
		if (nFrame == 6){
			txActive = txPunchUp;
		}
		if (nFrame == 7){
			txActive = txBlockStraight;
		}
		if (nFrame == 8){
			txActive = txBlockDown;
		}
		if (nFrame == 9){
			txActive = txBlockUp;
		}
		if (nFrame == 10){
			txActive = txKickStraight1;
		}
		if (nFrame == 11){
			txActive = txKickStraight2;
		}
		if (nFrame == 12){
			txActive = txKickLow1;
		}
		if (nFrame == 13){
			txActive = txKickLow2;
		}
		if (nFrame == 14){
			txActive = txKickJump;
		}
		if (nFrame == 15){
			txActive = txDead;
		}
		isRight = !isRight;
		batch.draw(txActive, nX, nY, 100, 250, 0, 0, 2048, 3225, isRight, false);
	}
}
