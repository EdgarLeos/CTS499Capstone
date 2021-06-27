package e_shelf.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.annotation.Bean;

import e_shelf.domains.database.*;
import e_shelf.domains.database.Class;
import e_shelf.repositories.*;

@Controller
public class Main {
	
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
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/E-Shelf/allInfo")
	public String getAllInfo(Model model) {
		List<Teacher> teachers = teacherRepository.findAll();
		List<Class> classes = classRepository.findAll();
		List<School> schools = schoolRepository.findAll();
		List<Resources> resources = resourceRepository.findAll();
		Iterable<Users> users = userRepository.findAll();
		
		for(Class teacherClass : teachers.get(0).getClass_has_teacher()) {
			System.out.println(teacherClass.getClass_name());
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode("E-Shelf2021!");
		
		System.out.println(encodedPassword);
		
		for(TeacherHasResource teacherResource : teachers.get(0).getTeacherHasResource()) {
			System.out.println(teacherResource.getResources().getResource_name());
			System.out.println(teacherResource.getTeacher_username());
			System.out.println(teacherResource.getTeacher_password());
		}
		
		model.addAttribute("teachers", teachers);
		model.addAttribute("users", users);
		model.addAttribute("schools", schools);
		model.addAttribute("classes", classes);
		model.addAttribute("resources", resources);
		
		return "all_info";
		
	}
	
	@GetMapping("E-Shelf/oneTeacherInfo")
	public String oneTeacher(Model model) {
		int id_teacher = 1773;
		List<Teacher>teachers = teacherRepository.findById(id_teacher);
		Teacher teacher = teachers.get(0);
		System.out.println(teacher.getTeacher_name());
		TeacherHasResource teacherResource = new TeacherHasResource();
		
		for(TeacherHasResource teacherResources: teacher.getTeacherHasResource()) {
			
			
		}
		
		model.addAttribute("teacher", teacher);
		model.addAttribute("resources",teacher.getTeacherHasResource());
		
		return "one_teacher";
		}
	
    @GetMapping("E-Shelf/login")
    public String viewLoginPage() {
        // custom logic before showing login page...
         
        return "index";
    }
    

	
	@PostMapping("E-Shelf/teacherInfo")
	public String teacherInfo(@RequestParam("email") String email, Model model) {
		List<Teacher>teachers = teacherRepository.findByEmail(email);
		Teacher teacher = teachers.get(0);
		System.out.println(teacher.getTeacher_name());
		TeacherHasResource teacherResource = new TeacherHasResource();
		
		for(TeacherHasResource teacherResources: teacher.getTeacherHasResource()) {
			
			
		}
		
		model.addAttribute("teacher", teacher);
		model.addAttribute("resources",teacher.getTeacherHasResource());
		
		return "one_teacher";
		}

}
