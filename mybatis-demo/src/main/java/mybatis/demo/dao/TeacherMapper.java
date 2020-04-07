package mybatis.demo.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mybatis.demo.entity.course;
import mybatis.demo.entity.score;
import mybatis.demo.entity.upwork;
import mybatis.demo.entity.work;
import mybatis.demo.security02.model.User;

@Mapper
public interface TeacherMapper {
	
	List<course> getallcourse(int id);
	void addcourse(course course);
	
	void deletecourse(int id);
	void updatecourse(course course);
	
	course getcoursebyflag(int cflag);
	int getcoursemates(int cflag);
	
	List<work> getallwork(int cflag);
	void addwork(work work);
	
	void deletework(int wid);
	void updatework(work work);
	
	List<User> findallstudent(int cflag);
	List<User> findteacher(int cflag);
	
	List<User> findbyname(String name);
	
	List<User> findnotup(int wid);
	List<upwork> findup(int wid);
	
	void addscore(@Param("id")int id,@Param("score")int score,@Param("wid")int wid);
	
	void guidang(@Param("cflag")int cflag,@Param("state")Boolean state);
	void recover(@Param("cflag")int cflag,@Param("state")Boolean state);
	
	List<score> getscores(int cflag);
}
