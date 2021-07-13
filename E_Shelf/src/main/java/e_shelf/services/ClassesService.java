package e_shelf.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_shelf.domains.info.ClassesInfo;
import e_shelf.repositories.ClassRepository;
import e_shelf.repositories.ResourceRepository;
import e_shelf.repositories.SchoolRepository;
import e_shelf.repositories.TeacherRepository;
import e_shelf.repositories.UserRepository;
import e_shelf.domains.database.Class;
import e_shelf.domains.database.School;
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
	
	@Autowired
	SchoolService schoolService;
	
	public void addClass(ClassesInfo classInfo) {
		
		Class newClass = new Class();
		newClass.setClass_name(classInfo.getClass_name());
		
		School school = schoolService.getSchool(classInfo.getSchool());
		newClass.setSchool(school);
		Set<Teacher> teachers = new HashSet<Teacher>();
		List<Class>existing = classRepository.findById(classInfo.getId_class());
		if(existing != null) {
			newClass.setId_class(existing.get(0).getId_class());
			teachers = existing.get(0).getClass_has_teacher();
			}
		

		newClass.setClass_has_teacher(teachers);
		
		classRepository.save(newClass);
		
	}
	
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
