package com.ff.service;


import com.ff.dto.Exposer;
import com.ff.entity.Student;

import java.util.List;

/**
 * 业务接口：站在“使用者”的角度去设计接口
 * 三方面：方法定义力度（使用者的行为来定义接口）；参数（简练直接），返回类型（return 类型/异常）
 *
 */
public interface StudentService {
    List<Student> getStudent();

    Student getByid(long sid);

    /**
     * 数据同学姓名
     * @param sid
     */
    Exposer exportName(long sid);
}
