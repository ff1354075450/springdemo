package com.ff.service.impl;

import com.ff.dao.StudentDao;
import com.ff.dto.Exposer;
import com.ff.entity.Student;
import com.ff.enums.StudentEnum;
import com.ff.exception.DemoException;
import com.ff.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import java.util.List;

//@Component @Service @Dao @Controller
@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String salt = "fsdlajfeiow";//延值

    //注入service依赖
    @Autowired//@Resource,@Inject 都是可以的，autowired表示自动注入，不需要自己new实现类
    private StudentDao studentDao;//无需初始化，如果报错请添加myBatis plugin插件，注意不是free myBatis plugin插件

    public List<Student> getStudent() {
        return studentDao.queryAll(0,4);
    }

    public Student getByid(long sid) {
        logger.error("test");
        logger.info("test");
        return studentDao.getStudent(sid);
    }

    /**
     * 使用注解的方式声明事务
     * 使用注解控制事务方法的优点：
     *  1.开发团队达成一致约定，明确标注事务方法的编程风格
     *  2.保证事务方法的执行时间尽可能短，不要穿插其他io操作RPC/http请求，或者剥离到事务方法外部
     *  3.不是所有的方法都需要事务，如只有一天修改操作，只读操作不需要事务控制
     * @param sid
     * @return
     */
    @Transactional
    public Exposer exportName(long sid) {
        throw new DemoException(StudentEnum.BAD);
    }

    private String getMD5(String base){
        base = base+"/"+salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
