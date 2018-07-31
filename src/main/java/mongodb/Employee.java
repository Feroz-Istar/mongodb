package mongodb;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class Employee {
    private long no;
    private String name;

    // Getters and Setters

    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DBObject toDBObject() {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder
                .start("no", no)
                .append("name", name);
        return builder.get();
    }
}