package entidades;

import java.time.LocalDateTime;

public class AluguelCarro {

	private LocalDateTime inicio;
	private LocalDateTime termino;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public AluguelCarro() {
	}

	public AluguelCarro(LocalDateTime inicio, LocalDateTime termino, Veiculo veiculo) {
		this.inicio = inicio;
		this.termino = termino;
		this.veiculo = veiculo;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getTermino() {
		return termino;
	}

	public void setTermino(LocalDateTime termino) {
		this.termino = termino;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
}