package eventsample.app;

import eventsample.event.Events;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class SampleService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void doSome() {
        logger.info("raise event");
        Events.raise(new SampleEvent());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }

        Integer result = jdbcTemplate.query("select 1", new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultSet.next();
                return resultSet.getInt(1);
            }
        });
        logger.info("doSome: query result = {}", result);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
        }
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
