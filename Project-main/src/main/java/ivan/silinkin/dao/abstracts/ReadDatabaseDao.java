package ivan.silinkin.dao.abstracts;
import java.util.HashMap;

public interface ReadDatabaseDao {

   HashMap<String, Double> averageValueInGlobalSalesByPlatform();
   void gameWithHighSalesValueInEU();
   void gameWithHighSalesValueInJPGenreSports();
}
