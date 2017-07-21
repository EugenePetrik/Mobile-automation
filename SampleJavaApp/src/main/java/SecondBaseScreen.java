import java.util.HashMap;

public class SecondBaseScreen extends BaseScreen {

    public void getTitle() {
        System.out.println("Print in console title from second base screen");
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashSecondBaseClass = new HashMap<String, Integer>();

        hashSecondBaseClass.put("String #1 from class SecondBaseScreen", 10);
        hashSecondBaseClass.put("String #2 from class SecondBaseScreen", 20);
        hashSecondBaseClass.put("String #3 from class SecondBaseScreen", 30);
        hashSecondBaseClass.put("String #4 from class SecondBaseScreen", 40);
        hashSecondBaseClass.put("String #5 from class SecondBaseScreen", 50);

        System.out.println("Hash size equals " + hashSecondBaseClass.size());

        for (String stringNumber : hashSecondBaseClass.keySet()) {
            System.out.println(stringNumber + " contains " + hashSecondBaseClass.get(stringNumber));
        }
    }

}
