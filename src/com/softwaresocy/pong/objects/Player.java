package com.softwaresocy.pong.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.softwaresocy.pong.main.Game;

public class Player {

	public boolean right,left;
	
	public int x,y;
	
	public int width,height;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		width = 40;
		height = 5;
	}
	
	public void tick() {
		if(right) {
			x++;
		}else if(left) {
			x--;
		}
		
		if(x + width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}else if(x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
}
