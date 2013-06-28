package com.bc.util;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Lic. José Alberto Sánchez González <a href="jaehoo@gmail.com">jaehoo@gmail.com</a>
 * Date: 07/07/12
 * Time: 22:23
 * <p>Twitter: <b>@jaehoox</b></p>
 * <p>Web:</p>
 * <ul>
 * <li>http://jaehoo.wordpress.com</li>
 * <li>http://www.orbitalzero.com</li>
 * <li>http://www.orbitalzero.org</li>
 * </ul>
 */
@RunWith(SpringJUnit4ClassRunner.class)
public interface AbstractTest {

    String APP_CTX="classpath:appcontext.xml";
    String APP_CTX_CORE="classpath:appcontext-bc-core.xml";
    String APP_CTX_DS="classpath:appcontext-ds.xml";

    String TEST_START=" TEST START---------";
    String TEST_READY=" TEST READY---------";
    String TEST_END=" TEST END---------";

    final String MAIN_DS ="classpath:sys_catalogs.xml";
    final String SAMPLE_DS="classpath:sample-dataset.xml";

    final String SYS_CAT="classpath:sys_catalogs.xml";
    final String BAS_CFG="classpath:basic-config.xml";
}
