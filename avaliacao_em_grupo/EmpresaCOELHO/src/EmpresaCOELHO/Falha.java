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
}
