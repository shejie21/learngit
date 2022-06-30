package com.qut;

import com.qut.dao.StudentDao;
import com.qut.domain.Student;
import com.qut.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);


        System.out.println("dao="+dao.getClass().getName());

        List<Student> students = dao.selectStudents();
        for(Student stu: students){
            System.out.println("学生="+stu);
        }
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession  = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(1007);
        student.setName("李飞");
        student.setEmail("dunshan@qq.com");
        student.setAge(28);
        int nums = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加对象的数量："+nums);
    }
    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession  = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1003);//要修改的 id
        student.setAge(30); //要修改的年龄值
        int rows = sqlSession.update(
                "com.qut.dao.StudentDao.updateStudent",student);
        sqlSession.commit();
        System.out.println("修改记录的行数:"+rows);
        sqlSession.close();
    }
    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession  = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);
        int id = 1001;
        int rows = sqlSession.delete(
                "com.qut.dao.StudentDao.deleteStudent",id);
        sqlSession.commit();
        System.out.println("修改记录的行数:"+rows);
        sqlSession.close();
    }
}
