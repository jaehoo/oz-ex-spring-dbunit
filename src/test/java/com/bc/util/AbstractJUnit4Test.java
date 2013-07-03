package com.bc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

@ContextConfiguration(locations = { AbstractTest.APP_CTX, AbstractTest.APP_CTX_DS})
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public abstract class AbstractJUnit4Test extends AbstractJUnit4SpringContextTests implements AbstractTest{

    public static final Logger logger= LoggerFactory.getLogger(AbstractJUnit4Test.class);

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
