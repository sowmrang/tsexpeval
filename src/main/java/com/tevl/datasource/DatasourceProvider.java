package com.tevl.datasource;


import java.util.logging.Logger;

public final class DatasourceProvider {

    private final DataSource configDatasource;
    private final DataSource runtimeDatasource;

    private static final Logger LOGGER = Logger.getLogger(DatasourceProvider.class.getName());

    public DatasourceProvider(DataSource configDatasource,DataSource runtimeDatasource)
    {
        LOGGER.info("Initializing datasource provider with config datasource of type "+
                configDatasource.getClass().getName());
        LOGGER.info("Initializing datasource provider with runtime datasource of type "+
                runtimeDatasource.getClass().getName());

        this.configDatasource = configDatasource;
        this.runtimeDatasource = runtimeDatasource;
    }

    //TODO what is this method for
    public DataSource getConfigDatasource() {
        return configDatasource;
    }

    public DataSource getRuntimeDatasource() {
        return runtimeDatasource;
    }
}
