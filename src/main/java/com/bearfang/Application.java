package com.bearfang;

import annotation.AppDataSource;
import enums.SupportDatasourceEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AppDataSource(datasourceType = {SupportDatasourceEnum.DEV_DB, SupportDatasourceEnum.PRE_DB, SupportDatasourceEnum.PROD_DB})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
