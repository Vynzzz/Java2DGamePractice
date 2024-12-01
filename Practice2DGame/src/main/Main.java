package main;
//Name to be made
public class Main {
	public static void main(String[] args) {
		new Thread(new GameLoop(new Game(800,600))).start();
	}
}
