package e_shelf.domains.info;

import java.util.List;

public class ResourcesInfo {
	
	private int id_resources;
	private String resource_name;
	private String resource_image_URL;
	private String resource_URL;
	private List<String> teachers;
	private String domain;
	private String sso;
	
	public ResourcesInfo() {}

	public ResourcesInfo(int id_resources, String resource_name, String resource_image_URL, String resource_URL,
			List<String> teachers, String domain, String sso) {
		super();
		this.id_resources = id_resources;
		this.resource_name = resource_name;
		this.resource_image_URL = resource_image_URL;
		this.resource_URL = resource_URL;
		this.teachers = teachers;
		this.domain = domain;
		this.sso = sso;
	}

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

	public List<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<String> teachers) {
		this.teachers = teachers;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSso() {
		return sso;
	}

	public void setSso(String sso) {
		this.sso = sso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + id_resources;
		result = prime * result + ((resource_URL == null) ? 0 : resource_URL.hashCode());
		result = prime * result + ((resource_image_URL == null) ? 0 : resource_image_URL.hashCode());
		result = prime * result + ((resource_name == null) ? 0 : resource_name.hashCode());
		result = prime * result + ((sso == null) ? 0 : sso.hashCode());
		result = prime * result + ((teachers == null) ? 0 : teachers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourcesInfo other = (ResourcesInfo) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (id_resources != other.id_resources)
			return false;
		if (resource_URL == null) {
			if (other.resource_URL != null)
				return false;
		} else if (!resource_URL.equals(other.resource_URL))
			return false;
		if (resource_image_URL == null) {
			if (other.resource_image_URL != null)
				return false;
		} else if (!resource_image_URL.equals(other.resource_image_URL))
			return false;
		if (resource_name == null) {
			if (other.resource_name != null)
				return false;
		} else if (!resource_name.equals(other.resource_name))
			return false;
		if (sso == null) {
			if (other.sso != null)
				return false;
		} else if (!sso.equals(other.sso))
			return false;
		if (teachers == null) {
			if (other.teachers != null)
				return false;
		} else if (!teachers.equals(other.teachers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResourcesInfo [id_resources=" + id_resources + ", resource_name=" + resource_name
				+ ", resource_image_URL=" + resource_image_URL + ", resource_URL=" + resource_URL + ", teachers="
				+ teachers + ", domain=" + domain + ", sso=" + sso + "]";
	}
	
	
	

}
