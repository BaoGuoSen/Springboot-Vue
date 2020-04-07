package mybatis.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mybatis.demo.entity.c_stu;
import mybatis.demo.entity.course;
import mybatis.demo.entity.score;
import mybatis.demo.entity.upwork;
import mybatis.demo.entity.work;
import mybatis.demo.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("joincourse")
	public void joincourse(@RequestBody c_stu c_stu) {
		this.studentService.joincourse(c_stu);
	}
	
	@GetMapping("getallcourse")
	public List<course> getallcourse(int id) {
		return this.studentService.getallcourse(id);
	}
	
	@PostMapping("deletecourse")
	public void deletecourse(@RequestBody c_stu c_stu) {
		this.studentService.deletecourse(c_stu);
	}
	
	@GetMapping("getcoursebyflag")
	public course getcoursebyflag(int cflag) {
		return this.studentService.getcoursebyflag(cflag);
	}
	
	@GetMapping("getcoursemates")
	public int getcoursemates(int cflag) {
		return this.studentService.getcoursemates(cflag);
	}
	
	@GetMapping("getallwork")
	public List<work> getallwork(int cflag) {
		return this.studentService.getallwork(cflag);
	}
	
	@PostMapping("uploadwork")
	public void uploadwork(@RequestBody upwork upwork)
	{
		this.studentService.uploadwork(upwork);
	}
	
	@GetMapping("findcourses")
	public List<course> findcourses() {
		return this.studentService.findcourses();
	}
	
	@GetMapping("getscores")
	public List<score> getscores(int id) {
		return this.studentService.getscores(id);
	}
}
