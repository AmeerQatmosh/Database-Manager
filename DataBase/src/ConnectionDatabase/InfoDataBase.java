package ConnectionDatabase;

public class InfoDataBase {
	
	private static String root;
	private static String pass;
	private static String localhost;
	private static int port;
	
	 public InfoDataBase()
	 {
		 super();
	 }
	 public InfoDataBase(String root,String pass,String localhost,int port)
	 {
		 setRoot(root);
		 setPass(pass);
		 setLocalhost(localhost);
		 setPort(port);
	 }
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		
		InfoDataBase.pass = pass;
	}
	public static String getRoot() {

		return root;
	}
	public static void setRoot(String root) {
		InfoDataBase.root = root;
	}
	public static int getPort() {
		return port;
	}
	public static void setPort(int port) {
		InfoDataBase.port = port;
	}
	public static String getLocalhost() {

		return localhost;
	}
	public static void setLocalhost(String localhost) {
		InfoDataBase.localhost = localhost;
	}

}
