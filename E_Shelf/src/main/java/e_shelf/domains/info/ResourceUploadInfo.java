package e_shelf.domains.info;

public class ResourceUploadInfo {
	
	int id_resource;
	String resource_name;
	String resource_URL;
	String domain;
	String sso;
	
	public ResourceUploadInfo() {}
	
	
	public ResourceUploadInfo(int id_resource, String resource_name, String resource_URL, String domain, String sso) {
		super();
		this.id_resource = id_resource;
		this.resource_name = resource_name;
		this.resource_URL = resource_URL;
		this.domain = domain;
		this.sso = sso;
	}


	public int getId_resource() {
		return id_resource;
	}


	public void setId_resource(int id_resource) {
		this.id_resource = id_resource;
	}


	public String getResource_name() {
		return resource_name;
	}


	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}


	public String getResource_URL() {
		return resource_URL;
	}


	public void setResource_URL(String resource_URL) {
		this.resource_URL = resource_URL;
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
		result = prime * result + id_resource;
		result = prime * result + ((resource_URL == null) ? 0 : resource_URL.hashCode());
		result = prime * result + ((resource_name == null) ? 0 : resource_name.hashCode());
		result = prime * result + ((sso == null) ? 0 : sso.hashCode());
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
		ResourceUploadInfo other = (ResourceUploadInfo) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (id_resource != other.id_resource)
			return false;
		if (resource_URL == null) {
			if (other.resource_URL != null)
				return false;
		} else if (!resource_URL.equals(other.resource_URL))
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
		return true;
	}


	@Override
	public String toString() {
		return "ResourceUploadInfo [id_resource=" + id_resource + ", resource_name=" + resource_name + ", resource_URL="
				+ resource_URL + ", domain=" + domain + ", sso=" + sso + "]";
	}

	
	

}
