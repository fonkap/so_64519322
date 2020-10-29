package so_64519322;

import java.sql.SQLException;
import java.util.List;

public class ProjectImpl implements Project{
    private RunRepository runRepository;

    public ProjectImpl(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @Override
    public void purge() throws SQLException {
        //some piece of code
        List<Integer> ids = null;

        try {
            runRepository.dropRun(ids);
        } catch (Exception e) {
            System.out.println("Error purging completed runs.");
            throw e;
        }
    }
}