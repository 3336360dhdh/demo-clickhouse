package com.uzbeklion.click

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class DruidConfig {
    @Bean
    fun dataSource(): DataSource {
        val datasource = DruidDataSource()
        datasource.url = "jdbc:clickhouse://127.0.0.1:8123/mvd"
        datasource.driverClassName = "ru.yandex.clickhouse.ClickHouseDriver"
        datasource.initialSize = 10
        datasource.minIdle = 10
        datasource.maxActive = 100
        datasource.maxWait = 6000
        return datasource
    }
}
