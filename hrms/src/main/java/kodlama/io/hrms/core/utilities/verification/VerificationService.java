package kodlama.io.hrms.core.utilities.verification;

public interface VerificationService {
	void sendLink(String email);
	String sendCode();
}
