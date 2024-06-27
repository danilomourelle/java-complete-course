import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.entities.Employee;
import model.entities.Person;

public class App {
	public static void main(String[] args) {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("Maria", 4300.00));
		employeesList.add(new Employee("Alex", 3100.00));
		employeesList.add(new Employee("Bob", 3500.00));

		List<Person> peopleList = new ArrayList<>();
		peopleList.add(new Person("Maria", 35));
		peopleList.add(new Person("Alex", 20));
		peopleList.add(new Person("Bob", 25));

		Collections.sort(employeesList);
		for (Employee emp : employeesList) {
			System.out.println(emp.getName() + ", " + emp.getSalary());
		}

		Collections.sort(peopleList, Comparator.comparing(Person::getName));
		for (Person p : peopleList) {
			System.out.println(p.getName() + ", " + p.getAge());
		}

		Collections.sort(peopleList, Comparator.comparing(Person::getAge).reversed());
		for (Person p : peopleList) {
			System.out.println(p.getName() + ", " + p.getAge());
		}
	}
}
