package com.pramati.lnr.mvc.dao;

import com.pramati.lnr.mvc.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: narendral
 * Date: 2/6/14
 * Time: 11:49 AM
 */
@Repository
public class UserDAO_Impl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        System.out.println(user);
        sessionFactory.getCurrentSession().save(user);
    }
    public List<User> listUser() {
        TestInnerClass test = new TestInnerClass();
        return test.listUser();
    }

    class TestInnerClass
    {

    public List<User> listUser() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
    }

    public User selectUser(Integer userId) {

        List<User> userList= sessionFactory.getCurrentSession().createQuery("from User where id="+userId).list();
        if(userList.iterator().hasNext())
            return userList.iterator().next();
        return null;
    }

    public User updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);


        List<User> userList= sessionFactory.getCurrentSession().createQuery("from User where id="+user.getId()).list();
        if(userList.iterator().hasNext())
            return userList.iterator().next();
        return null;
    }


    public void removeUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (null != user && null != user.getId()) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
