package com.missionbit.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by missionbit on 6/29/17.
 */

public class Obstacle {
    private Texture obstacle;
    private Animation obstacleAnimation;
    private Vector2 posObs;
    private static final int OBS_GAP = 100;
    private static final int FLUCTUATION = 300;
    private Random rand;
    private Rectangle boundsObs;

    //can change the obstacles and their position with each level
    public Obstacle(Texture obstacle, float x, float y, int frames, float time) {
        this.obstacle = obstacle;
        obstacleAnimation = new Animation(new TextureRegion(obstacle), frames, time);
        rand = new Random();
        posObs = new Vector2(x, y);
        boundsObs = new Rectangle(posObs.x, posObs.y, obstacle.getWidth(), obstacle.getHeight());
    }

    public Texture getObstacle() {return obstacle; }

    public TextureRegion getObsAnimation() {
        return obstacleAnimation.getFrame();
    }

    public void update(float dt) {
        obstacleAnimation.update(dt);
    }

    public int getWidth() { return obstacle.getWidth(); }

    public Vector2 getPosObs() { return posObs; }

    //reposition the obstacle
    public void reposition (float x) {
        //posObs.set(rand.nextInt(FLUCTUATION) + OBS_GAP, 1000);
        posObs.set(x, 50);
        System.out.println(posObs.x);
        boundsObs.setPosition(posObs.x, posObs.y);
    }

    //collision check
    public boolean collides(Rectangle player) {
        return player.overlaps(boundsObs);
    }

    //dispose
    public void dispose() {
        obstacle.dispose();
    }

    public Rectangle getBoundsObs() {
        return boundsObs;
    }
}
