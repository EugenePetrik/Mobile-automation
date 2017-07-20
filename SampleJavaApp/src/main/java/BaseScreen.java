public abstract class BaseScreen {

    String username;

    public void setUsername(String username) {
        this.username = username;
    }

    abstract public void getTitle();

    public static int goBack(int number) {
        return number;
    }
    
}
