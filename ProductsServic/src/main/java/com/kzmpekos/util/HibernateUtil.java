package com.kzmpekos.util;

import com.kzmpekos.products.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class HibernateUtil {
    //Getting one product by id
    public static Product getProductById(int id){

        //Building the session
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        Product product;
        product=(Product)session.get(Product.class,new Integer(id));
        //System.out.println(product.getName());
        factory.close();
        session.close();
        return product;
    }

    //Adding a new product
    public static String addProduct(Product product){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        //Saving the product into the db and shutting down the factory and session entities
        session.save(product);
        transaction.commit();
        //System.out.println("successfully saved");
        factory.close();
        session.close();
        return "Successfully saved";
    }

    //Getting all the available products
    public static List getAllProducts(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        String hql="FROM Product";
        Query query=session.createQuery(hql);
        List results= query.getResultList();
        factory.close();
        session.close();
        return results;
    }

}
