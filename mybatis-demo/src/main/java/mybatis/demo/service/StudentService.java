package mybatis.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybatis.demo.dao.StudentMapper;

import mybatis.demo.entity.c_stu;
import mybatis.demo.entity.course;
import mybatis.demo.entity.score;
import mybatis.demo.entity.upwork;
import mybatis.demo.entity.work;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentMapper studentMapper;
	
	public List<course> getallcourse(int id)
	{
		return this.studentMapper.getallcourse(id);
	}
	
	public void joincourse(c_stu c_stu)
	{
		this.studentMapper.joincourse(c_stu);
	}
	
	public void deletecourse(c_stu c_stu)
	{
		this.studentMapper.deletecourse(c_stu);
	}
	
	public course getcoursebyflag(int cflag)
	{
		return this.studentMapper.getcoursebyflag(cflag);
	}
	
	public int getcoursemates(int cflag)
	{
		return this.studentMapper.getcoursemates(cflag);
	}
	
	public List<work> getallwork(int cflag)
	{
		return this.studentMapper.getallwork(cflag);
	}
	
	public void uploadwork(upwork upwork)
	{
		this.studentMapper.uploadwork(upwork);
	}
	
	public List<course> findcourses()
	{
		return this.studentMapper.findcourses();
	}
	
	public List<score> getscores(int id)
	{
		return this.studentMapper.getscores(id);
	}
}
