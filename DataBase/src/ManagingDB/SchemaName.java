package ManagingDB;

public class SchemaName {
    private static String getSchema;
    public static String getSchemaName() {
        return getSchema;
    }

    public static void setSchemaName(String getSchema) {
        SchemaName.getSchema = getSchema;
    }
}
