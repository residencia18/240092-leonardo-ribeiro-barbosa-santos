package empresaDeOnibus;

public class Trechos {

	private PontoDeParada origem;
	private PontoDeParada destino;
	private int intervaloEstimado;

	public Trechos(PontoDeParada origem, PontoDeParada destino, int intervaloEstimado) {
		this.origem = origem;
		this.destino = destino;
		this.intervaloEstimado = intervaloEstimado;
	}
}
