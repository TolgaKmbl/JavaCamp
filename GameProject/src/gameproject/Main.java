package gameproject;

import gameproject.Adapter.MernisServiceAdapter;
import gameproject.Concrete.GameMarketManager;
import gameproject.Concrete.MemberManager;
import gameproject.Concrete.SpecialOfferManager;
import gameproject.Entities.Game;
import gameproject.Entities.Member;
import gameproject.Entities.SpecialOffer;

public class Main {

	public static void main(String[] args) {
		
		Member member1 = new Member("deneme@deneme.com", "11111111", "Tolga", "Kümbül", 1992, "123456789", 1000);		
		MemberManager memberManager = new MemberManager(new MernisServiceAdapter());
		memberManager.memberRegister(member1);
		
		SpecialOffer offer = new SpecialOffer("First Special Offer", 25);
		
		Game game = new Game("Demon's Souls","Playstation 5", 400);
		GameMarketManager gameMarket = new GameMarketManager();
		gameMarket.gameBuy(game, offer, member1);
		
		SpecialOfferManager offerManager = new SpecialOfferManager();
		offerManager.offerUpdate(offer, "Updated Special Offer", 35);
		System.out.println(offer.getName() + " " + offer.getDiscountRate()+ "%");
		
		Game game2 = new Game("Marvel's Spider-Man: Miles Morales","Playstation 5", 200);
		gameMarket.gameBuy(game2, offer, member1);
		
		offerManager.offerDelete(offer);
		
		Game game3 = new Game("God of War","Playstation 4", 150);
		gameMarket.gameBuy(game3, offer, member1);
		
	}

}
