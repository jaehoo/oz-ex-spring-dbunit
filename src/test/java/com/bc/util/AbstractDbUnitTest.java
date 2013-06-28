package com.bc.util;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @author: Lic. José Alberto Sánchez González <a href="jaehoo@gmail.com">jaehoo@gmail.com</a>
 * Date: 07/07/12
 * Time: 22:13
 * <p>Twitter: <b>@jaehoox</b></p>
 * <p>Web:</p>
 * <ul>
 * <li>http://jaehoo.wordpress.com</li>
 * <li>http://www.orbitalzero.com</li>
 * <li>http://www.orbitalzero.org</li>
 * </ul>
 */

@ContextConfiguration(locations = {
          AbstractTest.APP_CTX
        , AbstractTest.APP_CTX_DS
})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        //TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
//@Transactional(value = "transactionManager")
/*@it.openutils.testing.DbUnitConfiguration(
        dbUnitExecutions = {
                @it.openutils.testing.DbUnitExecution(

                        datasets = {"classpath:sys_catalogs.xml" },
                        dataTypeFactory = MySqlDataTypeFactory.class,
                        dataSource = "ds.main",
                        schema = "buro_db",
                        features = {
                                @it.openutils.testing.DbUnitFeature(
                                        key = DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES,
                                        value = true)
                        }
                )
        }
)*/
@DbUnitConfiguration(databaseConnection = "util.iDatabaseConnection")
public abstract class AbstractDbUnitTest extends AbstractTransactionalJUnit4SpringContextTests
        implements AbstractTest{

    public static final Logger logger = LoggerFactory.getLogger(AbstractDbUnitTest.class);

    @Autowired protected DataBaseInitializer dataBaseInitializer;

    @Before public  void setup(){       logger.info(TEST_START);    }
    @After public  void end(){        logger.info(TEST_END);    }


    protected void printList(List list){

        for(Object o: list){

            if(o instanceof List){
                printList((List)o);
            }else {
                logger.debug("{}",o);
            }

        }

    }
    protected void print(Object o){

        if(o instanceof List){

            for(Object ox: (List)o){
                logger.info("{}", ox);
            }

        }
        else{
            logger.info("{}", o);
        }

    }


}
