package gameproject.Entities;

public class Game {
private String name;
private String details;
private int price;

public Game(String name, String details, int price) {
	super();
	this.name = name;
	this.details = details;
	this.price = price;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}


}
