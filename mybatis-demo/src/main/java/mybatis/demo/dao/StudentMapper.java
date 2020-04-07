package mybatis.demo.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import mybatis.demo.entity.c_stu;
import mybatis.demo.entity.course;
import mybatis.demo.entity.score;
import mybatis.demo.entity.upwork;
import mybatis.demo.entity.work;

@Mapper
public interface StudentMapper {
	
	List<course> getallcourse(int id);//查找自己选择的课程
	
	void joincourse(c_stu c_stu);
	
	void deletecourse(c_stu c_stu);
	
	course getcoursebyflag(int cflag);
	int getcoursemates(int cflag);
	
	List<work> getallwork(int cflag);
	void uploadwork(upwork upwork);
	
	List<course> findcourses();//查找已有的全部课程，确保输入的课程码是存在的
	
	List<score> getscores(int id);
}
