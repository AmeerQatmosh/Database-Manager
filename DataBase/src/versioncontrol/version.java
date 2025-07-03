package versioncontrol;

import java.sql.Connection;

public interface version {
	
	void operation(Connection database);

}
