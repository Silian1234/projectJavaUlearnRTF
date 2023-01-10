package ivan.silinkin.service.impl;

import ivan.silinkin.dao.abstracts.ReadDatabaseDao;
import ivan.silinkin.dao.impl.ReadDatabaseDaoImpl;
import ivan.silinkin.service.abstracts.ReadDatabaseService;

import java.util.HashMap;

public class ReadDatabaseServiceImpl implements ReadDatabaseService {
    ReadDatabaseDao readDatabaseDao = new ReadDatabaseDaoImpl();

    @Override
    public HashMap<String, Double> averageValueInGlobalSalesByPlatform() {
        return readDatabaseDao.averageValueInGlobalSalesByPlatform();
    }

    @Override
    public void gameWithHighSalesValueInEU() {
        readDatabaseDao.gameWithHighSalesValueInEU();
    }

    @Override
    public void gameWithHighSalesValueInJPGenreSports() {
        readDatabaseDao.gameWithHighSalesValueInJPGenreSports();
    }
}
