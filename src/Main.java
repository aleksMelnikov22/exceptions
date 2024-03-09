import exceptions.DataCountException;
import exceptions.DataFormatException;
import impl.Repository;
import impl.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String command;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите команду new - n/exit - e");
            command = in.nextLine();
            if (command.equals("e")) {
                break;
            }
            if (command.equals("n")) {
                try {
                    System.out.println("Введите данные в виде: Фамилия Имя Отчество дата_рождения номер_телефона пол(m - мужской, f - женский: )");
                    String inputString = in.nextLine();
                    User user = new User(inputString);
                    Repository repository = new Repository();
                    repository.writeUser(user);
                } catch (DataCountException | DataFormatException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                System.out.println("Неверная команда");
            }
        }
    }
}