package e_shelf.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_shelf.domains.database.Teacher;
import e_shelf.domains.database.TeacherHasResource;
import e_shelf.repositories.*;
import e_shelf.domains.info.*;
import e_shelf.domains.database.Class;

@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	ClassRepository classRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public TeacherInfo getTecherInfo(int id_teacher) {
		List<Teacher> teachers = teacherRepository.findById(id_teacher);
		if(teachers!=null && !teachers.isEmpty()) {
			
			Teacher teacher = teacherRepository.findById(id_teacher).get(0);
			System.out.println(teacher.getSchool().getSchool_name());
			TeacherInfo teacherInfo = new TeacherInfo();
			teacherInfo.setId_teacher(teacher.getId_teacher());
			teacherInfo.setLast_name(teacher.getLast_name());;
			teacherInfo.setFirst_name(teacher.getFirst_name());
			teacherInfo.setTeacher_name(teacher.getTeacher_name());
			teacherInfo.setEmail(teacher.getEmail());
			teacherInfo.setLow_grade(teacher.getLow_grade());
			teacherInfo.setHigh_grade(teacher.getHigh_grade());
			teacherInfo.setSchool_name(teacher.getSchool().getSchool_name());
			List<String>teacher_classes = new ArrayList<String>();
			List<String>teacher_resources = new ArrayList<String>();
			for(Class teacher_class:teacher.getClass_has_teacher()) {
				System.out.println(teacher_class.getClass_name());
				teacher_classes.add(teacher_class.getClass_name());	
			}
			for(TeacherHasResource teacherHasResource: teacher.getTeacherHasResource()) {
				teacher_resources.add(teacherHasResource.getResources().getResource_name());
			}
			teacherInfo.setClasses(teacher_classes);
			teacherInfo.setResources(teacher_resources);
								
			return teacherInfo;
		}else {
			return null;
			}

	}
	

}
