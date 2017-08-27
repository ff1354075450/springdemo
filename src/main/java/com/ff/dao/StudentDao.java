package com.ff.dao;

import com.ff.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ff on 2017/8/27.
 */
public interface StudentDao {

    public Student getStudent(@Param("sid") long sid);

    /**
     * 根据偏移量查询所有学生信息
     *
     * @param offet
     * @param limit
     * @return
     */
    List<Student> queryAll(@Param("offset") int offet, @Param("limit") int limit);

}
