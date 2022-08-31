package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Алгоритм работы приложения:
        В методе main класса Main должны происходить следующие операции:
        - Создание таблицы User(ов)
        - Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        - Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
        - Очистка таблицы User(ов)
        - Удаление таблицы
        */
        User user1 = new User("Юзер1", "ФамилияЮзер1", (byte) 1);
        User user2 = new User("Юзер2", "ФамилияЮзер2", (byte) 2);
        User user3 = new User("Юзер3", "ФамилияЮзер3", (byte) 4);
        User user4 = new User("Юзер4", "ФамилияЮзер4", (byte) 3);

        UserService userService = new UserServiceImpl();

        userService.createUsersTable (); // создаю таблицу

        //---Занесение в таблицу людей---//
        saveUserExtension(user1,userService);
        saveUserExtension(user2,userService);
        saveUserExtension(user3,userService);
        saveUserExtension(user4,userService);

        List<User> userList = userService.getAllUsers();//Получение всех User из базы и вывод в консоль

        for (User text : userList)
        {
            System.out.println(text.toString());
        }

        userService.cleanUsersTable(); //Очистка таблицы User(ов)

        userService.dropUsersTable(); // удаление таблицы
    }
    public static void saveUserExtension(User user,UserService userService) {
        userService.saveUser(user.getName(),user.getLastName(),user.getAge());
        System.out.println(new StringBuilder().append("User с именем – ").append(user.getName()).append(" добавлен в базу данных"));
    }
}
