package ConnectionDatabase;

public class SchemaName {

    private static String getSchema;

    public static String getGetName() {
        return getSchema;
    }

    public static void setGetName(String getSchema) {
        SchemaName.getSchema = getSchema;
    }
}
