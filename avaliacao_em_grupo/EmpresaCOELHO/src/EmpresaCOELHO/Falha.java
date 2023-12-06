package EmpresaCOELHO;

public class Falha {
	private String tipo;
    private String matriculaImovelAssociado;
    private boolean reportadaPorCliente;
    private String descricao;
    
    public Falha(String tipo, String matriculaImovelAssociado, boolean reportadaPorCliente, String descricao) {
        this.tipo = tipo;
        this.matriculaImovelAssociado = matriculaImovelAssociado;
        this.reportadaPorCliente = reportadaPorCliente;
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMatriculaImovelAssociado() {
		return matriculaImovelAssociado;
	}
	public void setMatriculaImovelAssociado(String matriculaImovelAssociado) {
		this.matriculaImovelAssociado = matriculaImovelAssociado;
	}
	public boolean isReportadaPorCliente() {
		return reportadaPorCliente;
	}
	public void setReportadaPorCliente(boolean reportadaPorCliente) {
		this.reportadaPorCliente = reportadaPorCliente;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
