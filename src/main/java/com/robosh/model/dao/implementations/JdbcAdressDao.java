package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.AdressDao;
import com.robosh.model.dao.implementations.queries.AdressSQL;
import com.robosh.model.dao.mappers.AdressMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Adress;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcAdressDao implements AdressDao {

    private static final Logger LOG = Logger.getLogger(JdbcAdressDao.class);
    private Connection connection;

    public JdbcAdressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean checkAdressExist(String street, String number_house) {
        try (PreparedStatement ps = connection.prepareStatement(AdressSQL.READ_BY_ADRESS.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, number_house);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AdressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return true;
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Adress getById(long id) {
        Mapper<Adress> adressMapper = new AdressMapper();
        Adress result = new Adress();
        result.setIdAdress(-1);
        try (PreparedStatement ps = connection.prepareStatement(AdressSQL.READ_BY_ID.getQUERY())) {

            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AdressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = adressMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Adress> findAll() {
        List<Adress> adresses = new ArrayList<>();
        final String query = AdressSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {
            LOG.debug("connection createStatement");
            ResultSet rs = st.executeQuery(query);
            LOG.debug("Executed query" + AdressSQL.READ_ALL);
            Mapper<Adress> adressMapper = new AdressMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Adress adress = adressMapper.getEntity(rs);
                adresses.add(adress);
            }
            return adresses;
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    /**
     * not using
     */
    public void create(Adress entity) {

    }


    @Override
    /**
     * not using
     */
    public boolean update(Adress adress) {
        return false;
    }

    @Override
    /**
     * not using
     */
    public boolean delete(long id) {
        return false;
    }

    @Override
    public void close() {
        try {
            connection.close();
            LOG.debug("Connection closed");
        } catch (SQLException e) {
            LOG.debug(" SQLException occurred");
            throw new RuntimeException(e);
        }
    }
}
