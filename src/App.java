public class App {
	public static void main(String[] args) throws Exception {
		// if/else
		int x = 10;
		if (x < 10) {
			System.out.println("Menor que 10");
		} else if (x == 10) {
			System.out.println("Igual a 10");
		} else {
			System.out.println("Maior que 10");
		}

		// switch/case
		int number = 4;
		String weekDay;
		switch (number) {
			case 1:
				weekDay = "Sunday";
				break;
			case 2:
				weekDay = "Monday";
				break;
			case 3:
				weekDay = "Tuesday";
				break;
			case 4:
				weekDay = "Wednesday";
				break;
			case 5:
				weekDay = "Thursday";
				break;
			case 6:
				weekDay = "Friday";
				break;
			case 7:
				weekDay = "Saturday";
				break;
			default:
				weekDay = "Invalid day";
				break;
		}

		// operador ternário
		int hours = 0;
		String greetings = hours < 12 ? "Good Morning" : "Good Afternoon";
	}
}