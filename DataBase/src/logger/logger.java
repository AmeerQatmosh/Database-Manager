package logger;
import java.util.Calendar;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import logIn.logIn;
import signUp.signUp;

public final  class logger {
		private static final logger instance = new logger();
		public String logname = "simplelog";
		protected String env = System.getProperty("user.dir");
		private static File logFile;
		public static String ID; 
		
		public static logger getInstance(){
			return instance;
		}

		public static logger getInstance(String withName){
			instance.logname = withName;
			instance.createLogFile();
			return instance;
		}

		public void createLogFile(){
			File logsFolder = new File(env + '/' + "logs");
			if(!logsFolder.exists()){
				//Create the directory 
				System.err.println("INFO: Creating New Logs Directory In " + env);
				logsFolder.mkdir();
				
			}
			//Get the current date and time
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   	Calendar cal = Calendar.getInstance();
		   	//Create the name of the file from the path and current time
			logname =  logname + '-' +  dateFormat.format(cal.getTime()) + ".log";
			logger.logFile = new File(logsFolder.getName(),logname);
			try{
				if(logFile.createNewFile()){
					//New file made
					System.err.println("INFO: Creating New Log File");
				}
			}catch(IOException e){
				System.err.println("ERROR: Cannot Create Log File");
				System.exit(1);
			}
		}

		private logger(){
			if (instance != null){
				//Prevent Reflection
				throw new IllegalStateException("Cannot Instantiate A New Singleton Instance Of Log");
			}
			this.createLogFile();
		}

		public static void logInfo(String message){
			try{
				Date date = new Date();
				if(logIn.ID!=null) {
					ID=logIn.ID;
				}
				else {
					ID=signUp.ID;
				}
				FileWriter out = new FileWriter(logger.logFile, true);
				out.write("[User ID "+ID+"] [Info] ( "+date.toString()+" )  "+message+"\n");
				out.close();
			}catch(IOException e){
				System.err.println("ERROR: Could Not Write To Log File");
			}
		}
		
		public static void logError(String message){
			try{
				Date date = new Date();
				if(logIn.ID!=null) {
					ID=logIn.ID;
				}
				else {
					ID=signUp.ID;
				}
				FileWriter out = new FileWriter(logger.logFile, true);
				out.write("[User ID "+ID+"] [Error] ( "+date.toString()+" )  "+message+"\n");
				out.close();
			}catch(IOException e){
				System.err.println("ERROR: Could Not Write To Log File");
			}
		}
		
		public static void logDebug(String message){
			try{
				Date date = new Date();
				if(logIn.ID!=null) {
					ID=logIn.ID;
				}
				else {
					ID=signUp.ID;
				}
				FileWriter out = new FileWriter(logger.logFile, true);
				out.write("[User ID "+ID+"] [Debug] ( "+date.toString()+" )  "+message+"\n");
				out.close();
			}catch(IOException e){
				System.err.println("ERROR: Could Not Write To Log File");
			}
		}
		
		public static void logWarning(String message){
			try{
				Date date = new Date();
				if(logIn.ID!=null) {
					ID=logIn.ID;
				}
				else {
					ID=signUp.ID;
				}
				FileWriter out = new FileWriter(logger.logFile, true);
				out.write("[User ID "+ID+"] [Warning] ( " +date.toString()+" )  "+message+"\n");
				out.close();
			}catch(IOException e){
				System.err.println("ERROR: Could Not Write To Log File");
			}
		}
	}
	

