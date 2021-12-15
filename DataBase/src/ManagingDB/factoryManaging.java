package ManagingDB;

import Delete.*;
import Read.*;
import insert.*;
import export.*;

public class factoryManaging {

    public ManagingDatabase Data(String Operation){
        switch(Operation){
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
            case "ExportData":
                return new Export();

        }
        return null;
    }
}
