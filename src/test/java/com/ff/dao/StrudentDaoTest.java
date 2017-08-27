package com.ff.dao;

import com.ff.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 *配置srping和junit的整合，junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring 配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StrudentDaoTest {

    //注入dao实现类依赖
    @Resource
    private StudentDao studentDao;

    @Test
    public void getStudent() throws Exception {
        long id = 02;
        Student student = studentDao.getStudent(id);
        System.out.println(student);
    }

    @Test
    public void queryAll() throws Exception {
    }

}