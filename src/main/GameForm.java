package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameForm extends JFrame{
	Timer timer=new Timer();
	Image imageBuffer=null;
	Graphics bufferGraphics,formGraphics;
	GameScene gameScene;
	Bird mBird;
	public GameForm() {
		// TODO Auto-generated constructor stub
		this.setTitle("Flappy Bird");
		this.setSize(Configure.SCREEN_WIDTH, Configure.SCREEN_HEIGHT+27);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			Resourse.init();
			gameScene=new GameScene();
			mBird=new Bird();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fail to init resourses");
			System.exit(1);
		}
		this.addMouseListener(mouseListener);
		
	}
	private MouseListener mouseListener=new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			mBird.mouseRelease();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			mBird.mousePress();
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		imageBuffer = createImage(Configure.SCREEN_WIDTH, Configure.SCREEN_HEIGHT);//创建图形缓冲区  
		bufferGraphics = imageBuffer.getGraphics();//获取图形缓冲区的图形上下文  
		formGraphics=this.getGraphics();
		timer.schedule(loopTask,50,(int)(Configure.LOOP_PERIOD*1000));
	}


	
	TimerTask loopTask=new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			gameScene.loop();
			if(!mBird.loop(gameScene)){ //死亡
//				System.out.println("YOU DIE");
//				System.exit(0);
				SwingUtilities.invokeLater(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						GameForm.this.exit();
						AlertWindow alertWindow=new AlertWindow("Alert", "YOU DIE", new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								GameForm gameForm=new GameForm();
								gameForm.show();
							}
						});
						alertWindow.show();
					}

				});
			}
			else{
				gameScene.draw(bufferGraphics);
				mBird.draw(bufferGraphics);
				
				SwingUtilities.invokeLater(new Runnable(){
	
					@Override
					public void run() {
						// TODO Auto-generated method stub
						formGraphics.drawImage(imageBuffer, 0, 26, null);
					}
				
				});
			}
		}
	};
	public void exit(){
		timer.cancel();
		mBird=null;
		gameScene=null;
		this.hide();
	}

}
