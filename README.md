# Springboot-Vue 课程管理系统

  该系统主要参考课堂派实现，互动课堂管理平台，课前，课中，课后全过程管理。
## 技术栈<br>

  1.前端：vue+element-ui+router<br>
  2.后端:springboot+gradle+mybatis<br>
  3.数据:MySql<br>

## 主要功能实现

  1.学生和教师的登录，注册<br>
  2.页面的权限管理<br>
  3.教师管理自己的课程<br>
  4.学生输入课程号，选修课程<br>
  5.教师布置作业<br>
  6.学生提交作业<br>
  7.教师为作业评分<br>
  8.教师查看学生作业的提交状态，及模糊查询<br>

## 截图展示(只展示部分，完整截图查看演示文档)
  1.课程主界面：<br>
![image](https://github.com/BaoGuoSen/Springboot-Vue/blob/master/imgs/class.png)<br>
  2.学生提交作业状态及批阅：<br>
![image](https://github.com/BaoGuoSen/Springboot-Vue/blob/master/imgs/classmates.png)<br>
  3.选修课程界面：<br>
![image](https://github.com/BaoGuoSen/Springboot-Vue/blob/master/imgs/index.png)<br>
  4.注册：<br>
![image](https://github.com/BaoGuoSen/Springboot-Vue/blob/master/imgs/logon.png)<br>

## 技术难点：
  1.跨域<br>
  2.上传的文件存储，重启服务器后文件消失<br>
  3.用户的权限控制<br>

## 解决办法
  1.利用vue-cli创建的项目，自带proxyTable，代理跨域，利用axios的get/post方法调用后端接口，实现数据交互。<br>
  2.在后端配置文件上传的存储路径，将文件保存到本地文件夹，同时将文件的路径和名称插入数据库，调用的时候直接通过数据库获取文件的路径信息，实现引用。<br>
  3.通过后端重写HttpSecurity里的WebSecurityConfigurerAdapter中的方法给用户配置相应的角色，和能访问的路径。前端通过获取用户的角色信息跳转到相应的操作界面。<br>

## 项目收获
  1.对项目的一整套具体开发流程有了较详细的了解。<br>
  2.学会了如何调试项目中遇到的Bug。<br>
  3.前期的数据库的设计一定不要节约时间，要用更长远的目光来设计。
  
## 此项目主要是记录自己的开发过程及心得，如需转载，请注明出处。
