package e_shelf.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_shelf.domains.database.Teacher;
import e_shelf.domains.database.TeacherHasResources;
import e_shelf.repositories.*;
import e_shelf.domains.info.*;
import e_shelf.domains.database.Class;
import e_shelf.domains.database.School;

@Service
public class SchoolService {
	
	TeacherRepository teacherRepository;
	
	@Autowired
	ClassRepository classRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	ResourceRepository resourceRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void addSchool(School school) {
		schoolRepository.save(school);
	}
	
	public School getSchool(String schoolname)
	{
		List <School> schools = schoolRepository.findByKeyword(schoolname);
		School school = schools.get(0);
		
		return school;
	}
	
	public School getSchoolById(int id) {
		List <School> schools = schoolRepository.findById(id);
		School school = schools.get(0);
		return school;
	}

	public void delete(int id_school) {
		
		List<Class> classes = classRepository.findAll();
		for (Class school_class: classes) {
			if(school_class.getSchool().getId_school() == id_school) {
				classRepository.delete(school_class);
			}
		}
		
		
		schoolRepository.deleteById(id_school);
		
	}

}
