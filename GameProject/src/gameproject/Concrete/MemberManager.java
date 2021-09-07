package gameproject.Concrete;

import gameproject.Abstract.MemberCheckService;
import gameproject.Abstract.MemberService;
import gameproject.Entities.Member;

public class MemberManager implements MemberService{
private MemberCheckService memberCheckService;



	public MemberManager(MemberCheckService memberCheckService) {
	this.memberCheckService = memberCheckService;
}

	@Override
	public void memberRegister(Member member) {
		if(memberCheckService.checkIfRealPerson(member)) {
		System.out.println("Member Registered : "+member.getFirstName() + " " + member.getLastName());
		}
		else {
		System.out.println("Invaild Person !");	
		}
	}

	@Override
	public void memberDelete(Member member) {
		System.out.println("Member Deleted : "+member.getFirstName() + " " + member.getLastName());
		member.setBalance(0);
		member.setDateOfBirth(0);
		member.setEmail(null);
		member.setFirstName(null);
		member.setLastName(null);
		member.setNationalId(null);
		member.setPassword(null);
	}

}
