package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Employee;


public interface EmployeeService {


	DataResult<List<Employee>> getAll();


}
