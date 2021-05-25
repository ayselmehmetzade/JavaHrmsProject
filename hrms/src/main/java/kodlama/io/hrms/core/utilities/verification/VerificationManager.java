package kodlama.io.hrms.core.utilities.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService{

	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("Doğrulama bağlantısı gönderildi : " + email );
		System.out.println("Lütfen hesabınızı doğrulayın :  " + verificationLink );
		
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("Etkinleştirme kodu: " + verificationCode );
		return verificationCode;
	}

}
