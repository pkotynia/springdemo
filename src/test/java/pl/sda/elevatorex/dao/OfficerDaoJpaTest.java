package pl.sda.elevatorex.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.elevatorex.model.OfficerJpa;
import pl.sda.elevatorex.model.Rank;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OfficerDaoJpaTest {

    @Autowired
    private OfficerDaoJpa dao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Integer> getIds() {
        return jdbcTemplate.query("select id from officer", (rs, num) -> rs.getInt("id"));
    }

    @Test
    void should_save(){
        OfficerJpa result = dao.save(new OfficerJpa(null, Rank.OFFICER, "kirk"));
        assertNotNull(result.getId());
    }
}