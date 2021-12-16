package Import;


public class importfactory {

	 public Imports get(String Operation){
	        switch(Operation){
	            case "csv":
	                return new importCSV();
	            case "json":
	            	return new jsonfile();
	            	
	            case "sql":
	            	return new sql();
	        }
	        return null;
	    }
	}

