package modelo.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_FILME")
	@SequenceGenerator(name = "ID_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
	private Integer codigo;
	private String nomefilme;
	private String descricao;
	private String anofilme;
	private int qntfilme;
	private float valorfilme;

	@ManyToOne
	@JoinColumn(name = "id_categoria_fk")
	private Categoria categoria;

	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomefilme() {
		return nomefilme;
	}

	public void setNomefilme(String nomefilme) {
		this.nomefilme = nomefilme;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAnofilme() {
		return anofilme;
	}

	public void setAnofilme(String anofilme) {
		this.anofilme = anofilme;
	}

	public int getQntfilme() {
		return qntfilme;
	}

	public void setQntfilme(int qntfilme) {
		this.qntfilme = qntfilme;
	}

	public float getValorfilme() {
		return valorfilme;
	}

	public void setValorfilme(float valorfilme) {
		this.valorfilme = valorfilme;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Filme [codigo=" + codigo + ", nomefilme=" + nomefilme + ", descricao=" + descricao + ", anofilme="
				+ anofilme + ", qntfilme=" + qntfilme + ", valorfilme=" + valorfilme + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Filme other = (Filme) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
	

}
