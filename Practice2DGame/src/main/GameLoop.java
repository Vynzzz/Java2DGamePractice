package main;

public class GameLoop implements Runnable{
	
	private Game game;
	
	private boolean running;
	private final double updateRate = 1.00/60.0d;
	
	private long nextStatTime;
	private int fps, ups;
	
	
	public GameLoop(Game game) {
		this.game = game;
	}
	
	
	@Override
	public void run() {
		running = true;
		double ticks =0;
		long currentTime, lastUpdate = System.nanoTime();
		nextStatTime = System.nanoTime() + 1000000000;
		
		while(running) {
			currentTime = System.nanoTime();
			double lastRenderTimeInSecs = (currentTime - lastUpdate)/1000000000d;
			ticks += lastRenderTimeInSecs;
			lastUpdate = currentTime;
			
			if(ticks >= updateRate) {
				while(ticks > updateRate) {
					update();
					ticks -= updateRate;
				}
				render();
			}
			printStats();
		}
	}

	private void printStats() {
		if(System.nanoTime() > nextStatTime) {
			System.out.println(String.format("FPS: %d, UPS: %d", fps,ups));
			fps = 0;
			ups = 0;
			nextStatTime = System.nanoTime() + 1000000000;
		}
	}

	private void update() {
		game.update();
		ups++;
	}
	
	private void render() {
		game.render();
		fps++;
	}
}
