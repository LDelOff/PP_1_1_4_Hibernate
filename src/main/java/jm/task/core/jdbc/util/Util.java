package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    // Тут настройки подключения
    public static final String url = "jdbc:mysql://localhost:3306/pp_1_1_3-4_jdbc_hibernate";
    public static final String user = "root";
    public static final String pass = "3Iehegf@be";

    private static SessionFactory sessionFactory;

    public static SessionFactory getConnection() {
        try {
            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, url);
            properties.put(Environment.USER, user);
            properties.put(Environment.PASS, pass);
            properties.put(Environment.SHOW_SQL, false);
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return sessionFactory;
    }
}
