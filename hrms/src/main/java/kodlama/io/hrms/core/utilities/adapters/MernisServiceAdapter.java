package kodlama.io.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.mernis.FakeMernis;

@Service
public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean userValidate(long nationalId, String firstName, String lastName, int birthDate) {

		FakeMernis checkUser = new FakeMernis();
		boolean result = true;

		try {
			result = checkUser.userValidate(nationalId, firstName, lastName, birthDate);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

}
