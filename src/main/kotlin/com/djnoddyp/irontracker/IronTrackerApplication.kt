package com.djnoddyp.irontracker

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.support.Repositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [Repositories::class])
class IronTrackerApplication {

    @Autowired
    lateinit var env: Environment

    @Autowired
    lateinit var workoutRepository: WorkoutRepository

    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.url = env.getProperty("spring.datasource.url")
        dataSource.username = env.getProperty("spring.datasource.username")
        dataSource.password = env.getProperty("spring.datasource.password")
        return dataSource
    }

    @Bean
    fun jdbcTemplate() = JdbcTemplate(dataSource())

    @Bean
    fun namedParamJdbcTemplate() = NamedParameterJdbcTemplate(dataSource())

    @Bean
    fun workoutService() = WorkoutService(workoutRepository)


}

fun main(args: Array<String>) {
    runApplication<IronTrackerApplication>(*args)
}
