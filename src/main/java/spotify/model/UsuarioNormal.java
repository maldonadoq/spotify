package spotify.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class UsuarioNormal extends Usuario{
	@Column(nullable = false)
	private Boolean Estado;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Seguidor",
		joinColumns = @JoinColumn(name = "Usuario_id", referencedColumnName = "Id_usuario"),
		inverseJoinColumns = @JoinColumn(name = "Sigue_id", referencedColumnName = "Id_usuario")
	)
	public List<UsuarioNormal> Sigue;

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}
}
