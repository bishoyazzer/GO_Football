package go_football.entity;

public class Invitation {
	private User player;
	private AvaliableHour avaliableHour;
	private Playground playground;
	
	public Invitation(User player, AvaliableHour avaliableHour, Playground playground) {
		this.player = player;
		this.avaliableHour = avaliableHour;
		this.playground = playground;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public AvaliableHour getAvaliableHour() {
		return avaliableHour;
	}

	public void setAvaliableHour(AvaliableHour avaliableHour) {
		this.avaliableHour = avaliableHour;
	}

	public Playground getPlayground() {
		return playground;
	}

	public void setPlayground(Playground playground) {
		this.playground = playground;
	}
}
