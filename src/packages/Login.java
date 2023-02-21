package packages;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class Login {
	
	private ObjectId id;
	private String userName;
	private String password;
	
	public Login()
	{
		// default, DO NOT EDIT THIS CONSTRUCTOR
	}
	
	public Login(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	public boolean correctLogin(String userName, String password, ArrayList<Login> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getUserName().equals(userName) && 
					list.get(i).getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}
}
