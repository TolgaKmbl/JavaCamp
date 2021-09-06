package gameproject.Concrate;

import gameproject.Abstract.MemberCheckService;
import gameproject.Entities.Member;

public class MemberCheckManager implements MemberCheckService{

	@Override
	public boolean checkIfRealPerson(Member member) {
		return true;
	}

	
}
