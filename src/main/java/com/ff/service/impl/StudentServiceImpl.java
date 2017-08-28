package com.ff.service.impl;

import com.ff.dao.StudentDao;
import com.ff.dto.Exposer;
import com.ff.entity.Student;
import com.ff.enums.StudentEnum;
import com.ff.exception.DemoException;
import com.ff.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.rmi.StubNotFoundException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String salt = "fsdlajfeiow";//延值

    private StudentDao studentDao;//无需初始化

    public List<Student> getStudent() {
        return studentDao.queryAll(0,4);
    }

    public Student getByid(long sid) {
        logger.error("test");
        logger.info("test");
        return studentDao.getStudent(sid);
    }

    public Exposer exportName(long sid) {
        throw new DemoException(StudentEnum.BAD);

    }

    private String getMD5(String base){
        base = base+"/"+salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
