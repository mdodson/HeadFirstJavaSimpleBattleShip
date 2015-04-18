package simpleBattleShip;

public class DotComs {
	private String dotComName;
	
	private int shipLength = 3;
	private int shipLocation;
	private boolean shipSunk;
	private boolean shipHorizontal = true;
	private boolean[] hits;
	
	public DotComs(){
	
		hits = new boolean[shipLength];

	}
	
	public boolean setShipLocation(int startLocation, int numColumns){
		if (startLocation < (numColumns - shipLength)){
			shipLocation = startLocation;
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getShipLocation(){
		return shipLocation;
	}
	
	public int getShipLength(){
		return shipLength;
	}
	
	public boolean takeDamage(int column){
		boolean iveBeenHit = false;
		int hitCount = 0;
		
		for(int i = 0; i <shipLength; i++){
			if(column == (shipLocation + i) && hits[i] == false){
				iveBeenHit = true;
				hits[i] = true;
			}
		}
		for(int i = 0; i < shipLength; i++){
			if(hits[i]){
				hitCount++;
			}
		}
		if (hitCount == shipLength){
			shipSunk = true;
		}
			
		
		return iveBeenHit;
	}
	
	public boolean getShipSunk(){
		return shipSunk;
	}
	
	
	
}
