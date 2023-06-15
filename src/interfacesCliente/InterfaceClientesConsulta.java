package interfacesCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ClienteConsultaDatabase;
import controladores.ConsultaProdutos;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import classesCliente.ClienteConsultaTratamento;

import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

public class InterfaceClientesConsulta extends InterfaceClientesPrincipal {

	private JPanel contentPane;
	private JTextField inputNomeCliente;
	private JTextField inputCpfCLiente;
	private JTable tabelaResultadoCliente;

	/**
	 * Launch the application.
	 */
	public static void clienteConsulta() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClientesConsulta frame = new InterfaceClientesConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceClientesConsulta () {


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setBounds(12, 12, 121, 29);
		contentPane.add(lblNomeDoCliente);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 53, 31, 15);
		contentPane.add(lblCpf);
		
		//Ler o que foi digitado
		inputNomeCliente = new JTextField();
		inputNomeCliente.setBounds(140, 17, 388, 19);
		contentPane.add(inputNomeCliente);
		inputNomeCliente.setColumns(10);
		
		
		inputCpfCLiente = new JTextField();
		inputCpfCLiente.setColumns(10);
		inputCpfCLiente.setBounds(49, 51, 110, 19);
		contentPane.add(inputCpfCLiente);
		
		

		JButton btnConsultarCliente = new JButton("Consultar");
		
		
		btnConsultarCliente.setBounds(814, 429, 117, 25);
		contentPane.add(btnConsultarCliente);
		
		 	DefaultTableModel tabelaModel = new DefaultTableModel(new Object[][] {},
	                new String[] { "nome do cliente", "cpf do cliente", "data de nascimento", "telefone", "estado", "cidade",
	                        "bairro", "rua", "cep" });
	        tabelaResultadoCliente = new JTable(tabelaModel);
	        tabelaResultadoCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(2).setPreferredWidth(120);
	        tabelaResultadoCliente.getColumnModel().getColumn(3).setPreferredWidth(80);
	        tabelaResultadoCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
	        tabelaResultadoCliente.getColumnModel().getColumn(5).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(6).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(7).setPreferredWidth(100);
	        tabelaResultadoCliente.getColumnModel().getColumn(8).setPreferredWidth(80);
		
		JScrollPane scrollInformacoesCliente = new JScrollPane(tabelaResultadoCliente);
		scrollInformacoesCliente.setBounds(34, 94, 897, 141);
		contentPane.add(scrollInformacoesCliente);
		JLabel lblInformaesDoCliente = new JLabel("Informações do cliente:");
		lblInformaesDoCliente.setBounds(12, 80, 166, 15);
		contentPane.add(lblInformaesDoCliente);
		
		JLabel lblUltimosPedidosDo = new JLabel("Ultimos pedidos do cliente:");
		lblUltimosPedidosDo.setBounds(12, 238, 212, 29);
		contentPane.add(lblUltimosPedidosDo);
		
		DefaultTableModel produtosModel = new DefaultTableModel(
		        new Object[][] {},
		        new String[] { "id do produto", "nome do produto", "quantidade", "valor", "data de validade"}
		);
		JTable produtosResultadoCliente = new JTable(produtosModel);
		produtosResultadoCliente.getColumnModel().getColumn(0).setPreferredWidth(100);
		produtosResultadoCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
		produtosResultadoCliente.getColumnModel().getColumn(2).setPreferredWidth(120);
		produtosResultadoCliente.getColumnModel().getColumn(3).setPreferredWidth(120);
		produtosResultadoCliente.getColumnModel().getColumn(4).setPreferredWidth(120);

		JScrollPane scrollInformacoesProduto = new JScrollPane(produtosResultadoCliente);
		scrollInformacoesProduto.setBounds(34, 272, 897, 141);
		contentPane.add(scrollInformacoesProduto);
		
		btnConsultarCliente.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	               	                
	                ClienteConsultaTratamento infoCliente = new ClienteConsultaTratamento();
//
//	                //passa o que foi digitado na interface para a classe de tratamento de informações do cliente
	                infoCliente.consultaNomeCpf(inputNomeCliente.getText(), inputCpfCLiente.getText());
//	                
//	                //retorna os valores do database após passar pela classe de tratamentto de informações do cliente
	                List<Object[]> resultadosCliente = infoCliente.retornoInfo();
	           
	                tabelaModel.setRowCount(0);

	                for (Object[] cliente : resultadosCliente) {
	                	//vai ser adicionada uma nova linha com o conteúdo do cliente e vai crescer de acordo com o resultados
	                    tabelaModel.addRow(cliente); 
	                }
	                    
	                    produtosModel.setRowCount(0);
	                    
	                    List<Object[]> resultadosProduto = ConsultaProdutos.consultaProdutos(inputNomeCliente.getText(), inputCpfCLiente.getText());
	                    
	                    for (Object[] produtos : resultadosProduto) {
		                	//vai ser adicionada uma nova linha com o conteúdo do cliente e vai crescer de acordo com o resultados
		                    produtosModel.addRow(produtos); 
	                   
	                    
	                    
	                }
	            }
	        });
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Limpa as informações
				inputNomeCliente.setText("");
				inputCpfCLiente.setText("");
				tabelaModel.setRowCount(0); //vai zerar a tabela quando apertar o botao consultar
				produtosModel.setRowCount(0);
			}
		});
		btnNewButton.setBounds(685, 429, 117, 25);
		contentPane.add(btnNewButton);
		
	}
}



