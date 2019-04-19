package lab;

import java.io.Serializable;

public class UserDAO implements Serializable {
	
	private BasicDataSource ds;

	public BasicDataSource getDs() {
		return ds;
	}

	public void setDs(BasicDataSource ds) {
		this.ds = ds;
	}
	
}
