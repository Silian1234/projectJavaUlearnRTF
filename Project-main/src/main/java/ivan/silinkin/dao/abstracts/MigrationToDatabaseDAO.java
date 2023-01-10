package ivan.silinkin.dao.abstracts;


public interface MigrationToDatabaseDAO {
    void fillingTableGame();
    void fillingTableSales();
    void fillingTablePlatform();
    void fillingTableGenre();
    void fillingTablePublisher();
    void fillingTableGamesInGenre();
    void fillingTableGamesInPlatform();
    void fillingTableGamesInPublisher();
}
