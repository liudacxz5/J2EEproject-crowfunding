package com.ranger.j2EE.crowfunding.test;

import com.ranger.j2EE.crowfunding.entity.Admin;
import com.ranger.j2EE.crowfunding.mapper.AdminMapper;
import com.ranger.j2EE.crowfunding.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//在类上标记必要注解，Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

    Logger logger = LoggerFactory.getLogger(CrowdTest.class);
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "jerry", "123123", "汤姆", "jerry@qq.com", null);
        adminService.saveAdmin(admin);
        logger.info("=========================success!!=========================");
    }

    @Test
    public void testInsertAdmin(){
        Admin admin = new Admin(null, "tom", "123123", "汤姆", "tom@qq.com", null);

        int updateCount = adminMapper.insert(admin);

        logger.info(updateCount+"");

    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.info("================================================================================================");
        logger.info(connection.toString());
        logger.info("================================================================================================");

    }
}
