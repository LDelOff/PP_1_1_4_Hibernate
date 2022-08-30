package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

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
        userService.saveUser(user1.getName(),user1.getLastName(),user1.getAge());
        userService.saveUser(user2.getName(),user2.getLastName(),user2.getAge());
        userService.saveUser(user3.getName(),user3.getLastName(),user3.getAge());
        userService.saveUser(user4.getName(),user4.getLastName(),user4.getAge());

        userService.getAllUsers();//Получение всех User из базы и вывод в консоль

        userService.cleanUsersTable(); //Очистка таблицы User(ов)

        userService.dropUsersTable(); // удаление таблицы
    }
}
