package util;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import model.Cliente;

public class Util {
	
	public static String gerarCodigo() {
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
	}
	
	public Duration calcularTempo() {
		
		Cliente cliente = new Cliente();
		
		String stringEntrada = cliente.getHoraEntrada();
		String stringSaida = cliente.getHoraSaida();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalTime horaEntrada = LocalTime.parse(stringEntrada, format);
		LocalTime horaSaida = LocalTime.parse(stringSaida, format);
		
		Duration tempo = Duration.between(horaSaida, horaEntrada);
		tempo.toHours();
		System.out.println(tempo);
		
		return tempo;
	}
}
