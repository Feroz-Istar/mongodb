package pojo;

public class Person {
	Oid _id;
	String name;
	int age;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}



	



	public Oid get_id() {
		return _id;
	}



	public void set_id(Oid _id) {
		this._id = _id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	
}
