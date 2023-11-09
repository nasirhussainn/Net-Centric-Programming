import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class Part7 {

    public static LocalDate String_to_Date(String birthday){
        DateTimeFormatter local_birthday = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(birthday, local_birthday);
    }
    public static Period calculateBirth(LocalDate today, LocalDate birthday){

        return Period.between(birthday, today);
    }

    public static void DisplayDay(LocalDate today, LocalDate birthday){
        for(int i=birthday.getYear();i<=today.getYear();i++){
            LocalDate new_birthday = birthday.withYear(i);
            DayOfWeek dayofBirth = new_birthday.getDayOfWeek();
            System.out.print("BirthDay for Year: "+i+" is = "+dayofBirth+"\n");
        }
    }


    public static void main(String[] args) {
        String userInput = "";
        System.out.println("Please enter as follow :");
        System.out.println("YYYY-MM-DD");
        for (String arg : args) {
            userInput+=arg;
        }
        try {
            LocalDate today = LocalDate.now();
            LocalDate birthday = String_to_Date(userInput);
            System.out.print(today + "\n");
            System.out.print(birthday + "\n");
            Period myAge = calculateBirth(today, birthday);
            System.out.print("Calculated Age : ");
            System.out.print(myAge.getYears() + " Years, " + myAge.getMonths() + " Months and " + myAge.getDays() + " Days");

            System.out.print("\nDAYS OF BIRTHDAY IN EACH YEARS \n");
            DisplayDay(today, birthday);
        }catch(Exception e){
            System.out.println("Please enter as follow :");
            System.out.println("YYYY-MM-DD");

            System.out.print("\nError : Your input is wrong. Please give correct date (check date, month and year\n");
        }
    }
}
