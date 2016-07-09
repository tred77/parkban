package ir.ssa.parkban.vertical.configuration.data.JDBC.datasource.oracle;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @author Yeganeh
 */
@Aspect
@Component
@ImportResource("classpath:/aop/dataconnection/aop-connection.xml")
public class JDBCConnectionCustomization {

}
