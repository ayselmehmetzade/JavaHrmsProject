package kodlama.io.hrms.core.utilities.adapters;

public interface ValidationService {
	boolean userValidate(long nationalId, String firstName, String lastName, int birthDate );
}
