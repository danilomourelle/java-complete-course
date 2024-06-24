import entities.BusinessAccount;

public class App {
	public static void main(String[] args) throws Exception {
		BusinessAccount account = new BusinessAccount(8010, "Bob Brown", 100.0, 500.0);
		
		System.out.println(account.getLoanLimit());
		System.out.println(account.getBalance());
		System.out.println(account.getNumber());
	}
}