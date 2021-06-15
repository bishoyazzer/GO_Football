package go_football.entity;

public class Complain {
	private Playground playground;
	private Player player;
	private String complaine;
	
	
	public Complain(Playground playground, Player player, String complaine) {
		this.playground = playground;
		this.player = player;
		this.complaine = complaine;
	}


	public Playground getPlayground() {
		return playground;
	}


	public void setPlayground(Playground playground) {
		this.playground = playground;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public String getComplaine() {
		return complaine;
	}


	public void setComplaine(String complaine) {
		this.complaine = complaine;
	}


	@Override
	public String toString() {
		return "Complain [playground=" + playground + ", player=" + player + ", complaine=" + complaine + "]";
	}
	
}
