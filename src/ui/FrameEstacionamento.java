package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.EstacionamentoDao;
import model.Cliente;
import util.Util;

public class FrameEstacionamento{
	
private JLabel labelTitulo;
	
	private JLabel labelPlaca;
	private JTextField textFieldPlaca;
	private JLabel labelModelo;
	private JTextField textFieldModelo;
	private JButton buttonEntrar;
	
	private JScrollPane scrollTabela;
	private JTable tabelaVeiculos;
	private DefaultTableModel tabelaVeiculosModelo;
	
	private JLabel txtPlaca;
	private JLabel textPlaca;
	private JTextField txtFieldPlaca;
	private JButton buttonBuscar;
	
	private JLabel txtModelo;
	private JTextField txtFieldModelo;
	private JLabel labelDataEntrada;
	private JTextField textFieldDataEntrada;
	private JLabel txtEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textFieldHoraEntrada;
	private JLabel txtSaida;
	private JLabel labelDataSaida;
	private JTextField textFieldDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textFieldHoraSaida;
	private JLabel labelTempo;
	private JTextField textFieldTempo;
	private JLabel labelHoras;
	private JLabel labelMinutos;
	private JLabel labelSegundos;
	
	private JLabel labelValorTotal;
	private JTextField textFieldValorTotal;
	private JButton buttonFinalizar;
	private JButton buttonFechar;
	
	
	Font titulo = new Font("Arial Black", 0, 28);
	Font padrao = new Font("Bahnschrift", 0, 18);
	Font usuario = new Font("Franklin Gothic Heavy", 0, 22);
	Font usuario2 = new Font("Franklin Gothic Heavy", 0, 16);
	Font butao = new Font("Segoe UI Semibold", 0, 24);
	Font info = new Font ("Bahnschrift", 0, 12);
	Font detalhes = new Font ("Bahnschrift", 0, 8);
	
	Color laranja = new Color(255, 113, 41);
	Color preto = new Color(25, 24, 22);
	Color cinza = new Color(118, 113, 113);
	Color vermelho = new Color(222, 33, 18);
	
	public void criarTela() {
		
		JFrame tela = new JFrame();
		
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("ESTACIONAMENTO");
		
		tela.setSize(850, 650);
		tela.setLayout(null);
		tela.setBackground(preto);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		
		
		
		labelTitulo = new JLabel("ESTACIONAMENTO" );
		labelTitulo.setBounds(277, 0, 295, 50);
		labelTitulo.setFont(titulo);
		labelTitulo.setForeground(laranja);
		
		
		labelPlaca = new JLabel("PLACA DO VEÍCULO:");
		labelPlaca.setBounds(50, 60, 175, 20);
		labelPlaca.setFont(padrao);
		labelPlaca.setForeground(laranja);
		
		textFieldPlaca = new JTextField();
		textFieldPlaca.setBounds(50, 80, 150, 37);
		textFieldPlaca.setBackground(cinza);
		textFieldPlaca.setFont(usuario);
		textFieldPlaca.setForeground(preto);
		textFieldPlaca.setBorder(null);
		
		labelModelo = new JLabel("MARCA E MODELO DO VEÍCULO:");
		labelModelo.setBounds(285, 60, 275, 20);
		labelModelo.setFont(padrao);
		labelModelo.setForeground(laranja);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(285, 80, 275, 37);
		textFieldModelo.setBackground(cinza);
		textFieldModelo.setFont(usuario);
		textFieldModelo.setForeground(preto);
		textFieldModelo.setBorder(null);
		
		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(655, 80, 120, 37);
		buttonEntrar.setBackground(laranja);
		buttonEntrar.setFont(butao);
		buttonEntrar.setForeground(preto);
		buttonEntrar.setBorder(null);
		
		
		
		criarTabela();
		
		scrollTabela = new JScrollPane(tabelaVeiculos);
		scrollTabela.setBounds(100, 150, 650, 200);
		scrollTabela.getViewport().setBackground(preto);
		
		tabelaVeiculos = new JTable();
		tabelaVeiculos.setOpaque(false);
		
		
		
		txtPlaca = new JLabel("BUSCAR POR VEÍCULO:");
		txtPlaca.setBounds(50, 370, 200, 20);
		txtPlaca.setFont(padrao);
		txtPlaca.setForeground(laranja);
		
		textPlaca = new JLabel("PLACA:");
		textPlaca.setBounds(50, 390, 80, 37);
		textPlaca.setFont(usuario);
		textPlaca.setForeground(preto);
		textPlaca.setOpaque(true);
		textPlaca.setBackground(laranja);
		
		txtFieldPlaca = new JTextField();
		txtFieldPlaca.setBounds(125, 390, 150, 37);
		txtFieldPlaca.setBackground(cinza);
		txtFieldPlaca.setFont(usuario);
		txtFieldPlaca.setForeground(preto);
		txtFieldPlaca.setBorder(null);
		
		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(300, 390, 120, 37);
		buttonBuscar.setBackground(laranja);
		buttonBuscar.setFont(butao);
		buttonBuscar.setForeground(preto);
		buttonBuscar.setBorder(null);
		
		
		
		txtModelo = new JLabel("MARCA E MODELO DO VEÍCULO:");
		txtModelo.setBounds(50, 460, 275, 20);
		txtModelo.setForeground(laranja);
		txtModelo.setFont(info);
		
		txtFieldModelo = new JTextField();
		txtFieldModelo.setBounds(50, 480, 275, 37);
		txtFieldModelo.setBackground(cinza);
		txtFieldModelo.setFont(usuario2);
		txtFieldModelo.setForeground(preto);
		txtFieldModelo.setBorder(null);
		txtFieldModelo.setEditable(false);
		
		txtEntrada = new JLabel("DADOS DA ENTRADA");
		txtEntrada.setBounds(375, 520, 350, 15);
		txtEntrada.setForeground(laranja);
		txtEntrada.setFont(info);
		
		labelDataEntrada = new JLabel("DATA:");
		labelDataEntrada.setBounds(360, 460, 65, 20);
		labelDataEntrada.setForeground(laranja);
		labelDataEntrada.setFont(info);
		
		textFieldDataEntrada = new JTextField();
		textFieldDataEntrada.setBounds(360, 480, 65, 37);
		textFieldDataEntrada.setBackground(cinza);
		textFieldDataEntrada.setFont(usuario2);
		textFieldDataEntrada.setForeground(preto);
		textFieldDataEntrada.setBorder(null);
		textFieldDataEntrada.setEditable(false);
		
		labelHoraEntrada = new JLabel("HORA:");
		labelHoraEntrada.setBounds(430, 460, 65, 20);
		labelHoraEntrada.setForeground(laranja);
		labelHoraEntrada.setFont(info);
		
		textFieldHoraEntrada = new JTextField();
		textFieldHoraEntrada.setBounds(430, 480, 65, 37);
		textFieldHoraEntrada.setBackground(cinza);
		textFieldHoraEntrada.setFont(usuario2);
		textFieldHoraEntrada.setForeground(preto);
		textFieldHoraEntrada.setBorder(null);
		textFieldHoraEntrada.setEditable(false);
		
		txtSaida = new JLabel("DADOS DA SAÍDA");
		txtSaida.setBounds(545, 520, 350, 15);
		txtSaida.setForeground(laranja);
		txtSaida.setFont(info);
		
		labelDataSaida = new JLabel("DATA:");
		labelDataSaida.setBounds(520, 460, 65, 20);
		labelDataSaida.setForeground(laranja);
		labelDataSaida.setFont(info);
		
		textFieldDataSaida = new JTextField();
		textFieldDataSaida.setBounds(520, 480, 65, 37);
		textFieldDataSaida.setBackground(cinza);
		textFieldDataSaida.setFont(usuario2);
		textFieldDataSaida.setForeground(preto);
		textFieldDataSaida.setBorder(null);
		textFieldDataSaida.setEditable(false);
		
		labelHoraSaida = new JLabel("HORA:");
		labelHoraSaida.setBounds(590, 460, 65, 20);
		labelHoraSaida.setForeground(laranja);
		labelHoraSaida.setFont(info);
		
		textFieldHoraSaida = new JTextField();
		textFieldHoraSaida.setBounds(590, 480, 65, 37);
		textFieldHoraSaida.setBackground(cinza);
		textFieldHoraSaida.setFont(usuario2);
		textFieldHoraSaida.setForeground(preto);
		textFieldHoraSaida.setBorder(null);
		textFieldHoraSaida.setEditable(false);
		
		labelTempo = new JLabel("TEMPO TOTAL");
		labelTempo.setBounds(688,460, 75, 20);
		labelTempo.setForeground(laranja);
		labelTempo.setFont(info);
		
		textFieldTempo = new JTextField();
		textFieldTempo.setBounds(688, 480, 92, 37);
		textFieldTempo.setBackground(cinza);
		textFieldTempo.setFont(usuario2);
		textFieldTempo.setForeground(preto);
		textFieldTempo.setBorder(null);
		textFieldTempo.setEditable(false);
		
		labelHoras = new JLabel("H");
		labelHoras.setBounds(700, 520, 50, 15);
		labelHoras.setForeground(laranja);
		labelHoras.setFont(detalhes);
		labelMinutos = new JLabel("M");
		labelMinutos.setBounds(730, 520, 50, 15);
		labelMinutos.setForeground(laranja);
		labelMinutos.setFont(detalhes);
		labelSegundos = new JLabel("S");
		labelSegundos.setBounds(760, 520, 50, 15);
		labelSegundos.setForeground(laranja);
		labelSegundos.setFont(detalhes);
		
		
		
		labelValorTotal = new JLabel("VALOR A PAGAR:");
		labelValorTotal.setBounds(50, 550, 180, 37);
		labelValorTotal.setForeground(preto);
		labelValorTotal.setFont(usuario);
		labelValorTotal.setBackground(laranja);
		labelValorTotal.setOpaque(true);
		
		textFieldValorTotal = new JTextField("R$ ");
		textFieldValorTotal.setBounds(230, 550, 140, 37);
		textFieldValorTotal.setBackground(cinza);
		textFieldValorTotal.setFont(usuario);
		textFieldValorTotal.setForeground(preto);
		textFieldValorTotal.setBorder(null);
		textFieldValorTotal.setEditable(false);
		
		buttonFinalizar = new JButton("FINALIZAR");
		buttonFinalizar.setBounds(400, 550, 125, 37);
		buttonFinalizar.setBackground(laranja);
		buttonFinalizar.setFont(butao);
		buttonFinalizar.setForeground(preto);
		buttonFinalizar.setBorder(null);
		
		buttonFechar = new JButton("FECHAR");
		buttonFechar.setBounds(657, 550, 125, 37);
		buttonFechar.setBackground(vermelho);
		buttonFechar.setFont(butao);
		buttonFechar.setForeground(preto);
		buttonFechar.setBorder(null);
		
		
		
		tela.getContentPane().setBackground(preto);
		tela.getContentPane().add(labelTitulo);
		tela.getContentPane().add(labelPlaca);
		tela.getContentPane().add(textFieldPlaca);
		tela.getContentPane().add(labelModelo);
		tela.getContentPane().add(textFieldModelo);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(scrollTabela);
		tela.getContentPane().add(txtPlaca);
		tela.getContentPane().add(textPlaca);
		tela.getContentPane().add(txtFieldPlaca);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(txtModelo);
		tela.getContentPane().add(txtFieldModelo);
		tela.getContentPane().add(txtEntrada);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textFieldDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textFieldHoraEntrada);
		tela.getContentPane().add(txtSaida);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textFieldDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textFieldHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textFieldTempo);
		tela.getContentPane().add(labelHoras);
		tela.getContentPane().add(labelMinutos);
		tela.getContentPane().add(labelSegundos);
		tela.getContentPane().add(labelValorTotal);
		tela.getContentPane().add(textFieldValorTotal);
		tela.getContentPane().add(buttonFinalizar);
		tela.getContentPane().add(buttonFechar);
		
		tela.setVisible(true);
		
		
		
		buttonEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (validarFormulario()) {
					
					Cliente cliente = new Cliente();
					cliente.setCodigo(Util.gerarCodigo());
					cliente.setPlaca(textFieldPlaca.getText().toUpperCase());
					cliente.setModelo(textFieldModelo.getText().toUpperCase());
					cliente.setDataEntrada(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM")).toString());
					cliente.setHoraEntrada(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString());
					
					EstacionamentoDao dao = new EstacionamentoDao(cliente);
					dao.salvar();
					
					JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
					
					limparFormulario();
					
					criarTabela();
					
				} else {
					
					JOptionPane.showMessageDialog(
							null, "Você deve preencher todos os campos!", "Atenção!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}); // fim do BUTTON LISTENER
		
		
		
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				EstacionamentoDao dao = new EstacionamentoDao();
				Cliente cliente = dao.buscarClientes(txtFieldPlaca.getText());
				
				//Util util = new Util();
				//util.calcularTempo();
				
				txtFieldModelo.setText(cliente.getModelo());
				textFieldDataEntrada.setText(cliente.getDataEntrada());
				textFieldHoraEntrada.setText(cliente.getHoraEntrada());
				textFieldDataSaida.setText(cliente.getDataSaida());
				textFieldHoraSaida.setText(cliente.getHoraSaida());
				//textFieldTempo.setText(cliente.getTempo());
				// textFieldValorTotal.setText(cliente.getValorTotal());
			}
		});
		
		
		
		buttonFinalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		buttonFechar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	
	
	private void criarTabela() {
		
		tabelaVeiculosModelo = new DefaultTableModel();
		tabelaVeiculosModelo.addColumn("CÓDIGO");
		tabelaVeiculosModelo.addColumn("PLACA");
		tabelaVeiculosModelo.addColumn("MODELO E MARCA");
		tabelaVeiculosModelo.addColumn("DATA");
		tabelaVeiculosModelo.addColumn("HORA");
		
		EstacionamentoDao clienteDao = new EstacionamentoDao();
		ArrayList<Cliente> clientes = clienteDao.listarClientes();
		
		for (Cliente cliente : clientes) {
			String[] vetorCliente = {cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(), cliente.getDataEntrada(), cliente.getHoraEntrada()};
			tabelaVeiculosModelo.addRow(vetorCliente);
		}
		
		
		tabelaVeiculos = new JTable(tabelaVeiculosModelo);
		
		tabelaVeiculos.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaVeiculos.getColumnModel().getColumn(2).setPreferredWidth(225);
		tabelaVeiculos.getColumnModel().getColumn(3).setPreferredWidth(127);
		tabelaVeiculos.getColumnModel().getColumn(4).setPreferredWidth(127);
		
		tabelaVeiculos.getColumnModel().getColumn(0).setResizable(false);
		tabelaVeiculos.getColumnModel().getColumn(1).setResizable(false);
		tabelaVeiculos.getColumnModel().getColumn(2).setResizable(false);
		tabelaVeiculos.getColumnModel().getColumn(3).setResizable(false);
		tabelaVeiculos.getColumnModel().getColumn(4).setResizable(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tabelaVeiculos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabelaVeiculos.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tabelaVeiculos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tabelaVeiculos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tabelaVeiculos.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		tabelaVeiculos.setForeground(cinza);
		tabelaVeiculos.setFont(info);
		tabelaVeiculos.setBackground(preto);
		
		tabelaVeiculos.getTableHeader().setForeground(laranja);
		tabelaVeiculos.getTableHeader().setFont(padrao);
		tabelaVeiculos.getTableHeader().setBackground(preto);

	}
	
	
	
	private void limparFormulario() {
		textFieldPlaca.setText("");
		textFieldModelo.setText("");
		
		textFieldPlaca.requestFocus();
	}
	
	
	private boolean validarFormulario() {
		
		boolean valido = true;
		
		if (textFieldPlaca.getText().trim().length() == 0) {
			labelPlaca.setForeground(Color.RED);
			return false;
		} else if (textFieldModelo.getText().trim().length() == 0) {
			labelModelo.setForeground(Color.RED);
			return false;
		}
		
		return valido;
		
	}
}