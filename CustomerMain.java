import com.bsy.controller.CustomerController;
import com.bsy.service.ICustomerService;
import com.bsy.service.CustomerService;

public class CustomerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ICustomerService custService = new CustomerService();
		CustomerController custController = new CustomerController();
		
		custController.setCustomerService(custService);
		custController.run();
		

	}

}
