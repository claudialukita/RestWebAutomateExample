package utility;
public class DefaultData {

public static TestData testData = new TestData();

    public static void setTest1Data() throws Exception {
        testData.setUrl(ClassHelp.getEnv("url"));
    }
    public static void setTestMultiData() throws Exception {
        testData.setUrl(ClassHelp.getEnv("urlMulti"));
    }

    public static void setUrlAnother() throws Exception {
        testData.setUrl(ClassHelp.getEnv("urlAnother"));
    }
}
