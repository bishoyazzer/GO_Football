package go_football.entity;

import java.util.ArrayList;
import java.util.List;

public class Playground {
	
	private static int idCounter;
	private int id;
	private String location;
	private double size;
	private String name;
	private double pricePerHour;
	private PlayGroundOwner owner;
	
	private List<AvaliableHour> avaliableHours;
	private List<Complain> complains;
	
	
	public Playground(String location, double size, String name, double pricePerHour, PlayGroundOwner owner) {
		this.id = idCounter;
		idCounter += 1;
		this.location = location;
		this.size = size;
		this.name = name;
		this.pricePerHour = pricePerHour;
		this.owner = owner;
		avaliableHours = new ArrayList<>();
		complains = new ArrayList<>();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public List<AvaliableHour> getAvaliableHours() {
		return avaliableHours;
	}
	
	public void addNewAvaliableHour(AvaliableHour avaliableHour) {
		avaliableHours.add(avaliableHour);
	}
	
	public boolean removeAvaliableHour(AvaliableHour avaliableHour) {
		return avaliableHours.remove(avaliableHour);
	}

	public PlayGroundOwner getOwner() {
		return owner;
	}

	public void setOwner(PlayGroundOwner owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "Playground [id=" + id + ", location=" + location + ", size=" + size + ", name=" + name
				+ ", pricePerHour=" + pricePerHour + ", avaliableHours=" + avaliableHours + "]";
	}


	public List<Complain> getComplains() {
		return complains;
	}


	public void complain(Player player, String complainMessage) {
		Complain newComplain = new Complain(this, player, complainMessage);
		complains.add(newComplain);
	}
	
	
}
