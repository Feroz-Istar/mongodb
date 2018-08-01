package appuser;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.github.javafaker.Faker;

import dao.AppUserDao;
import pojo.AppUser;

public class TestAppUser {
	public static void main(String args[]) {
		//addUser();
		//findAllAppUser();
		//findAppUser();
		
		//findmultiple();
		
		//sortMultiple();
		//deleteOne();
		AppUserDao appUserDao = new AppUserDao();
		appUserDao.deleteAll();
	}

	private static void deleteOne() {
		AppUserDao appUserDao = new AppUserDao();
		appUserDao.delete("password","Kanlam");
	}

	private static void sortMultiple() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("_id", 1);

		
		AppUserDao appUserDao = new AppUserDao();
		List<AppUser> appUsers = appUserDao.sortMulitple(map);
		for(AppUser appUser: appUsers) {
			System.out.println(appUser.get_id().get$oid());
		}
	}

	private static void findmultiple() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", "berry.sanford@yahoo.com");
		map.put("password", "Quo Lux");

		
		AppUserDao appUserDao = new AppUserDao();
		List<AppUser> appUsers = appUserDao.findMulitple(map);
		for(AppUser appUser: appUsers) {
			System.out.println(appUser.get_id().get$oid());
		}
	}

	private static void findAppUser() {
		AppUserDao appUserDao = new AppUserDao();
		AppUser appUser = appUserDao.find("password","Kanlam");
		System.out.println(appUser.getEmail());
	}

	private static void findAllAppUser() {
		AppUserDao appUserDao = new AppUserDao();
		List<AppUser> appUsers = appUserDao.findAll();
		for(AppUser appUser: appUsers) {
			System.out.println(appUser.get_id().get$oid());
		}
	}

	private static void addUser() {
		for(int i =0; i<10;i++) {
		Faker faker = new Faker();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -faker.number().numberBetween(10, 20));
		Date dateBefore30Days = cal.getTime();
		cal.add(Calendar.DATE, -faker.number().numberBetween(20, 50));
		Date dateBefore40Days = cal.getTime();

		AppUser appUser = new AppUser(faker.app().name(), faker.internet().emailAddress(), dateBefore30Days,
				dateBefore40Days);
		AppUserDao appUserDao = new AppUserDao();
		appUserDao.insertAppUser(appUser);
		}
	}
}
