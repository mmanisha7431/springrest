package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceimpl implements CourseService {

	//List<Course>List;
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceimpl() {
	/*List=new ArrayList<>();
	List.add(new Course(123,"java core course","this is basic of java") );
	List.add(new Course(124,"advance java","this is  more than  basic of java") );
	List.add(new Course(125,"frameworks of java","like spring,sringboot") );
	List.add(new Course(126,"database","h2") );

	*/	
	}
	
	
	@Override
	public List<Course> getCourses() {
		
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
/*Course c=null;

for(Course course:List)
{
	if(course.getId()==courseId)
	{
		c=course;
		break;
	}
}
*/
		return courseDao.getById(courseId);
	}


	@Override
	public Course addCourse(Course course) {
     //  List.add(course);
		courseDao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		/*
List.forEach(e ->{
	if(e.getId()==course.getId()){
		e.setTitle(course.getTitle());
		e.setDescription(course.getDescription());
	}
});*/
		courseDao.save(course);
		
		return course;
		
	}


	@Override
	public void deleteCourse(long parselong) {
  //List=this.List.stream().filter(e->e.getId()!=parselong).collect(Collectors.toList() );
		Course entity=courseDao.getById(parselong);
		courseDao.delete(entity);
	}

}
