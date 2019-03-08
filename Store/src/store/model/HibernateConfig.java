package store.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



/*public class HibernateConfig {

    private SessionFactory sessionFactory;

    public HibernateConfig() {
        Configuration config = new Configuration();

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/store");
        config.setProperty("hibernate.connection.username", "takadre");
        config.setProperty("hibernate.connection.password", "password");

        config.setProperty("hibernate.connection.pool.size", "10");
        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

        //config.setProperty("hibernate.hbm2dd1.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        config.setProperty("hibernate.current_session_context_class", "threads");

        config.addAnnotatedClass(store.model.User.class);
        config.addAnnotatedClass(store.model.PhoneNumber.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}*/
