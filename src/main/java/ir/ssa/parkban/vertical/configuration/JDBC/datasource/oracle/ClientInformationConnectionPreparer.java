package ir.ssa.parkban.vertical.configuration.JDBC.datasource.oracle;

import org.springframework.data.jdbc.support.ConnectionPreparer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Yeganeh
 */

public class ClientInformationConnectionPreparer implements ConnectionPreparer {

    private static String prepSql = "{ call DBMS_SESSION.SET_IDENTIFIER('SPRING') }";

    @Override
    public Connection prepare(Connection conn) throws SQLException {
        CallableStatement cs = conn.prepareCall(prepSql);
        cs.execute();
        cs.close();
        return conn;
    }
}
