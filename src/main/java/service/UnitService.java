package service;

import domain.Unit;

import java.util.List;

/**
 * Created by cqx on 16/6/7.
 */
public interface UnitService {

    boolean createUnit(Unit unit);

    public List<Unit> getAllUnits();

    Unit getUnit(String UnitNo);

    boolean updateUnit(Unit unit);

    boolean deleteUnit(Unit unit);
}
