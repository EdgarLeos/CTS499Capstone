package e_shelf.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import e_shelf.domains.database.Teacher;
import e_shelf.domains.database.TeacherHasResource;
import e_shelf.repositories.*;
import e_shelf.domains.info.*;
import e_shelf.domains.database.Class;
import e_shelf.domains.database.Resources;
import e_shelf.services.*;

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
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	ResourceService resourceService;
	
	public void addTacher(TeacherInfo teacherInfo) {
		
		Teacher teacher = new Teacher();
		
		String[] grades = {"Kinder", "1st Grade", "2nd Grade", "3rd Grade", "4th Grade", "5th Grade", "6th Grade", "7th Grade", "8th Grade", "9th Grade", "10th Grade", "11th Grade", "12th Grade"};
		int low_grade = 0;
		int high_grade = 0;
		for(int i = 0; i < grades.length; i ++) {
			if(grades[i] == teacherInfo.getLow_grade()) {
				low_grade = i;
			}
			if(grades[i] == teacherInfo.getHigh_grade()) {
				high_grade = i;
			}
		}
		
		
		teacher.setLast_name(teacherInfo.getLast_name());
		teacher.setFirst_name(teacherInfo.getFirst_name());
		teacher.setTitle(teacherInfo.getTittle());
		teacher.setTeacher_name(teacherInfo.getLast_name() + ", " + teacherInfo.getFirst_name());
		teacher.setEmail(teacherInfo.getFirst_name().substring(0,1).toLowerCase() + teacherInfo.getLast_name().toLowerCase() + "@capstone.k12.ca.us");
		teacher.setTitle(teacherInfo.getTittle());
		teacher.setLow_grade(String.valueOf(low_grade));
		teacher.setHigh_grade(String.valueOf(high_grade));
		teacher.setSchool(schoolService.getSchool(teacherInfo.getSchool_name()));
		//teacher.setId_teacher(teacherInfo.getId_teacher());
		Set<Class> teacher_classes = new HashSet<Class>();
		List<Resources>resources = new ArrayList<Resources>();
		
		List<TeacherHasResource> teacher_resources = new ArrayList<TeacherHasResource>();
		teacher.setTeacherHasResource(teacher_resources);
		

		teacher.setClass_has_teacher(teacher_classes);
		if(!(teacherInfo.getResources()==null)) {
			for(String teacherInfo_resurce: teacherInfo.getResources()) {
				
				Resources resource = resourceRepository.findByResource_name(teacherInfo_resurce);
				
				teacher.getTeacherHasResource().add(resourceService.getTeacherHasResource(resource, teacher));
				
			}

		}
		for(String teacherInfo_class: teacherInfo.getClasses()) {
			teacher.getClass_has_teacher().add(classRepository.findByClass_name(teacherInfo_class));
			}
		
		//System.out.println(teacher.toString());
		
		teacherRepository.save(teacher);

		
		
		
	}
	
	
	public TeacherInfo getTecherInfo(int id_teacher) {
		List<Teacher> teachers = teacherRepository.findById(id_teacher);
		if(teachers!=null && !teachers.isEmpty()) {
			
			Teacher teacher = teacherRepository.findById(id_teacher).get(0);
			//System.out.println(teacher.getSchool().getSchool_name());
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
				//System.out.println(teacher_class.getClass_name());
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
