package apllication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.AluguelCarro;
import entidades.Veiculo;
import servicos.ServicoAluguel;
import servicos.ServicoImpostoBrasil;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		
		System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
		LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);
		
		System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
		LocalDateTime termino = LocalDateTime.parse(sc.nextLine(), fmt);
		
		AluguelCarro ac = new AluguelCarro(inicio, termino, new Veiculo(modeloCarro));

		System.out.print("Entre com o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		
		System.out.print("Entre com o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorDia, precoPorHora, new ServicoImpostoBrasil());
		
		servicoAluguel.processFatura(ac);

		System.out.println("FATURA:");
		System.out.println("Pagamento basico: " + String.format("%.2f", ac.getFatura().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f", ac.getFatura().getTaxa()));
		System.out.println("Pagamento total: " + String.format("%.2f", ac.getFatura().getTotalPagamento()));
		
		sc.close();
	}
}
