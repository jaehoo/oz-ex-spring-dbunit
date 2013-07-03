package com.bc.dao.impl;

import com.bc.dao.AbstractDao;
import com.bc.dao.UserManagerDao;

import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 3/07/13
 * Time: 11:51 AM
 *
 * @author <a href="jaehoo@gmail.com">Alberto Sánchez</a>
 *         Contact me by:
 *         <ul><li>Twitter: @jaehoox</li><ul>
 */
public class DbUserManager extends AbstractDao implements UserManagerDao{

    @Override
    public List listAll() {
        Query q = em.createQuery("FROM User");
        return q.getResultList();
    }

}
