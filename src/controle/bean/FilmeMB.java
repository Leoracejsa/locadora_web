package controle.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.CategoriaDAO;
import modelo.dao.FilmeDAO;
import modelo.dominio.Categoria;
import modelo.dominio.Filme;

@ManagedBean(name = "filmeMB")
@RequestScoped
public class FilmeMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{logimMB}")
	private LoginMB logimMB;

	private Filme filme = new Filme();

	private Categoria filtroCategoria = null;
	private String filtroDescricao = null;

	private FilmeDAO dao = new FilmeDAO();

	private List<Filme> filmes = null;

	private List<Categoria> categorias = null;
	
	
	public String getContador()
	{
		String descricao = this.filme.getDescricao();
		if (descricao == null)
			return "0";
		
		return String.valueOf(descricao.length());
	}

	public List<Filme> getFilmes() {

		if (this.filmes == null)
			this.filmes = this.dao.lerTodos();

		return filmes;
	}

	public List<Categoria> getCategorias() {

		if (this.categorias == null)
			this.categorias = new CategoriaDAO().lerTodos();

		return categorias;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Categoria getFiltroCategoria() {
		return filtroCategoria;
	}

	public void setFiltroCategoria(Categoria filtroCategoria) {
		this.filtroCategoria = filtroCategoria;
	}

	public String getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(String filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public LoginMB getLogimMB() {
		return logimMB;
	}

	public void setLogimMB(LoginMB logimMB) {
		this.logimMB = logimMB;
	}

	public String acaoListar() {
		return "filmeListar.jsf?faces-redirect=true";
	}

	public String acaoPesquisar() {

		this.filmes = this.dao.filtrarFilmes(filtroCategoria, filtroDescricao);

		return "filmeListar.jsf";
	}

	public String acaoAbrirInclusao() {

		this.filme = new Filme();

		return "filmeEditar.jsf";
	}

	public String acaoAbrirAlteracao(Integer codigo) {

		this.filme = dao.lerPorId(codigo);

		return "filmeEditar.jsf";
	}

	public String acaoExcluir(Integer codigo) {

		// ler objeto do banco
		this.filme = dao.lerPorId(codigo);

		this.dao.excluir(this.filme);

		return acaoListar();
	}

	public String acaoSalvar() {

		this.dao.salvar(this.filme);

		return acaoListar();
	}

	public String acaoCancelar() {

		return acaoListar();
	}
}
