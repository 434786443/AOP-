package com.bearfang;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author idea
 * @data 2020/3/7
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContextHolder.getDatabaseHolder();
        return dataSource;
    }
}