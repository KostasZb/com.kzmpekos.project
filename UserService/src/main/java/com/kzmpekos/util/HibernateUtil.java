package com.kzmpekos.util;

import com.kzmpekos.users.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HibernateUtil {
    //Getting user by username and password
    public static User getUser(String email,String password){
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();
        User user=new User();

        //Finding the user in the db
        try{
            String hql="FROM User WHERE User.email="+email +"AND User.password="+password;
            Query query=session.createQuery(hql);
            user=(User) query.getResultList().get(0);
            factory.close();
            session.close();

        }catch(Exception e){

        }
        return user;
    }

    //Adding a new user
    public static String addUser(User user){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        factory.close();
        session.close();
        return "Successfully added user";

    }
}
