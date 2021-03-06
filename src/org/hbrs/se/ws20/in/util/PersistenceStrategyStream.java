package org.hbrs.se.ws20.in.util;

import org.hbrs.se.ws20.al.exception.PersistenceException;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {
    @Override
    public void openConnection() throws PersistenceException {

    }

    @Override
    public void closeConnection() throws PersistenceException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member, String file) throws PersistenceException  {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            List l = member;
            oos.writeObject(l);
            oos.close();
        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.SaveFailure, "IOException occurred.");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load(String file) throws PersistenceException  {

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                Object obj = ois.readObject();
                List<Member> l = null;
                if(obj instanceof List<?>){
                    l = (List<Member>)obj;
                }
                ois.close();
                return l;
            } catch (ClassNotFoundException e) {
                throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "ClassNotFoundException occurred.");
            }

        } catch (IOException e) {
            throw new PersistenceException(PersistenceException.ExceptionType.LoadFailure, "IOException occurred.");
        }

    }
}
