package gameproject.Concrete;

import gameproject.Abstract.SpecialOfferService;
import gameproject.Entities.SpecialOffer;

public class SpecialOfferManager implements SpecialOfferService{

	@Override
	public void offerAdd(SpecialOffer offer) {
		System.out.println("A New Special Order has Added : "+offer.getName());
		
	}

	@Override
	public void offerUpdate(SpecialOffer offer, String name, int discountRate) {
		System.out.println("A Special Order has Updated : "+offer.getName());
		offer.setName(name);
		offer.setDiscountRate(discountRate);				
	}

	@Override
	public void offerDelete(SpecialOffer offer) {
		System.out.println("A Special Order has Deleted : "+offer.getName());
		offer.setName(null);
		offer.setDiscountRate(0);
	}

	
}
