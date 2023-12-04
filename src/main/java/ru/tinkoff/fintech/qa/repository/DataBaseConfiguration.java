package ru.tinkoff.fintech.qa.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "fintechEntityManagerFactory",
        transactionManagerRef = "fintechTransactionManager",
        basePackages = "ru.tinkoff.fintech.qa")
public class DataBaseConfiguration {
    @Bean(name = "fintechEntityManagerFactory")
    @Primary
    @Qualifier("postgresEm")
    public LocalContainerEntityManagerFactoryBean fintechEntityManagerFactory(
            @Qualifier("fintechDataSource") DataSource fintechDataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        entityManagerFactoryBean.setDataSource(fintechDataSource);
        entityManagerFactoryBean.setPackagesToScan("ru.tinkoff.fintech.qa");
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
        return entityManagerFactoryBean;
    }

    @Bean(name = "fintechTransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("fintechEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
