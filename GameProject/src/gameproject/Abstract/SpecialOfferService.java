package gameproject.Abstract;

import gameproject.Entities.SpecialOffer;

public interface SpecialOfferService {
void offerAdd(SpecialOffer offer);
void offerUpdate(SpecialOffer offer, String name, int discountRate);
void offerDelete(SpecialOffer offer);
}
