package servicos;

import java.time.Duration;

import entidades.AluguelCarro;
import entidades.Fatura;

public class ServicoAluguel {

	private Double precoPorDia;
	private Double precoPorHora;
	
	private ServicoTaxa servicoTaxa;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ServicoTaxa servicoTaxa) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.servicoTaxa = servicoTaxa;
	}
	
	public void processFatura(AluguelCarro aluguelCarro) {
		
		double minutos = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getTermino()).toMinutes();		
		double horas = minutos / 60.0;
		
		double pagamentoBasico;
		if (horas <= 12.0) {
			pagamentoBasico = precoPorHora * Math.ceil(horas);
		}
		else {
			pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
		}

		double taxa = servicoTaxa.taxa(pagamentoBasico);

		aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
	}
}