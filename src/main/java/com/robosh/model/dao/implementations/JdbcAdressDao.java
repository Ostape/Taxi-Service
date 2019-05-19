package com.robosh.model.dao.implementations;

import com.robosh.model.dao.AdressDao;
import com.robosh.model.dao.implementations.queries.AdressSQL;
import com.robosh.model.dao.mappers.AdressMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Adress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcAdressDao implements AdressDao {

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
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * not
     */
    public void create(Adress entity) {

    }

    @Override
    public Adress getById(long id) {
        Mapper<Adress> adressMapper = new AdressMapper();
        Adress result = new Adress();
        result.setIdAdress(-1);

        try (PreparedStatement ps = connection.prepareStatement(AdressSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = adressMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Adress> findAll() {
        List<Adress> adresses = new ArrayList<>();
        final String query = AdressSQL.READ_ALL.getQUERY();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Adress> adressMapper = new AdressMapper();

            while (rs.next()) {
                Adress adress = adressMapper.getEntity(rs);
                adresses.add(adress);
            }
            return adresses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            //todo optional
        }
    }

    @Override
    /**
     * not
     */
    public void update(Adress adress) {

    }

    @Override
    /**
     * not
     */
    public void delete(long id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
