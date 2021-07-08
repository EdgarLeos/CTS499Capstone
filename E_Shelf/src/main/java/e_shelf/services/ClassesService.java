package e_shelf.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_shelf.domains.info.ClassesInfo;
import e_shelf.repositories.ClassRepository;
import e_shelf.repositories.ResourceRepository;
import e_shelf.repositories.SchoolRepository;
import e_shelf.repositories.TeacherRepository;
import e_shelf.repositories.UserRepository;
import e_shelf.domains.database.Class;
import e_shelf.domains.database.Teacher;

@Service
public class ClassesService {
	
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
	
	public ClassesInfo getClassesInfo(int id_class) {
		List<Class> classes = classRepository.findById(id_class);
		if(classes !=null && !classes.isEmpty()) {
			Class dBClass = classRepository.findById(id_class).get(0);
			ClassesInfo classInfo = new ClassesInfo();
			classInfo.setId_class(dBClass.getId_class());
			classInfo.setClass_name(dBClass.getClass_name());
			classInfo.setSchool(dBClass.getSchool().getSchool_name());
			List<String>classes_teachers = new ArrayList<String>();
			for(Teacher class_teacher:dBClass.getClass_has_teacher()) {
				classes_teachers.add(class_teacher.getTeacher_name());
				
			}
			classInfo.setTeachers(classes_teachers);
			
			return classInfo;
		}else {
			return null;
		}
	}
	

}