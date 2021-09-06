package gameproject.Adapter;

import java.rmi.RemoteException;
import java.util.Locale;

import gameproject.Abstract.MemberCheckService;
import gameproject.Entities.Member;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements MemberCheckService{

	@Override
	public boolean checkIfRealPerson(Member member) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = true;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(member.getNationalId()),member.getFirstName().toUpperCase(new Locale("tr")),
					member.getLastName().toUpperCase(new Locale("tr")),member.getDateOfBirth());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
