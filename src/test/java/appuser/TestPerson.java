package appuser;

import dao.PersonDao;
import pojo.Person;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addPerson();
		PersonDao personDao =  new PersonDao();
		personDao.findAll();
	}

	private static void addPerson() {
		PersonDao personDao =  new PersonDao();
		Person person = new Person("Feroz", 26);
		
		personDao.insertPerson(person);
	}

}
