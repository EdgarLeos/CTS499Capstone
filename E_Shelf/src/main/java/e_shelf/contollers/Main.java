package e_shelf.contollers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import e_shelf.domains.database.*;
import e_shelf.domains.database.Class;
import e_shelf.domains.info.*;
import e_shelf.repositories.*;
import e_shelf.services.*;
import e_shelf.services.ResourceService;
import e_shelf.utilities.FileUploadUtil;

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
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ClassesService classService;
	
	@Autowired
	SchoolService schoolService;
	
	
	@GetMapping("/E-Shelf/allInfo")
	public String getAllInfo(Model model) {
		List<Teacher> teachers = teacherRepository.findAll();
		List<Class> classes = classRepository.findAll();
		List<School> schools = schoolRepository.findAll();
		List<Resources> resources = resourceRepository.findAll();
		Iterable<User> users = userRepository.findAll();
		
		for(Class teacherClass : teachers.get(0).getClass_has_teacher()) {
			System.out.println(teacherClass.getClass_name());
		}
		
	
		
		for(TeacherHasResources teacherResource : teachers.get(0).getTeacherHasResource()) {
			System.out.println(teacherResource.getResources().getResource_name());
			System.out.println(teacherResource.getTeacher_username());
			System.out.println(teacherResource.getTeacher_password());
		}
//        Path pathToFile = Paths.get("src/main/resources/static/csv/users.csv");
//        System.out.println(pathToFile.toAbsolutePath());
//        
//
//        // create an instance of BufferedReader
//        // using try with resource, Java 7 feature to close resources
//        try (BufferedReader br = Files.newBufferedReader(pathToFile,
//                StandardCharsets.US_ASCII)) {
//
//            // read the first line from the text file
//            String line = br.readLine();
//
//            // loop until all lines are read
//            while (line != null) {
//
//                // use string.split to load a string array with the values from
//                // each line of
//                // the file, using a comma as the delimiter
//                String[] attributes = line.split(",");
//                
//                Users user = new Users();
//                user.setId_users(Integer.parseInt(attributes[0]));
//                user.setUsername(attributes[1]);
//                user.setPassword(bCryptPasswordEncoder.encode(attributes[2]));
//                user.setRole(attributes[3]);
//                user.setEnabled(attributes[4]); 
//                
//                userRepository.save(user);
//
//                // read next line before looping
//                // if end of file reached, line would be null
//                line = br.readLine();
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
     
		model.addAttribute("teachers", teachers);
		model.addAttribute("users", users);
		model.addAttribute("schools", schools);
		model.addAttribute("classes", classes);
		model.addAttribute("resources", resources);
		
		return "all_info";
		
	}
	
//	@GetMapping("E-Shelf/oneTeacherInfo")
//	public String oneTeacher(Model model) {
//		int id_teacher = 1773;
//		List<Teacher>teachers = teacherRepository.findById(id_teacher);
//		Teacher teacher = teachers.get(0);
//		System.out.println(teacher.getTeacher_name());
//		TeacherHasResource teacherResource = new TeacherHasResource();
//		
//		for(TeacherHasResource teacherResources: teacher.getTeacherHasResource()) {
//			
//			
//		}
//		
//		model.addAttribute("teacher", teacher);
//		model.addAttribute("resources",teacher.getTeacherHasResource());
//		
//		return "one_teacher";
//		}
	
    @GetMapping("/login")
    public String viewLoginPage() {
        // custom logic before showing login page...
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
        	return "login";
        	
        }
        return "redirect:/";
    }
    
    @GetMapping("")
    public String index() {
    	return "login";
    }

    
    @PostMapping("/E-Shelf/main/addResource")
    public String addNewResource(ResourceUploadInfo resource,  @RequestParam("image") MultipartFile multipartFile) throws IOException {

    	String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    	String uploadDir = "/Users/edgarleos/git/CapStone/E_Shelf/src/main/resources/static/img/";
    	resourceService.addResource(resource, fileName);
    	FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    	return "redirect:/admin";
    }
    
    
    @PostMapping("/E-Shelf/main/addTeacher")
    public String addNewTeacher(TeacherInfo teacher, Model model) {
    	
    	teacherService.addTacher(teacher);

    	return "redirect:/admin";
    }
    
    
    @RequestMapping("/E-Shelf/main/findTeacherById")
    @ResponseBody
    public TeacherInfo findTeacherById(int id){
    	return teacherService.getTecherInfo(id);
    }
    
    @RequestMapping(value = "/E-Shelf/main/EditTeacher", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateNewTeacher(TeacherInfo teacher, Model model) {
    	
    	teacherService.addTacher(teacher);

    	return "redirect:/admin";
    }
    
    
    @PostMapping("/E-Shelf/main/addSchool")
    public String addNewSchool(School school, Model model) {
    	
    	schoolService.addSchool(school);

    	return "redirect:/admin";
    }
    
    @PostMapping("/E-Shelf/main/addClass")
    public String addNewClass(ClassesInfo classInfo, Model model) {
    	
    	classService.addClass(classInfo);

    	return "redirect:/admin";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String laodAdminPage(Model model) {			
				List<Teacher> teachers = teacherRepository.findAll();
				List<TeacherInfo> teacherInfos = new ArrayList<TeacherInfo>();
				for(Teacher teacher: teachers) {
					teacherInfos.add(teacherService.getTecherInfo(teacher.getId_teacher()));
				}
				
				List<Class> classes = classRepository.findAll();
				List<ClassesInfo> classInfo = new ArrayList<ClassesInfo>();
				for( Class schoolClass: classes) {
					classInfo.add(classService.getClassesInfo(schoolClass.getId_class()));
				}
				
				List<School> schools = schoolRepository.findAll();
				
				List<Resources> resources = resourceRepository.findAll();
				List<ResourcesInfo> resourceInfo = new ArrayList<ResourcesInfo>();
				for(Resources resource:resources) {
					resourceInfo.add(resourceService.getResourcsInfo(resource.getId_resources()));
				}
				
				Iterable<User> users = userRepository.findAll();
				model.addAttribute("teachers", teacherInfos);
				model.addAttribute("users", users);
				model.addAttribute("schools", schools);
				model.addAttribute("classes", classInfo);
				model.addAttribute("resources", resourceInfo);
				
				return "admin_page";
			
		
	}
    
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String loadTeacherPage(Model model, Authentication authResult) {

    			String email = authResult.getName().toString();

				List<Teacher>teachers = teacherRepository.findByEmail(email);
				Teacher teacher = teachers.get(0);
				TeacherInfo teacherInfo = teacherService.getTecherInfo(teacher.getId_teacher());
				System.out.println(teacherInfo.toString());
				model.addAttribute("teacher", teacher);
				model.addAttribute("resources",teacher.getTeacherHasResource());
				
				return "teacher_page";
			}

    
    
//    @GetMapping("/E-Shelf/main/user")
//    public String getTeachers(Model model, String keyword) {
//		List<Teacher> teachers = teacherRepository.findAll();
//		
//	
//			model.addAttribute("teachers", teachers);
//		return "admin_page";
//    }
//    
//    @RequestMapping(value = "/E-Shelf/main/admin/search", method = RequestMethod.POST)
//	public String search(@RequestParam("email") String email, String password, Model model) {
//    	Users user = new Users();
//    	user.setUsername(email);
//    	user.setPassword(password);
//    	
//    	model.addAttribute("user", user);
//    	return "search";
//    	
//    }
}
