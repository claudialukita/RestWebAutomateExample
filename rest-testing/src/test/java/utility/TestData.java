package utility;

public class TestData {
    public static String url;
    public static String username;
    public static String password;
    public static String isHeadless = "No";
    public static String isHeadlessYes = "Yes";
    public static int timeInSeconds;
    public static String policyNo;
    public static String closeBrowserEveryScenario = "No";

    //Configuration Browser
    public String getIsHeadlessYes(){
        return isHeadlessYes;
    }
    public void setIsHeadlessYes(String isHeadlessYes){
        TestData.isHeadlessYes = isHeadlessYes;
    }
    public String getIsHeadless() {
        return isHeadless;
    }
    public void setIsHeadless(String isHeadless) {
        TestData.isHeadless = isHeadless;
    }
    //PolicyNo Setting
    public String getPolicyNo(){
        return policyNo;
    }
    public void setPolicyNoDefault(String policyNo)  {
        TestData.policyNo = policyNo;
    }
    //Url Setting
    public String getUrl() {
        return url;
    }
    public int getTimeInSeconds() {
        return timeInSeconds;
    }
    public void setUrl(String url) {
        TestData.url = url;
    }
    // Username & Password Setting Defaultdata
    public void setUserName(String username) {
        TestData.username = username;
    }
    public String getUserName (){
        return username;
    }
    public void SetPassword(String password) {
        TestData.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getCloseBrowserEveryScenario() {
        return closeBrowserEveryScenario;
    }
    public void setCloseBrowserEveryScenario(String closeBrowserEveryScenario) {
        if (TestData.isHeadlessYes.equalsIgnoreCase("Yes")
                && closeBrowserEveryScenario.equalsIgnoreCase("No")) {
            closeBrowserEveryScenario = "Yes";
        }
        TestData.closeBrowserEveryScenario = closeBrowserEveryScenario;
    }
}