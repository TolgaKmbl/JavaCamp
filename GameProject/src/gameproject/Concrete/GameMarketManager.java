package gameproject.Concrete;

import gameproject.Abstract.GameMarketService;
import gameproject.Entities.Game;
import gameproject.Entities.Member;
import gameproject.Entities.SpecialOffer;

public class GameMarketManager implements GameMarketService{

	@Override
	public void gameBuy(Game game, SpecialOffer offer, Member member) {
		
		int priceAfterDiscount = (game.getPrice()-(game.getPrice()*offer.getDiscountRate()/100));
		
		String game1 = "The name of the Game : "+game.getName()
					  +"\nPlatform : "+game.getDetails()
					  +"\nPrice :"+game.getPrice() +" TL"
					  +"\nSpecial Offer Name :"+offer.getName()+" "+offer.getDiscountRate()+"% off"
					  +"\nReduced Price :"+ priceAfterDiscount +" TL";
		
		System.out.println(game1);
		System.out.println("Added to the Cart !");
		System.out.println(member.getFirstName()+" "+member.getLastName()+" your new balance is : "+(member.getBalance()-priceAfterDiscount)
				+" TL.");
		member.setBalance(member.getBalance()-priceAfterDiscount);
	}

}
