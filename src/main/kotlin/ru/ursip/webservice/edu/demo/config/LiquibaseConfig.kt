package ru.ursip.webservice.edu.demo.config

import liquibase.integration.spring.SpringLiquibase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class LiquibaseConfig {

    @Autowired
    lateinit var currentDataSource: DataSource

    @Bean
    fun liquibase() = SpringLiquibase().apply {
        changeLog = "classpath:/db/liquibase-changelog.xml"
        dataSource = currentDataSource
        defaultSchema = currentDataSource.connection.schema
        isDropFirst = false
    }
}