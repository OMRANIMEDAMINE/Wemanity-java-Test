/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.util.List;

/**
 *
 * @author OMRANI
 */
public interface IDAO<T> {
    public boolean insert(T e);
    public boolean update(T e,int var);
    public boolean delete(T e);
    public List<T> getAll();
    public T findByINT(int var);
    public List<T> findByString(String var);
}
