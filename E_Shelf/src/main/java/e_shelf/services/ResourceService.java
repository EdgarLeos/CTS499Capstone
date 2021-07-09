package e_shelf.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_shelf.domains.database.TeacherHasResource;
import e_shelf.repositories.*;
import e_shelf.domains.info.*;
import e_shelf.domains.database.Resources;
import e_shelf.domains.database.Teacher;

@Service
public class ResourceService {
	
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
	
	public void addResource(ResourceUploadInfo resourceUploadInfo, String fileName) {
		
		Resources resource = new Resources();
		resource.setResource_name(resourceUploadInfo.getResource_name());
		resource.setResource_image_URL("/img/" + fileName);
		resource.setResource_URL(resourceUploadInfo.getResouce_URL());
		if(resourceUploadInfo.getDomain().equals("Yes")) {
			resource.setDomain(true);
		}else {
			resource.setDomain(false);
		}
		if(resourceUploadInfo.getSso().equals("Yes")) {
			resource.setSSO(true);
		}else {
			resource.setSSO(false);
		}
		List<TeacherHasResource> teacher_resources = new ArrayList<TeacherHasResource>();
		resource.setResource(teacher_resources);
		
		resourceRepository.save(resource);
		
		System.out.println(resource.getResource_name());
		System.out.println(resource.getResource_image_URL());
		System.out.println(resource.getResource_URL());
		
		
	}
	
	public TeacherHasResource getTeacherHasResource(Resources resource, Teacher teacher) {
		TeacherHasResource teacherResource = new TeacherHasResource();
		 if(resource.isDomain())
		 {
			 teacherResource.setTeacher_username(teacher.getEmail());
		 }
		 else {
			 String[] parts = teacher.getEmail().split("@");
			 teacherResource.setTeacher_username(parts[0]);
		 }
		 if(resource.isSSO()) {
			 teacherResource.setTeacher_password("SSO Same As Gmail");
		 }
		 else {
			 teacherResource.setTeacher_password("CapStone2021!");
		 }
		 teacherResource.setResources(resource);
		 teacherResource.setTeacher(teacher);
		 
		 return teacherResource;
	}
	
	public ResourcesInfo getResourcsInfo(int id_resource) {
		
		List<Resources> resources = resourceRepository.findById(id_resource);
		if(resources !=null && !resources.isEmpty()) {
			Resources resource = resourceRepository.findById(id_resource).get(0);
			ResourcesInfo resourcesInfo = new ResourcesInfo();
			resourcesInfo.setId_resources(resource.getId_resources());
			resourcesInfo.setResource_name(resource.getResource_name());
			resourcesInfo.setResource_URL(resource.getResource_URL());
			resourcesInfo.setResource_image_URL(resource.getResource_image_URL());
			List<String>resource_teachers = new ArrayList<String>();
			for(TeacherHasResource teacherHasResource: resource.getResource()) {
				resource_teachers.add(teacherHasResource.getTeacher().getTeacher_name());
			}
			resourcesInfo.setTeachers(resource_teachers);
			
			return resourcesInfo;
		}else {
			return null;
		}
		
	}
}
