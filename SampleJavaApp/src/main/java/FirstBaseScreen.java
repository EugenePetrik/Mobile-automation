import java.util.ArrayList;

public class FirstBaseScreen extends BaseScreen {

    public void getTitle() {
        System.out.println("Print in console title from first base screen");
    }

    public static void main(String[] args) {
        ArrayList<String> arrayFirstBaseClass = new ArrayList<String>();

        arrayFirstBaseClass.add("String #1 from class FirstBaseScreen");
        arrayFirstBaseClass.add("String #2 from class FirstBaseScreen");
        arrayFirstBaseClass.add("String #3 from class FirstBaseScreen");
        arrayFirstBaseClass.add("String #4 from class FirstBaseScreen");
        arrayFirstBaseClass.add(0, "String #0 from class FirstBaseScreen");

        System.out.println("Array size equals " + arrayFirstBaseClass.size());

        for (String array : arrayFirstBaseClass ) {
            System.out.println("Array element equals " + array);
        }
    }

}
