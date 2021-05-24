package kodlama.io.hrms.mernis;

public class FakeMernis {

	public boolean userValidate(long nationalId, String firstName, String lastName, int birthDate ) {
		System.out.println("Doğrulama Başarılı" + firstName + " " + lastName);
		return true;
	}
}
