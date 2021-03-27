package org.hbrs.se.ws20.in.control;

import org.hbrs.se.ws20.al.exception.PersistenceException;
import org.hbrs.se.ws20.in.model.PersistenceStrategy;

import java.util.List;

public class PersistenceStrategyMongoDB<Member> implements PersistenceStrategy<Member> {
    @Override
    public void openConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<Member> member) {
        throw new UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<Member> load() {
        throw new UnsupportedOperationException("Not implemented!");
    }
}