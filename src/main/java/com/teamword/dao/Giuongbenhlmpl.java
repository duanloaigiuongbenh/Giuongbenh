package com.teamword.dao;

import com.teamword.model.Giuongbenh;
import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Giuongbenhlmpl implements GiuongbenhDao {

    private SessionFactory sessionFactory;
  //  private int  test_bean;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){

        return  sessionFactory.getCurrentSession();
    };

    public void create(Giuongbenh gb) {
        try {
            getSession().beginTransaction();
            getSession().save(gb);

            getSession().beginTransaction().commit();
           /* Session session=getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(gb);
            trans.commit(); */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void update(Giuongbenh gb) {
        try {
            getSession().beginTransaction();
            getSession().update(gb);
            getSession().beginTransaction().commit();
           /* Session session=getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(gb);
            trans.commit(); */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

   // @Transactional
    public void delete(int id) {
        try {
            getSession().beginTransaction();
            Giuongbenh gb = (Giuongbenh) getSession().get(Giuongbenh.class,id);
            if(gb!= null ){
                getSession().delete(gb);
            }

           getSession().beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*ham delete su dung truy van HQL  cua hibernate */
// CHÚ Ý:  Bó tay nó ko hỗ trợ dạng insert với values !!!!!!!!
    public void createquery(Giuongbenh gb){
        int id = gb.getId();
        String name = gb.getName();
        BigDecimal price = (BigDecimal) gb.getPrice();
        String description = gb.getDescription();
        try {
            getSession().beginTransaction();
            Query query = getSession().createQuery("INSERT INTO Giuongbenh(name,price,description) SELECT name,price,description FROM Giuongbenh");
          //  query.setParameter("id",id);
           // query.setParameter("name",name);
         //  query.setParameter("price",price);
         //   query.setParameter("description",description);
            query.executeUpdate();
            getSession().beginTransaction().commit();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updatequery (Giuongbenh gb){
       // BigDecimal price = new BigDecimal(100000.0000);
        int id = gb.getId();
        String name = gb.getName();
        BigDecimal price = (BigDecimal) gb.getPrice();
        String description = gb.getDescription();
        try{
            getSession().beginTransaction();
            Query query = getSession().createQuery("UPDATE Giuongbenh set name = :name, price = :price, description = :description " +
                    "WHERE id = :id");
            query.setParameter("id",id);
            query.setParameter("name",name);
            query.setParameter("price",price);
            query.setParameter("description",description);
            query.executeUpdate();
            getSession().beginTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void deletequery(int id) {
        try {
            getSession().beginTransaction();
          //  Giuongbenh gb = (Giuongbenh) getSession().get(Giuongbenh.class,id);
            if(id != 0 ){
                Query query = getSession().createQuery("DELETE FROM Giuongbenh WHERE id = :id");
                query.setParameter("id",id);
                query.executeUpdate();
            }

            getSession().beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    /*ham delete su dung truy van HQL  cua hibernate */

    public Giuongbenh get(int id) {
        Giuongbenh gb = null;
        try {
            getSession().beginTransaction();
            gb = (Giuongbenh) getSession().get(Giuongbenh.class,id);
            getSession().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gb;
    }

    //@Transactional
    public List<Giuongbenh> getall() {
        List<Giuongbenh> Giuongbenhlist = new ArrayList<Giuongbenh>();
        try {
            getSession().beginTransaction();

          //  Giuongbenhlist = getSession().createCriteria(Giuongbenh.class).list();

              Giuongbenhlist = getSession().createQuery("from Giuongbenh").list();

            //Query query = getSession().createQuery("from Giuongbenh");
          // Giuongbenhlist = query.list();
           getSession().getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return Giuongbenhlist;
    }
}
