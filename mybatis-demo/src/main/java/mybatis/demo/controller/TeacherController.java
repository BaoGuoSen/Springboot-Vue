package mybatis.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mybatis.demo.entity.Student;
import mybatis.demo.entity.course;
import mybatis.demo.entity.score;
import mybatis.demo.entity.upwork;
import mybatis.demo.entity.work;
import mybatis.demo.security02.model.User;
import mybatis.demo.service.TeacherService;



@RestController
@RequestMapping("/tea")
public class TeacherController {
	
	@Autowired
	private TeacherService TeacherService;
	
	
	@GetMapping("getallcourse")
	public List<course> getallcourse(int id) {
		return this.TeacherService.getallcourse(id);
	}
	
	@PostMapping("addcourse")
	public void addcourse(@RequestBody course course)
	{
		TeacherService.addcourse(course);
	}
	
	
	@GetMapping("deletecourse")
	public void deletecourse(int id) {
		 this.TeacherService.deletecourse(id);
	}
	
	@PostMapping("updatecourse")
	public void updatecourse(@RequestBody course course)
	{
		this.TeacherService.updatecourse(course);
	}
	
	@GetMapping("getcoursebyflag")
	public course getcoursebyflag(int cflag) {
		return this.TeacherService.getcoursebyflag(cflag);
	}
	
	@GetMapping("getcoursemates")
	public int getcoursemates(int cflag) {
		return this.TeacherService.getcoursemates(cflag);
	}
	
	@GetMapping("getallwork")
	public List<work> getallwork(int cflag) {
		return this.TeacherService.getallwork(cflag);
	}
	
	@PostMapping("addwork")
	public void addwork(@RequestBody work work)
	{
		this.TeacherService.addwork(work);
	}
	
	@GetMapping("deletework")
	public void deletework(int wid) {
		 this.TeacherService.deletework(wid);
	}
	
	@PostMapping("updatework")
	public void updatework(@RequestBody work work)
	{
		this.TeacherService.updatework(work);
	}
	
	@GetMapping("findallstudent")
	public List<User> findallstudent(int cflag) {
		 return this.TeacherService.findallstudent(cflag);
	}
	
	@GetMapping("findteacher")
	public List<User> findteacher(int cflag) {
		 return this.TeacherService.findteacher(cflag);
	}
	
	@GetMapping("findbyname")
	public List<User> findbyname(String name) {
		 return this.TeacherService.findbyname(name);
	}
	
	@GetMapping("findnotup")
	public List<User> findnotup(int wid) {
		 return this.TeacherService.findnotup(wid);
	}
	
	@GetMapping("findup")
	public List<upwork> findup(int wid) {
		 return this.TeacherService.findup(wid);
	}
	
	@GetMapping("addscore")
	public void addscore(@Param("id")int id,@Param("score")int score,@Param("wid")int wid)
	{
		this.TeacherService.addscore(id,score,wid);
	}
	
	@GetMapping("guidang")
	public void guidang(@Param("cflag")int cflag,@Param("state")Boolean state)
	{
		this.TeacherService.guidang(cflag,state);
	}
	
	@GetMapping("recover")
	public void recover(@Param("cflag")int cflag,@Param("state")Boolean state)
	{
		this.TeacherService.recover(cflag,state);
	}
	
	@GetMapping("getscores")
	public List<score> getscores(int cflag) {
		 return this.TeacherService.getscores(cflag);
	}
}
