package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectAllPageHelper(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的方法，分页
        // pageNum: 第几页， 从1开始
        // pageSize: 一页中有多少行数据
        PageHelper.startPage(1,3);
        List<Student> students = dao.selectAll();
        for(Student stu:students){
            System.out.println("foreach--one ==="+stu);
        }
    }
}
