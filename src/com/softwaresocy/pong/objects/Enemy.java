package com.softwaresocy.pong.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.softwaresocy.pong.main.Game;

public class Enemy {

	public double x,y;
	
	public boolean right,left;
	
	public int width,height;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y= y;
		width = 40;
		height = 5;
	}
	
	//logica do enimigo
	public void tick() {
		x+= (Game.ball.x - x - 6) * 0.07;
	}
	
	//renderiza��o do enimigo
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x,(int)y, width, height);
	}
	
}
