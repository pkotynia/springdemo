package pl.sda.elevatorex.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.sda.elevatorex.model.Officer;
import pl.sda.elevatorex.model.OfficerJpa;
import pl.sda.elevatorex.model.Rank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class OfficerDaoJdbc implements OfficerDao<Officer> {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertOfficer;

    public OfficerDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officer")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Officer save(Officer officer) {
        Map<String, Object> parameters = new TreeMap<>();
        parameters.put("rank", officer.getRank());
        parameters.put("name", officer.getName());
        Integer officerId = insertOfficer.execute(parameters);
        officer.setId(officerId);
        return officer;
    }

    @Override
    public Optional<Officer> findById(Integer id) {
        String query = "SELECT * FROM officer WHERE id=?";
        RowMapper<Officer> rowMapper = new RowMapper<Officer>() {
            @Override
            public Officer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Officer(
                        rs.getInt("id"),
                        Rank.valueOf(rs.getString("rank")),
                        rs.getString("name"));
            }
        };

        return Optional.ofNullable(jdbcTemplate.queryForObject(query, rowMapper, id));
    }

    @Override
    public List<Officer> findAll() {
        String query = "SELECT * FROM officer";
        RowMapper<Officer> rowMapper = new RowMapper<Officer>() {
            @Override
            public Officer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Officer(
                        rs.getInt("id"),
                        Rank.valueOf(rs.getString("rank")),
                        rs.getString("name"));
            }
        };
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(*) from officer", Long.class);
    }

    @Override
    public void delete(Officer officer) {
        jdbcTemplate.update("DELETE FROM officer WHERE id=?", officer.getId());

    }
}
