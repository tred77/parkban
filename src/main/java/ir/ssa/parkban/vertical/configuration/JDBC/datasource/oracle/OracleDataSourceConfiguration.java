package ir.ssa.parkban.vertical.configuration.JDBC.datasource.oracle;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Yeganeh
 */
@Configuration
public class OracleDataSourceConfiguration {

    @Bean
    DataSource dataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("PARKBAN");
        dataSource.setPassword("parkban");
        dataSource.setURL("jdbc:oracle:thin:@198.143.180.4:1521:XE");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

}
