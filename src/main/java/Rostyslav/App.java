package Rostyslav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Rostyslav.entity.City;
import Rostyslav.entity.Country;
import Rostyslav.entity.User;

//import Rostyslav.entity.City;
//import Rostyslav.entity.Country;
//import Rostyslav.entity.User;
//import Rostyslav.reader.Reader;

public class App {

	public static Scanner scan = new Scanner(System.in);
	public static boolean work = true;
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
	public static EntityManager em = factory.createEntityManager();

	public static void main(String[] args) throws Exception {
		em.getTransaction().begin();

		// Reader.read();

		// for (String string : Reader.COUNTRIES) {
		// Country country = new Country();
		// country.setName(string);
		// em.persist(country);
		// }

		// for (String string : Reader.CITYEES) {
		// City city = new City();
		// city.setName(string);
		// city.setCountry(em.createQuery("SELECT c FROM Country c WHERE c.id = :id",
		// Country.class)
		// .setParameter("id", (long) new Random().nextInt(19) + 1)
		// .getSingleResult());
		// em.persist(city);
		// }

		// for (String string : Reader.USERS) {
		// User user = new User();
		// user.setFullName(string);
		// user.setAge(new Random().nextInt(100) + 1);
		// user.setCity(em.createQuery("SELECT c FROM City c WHERE c.id = :id",
		// City.class)
		// .setParameter("id", (long) new Random().nextInt(38) + 1)
		// .getSingleResult());
		// em.persist(user);
		// }

		while (work) {
			menu();
			programWork(scan.nextInt());
		}

		scan.close();
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static void programWork(int choise) {
		switch (choise) {
		case 1:
			List<User> users = new ArrayList<>();
			users = em.createQuery("select u from User u order by u.id asc", User.class).getResultList();
			System.out.println("id" + "\t" + "FullName" + " ( " + "age" + " )");
			for (int i = 0; i < users.size(); i++) {
				System.out.println(users.get(i).getId() + "\t" + users.get(i).getFullName() +
						" ( " + users.get(i).getAge() + " )");
			}
			break;
		case 2:
			List<Country> countries = new ArrayList<>();
			countries = em.createQuery("select c from Country c order by c.id desc", Country.class).getResultList();
			System.out.println("id" + "\t" + "Name");
			for (int i = 0; i < countries.size(); i++) {
				System.out.println(countries.get(i).getId() + "\t" + countries.get(i).getName());
			}
			break;
		case 3:
			List<City> cityes= new ArrayList<>();
			cityes = em.createQuery("select c from City c order by c.name asc", City.class).getResultList();
			System.out.println("id" + "\t" + "Name");
			for (int i = 0; i < cityes.size(); i++) {
				System.out.println(cityes.get(i).getId() + "\t" + cityes.get(i).getName());
			}
			break;
		case 4:
			List<User> users2 = new ArrayList<>();
			users2 = em.createQuery("select u from User u join fetch u.city uc order by u.fullName desc", User.class).getResultList();
			System.out.println("id" + "\t" + "FullName" + " ( " + "age" + " ) \t\t\t" + "City");
			for (int i = 0; i < users2.size(); i++) {
				System.out.println(users2.get(i).getId() + "\t" + users2.get(i).getFullName() +
						" ( " + users2.get(i).getAge() + " ) \t\t\t" + users2.get(i).getCity().getName());
			}
			break;
		case 5:
			List<Country> countries2 = new ArrayList<>();
			countries2 = em.createQuery("select c from Country c where name like 'a%'", Country.class).getResultList();
			System.out.println("id" + "\t" + "Name");
			for (int i = 0; i < countries2.size(); i++) {
				System.out.println(countries2.get(i).getId() + "\t" + countries2.get(i).getName());
			}
			break;
		case 6:
			List<City> cityes2 = new ArrayList<>();
			cityes2 = em.createQuery("select c from City c where name like '%n_'", City.class).getResultList();
			List<City> cityes3 = new ArrayList<>();
			cityes3 = em.createQuery("select c from City c where name like '%r_'", City.class).getResultList();
			System.out.println("id" + "\t" + "Name");
			for (int i = 0; i < cityes2.size(); i++) {
				System.out.println(cityes2.get(i).getId() + "\t" + cityes2.get(i).getName());
			}
			for (int i = 0; i < cityes3.size(); i++) {
				System.out.println(cityes3.get(i).getId() + "\t" + cityes3.get(i).getName());
			}
			break;
		case 7:
//			System.out.println("Мінімальний вік - " + em.createQuery("select min(u.age) from User u").getResultList());
			List<Integer> l = em.createQuery("select min(u.age) from User u", Integer.class).getResultList();
			int k = l.get(0);
			List<User> usersS = new ArrayList<>();
			usersS = em.createQuery("select u from User u join fetch u.city uc", User.class).getResultList();
			System.out.println("id" + "\t" + "FullName" + " ( " + "age" + " ) \t\t\t" + "City");
			for (int i = 0; i < usersS.size(); i++) {
				if (k == usersS.get(i).getAge()) {
					System.out.println(usersS.get(i).getId() + "\t" + usersS.get(i).getFullName() +
							" ( " + usersS.get(i).getAge() + " ) \t\t\t" + usersS.get(i).getCity().getName());
				}
			}
			break;
		case 8:
			System.out.println("Середній вік - " + em.createQuery("select avg(u.age) from User u").getResultList());
			break;
		case 9:
			List<User> users3 = new ArrayList<>();
			users3 = em.createQuery("select u from User u join fetch u.city c order by u.id asc", User.class).getResultList();
			System.out.println("id" + "\t" + "FullName" + " ( " + "age" + " ) \t\t\t" + "City");
			for (int i = 0; i < users3.size(); i++) {
				System.out.println(users3.get(i).getId() + "\t" + users3.get(i).getFullName() +
						" ( " + users3.get(i).getAge() + " ) \t\t\t" + users3.get(i).getCity().getName());
			}
			break;
		case 10:
			List<User> users4 = new ArrayList<>();
			users4 = em.createQuery("select u from User u join fetch u.city uc "
					+ "where u.id != 2 and u.id != 5 and u.id != 9 and u.id != 12 "
					+ "and u.id != 13 and u.id != 16 order by u.id asc ", User.class).getResultList();
			System.out.println("id" + "\t" + "FullName" + " ( " + "age" + " ) \t\t\t" + "City");
			for (int i = 0; i < users4.size(); i++) {
				System.out.println(users4.get(i).getId() + "\t" + users4.get(i).getFullName() +
						" ( " + users4.get(i).getAge() + " ) \t\t\t" + users4.get(i).getCity().getName());
			}
			break;
		case 11:
			List<User> users5 = new ArrayList<>();
			users5 = em.createQuery("select u from User u join fetch u.city c order by u.id asc", User.class).getResultList();
			System.out.println("id" + "\t" + "FullName" + " ( " + "age" + " ) \t\t\t" + "City"
			 + "\t\t\t Country");
			for (int i = 0; i < users5.size(); i++) {
				System.out.println(users5.get(i).getId() + "\t" + users5.get(i).getFullName() +
						" ( " + users5.get(i).getAge() + " ) \t\t\t" + users5.get(i).getCity().getName()
						 + "\t\t\t " + users5.get(i).getCity().getCountry().getName());
			}
			break;
		case 12:
			System.out.println("Дякую за користування програмою!");
			work = false;
			break;
		default:
			System.out.println("Введіть значення від 1 до 11 !!!");
			work = true;
		}
	}

	public static void menu() {
		System.out.println("Доброго дня!");
		System.out.println("Виберіть один з пунктів: ");
		System.out.println("1) Вивести з таблиці User всі дані.\r\n"
				+ "2) Вивести з таблиці Country всі дані у зворотньому порядку.\r\n"
				+ "3) Вивести з таблиці City всі дані відсортовані по name\r\n"
				+ "4) Вивести з таблиці User всі дані відсортовані по name в зворотньому порядку\r\n"
				+ "5) Вивести з таблиці Country всі дані, які починаються на символ \"a\". (пошук повинен відбуватись з ігноруванням регістру літери)\r\n"
				+ "6) Вивести з таблиці City всі дані, де передостання буква \"n\" та \"r\".\r\n"
				+ "7) Вивести з таблиці User вивести користувача з мінімальним age.\r\n"
				+ "8) Вивести з таблиці User вивести середній age всіх User.\r\n"
				+ "9) Вивести всі дані про User та City використавши join.\r\n"
				+ "10) Вивести дані про User та City використавши join де User.id не рівний (!=) 2, 5, 9, 12, 13, 16.\r\n"
				+ "11) Вивести дані про User, Country та City одним запитом використавши join.\r\n"
				+ "12) Вийти з програми.");
	}
}
