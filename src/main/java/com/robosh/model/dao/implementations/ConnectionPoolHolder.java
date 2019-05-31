package com.robosh.model.dao.implementations;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    private static final Logger LOG = Logger.getLogger(ConnectionPoolHolder.class);


    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    LOG.debug("DataSource: " + dataSource);
                    Properties properties = new Properties();
                    String propFileName = "db.properties";
                    LOG.debug("Properties name file: " + propFileName);
                    try (InputStream inputStream = Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream(propFileName)) {
                        LOG.debug("InputStream: " + inputStream);

                        if (inputStream != null) {
                            LOG.debug("inputStream != null");
                            properties.load(inputStream);
                        } else {
                            LOG.debug("property file '" + propFileName + "' not found in the classpath");
                            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                        }

                        Class.forName(properties.getProperty("db.connection.driver"));
                        dataSource = getBasicDataSource(properties);

                    } catch (IOException | ClassNotFoundException e) {
                        LOG.debug("File not found " + propFileName);
                        e.printStackTrace();
                    }
                }
            }
        }

        return dataSource;
    }

    private static BasicDataSource getBasicDataSource(Properties properties) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(properties.getProperty("db.connection.url"));
        ds.setUsername(properties.getProperty("db.connection.username"));
        ds.setPassword(properties.getProperty("db.connection.password"));

        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
        return ds;
    }
}
