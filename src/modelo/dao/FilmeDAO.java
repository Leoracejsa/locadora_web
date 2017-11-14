package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import modelo.dominio.Categoria;
import modelo.dominio.Filme;

public class FilmeDAO extends JpaDAO<Filme> {

	public List<Filme> filtrarFilmes(Categoria cat, String descricao) {
		String jpql = "from Filme f  ";

		if (cat != null) {
			jpql = jpql + " where p.categoria = :categ";
		} else if (descricao != null) {
			jpql = jpql + " where p.descricao like :descricao";
		}

		jpql = jpql + " order by p.descricao";

		TypedQuery<Filme> comando = this.getEntityManager().createQuery(jpql, Filme.class);

		if (cat != null)
			comando.setParameter("categ", cat);
		else if (descricao != null)
			comando.setParameter("descricao", "%" + descricao + "%");

		return comando.getResultList();
	}

}
