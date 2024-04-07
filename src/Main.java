import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("4.1" +"\n"+"Введите строку");
        String firstString = in.nextLine();
        System.out.println("Введите подстроку");
        String secondString = in.nextLine();
        String[] splitFirstString = firstString.split(secondString);
        System.out.println(
                "Подстрака '" + secondString + "' встречается "+ (splitFirstString.length-1) + " раза"
        );

        System.out.println("4.2" +"\n"+"Введите строку");
        String controlledText = in.nextLine();
        final String WORDPERMIT = "вырезано цензурой";

        //Примитивный вариант:
        /*
        final String WORDCONTROL_1 = "кака";
        final String WORDCONTROL_2 = "бяка";
        String resultControl_1 = controlledText.replace(WORDCONTROL_1, WORDPERMIT);
        String resultControl_2 = resultControl_1.replace(WORDCONTROL_2, WORDPERMIT);
        System.out.println(resultControl_2);
         */

        //Более приемлемый вариант (на мой взгляд).
        String[] wordsControl = new String[] {"кака", "бяка"};
        for (String s : wordsControl) {
            if (controlledText.contains(s)) {
                controlledText = controlledText.replace(s, WORDPERMIT);
            }
        }
        System.out.println(controlledText);

        System.out.println("4.3" +"\n"+"Введите дату в формате 'дд.мм.гггг'");
        String data = in.nextLine();
        String[] elements = data.split("\\.");

        String[] reversElement = new String[elements.length];
        for (int i = elements.length-1; i>0;){
            for (int j = 0; j < elements.length; j++){
                reversElement[j] = elements[i];
                i--;
            }
        }
        String result = String.join("-",reversElement);
        System.out.println(result);

        System.out.println("4.4" +"\n"+"Введите дату в формате 'дд.мм.гггг'");
        String dataTextIn = in.nextLine();
        DateFormat formaterIn = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formaterOut = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = new Date();
        try {
            dateFormat = formaterIn.parse(dataTextIn);
            String dataTextOut = formaterOut.format(dateFormat);
            System.out.println(dataTextOut);
        }  catch (ParseException e) { //реагирует только на разделитель
            System.out.println("Введён неверный формат даты!");
        }
    }
}