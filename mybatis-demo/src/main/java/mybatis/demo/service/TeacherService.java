package mybatis.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.demo.dao.TeacherMapper;
import mybatis.demo.entity.course;
import mybatis.demo.entity.score;
import mybatis.demo.entity.upwork;
import mybatis.demo.entity.work;
import mybatis.demo.security02.mapper.UserMapper;
import mybatis.demo.security02.model.User;

@Service
@Transactional
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	
	public List<course> getallcourse(int id)
	{
		return teacherMapper.getallcourse(id);
	}
	
	public void addcourse(course course)
	{
		course.setState(true);
		this.teacherMapper.addcourse(course);
	}
	
	public void updatecourse(course course)
	{
		this.teacherMapper.updatecourse(course);
	}
	

	public void deletecourse(int id)
	{
		this.teacherMapper.deletecourse(id);
	}
	
	public course getcoursebyflag(int cflag)
	{
		return this.teacherMapper.getcoursebyflag(cflag);
	}
	
	public int getcoursemates(int cflag)
	{
		return this.teacherMapper.getcoursemates(cflag);
	}
	
	public List<work> getallwork(int cflag)
	{
		return this.teacherMapper.getallwork(cflag);
	}
	
	public void addwork(work work)
	{
		this.teacherMapper.addwork(work);
	}
	
	public void deletework(int wid)
	{
		this.teacherMapper.deletework(wid);;
	}
	
	public void updatework(work work)
	{
		this.teacherMapper.updatework(work);
	}
	
	public List<User> findallstudent(int cflag)
	{
		return this.teacherMapper.findallstudent(cflag);
	}
	
	public List<User> findteacher(int cflag)
	{
		return this.teacherMapper.findteacher(cflag);
	}
	
	public List<User> findbyname(String name)
	{
		return this.teacherMapper.findbyname(name);
	}
	
	public List<User> findnotup(int wid)
	{
		return this.teacherMapper.findnotup(wid);
	}
	
	public List<upwork> findup(int wid)
	{
		return this.teacherMapper.findup(wid);
	}
	
	public void addscore(int id,int score,int wid)
	{
		this.teacherMapper.addscore(id,score,wid);
	}
	
	public void guidang(int cflag,boolean state)
	{
		this.teacherMapper.guidang(cflag,state);
	}
	
	public void recover(int cflag,boolean state)
	{
		this.teacherMapper.recover(cflag,state);
	}
	
	public List<score> getscores(int cflag)
	{
		return this.teacherMapper.getscores(cflag);
	}
}
