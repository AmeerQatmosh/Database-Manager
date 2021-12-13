package ConnectionDatabase;

public class factoryManaging {

    public  ManagingDatabase tables(String nametable){
        switch(nametable){
            case "ReadSchema":
                return new ReadSchema();
            case "InsertTable":
                return new InsertData();
            case "ReadTable":
                return new ReadTable();
            case "DeleteTable":
                return new DeleteTable();
            case "DeleteData":
                return new DeleteData();

        }
        return null;
    }
}
