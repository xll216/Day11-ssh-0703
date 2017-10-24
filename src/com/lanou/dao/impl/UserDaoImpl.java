package com.lanou.dao.impl;

import com.lanou.dao.UserDao;
import com.lanou.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Override
    public boolean login(String name, String psw) {
        Session session = sessionFactory.getCurrentSession();
        /*如果在spring配置文件中引入了事务切面 则不需要再手动调用事务*/
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(
                "from User where name=:na and password=:psw");
        //设置参数
        query.setParameter("na", name);
        query.setParameter("psw", psw);

        List<User> users = query.list();

        transaction.commit();
        return users.size() > 0;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
