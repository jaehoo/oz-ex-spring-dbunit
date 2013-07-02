package com.bc;


import com.bc.util.AbstractDbUnitTest;
import com.bc.util.AbstractJUnit4Test;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/07/12
 * Time: 03:55 PM
 * Author: Lic. José Alberto Sánchez González
 * Twitter: @jaehoox
 * mail: <a href="mailto:jaehoo@gmail.com">jaehoo@gmail.com</a>
 */
public class testdb extends AbstractDbUnitTest {

    public static final Logger logger= LoggerFactory.getLogger(testdb.class);

    @Test
    public void makeDB(){
        logger.info("BOO!...");
    }

    @Test
    @DatabaseSetup(value = "classpath:sample-dataset.xml",type = DatabaseOperation.REFRESH)
    @Rollback(false)
    public void fillDB(){
        logger.info("Fill table ...");
    }






}
