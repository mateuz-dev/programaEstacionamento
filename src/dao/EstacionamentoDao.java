package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Cliente;

public class EstacionamentoDao {
	
	private Cliente cliente;
	
	private static final String ARQUIVO_MOVIMENTACAO = "C:/Users/nirem/DocumentosEstacionamento/movimentacao.ds1";
	// private static final String ARQUIVO_VALORES = "C:/Users/nirem/DocumentosEstacionamento/valores.ds1";
	
	
	// MÉTODO CONSTRUTOR VAZIO
	public EstacionamentoDao() {
		
	}
	
	// MÉTODO com CLIENTE
	public EstacionamentoDao (Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
	
	// MÉTODO SALVAR
	public void salvar() {
		
		Path path = Paths.get(ARQUIVO_MOVIMENTACAO);
		
		try {
			
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);
			
			writer.write(cliente.toString());
			writer.newLine();
			writer.close();
			
		}  catch (Exception e) {
			System.out.println("Ocoreu um erro na tentativa de gravar os dados.");
			e.printStackTrace();
		}
				
	}
	
	
	
	// MÉTODO LISTAR CLIENTES
	public ArrayList<Cliente> listarClientes(){
		
		Path path = Paths.get(ARQUIVO_MOVIMENTACAO);
		
		try {
			
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			
			String linha = reader.readLine();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			while(linha != null) {
				
				String[] vetorCliente = linha.split(";");
				
				Cliente cliente = new Cliente();
				cliente.setCodigo(vetorCliente[0]);
				cliente.setPlaca(vetorCliente[1]);
				cliente.setModelo(vetorCliente[2]);
				cliente.setDataEntrada(vetorCliente[3]);
				cliente.setHoraEntrada(vetorCliente[4]);
				cliente.setDataSaida(vetorCliente[5]);
				cliente.setHoraSaida(vetorCliente[6]);
				cliente.setTempo(Double.parseDouble(vetorCliente[7]));
				cliente.setValorTotal(Double.parseDouble(vetorCliente[8]));
				
				clientes.add(cliente);
				
				linha = reader.readLine();
				
			}
			
			reader.close();
			
			return clientes;
			
			
		} catch (Exception e) {

			System.out.println("Ocorreu um erro na tentativa de listar os clientes!");
			e.printStackTrace();
			return null;
			
		}
	}
	
	
	
	// MÉTODO BUSCAR CLIENTES
	public Cliente buscarClientes(String placa) {
		
		Path path = Paths.get(ARQUIVO_MOVIMENTACAO);
		
		try {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			
			String linha = reader.readLine();
			Cliente cliente = new Cliente();
			
			while(linha != null) {
				String[] vetorCliente = linha.split(";");
				
				if(vetorCliente[1].equals(placa)) {
					cliente.setCodigo(vetorCliente[0]);
					cliente.setPlaca(vetorCliente[1]);
					cliente.setModelo(vetorCliente[2]);
					cliente.setDataEntrada(vetorCliente[3]);
					cliente.setHoraEntrada(vetorCliente[4]);
					cliente.setDataSaida(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM")).toString());
					cliente.setHoraSaida(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
					cliente.setTempo(Double.parseDouble(vetorCliente[7]));
					cliente.setValorTotal(Double.parseDouble(vetorCliente[8]));
					break;
				}
				
				linha = reader.readLine();
				
			}
			
			reader.close();
			
			System.out.println(cliente);
			
			return cliente;
		}
		
		catch (Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return null;
		}
	}
	
}
