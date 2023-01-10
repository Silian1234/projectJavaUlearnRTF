package ivan.silinkin.service.abstracts;


public interface MigrationToDatabaseService {
    void fillingTableGame();
    void fillingTableSales();
    void fillingTablePlatform();
    void fillingTableGenre();
    void fillingTablePublisher();

    void fillingTableGamesInGenre();

    void fillingTableGamesInPlatform();
    void fillingTableGamesInPublisher();
}
