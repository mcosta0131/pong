package com.softwaresocy.pong.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.softwaresocy.pong.main.Game;

public class Ball {

	
	public double x,y;
	
	public boolean right,left;
	
	public int width,height;
	
	public double dx,dy;
	public double speed =1.3;
	
	
	public Ball(int x, int y) {
		this.x = x;
		this.y= y;
		width = 4;
		height = 4;
		
		
		int angle = new Random().nextInt((120 - 45) + 45);
		
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	
	//logica do enimigo
	public void tick() {
		
		if(x+(dx*speed) + width >= Game.WIDTH || x+(dx * speed) < 0) {
			dx*=-1;
		}
		
		if(y >= Game.HEIGHT) {
			//ponto do inimigo
			System.out.println("PONTO DO INIMIGO");
			new Game();
			return;
		
		}else if(y < 0) {
			//ponto do jogador
			System.out.println("PONTO DO JOGADOR !! YAAY!");
			new Game();
			return;
		}
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y + (dy*speed)),width,height);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		

		Rectangle boundsEnemy = new Rectangle((int)(Game.enemy.x),(int)(Game.enemy.y),Game.enemy.width,Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt((120 - 45) + 45);
			
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0)
				dy *= -1;
		}

		if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt((120 - 45) + 45);
			
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if(dy < 0)
				dy *= -1;
		}
		
		x += dx * speed;
		y += dy * speed;
	}
	
	//renderização do enimigo
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect((int)x,(int)y, width, height);
	}
}
