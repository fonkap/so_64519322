package so_64519322;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.Mockito.doThrow;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ProjectImplTest {

    private Project project;

    @Mock
    private RunRepository runRepository;

    @BeforeEach
    public void setUp() {
        //some piece of code
        project = new ProjectImpl(runRepository);
    }

    @Test
    public void GIVEN_non_empty_completed_runs_WHEN_purge_is_invoked_THEN_dropRun_is_invoked()
            throws SQLException {

        doThrow(SQLException.class).when(runRepository).dropRun(any());

        //Then
        assertThrows(SQLException.class, () -> project.purge());
    }

    @Test
    public void GIVEN_non_empty_completed_runs_WHEN_purge_is_invoked_THEN_dropRun_is_invoked2()
            throws SQLException {

        willAnswer(invocation -> {
            throw new SQLException();
        }).given(runRepository).dropRun(any());

        //Then
        assertThrows(SQLException.class, () -> project.purge());
    }

}