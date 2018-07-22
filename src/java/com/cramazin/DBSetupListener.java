
package com.cramazin;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@DataSourceDefinition(
        name = "java:app/jdbc/cramazin",
        className = "org.apache.derby.jdbc.ClientDataSource",
        url = "jdbc:derby://localhost:1527/",
        databaseName = "CramazinDb",
        user = "javauser",
        password = "javauser")
@WebListener
public class DBSetupListener implements ServletContextListener {
    @Resource(lookup = "java:app/jdbc/cramazin")
    DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("dataManager", new DataManager(dataSource));
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("End of database connection");
    }
}
