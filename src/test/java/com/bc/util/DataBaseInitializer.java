package com.bc.util;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.datatype.DefaultDataTypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Lic. José Alberto Sánchez González <a href="jaehoo@gmail.com">jaehoo@gmail.com</a>
 * Date: 07/07/12
 * Time: 22:16
 * <p>Twitter: <b>@jaehoox</b></p>
 * <p>Web:</p>
 * <ul>
 * <li>http://jaehoo.wordpress.com</li>
 * <li>http://www.orbitalzero.com</li>
 * <li>http://www.orbitalzero.org</li>
 * </ul>
 */
public class DataBaseInitializer {

    public static final Logger LOG= LoggerFactory.getLogger(DataBaseInitializer.class);

    @javax.annotation.Resource(name = "util.iDatabaseConnection")
    private IDatabaseConnection connection;

    @javax.annotation.Resource(name = "util.dbunit.DataTypeFactory")
    private DefaultDataTypeFactory dataTypeFactory;

    @PostConstruct
    //@DatabaseSetup(value = {AbstractTest.SYS_CAT}, type = DatabaseOperation.REFRESH)
    public void load(){
      LOG.info( "... LOAD");

        //connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,dataTypeFactory);

    }


    @PreDestroy
    public void unload(){
        LOG.info( "... DESTROY");

    }

}
