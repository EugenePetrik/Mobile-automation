import java.util.ArrayList;

public class ThirdBaseScreen extends BaseScreen {

    public void getTitle() {
        System.out.println("Print in console title from third base screen");
    }

    public static void main(String[] args) {

        ArrayList<String> arrayThirdBaseClass = new ArrayList<String>();

        arrayThirdBaseClass.add("v");
        arrayThirdBaseClass.add("g");
        arrayThirdBaseClass.add("e");
        arrayThirdBaseClass.add("n");
        arrayThirdBaseClass.add("i");
        arrayThirdBaseClass.add("y");
        arrayThirdBaseClass.add(0, "E");

        System.out.print("My name is ");

        for (int i = 0; i < arrayThirdBaseClass.size(); i++) {
            System.out.print(arrayThirdBaseClass.get(i));
        }

        System.out.println("\nName consists from " + arrayThirdBaseClass.size() + " letters");

    }

}
