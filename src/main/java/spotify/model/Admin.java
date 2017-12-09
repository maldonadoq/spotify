package spotify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin extends Usuario{
	@Id
	@Column(length = 64, nullable = false)
	private String idAdmin;

	public String getIdAdmin() {
		return idAdmin;
	}

	
	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}	
}
