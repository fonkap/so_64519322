package so_64519322;

import java.sql.SQLException;
import java.util.List;

public interface RunRepository {
    void dropRun(List<Integer> ids) throws SQLException;
}