package com.robosh.model.dao.implementations;

import com.robosh.model.dao.ClientDao;
import com.robosh.model.dao.implementations.queries.ClientSQL;
import com.robosh.model.dao.mappers.ClientMapper;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcClientDao implements ClientDao {

    private Connection connection;

    public JdbcClientDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * checks is client registered
     *
     */
    @Override
    public boolean isClientExists(String phoneNumber, String password) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_PHONE_PASSWORD.getQUERY())) {
            ps.setString(1, phoneNumber);
            ps.setString(2, password);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * checks if phone number is free
     *
     * @param phoneNumber
     * @return
     */
    @Override
    public boolean isPhoneNumberExists(String phoneNumber) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_PHONE_NUMBER.getQUERY())) {
            ps.setString(1, phoneNumber);
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
    public boolean isEmailExists(String email) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_EMAIL.getQUERY())) {
            ps.setString(1, email);
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
    public Client getClientByPassPhone(String phoneNumber, String password) {
        Mapper<Client> clientMapper = new ClientMapper();
        Client result = new Client();
        result.setPersonId(-1);
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_PHONE_PASSWORD.getQUERY())) {
            ps.setString(1, phoneNumber);
            ps.setString(2, password);

            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = clientMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void create(Client client) {
        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.INSERT.getQUERY())) {
            ps.setString(1, client.getSurname());
            ps.setString(2, client.getName());
            ps.setString(3, client.getPhoneNumber());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client getById(long id) {
        Mapper<Client> clientMapper = new ClientMapper();
        Client result = new Client();
        result.setPersonId(-1);

        try (PreparedStatement ps = connection.prepareStatement(ClientSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = clientMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        final String query = ClientSQL.READ_ALL.getQUERY();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Client> clientMapper = new ClientMapper();

            while (rs.next()) {
                Client student = clientMapper.getEntity(rs);
                clients.add(student);
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
    *not using yet
     */
    @Override
    public boolean update(Client client) {
        return false;
    }

    /**
     * not using
     */
    @Override
    public boolean delete(long id) {
        return false;
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
