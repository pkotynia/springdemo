package pl.sda.elevatorex.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.elevatorex.model.Officer;
import pl.sda.elevatorex.model.Rank;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OfficerDaoJdbcTest {

    @Autowired
    private OfficerDaoJdbc officerDao;

    @Test
    void should_save() {
        Officer kirk = officerDao.save(new Officer(0, Rank.OFFICER, "kirk"));
        assertNotNull(kirk);
    }

    @Test
    void should_count() {
        assertEquals(1, officerDao.count());
    }

    @Test
    void should_findAll() {
       assertEquals(1, officerDao.findAll().size());
    }


}