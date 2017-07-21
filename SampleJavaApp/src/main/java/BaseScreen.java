public abstract class BaseScreen {

    public String username;

    public static final String PROJECT_NAME = "SAMPLE JAVA APP";

    public void setUsername(String username) {
        this.username = username;
    }

    abstract public void getTitle();

    public static int goBack(int number) {
        return number;
    }

    public static void main(String[] args) {

        new FirstBaseScreen().getTitle();

        new SecondBaseScreen().getTitle();

        new ThirdBaseScreen().getTitle();

    }

}
