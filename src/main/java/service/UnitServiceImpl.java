package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UnitDao;
import domain.Unit;
@Service
public class UnitServiceImpl implements UnitService{

    @Autowired
    private UnitDao unitHibDao;
    public UnitDao getUnitDao() {
        return unitHibDao;
    }

    public void setUnitDao(UnitDao unitHibDao) {
        this.unitHibDao = unitHibDao;
    }

    public boolean createUnit(Unit unit) {
        unitHibDao.save(unit);
        return true;
    }

    public List<Unit> getAllUnits() {
        return unitHibDao.findAll(Unit.class);
    }

    public Unit getUnit(String UnitNo) {
        return unitHibDao.get(Unit.class,Integer.parseInt(UnitNo));
    }

    public boolean updateUnit(Unit unit) {
        unitHibDao.update(unit);
        return true;
    }

    public boolean deleteUnit(Unit unit) {
        unitHibDao.delete(unit);
        return true;
    }

}
