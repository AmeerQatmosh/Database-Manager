package ManagingDB;

import Delete.*;
import Read.*;
import insert.*;

public class factoryManaging {

    public ManagingDatabase tables(String nametable){
        switch(nametable){
            case "ReadSchema":
                return new ReadSchema();
            case "InsertData":
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
