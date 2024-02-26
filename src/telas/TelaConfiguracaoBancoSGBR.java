package telas;

import conexaoDB.firebird.FirebirdConnector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import sistemas.SGBR.model.dao.impl.EmpresaDaoJDBC;
import sistemas.SGBR.model.entidades.Empresa;
import static telas.TelaPrincipal.cinza;
import static telas.TelaPrincipal.roxo;

/**
 *
 * @author Rafael Nunes
 */
public class TelaConfiguracaoBancoSGBR extends JDialog {

    private String caminhoBanco;
    private String usuario;
    private String senha;
    private String porta;
    private TelaConfirmacao telaConfirmacao;
    private TelaPrincipal telaPrincipal;
    Color branco = new Color(255, 255, 255);

    public TelaConfiguracaoBancoSGBR(TelaPrincipal telaPrincipal) {
        super(telaPrincipal, "Configuração do Banco de Dados", Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        configurarMouseListeners();
        //configurarGradienteTopo(jPanelTopo, new Color(20, 21, 81), new Color(72, 61, 139), true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.telaPrincipal = telaPrincipal;
    }

    private void configurarGradienteTopo(JPanel panel, Color startColor, Color endColor, boolean horizontal) {
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        JPanel gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int w = getWidth();
                int h = getHeight();

                // Ajuste para tornar o final do gradiente mais escuro
                Color darkerEndColor = endColor.darker();

                GradientPaint gradientPaint;

                if (horizontal) {
                    gradientPaint = new GradientPaint(0, 0, startColor, 0, h, darkerEndColor);
                } else {
                    gradientPaint = new GradientPaint(0, 0, startColor, 0, h, darkerEndColor);
                }

                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, w, h);
                g2d.dispose();
            }
        };

        panel.add(gradientPanel);
    }

    private void configurarMouseListeners() {
        jPanelPesquisar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelPesquisar.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelPesquisar.setBackground(branco);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                abrirFileChooser();
                // Seta o caminho do banco para a tela do usuario
                jLabelLocalbanco.setText(" " + caminhoBanco);
            }
        });

        jPanelSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelSair.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelSair.setBackground(roxo);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        jPanelTestarConexao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelTestarConexao.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelTestarConexao.setBackground(roxo);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                usuario = txtUsuario.getText().toUpperCase();
                senha = txtSenha.getText();
                porta = txtPorta.getText();

                // No metodo que testa ja fecha a conexao de teste
                FirebirdConnector conector = new FirebirdConnector(porta, caminhoBanco, usuario, senha);
                boolean conexaoValida = conector.testarConexao(porta, usuario, senha, caminhoBanco);

                if (conexaoValida) {
                    getTelaConfirmacaoConexao();
                } else {
                    getTelaRejeicaoConexao();
                    txtSenha.setText("");
                }
            }
        });

        jPanelSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelSalvar.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelSalvar.setBackground(roxo);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                usuario = txtUsuario.getText().toUpperCase();
                senha = txtSenha.getText();
                porta = txtPorta.getText();

                FirebirdConnector firebirdConnector = new FirebirdConnector(porta, caminhoBanco, usuario, senha);
                boolean validarConexao = firebirdConnector.testarConexao(porta, usuario, senha, caminhoBanco);

                if (validarConexao) {
                    EmpresaDaoJDBC empresas = new EmpresaDaoJDBC(firebirdConnector.getConnection());
                    List<Empresa> listaDeEmpresas = empresas.findAll();
                    configurarTelaPrincipal(firebirdConnector, caminhoBanco, usuario, senha, porta, listaDeEmpresas);
                } else {
                    getTelaLoginNaoSalvo();
                }
            }
        });
    }

    private void configurarTelaPrincipal(FirebirdConnector firebirdConnector, String caminhoBanco, String usuario, String senha, String porta, List<Empresa> listaDeEmpresas) {
        telaPrincipal.setLoginBancoFirebird(firebirdConnector, caminhoBanco, usuario, senha, porta, listaDeEmpresas);
        getTelaLoginSalvo();
        dispose();
        telaPrincipal.setVisibilidadePainelMigracao(true);
        telaPrincipal.setVisibilidadePainelConfiguracao(false);
    }

    private void exibirMensagem(String mensagem, String caminhoIcone) {
        telaConfirmacao = new TelaConfirmacao(TelaConfiguracaoBancoSGBR.this, mensagem, caminhoIcone);
        telaConfirmacao.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        telaConfirmacao.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        telaConfirmacao.setVisible(true);
    }

    // Adicione constantes para ícones e caminhos
    private static final String OK_ICON_PATH = "src/imagens/icons8-ok.gif";
    private static final String ERRO_ICON_PATH = "src/imagens/icons8-erro.gif";
    private static final String ATENCAO_ICON_PATH = "src/imagens/icons8-atencao.gif.gif";

    private void getTelaConfirmacaoConexao() {
        exibirMensagem("Conexão com o Banco aprovada!", OK_ICON_PATH);
    }

    private void getTelaRejeicaoConexao() {
        exibirMensagem("Conexão com o Banco reprovada!", ERRO_ICON_PATH);
    }

    private void getTelaLoginSalvo() {
        exibirMensagem("Salvo com sucesso!", OK_ICON_PATH);
    }

    private void getTelaLoginNaoSalvo() {
        exibirMensagem("Verifique os dados de login!", ATENCAO_ICON_PATH);
    }

    private void abrirFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        // Define o filtro para aceitar apenas arquivos com extensões .FDB e .GDB
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Banco de Dados (*.FDB, *.GDB)", "FDB", "GDB");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            caminhoBanco = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelLocalbanco = new javax.swing.JLabel();
        jPanelPesquisar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jPanelTestarConexao = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        jPanelSair = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelSalvar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelTopo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Local:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 60, 30));

        jPanel2.setBackground(new java.awt.Color(99, 49, 148));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLocalbanco.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLocalbanco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelLocalbanco.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabelLocalbanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 600, 35));

        jPanelPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPesquisar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-33.png"))); // NOI18N
        jPanelPesquisar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel1.add(jPanelPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 82, 50, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Servidor");

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel8.setText("Usuario");

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setText("Senha");

        txtServidor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtServidor.setForeground(new java.awt.Color(0, 0, 0));

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setText("SYSDBA");

        jPanelTestarConexao.setBackground(new java.awt.Color(99, 49, 148));
        jPanelTestarConexao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-configuração-de-dados-22.png"))); // NOI18N
        jLabel6.setText(" Testar");
        jPanelTestarConexao.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        txtSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));
        txtSenha.setText("masterkey");

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setText("Porta");

        txtPorta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPorta.setForeground(new java.awt.Color(0, 0, 0));
        txtPorta.setText("3050");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelTestarConexao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanelTestarConexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 250));

        jPanelSair.setBackground(new java.awt.Color(99, 49, 148));
        jPanelSair.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sair-22.png"))); // NOI18N
        jLabel4.setText(" Sair");
        jPanelSair.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        jPanel1.add(jPanelSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 90, 50));

        jPanelSalvar.setBackground(new java.awt.Color(99, 49, 148));
        jPanelSalvar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-salvar-22.png"))); // NOI18N
        jLabel5.setText(" Salvar");
        jPanelSalvar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        jPanel1.add(jPanelSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 90, 50));

        jPanelTopo.setBackground(new java.awt.Color(37, 37, 37));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo SGBR.png"))); // NOI18N
        jLabel7.setText("   Configuração do Banco de Dados");

        javax.swing.GroupLayout jPanelTopoLayout = new javax.swing.GroupLayout(jPanelTopo);
        jPanelTopo.setLayout(jPanelTopoLayout);
        jPanelTopoLayout.setHorizontalGroup(
            jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jPanelTopoLayout.setVerticalGroup(
            jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelTopo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracaoBancoSGBR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLocalbanco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelPesquisar;
    private javax.swing.JPanel jPanelSair;
    private javax.swing.JPanel jPanelSalvar;
    private javax.swing.JPanel jPanelTestarConexao;
    private javax.swing.JPanel jPanelTopo;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtServidor;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
