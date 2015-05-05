/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan;

import com.ddabadi.keuangan.dao.HistoryDao;
import com.ddabadi.keuangan.dao.JenisTransaksiDao;
import com.ddabadi.keuangan.dao.KwitansiDao;
import com.ddabadi.keuangan.dao.ParamsDao;
import com.ddabadi.keuangan.dao.TempTransaksiDao;
import com.ddabadi.keuangan.dao.TransaksiHdDao;
import com.ddabadi.keuangan.dao.UrutNoTransaksiDao;
import com.ddabadi.keuangan.dao.impl.HistoryDaoImpl;
import com.ddabadi.keuangan.dao.impl.JenisTransaksiDaoImpl;
import com.ddabadi.keuangan.dao.impl.KwitansiDaoImpl;
import com.ddabadi.keuangan.dao.impl.ParamsDaoImpl;
import com.ddabadi.keuangan.dao.impl.TempTransaksiDaoImpl;
import com.ddabadi.keuangan.dao.impl.TransaksiHdDaoImpl;
import com.ddabadi.keuangan.dao.impl.UrutNoTransaksiDaoImpl;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author win7
 */

@Configuration
@ComponentScan(basePackages = "com.ddabadi.keuangan")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ddabadi.keuangan")
@PropertySource(value = "classpath:jdbc.properties")
public class AppConfig {
    
    @Autowired Environment environment;
    
    @Bean 
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        
        return dataSource;
    }
    
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter =new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setGenerateDdl(Boolean.TRUE);
        hibernateJpaVendorAdapter.setShowSql(Boolean.TRUE);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.ddabadi.keuangan");
        factoryBean.setJpaProperties(properties);
        factoryBean.setPersistenceUnitName("EntityManager");
        return factoryBean;
    }


    @Bean(name = "transactionManager")
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
        return transactionManager;
    };
    
    @Bean(name="transaksiHdDao")
    public TransaksiHdDao transaksiHdFunc(){
        return new TransaksiHdDaoImpl();
    };
    
    @Bean(name="jenisTransaksiDao") 
    public JenisTransaksiDao  jenisTransaksiFunc() {
        return new JenisTransaksiDaoImpl();
    };        
    
    @Bean(name="paramsDao") 
    public ParamsDao  paramsFunc() {
        return new ParamsDaoImpl();
    };
    
    @Bean(name="historyDao")
    public HistoryDao historyFunc(){
        return new HistoryDaoImpl();
    };
            
    @Bean(name="urutNoTransaksiDao")
    public UrutNoTransaksiDao urutNoTransaksiFunc(){
        return new UrutNoTransaksiDaoImpl();
    };
    
    @Bean(name="tempTransaksiDao")
    public TempTransaksiDao tempTransaksiDaoFunc(){
        return new TempTransaksiDaoImpl();
    }
    
    @Bean(name="kwitansiDao")
    public KwitansiDao kwitansiDaoFunc(){
        return new KwitansiDaoImpl();
    }
}
