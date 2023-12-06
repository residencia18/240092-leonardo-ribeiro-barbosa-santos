package EmpresaCOELHO;

public class Reparo {
	 private Falha falhaAssociada;
	    private String previsao;
	    private String dataInicio;
	    private String dataFim;
	    private boolean concluido;

	    public Reparo(Falha falhaAssociada, String previsao, String dataInicio) {
	        this.falhaAssociada = falhaAssociada;
	        this.previsao = previsao;
	        this.dataInicio = dataInicio;
	        this.concluido = false;
	    }

	    public boolean isConcluido() {
	        return concluido;
	    }

	    public void setConcluido(boolean concluido) {
	        this.concluido = concluido;
	    }

	    @Override
	    public String toString() {
	        return "Falha: " + falhaAssociada.getTipo() +
	               "\nDescrição: " + falhaAssociada.getDescricao() +
	               "\nPrevisão: " + previsao +
	               "\nData de Início: " + dataInicio +
	               "\nData de Fim: " + dataFim +
	               "\nConcluído: " + (concluido ? "Sim" : "Não");
	    }
	    public Falha getFalhaAssociada() {
			return falhaAssociada;
		}

		public void setFalhaAssociada(Falha falhaAssociada) {
			this.falhaAssociada = falhaAssociada;
		}

		public String getPrevisao() {
			return previsao;
		}

		public void setPrevisao(String previsao) {
			this.previsao = previsao;
		}

		public String getDataInicio() {
			return dataInicio;
		}

		public void setDataInicio(String dataInicio) {
			this.dataInicio = dataInicio;
		}

		public String getDataFim() {
			return dataFim;
		}

		public void setDataFim(String dataFim) {
			this.dataFim = dataFim;
		}

		public void setDataFinalizacao(String dataFinalizacao) {
	        this.dataFim = dataFinalizacao;
	    }
}
