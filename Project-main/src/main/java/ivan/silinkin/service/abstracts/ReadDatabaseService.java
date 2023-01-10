package ivan.silinkin.service.abstracts;

import java.util.HashMap;

public interface ReadDatabaseService {
    HashMap<String, Double> averageValueInGlobalSalesByPlatform();
    void gameWithHighSalesValueInEU();
    void gameWithHighSalesValueInJPGenreSports();
}
