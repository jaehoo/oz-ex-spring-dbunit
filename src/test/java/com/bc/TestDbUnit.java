package com.bc;


import com.bc.dao.UserManagerDao;
import com.bc.util.AbstractDbUnitTest;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/07/12
 * Time: 03:55 PM
 * Author: Lic. José Alberto Sánchez González
 * Twitter: @jaehoox
 * mail: <a href="mailto:jaehoo@gmail.com">jaehoo@gmail.com</a>
 */
public class TestDbUnit extends AbstractDbUnitTest {

    public static final Logger logger= LoggerFactory.getLogger(TestDbUnit.class);

    @Resource(name = "daoUserManager")
    private UserManagerDao userManagerDao;

    @Test
    public void testMakeDB(){
        logger.info("BOO!...");
    }

    @Test
    @DatabaseSetup(value = "classpath:sample-dataset.xml",type = DatabaseOperation.REFRESH)
    public void testListUsers(){
        logger.info("Get All users!...");

        List result= userManagerDao.listAll();
        print(result);
    }





}
