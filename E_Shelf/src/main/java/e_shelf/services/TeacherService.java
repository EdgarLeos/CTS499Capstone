package e_shelf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_shelf.domains.database.Teacher;
import e_shelf.repositories.*;
import e_shelf.domains.info.*;

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
			
			Teacher teacher = teachers.get(id_teacher);
			
			

			
			return new TeacherInfo();
		}else {
			return null;
			}

	}
	

}
