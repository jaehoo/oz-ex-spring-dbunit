package com.bc;

import com.bc.util.AbstractJUnit4Test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: asanchez
 * Date: 27/06/13
 * Time: 05:30 PM
 *
 * @author <a href="jaehoo@gmail.com">Alberto Sánchez</a>
 *         Contact me by:
 *         <ul><li>Twitter: @jaehoox</li><ul>
 */
public class TestDemo extends AbstractJUnit4Test {

    private static final Logger logger= LoggerFactory.getLogger(TestDemo.class);

    @Test
    public void testName() throws Exception {


        logger.info("============= PRUEBA");


    }
}
