package pojo;

import java.util.Date;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;


public class AppUser {
	private String password;
	private String email;
	private Date created_at;
	private Date update_at;
	Oid _id;

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AppUser(String password, String email, Date created_at, Date update_at) {
		super();
		this.password = password;
		this.email = email;
		this.created_at = created_at;
		this.update_at = update_at;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}


	public Oid get_id() {
		return _id;
	}


	public void set_id(Oid _id) {
		this._id = _id;
	}
	
	
	
	
}
