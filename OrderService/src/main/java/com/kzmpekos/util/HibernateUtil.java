package com.kzmpekos.util;

import com.kzmpekos.commissions.Commission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import java.util.List;

public class HibernateUtil {
    //Adding a new order
    public static String addCommission(Commission commission){
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(commission);
        transaction.commit();
        factory.close();
        session.close();
        return "successfully added order";
    }
    
    //Retrieving a list of orders placed by the user
    public static List<Commission> retrieveOrdersByUserId(int userId){
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();
        List<Commission> commissions;
        try{
            String hql="FROM Commission WHERE Commission.UserId="+userId;
            Query query=session.createQuery(hql);
            commissions=query.getResultList();
            factory.close();
            session.close();
        }catch (Exception e){
            commissions=null;
        }
        return commissions;
    }
}
