package versioncontrol;

public class versionfactory {
	
	public static version Snap(String operation) {
	
	switch(operation)
	{
	case "export":
		return new exportdata();
	case "rescive":
		return new rescive();
	}
	return null;
	}

}
