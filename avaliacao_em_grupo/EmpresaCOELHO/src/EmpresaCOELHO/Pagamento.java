package EmpresaCOELHO;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pagamento {
	 private String matriculaFatura;
	    private double valorPago;
	    private LocalDate dataPagamento;
	    
	    private ArrayList<Pagamento> pagamentos;

	    public Pagamento(String matriculaFatura, double valorPago) {
	        this.matriculaFatura = matriculaFatura;
	        this.valorPago = valorPago;
	        this.dataPagamento = LocalDate.now();
	        this.pagamentos = new ArrayList<>();
	    }

	    public String getMatriculaFatura() {
	        return matriculaFatura;
	    }

	    public ArrayList<Pagamento> getPagamentos() {
			return pagamentos;
		}

		public void setPagamentos(ArrayList<Pagamento> pagamentos) {
			this.pagamentos = pagamentos;
		}

		public void setMatriculaFatura(String matriculaFatura) {
			this.matriculaFatura = matriculaFatura;
		}

		public void setValorPago(double valorPago) {
			this.valorPago = valorPago;
		}

		public void setDataPagamento(LocalDate dataPagamento) {
			this.dataPagamento = dataPagamento;
		}

		public double getValorPago() {
	        return valorPago;
	    }

	    public LocalDate getDataPagamento() {
	        return dataPagamento;
	    }

	    @Override
	    public String toString() {
	        return "Matrícula da Fatura: " + matriculaFatura +
	               "\nValor Pago: R$" + valorPago +
	               "\nData do Pagamento: " + dataPagamento;
	    }
	    
	    public void registrarPagamento(Pagamento pagamento) {
	        pagamentos.add(pagamento);
	    }

		public boolean isReembolso() {
			// TODO Stub de método gerado automaticamente
			return false;
		}
}
