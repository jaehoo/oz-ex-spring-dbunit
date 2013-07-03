package com.bc.dao;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 3/07/13
 * Time: 11:48 AM
 *
 * @author <a href="jaehoo@gmail.com">Alberto Sánchez</a>
 *         Contact me by:
 *         <ul><li>Twitter: @jaehoox</li><ul>
 */
public interface GenericDao<T,K extends Serializable> {

    public void save(T t);

    public void delete(T t);

    public T update(T t) ;

    public T find(Class clase, K id);

    public void flush();

    public void clear();
}
