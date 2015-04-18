package simpleBattleShip;

public class Game {

	private int shotsFired = 0;
	
	//Board is automagically set to false, false will mean no ship.
	private boolean[] board = new boolean[6];
	
	private DotComs[] ships = new DotComs[1];
	
	public Game(){
	
	
	for(DotComs ship : ships){
		ship = new DotComs();
		
		boolean placement = false;
		while (!placement){
			int potentialStart = (int) Math.random() * (board.length - ship.getShipLength());
			//assuming ship of length 3  Checks to see if there is a ship in any of those squares, if yes then it tries another number.
			if(!board[potentialStart] && !board[potentialStart + 1] && !board[potentialStart + 2]){
				board[potentialStart] = true;
				board[potentialStart + 1] = true;
				board[potentialStart + 2] = true;
				placement = true;
			}
		}
		
	}
	

	
}
public void playGame(){
		boolean allShipsSunk = false;
		while(!allShipsSunk){
			shotsFired++;
			allShipsSunk = true;
			int shoot = (int) (Math.random() * board.length);
			for(DotComs ship : ships){
				ship.takeDamage(shoot);
				if(!ship.getShipSunk()){
					allShipsSunk = false;
				}
			}
			
		}
		System.out.println("You shot " + shotsFired + " times.");
		System.out.println("You hit " + (ships.length * 3) + " times.");
		System.out.println("Your accuracy was" + ((ships.length * 3) / shotsFired) + " percent");
	}
}
