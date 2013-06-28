package com.bc;


import com.bc.util.AbstractJUnit4Test;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/07/12
 * Time: 03:55 PM
 * Author: Lic. José Alberto Sánchez González
 * Twitter: @jaehoox
 * mail: <a href="mailto:jaehoo@gmail.com">jaehoo@gmail.com</a>
 */
public class testdb extends AbstractJUnit4Test {

    public static final Logger logger= LoggerFactory.getLogger(testdb.class);

    /*@Resource(name="s2")
    private Service2 srv;

    @Test
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, value = "transactionManager")
    @Rollback(false)
    public void testSave() throws Exception {

        srv.save();
    }
*/

    /*@Resource(name="s1")
    private Service1 test;*/


    @Test
    public void makeDB(){
        logger.info("BOO!...");
    }

    @Test

    @DatabaseSetup(value = "classpath:sample-dataset.xml",type = DatabaseOperation.REFRESH)
    public void fillDB(){
        logger.info("Prepare case...");
    }


}
