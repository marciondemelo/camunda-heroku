package config;

import javax.sql.DataSource;

import config.entity.CredentialDataBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Locale;

@Configuration
public class DataBaseConnect {
    private final CredentialDataBase credentialDataBase;

    public DataBaseConnect(CredentialDataBase credentialDataBase) {
        this.credentialDataBase = credentialDataBase;
    }

    @Bean
    public DataSource dataSource() {
        if(credentialDataBase.getClassName().toLowerCase(Locale.ROOT).contains("h2")){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(credentialDataBase.getClassName());
            dataSource.setUrl(credentialDataBase.getUrl());
            return dataSource;
        }else{
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(credentialDataBase.getClassName());
            dataSource.setUrl(credentialDataBase.getUrl());
            dataSource.setUsername(credentialDataBase.getUserName());
            dataSource.setPassword(credentialDataBase.getPassword());
            return dataSource;
        }
    }
}
