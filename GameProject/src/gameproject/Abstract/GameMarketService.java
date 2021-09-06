package gameproject.Abstract;

import gameproject.Entities.Game;
import gameproject.Entities.Member;
import gameproject.Entities.SpecialOffer;

public interface GameMarketService {
void gameBuy(Game game,SpecialOffer offer,Member member);
}
