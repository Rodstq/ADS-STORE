package interfacesPedidos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controladores.PedidosDeleteDb;

public class InterfacePedidosDeletar extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldIdPedido;
    private JButton btnDeletar;

    /**
     * Launch the application.
     */
    public static void AbrirInterfacePedidosDeletar() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfacePedidosDeletar frame = new InterfacePedidosDeletar();
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
    public InterfacePedidosDeletar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Deletar Pedido");
        setBounds(100, 100, 350, 200);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        JLabel lblTitulo = new JLabel("Deletar Pedido");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        GridBagConstraints gbcLblTitulo = new GridBagConstraints();
        gbcLblTitulo.gridwidth = 2;
        gbcLblTitulo.insets = new Insets(0, 0, 20, 0);
        gbcLblTitulo.gridx = 0;
        gbcLblTitulo.gridy = 0;
        contentPane.add(lblTitulo, gbcLblTitulo);

        JLabel lblIdPedido = new JLabel("ID do Pedido:");
        GridBagConstraints gbcLblIdPedido = new GridBagConstraints();
        gbcLblIdPedido.anchor = GridBagConstraints.WEST;
        gbcLblIdPedido.insets = new Insets(0, 0, 10, 10);
        gbcLblIdPedido.gridx = 0;
        gbcLblIdPedido.gridy = 1;
        contentPane.add(lblIdPedido, gbcLblIdPedido);

        textFieldIdPedido = new JTextField();
        GridBagConstraints gbcTextFieldIdPedido = new GridBagConstraints();
        gbcTextFieldIdPedido.insets = new Insets(0, 0, 10, 0);
        gbcTextFieldIdPedido.fill = GridBagConstraints.HORIZONTAL;
        gbcTextFieldIdPedido.gridx = 1;
        gbcTextFieldIdPedido.gridy = 1;
        contentPane.add(textFieldIdPedido, gbcTextFieldIdPedido);
        textFieldIdPedido.setColumns(10);

        btnDeletar = new JButton("Deletar");
        GridBagConstraints gbcBtnDeletar = new GridBagConstraints();
        gbcBtnDeletar.gridx = 1;
        gbcBtnDeletar.gridy = 2;
        contentPane.add(btnDeletar, gbcBtnDeletar);

        btnDeletar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPedido = textFieldIdPedido.getText();
                PedidosDeleteDb pedidosDeleteDb = new PedidosDeleteDb();
                boolean deletou = pedidosDeleteDb.deletarPedido(idPedido);

                if (deletou) {
                    JOptionPane.showMessageDialog(null, "Pedido deletado com sucesso!", "Deleção",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao deletar o pedido. Verifique o ID informado.",
                            "Deleção", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfacePedidosDeletar();
            }
        });
    }
}
