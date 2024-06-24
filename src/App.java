import entities.Account;
import entities.BusinessAccount;

public class App {
	public static void main(String[] args) throws Exception {

		BusinessAccount businessAccount = new BusinessAccount(1002, "Maria", 1000.0, 500.0);
		Account account = businessAccount; // UPCASTING

		if (account instanceof BusinessAccount) {
			BusinessAccount businessAccount2 = (BusinessAccount) account; // DOWNCASTING
			businessAccount2.loan(100.0);
		}
	}
}