package e_shelf.domains.database;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

//Teacher object to link to dB with its proper constructors, getters and setters. 
@Entity
@Table(name = "resources")
public class Resources {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_resources;
	private String resource_name;
	private String resource_image_URL;
	private String resource_URL;
	private boolean domain;
	private boolean SSO;
	
	public Resources(int id_resources, String resource_name, String resource_image_URL, String resource_URL,
			boolean domain, boolean sSO, List<TeacherHasResources> resource) {
		super();
		this.id_resources = id_resources;
		this.resource_name = resource_name;
		this.resource_image_URL = resource_image_URL;
		this.resource_URL = resource_URL;
		this.domain = domain;
		SSO = sSO;
		this.resource = resource;
	}

	@OneToMany(mappedBy = "resources", cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<TeacherHasResources> resource;
	
	public Resources() {}

	public int getId_resources() {
		return id_resources;
	}

	public void setId_resources(int id_resources) {
		this.id_resources = id_resources;
	}

	public String getResource_name() {
		return resource_name;
	}

	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}

	public String getResource_image_URL() {
		return resource_image_URL;
	}

	public void setResource_image_URL(String resource_image_URL) {
		this.resource_image_URL = resource_image_URL;
	}

	public String getResource_URL() {
		return resource_URL;
	}

	public void setResource_URL(String resource_URL) {
		this.resource_URL = resource_URL;
	}

	public boolean isDomain() {
		return domain;
	}

	public void setDomain(boolean domain) {
		this.domain = domain;
	}

	public boolean isSSO() {
		return SSO;
	}

	public void setSSO(boolean sSO) {
		SSO = sSO;
	}

	public List<TeacherHasResources> getResource() {
		return resource;
	}

	public void setResource(List<TeacherHasResources> resource) {
		this.resource = resource;
	}

	


}
