package com.robosh.model.dao.implementations;

import com.robosh.model.dao.interfaces.AddressDao;
import com.robosh.model.dao.implementations.queries.AddressSQL;
import com.robosh.model.dao.mappers.AddressMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Address;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class JdbcAddressDao implements AddressDao {

    private static final Logger LOG = Logger.getLogger(JdbcAddressDao.class);
    private Connection connection;

    public JdbcAddressDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean checkAddressExist(String street, String numberHouse) {
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_BY_ADRESS.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, numberHouse);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_BY_ADRESS);
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
    public long getAddressId(String street, String numberHouse) {
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_ADDRESS_ID.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, numberHouse);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_ADDRESS_ID);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                return rs.getLong("id_adress");
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Address getAddressByStreetNumberHouse(String street, String numberHouse) {
        Mapper<Address> addressMapper = new AddressMapper();
        Address result = new Address();
        result.setIdAddress(-1);
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_BY_ADRESS.getQUERY())) {
            ps.setString(1, street);
            ps.setString(2, numberHouse);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = addressMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Address getById(int id) {
        Mapper<Address> addressMapper = new AddressMapper();
        Address result = new Address();
        result.setIdAddress(-1);
        try (PreparedStatement ps = connection.prepareStatement(AddressSQL.READ_BY_ID.getQUERY())) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            LOG.debug("Executed query" + AddressSQL.READ_BY_ADRESS);
            if (rs.next()) {
                LOG.debug("check is rs has next");
                result = addressMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            LOG.debug("SQLException occurred");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        final String query = AddressSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {
            LOG.debug("connection createStatement");
            ResultSet rs = st.executeQuery(query);
            LOG.debug("Executed query" + AddressSQL.READ_ALL);
            Mapper<Address> adressMapper = new AddressMapper();

            while (rs.next()) {
                LOG.debug("Read objects");
                Address address = adressMapper.getEntity(rs);
                addresses.add(address);
            }
            return addresses;
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
    public void create(Address entity) {

    }

    @Override
    /**
     * not using
     */
    public boolean update(Address address) {
        return false;
    }

    @Override
    /**
     * not using
     */
    public boolean delete(int id) {
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
