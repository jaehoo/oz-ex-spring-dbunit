package com.bc.util;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Lic. José Alberto Sánchez González <a href="jaehoo@gmail.com">jaehoo@gmail.com</a>
 * Date: 08/07/12
 * Time: 11:29
 * <p>Twitter: <b>@jaehoox</b></p>
 * <p>Web:</p>
 * <ul>
 * <li>http://jaehoo.wordpress.com</li>
 * <li>http://www.orbitalzero.com</li>
 * <li>http://www.orbitalzero.org</li>
 * </ul>
 */
public class DbUnitXmlFactory extends AbstractJUnit4Test{

      public static final Logger LOG = LoggerFactory.getLogger(DbUnitXmlFactory.class);

   /* @javax.annotation.Resource(name = "ds.main")
    private DataSource dataSource;*/

    @javax.annotation.Resource(name = "util.iDatabaseConnectionDS")
    private IDatabaseConnection connection;

    @javax.annotation.Resource(name = "util.dbunit.DataTypeFactory")
    private DefaultDataTypeFactory dataTypeFactory;

    /**
     *
     * @throws org.dbunit.DatabaseUnitException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    @Test
    public void makeDataSet() throws DatabaseUnitException, SQLException, IOException {
       /* Class.forName("com.mysql.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/buro_db","root","root");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);*/


        QueryDataSet dataSet = new QueryDataSet(connection);

        connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,dataTypeFactory);

        //dataSet.addTable("BC_RULE", "SELECT * FROM BC_RULE"); //filtered data

        //System Catalogs
        String[] tableNames={
                  "EMPLOYEE"
               /* , "BC_COMM_RULE"
                , "BC_SEGMENT"
                , "BC_SEG_RULE"
                , "BC_REGISTER"
                , "BC_REG_CFG"
                , "BC_ASSIGNED_RULE"*/
                //, "BC_SYS_CFG"
        };


        for(String t: tableNames){

            dataSet.addTable(t);

        }

        /*File dtd=applicationContext.getResource("classpath:exported-ds.dtd").getFile();
        LOG.info("dtd exists?:{}",dtd.exists());
        FlatDtdDataSet.write(dataSet, new FileOutputStream(dtd));*/

        File out=applicationContext.getResource("classpath:exported-ds.xml").getFile();
        LOG.info("out exists?:{}", out.exists());
        FlatXmlDataSet.write(dataSet, new FileOutputStream(out));


        /*// full database export
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream(out));*/


        connection.close();
    }

    public static void main(String[] args) throws Exception
    {

         new DbUnitXmlFactory().makeDataSet();

      /*// database connection
        Class driverClass = Class.forName("org.hsqldb.jdbcDriver");
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:hsqldb:sample", "sa", "");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        // partial database export
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
        partialDataSet.addTable("BAR");
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));

        // full database export
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));

        // dependent tables database export: export table X and all tables that
        // have a PK which is a FK on X, in the right order for insertion
        String[] depTableNames =
                TablesDependencyHelper.getAllDependentTables(connection, "X");
        IDataSet depDataset = connection.createDataSet( depTableNames );
        FlatXmlDataSet.write(depDataset, new FileOutputStream("~/dependents.xml"));*/

    }

}
