import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class  CustomException extends Exception {

    public CustomException(String str) {
        super();
        System.out.println(str);
    }
}

public class PhoneBook {

    public static Map<String, Person> map =  new HashMap<String, Person>();

    public static void addPerson( String name, String number) {
        Person person = new Person( name, number);
        map.put(name, person);

        operations();
    }

    public static void deletePerson(String name) throws CustomException {
        if (map.containsKey(name)) {
            map.remove(name);
            System.out.println("Successfully Delete from the List !!");
        }else {
            throw new CustomException("Not Found Exception");
        }

        operations();
    }

    public static void searchPerson(String name) throws CustomException {
        if (map.containsKey(name)) {
            System.out.println("PhoneBook: - " + map.get(name));
        }else {
            throw new CustomException("Not Found Exception");
        }

        operations();
    }

    public static void perList() {
        System.out.println(map.toString());
    }


    public static void operations() {
        System.out.println("\n ****** Person PhoneBook ******");
        System.out.println("1. Add Person");
        System.out.println("2. Delete Person");
        System.out.println("3. Search Person");
        System.out.println("4. PhoneBook List");
        System.out.println("5. Exit");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("Enter PhoneBook(Name | number)");
                Scanner scanner1 = new Scanner(System.in);

                String name = scanner1.next();
                String number = scanner1.next();
                if (!name.equals("") && !number.equals("")){
                    addPerson(name, number);
                }
                break;

            case 2:
                System.out.println("Enter person name: ");
                Scanner scanner2 = new Scanner(System.in);

               String name1 = scanner2.next();
                try {
                    deletePerson(name1);
                }catch (CustomException e){
                    e.printStackTrace();
                }
                break;

            case 3:
                System.out.println("Enter person name: ");
                Scanner scanner3 = new Scanner(System.in);

                String name2 = scanner3.next();
                try {
                    searchPerson(name2);
                }catch (CustomException e){
                    e.printStackTrace();
                }
                operations();
                break;

            case 4:
                perList();

                operations();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Please choose again");
        }
    }
}