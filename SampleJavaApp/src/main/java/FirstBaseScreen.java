import java.util.ArrayList;

public class FirstBaseScreen extends BaseScreen {

    public void getTitle() {
        System.out.println("Print in console title from first base screen");
    }

    static ArrayList<String> arrayFirstBaseClass = new ArrayList<String>();

    public static void main(String[] args) {

        addString("String #1 from class FirstBaseScreen");
        addString("String #2 from class FirstBaseScreen");
        addString("String #3 from class FirstBaseScreen");
        addString("String #4 from class FirstBaseScreen");
        addString("String #5 from class FirstBaseScreen");

        System.out.println("Array size equals " + arrayFirstBaseClass.size());

        System.out.println("The first element in array equals: \'" + getArrayValueByIndex(0) + "\'");

        for (String array : arrayFirstBaseClass ) {
            System.out.println("Array element equals " + array);
        }

    }

    private static void addString(String someString) {
        arrayFirstBaseClass.add(someString);
    }

    private static String getArrayValueByIndex(int index) {
        return arrayFirstBaseClass.get(index);
    }

}
