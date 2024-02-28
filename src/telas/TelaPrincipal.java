package telas;

import application.Program;
import conexaoDB.firebird.FirebirdConnector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import sistemas.SGBR.model.entidades.Empresa;

/**
 *
 * @author Rafael Nunes
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private TelaMensagemPrincipal telaMensagemPrincipal;
    private FirebirdConnector firebirdConnector;
    protected String caminhoBanco;
    protected String usuario;
    protected String senha;
    protected String porta;
    protected List<Empresa> listaDeEmpresasSGBR;
    static Color preto = new Color(37, 37, 37); // cor Principal
    static Color cinza = new Color(113, 111, 114); // cor de efeito ao passar o mouse
    static Color roxo = new Color(99, 49, 148); // cor em Executar

    public TelaPrincipal() {
        initComponents();
        setLogoLc();
        setVisibilidadeBotoesDeSelecaoParaMigracao(false);
        configurarMouseListeners();
        jPanelMigracao.setVisible(false);
    }

    public void setLoginBancoFirebird(FirebirdConnector firebirdConnector, String caminhoBanco, String usuario, String senha, String porta, List<Empresa> listaDeEmpresasSGBR) {
        this.firebirdConnector = firebirdConnector;
        this.caminhoBanco = caminhoBanco;
        this.usuario = usuario;
        this.senha = senha;
        this.porta = porta;
        this.listaDeEmpresasSGBR = listaDeEmpresasSGBR;
        // Carrega a lista de Empresas para a combobox
        mostrarListaDeEmpresasCombobox(listaDeEmpresasSGBR);
    }

    private void setLogoLc() {
        ImageIcon icon = new ImageIcon("src/imagens/novaLogoLC.gif");
        icon.setImage(icon.getImage().getScaledInstance(200, 70, 20));
        lblLogo.setIcon(icon);
    }

    private void configurarMouseListeners() {
        // Adiciona ouvintes de eventos de mouse ao JPanelConfiguracao
        jPanelConfiguracao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelConfiguracao.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelConfiguracao.setBackground(preto);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                TelaConfiguracaoBancoSGBR telaConfiguracao = new TelaConfiguracaoBancoSGBR(TelaPrincipal.this);
                telaConfiguracao.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                telaConfiguracao.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                telaConfiguracao.setVisible(true);
            }
        });

        // Adiciona ouvintes de eventos de mouse ao JPanelMigracao
        jPanelMigracao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelMigracao.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelMigracao.setBackground(preto);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                jPanelSeletores.setVisible(true);
                jPanelExecutar.setVisible(true);
            }
        });

        // Adiciona ouvintes de eventos de mouse ao JPanelExecutar
        jPanelExecutar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelExecutar.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelExecutar.setBackground(roxo);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    if (btnClientes.isSelected() || btnFornecedores.isSelected() || btnProdutos.isSelected()) {
                        new Program(firebirdConnector).realizarOperacoes();
                        getTelaSucessoMigracao();
                    } else {
                        getTelaAtencao();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Adiciona ouvintes de eventos de mouse ao JLabel lblSair
        jPanelsair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelsair.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelsair.setBackground(preto);  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);  // Isso encerrará o programa
                System.out.println("Saindo do sistema");
            }
        });

        // Adiciona ouvintes de eventos de mouse ao JCombobox de Empresa
        jComboBoxEmpresas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém o índice da empresa selecionada na ComboBox
                int selectedIndex = jComboBoxEmpresas.getSelectedIndex();

                // Ajusta o índice para considerar a presença do item "Selecione"
                int adjustedIndex = selectedIndex - 1;

                if (adjustedIndex >= 0 && adjustedIndex < listaDeEmpresasSGBR.size()) {
                    Empresa empresaSelecionada = listaDeEmpresasSGBR.get(adjustedIndex);

                    // Chama o método para mostrar os dados da empresa
                    mostrarDadosEmpresaSelecionada(empresaSelecionada);
                }
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanelsair = new javax.swing.JPanel();
        lblSair = new javax.swing.JLabel();
        jPanelMenus = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelConfiguracao = new javax.swing.JPanel();
        jLabelConfiguracao = new javax.swing.JLabel();
        jPanelMigracao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelSeletores = new javax.swing.JPanel();
        jComboBoxEmpresas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanelDadosEmpresa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblRazaoSocial = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblRegime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCnpj = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblIe = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblUf = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxRegimeEmpresa = new javax.swing.JComboBox<>();
        jPanelSelecao = new javax.swing.JPanel();
        btnProdutos = new javax.swing.JRadioButton();
        jPanelProdutos = new javax.swing.JPanel();
        btnUnidade = new javax.swing.JRadioButton();
        btnCategoria = new javax.swing.JRadioButton();
        btnSubcategoria = new javax.swing.JRadioButton();
        btnNcm = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnCest = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnEstoque = new javax.swing.JRadioButton();
        btnFabricante = new javax.swing.JRadioButton();
        btnFornecedores = new javax.swing.JRadioButton();
        jPanelContasAPagar = new javax.swing.JPanel();
        btnPagar = new javax.swing.JRadioButton();
        btnPagas = new javax.swing.JRadioButton();
        jPanelContasReceber = new javax.swing.JPanel();
        btnReceber = new javax.swing.JRadioButton();
        btnRecebidas = new javax.swing.JRadioButton();
        btnClientes = new javax.swing.JRadioButton();
        jPanelExecutar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(37, 37, 37));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelsair.setBackground(new java.awt.Color(37, 37, 37));
        jPanelsair.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sair-50.png"))); // NOI18N
        jPanelsair.add(lblSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        jPanel3.add(jPanelsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 21, 60, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 1260, 110));

        jPanelMenus.setBackground(new java.awt.Color(37, 37, 37));
        jPanelMenus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(122, 123, 127));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(182, 187, 187));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 100));

        jPanelMenus.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 115));

        jPanelConfiguracao.setBackground(new java.awt.Color(37, 37, 37));
        jPanelConfiguracao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelConfiguracao.setBackground(new java.awt.Color(255, 255, 255));
        jLabelConfiguracao.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelConfiguracao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-configuração-40.png"))); // NOI18N
        jLabelConfiguracao.setText("  Configuração");
        jPanelConfiguracao.add(jLabelConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 100));

        jPanelMenus.add(jPanelConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 310, 110));

        jPanelMigracao.setBackground(new java.awt.Color(37, 37, 37));
        jPanelMigracao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-migração-de-dados-40.png"))); // NOI18N
        jLabel1.setText("  Migração");
        jPanelMigracao.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 300, 100));

        jPanelMenus.add(jPanelMigracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 238, 310, 110));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelMenus.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 290, 10));

        jPanel1.add(jPanelMenus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 310, 750));

        jPanelSeletores.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeletores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelSeletores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxEmpresas.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEmpresas.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jComboBoxEmpresas.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxEmpresas.setToolTipText("");
        jComboBoxEmpresas.setBorder(null);
        jComboBoxEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpresasActionPerformed(evt);
            }
        });
        jPanelSeletores.add(jComboBoxEmpresas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 1110, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Empresa:");
        jPanelSeletores.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanelDadosEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDadosEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações da Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(99, 49, 148))); // NOI18N
        jPanelDadosEmpresa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("E-mail:  ");
        jPanelDadosEmpresa.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Razão Social:  ");
        jPanelDadosEmpresa.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblRazaoSocial.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 30, 310, 16));

        lblEmail.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 70, 380, 16));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Bairro:  ");
        jPanelDadosEmpresa.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Regime:  ");
        jPanelDadosEmpresa.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        lblBairro.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 50, 160, 16));

        lblRegime.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblRegime, new org.netbeans.lib.awtextra.AbsoluteConstraints(916, 30, 210, 16));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CNPJ:  ");
        jPanelDadosEmpresa.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        lblCnpj.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 30, 180, 16));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("IE:  ");
        jPanelDadosEmpresa.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        lblIe.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblIe, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 30, 180, 16));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("UF:  ");
        jPanelDadosEmpresa.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, -1, -1));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cidade:  ");
        jPanelDadosEmpresa.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        lblCidade.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 50, 180, 16));

        lblUf.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 40, 16));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Endereço:  ");
        jPanelDadosEmpresa.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lblEndereco.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 50, 300, 16));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Telefone:  ");
        jPanelDadosEmpresa.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblTelefone.setForeground(new java.awt.Color(102, 102, 102));
        jPanelDadosEmpresa.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 70, 120, 16));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Regime da Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 13), new java.awt.Color(99, 49, 148))); // NOI18N
        jPanel2.setLayout(null);

        jComboBoxRegimeEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxRegimeEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxRegimeEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simples Nacional", "Regime Normal" }));
        jPanel2.add(jComboBoxRegimeEmpresa);
        jComboBoxRegimeEmpresa.setBounds(10, 25, 1160, 26);

        jPanelDadosEmpresa.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1180, 60));

        jPanelSeletores.add(jPanelDadosEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1200, 170));

        jPanelSelecao.setBackground(new java.awt.Color(238, 238, 238));
        jPanelSelecao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProdutos.setBackground(new java.awt.Color(238, 238, 238));
        btnProdutos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(0, 0, 0));
        btnProdutos.setText(" Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });
        jPanelSelecao.add(btnProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 250, -1));

        jPanelProdutos.setBackground(new java.awt.Color(238, 238, 238));
        jPanelProdutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUnidade.setBackground(new java.awt.Color(238, 238, 238));
        btnUnidade.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnUnidade.setForeground(new java.awt.Color(51, 51, 51));
        btnUnidade.setText(" Unidades");
        jPanelProdutos.add(btnUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 0, 160, -1));

        btnCategoria.setBackground(new java.awt.Color(238, 238, 238));
        btnCategoria.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(51, 51, 51));
        btnCategoria.setText(" Categorias");
        jPanelProdutos.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 30, -1, -1));

        btnSubcategoria.setBackground(new java.awt.Color(238, 238, 238));
        btnSubcategoria.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnSubcategoria.setForeground(new java.awt.Color(51, 51, 51));
        btnSubcategoria.setText(" Subcategorias");
        jPanelProdutos.add(btnSubcategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 60, -1, -1));

        btnNcm.setBackground(new java.awt.Color(238, 238, 238));
        btnNcm.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnNcm.setForeground(new java.awt.Color(51, 51, 51));
        btnNcm.setText(" Ncm");
        jPanelProdutos.add(btnNcm, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 140, -1, -1));
        jPanelProdutos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 210, 5));

        btnCest.setBackground(new java.awt.Color(238, 238, 238));
        btnCest.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnCest.setForeground(new java.awt.Color(51, 51, 51));
        btnCest.setText(" Cest");
        jPanelProdutos.add(btnCest, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 170, -1, -1));
        jPanelProdutos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 210, 210, 5));

        btnEstoque.setBackground(new java.awt.Color(238, 238, 238));
        btnEstoque.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnEstoque.setForeground(new java.awt.Color(51, 51, 51));
        btnEstoque.setText(" Estoque");
        jPanelProdutos.add(btnEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 220, 180, -1));

        btnFabricante.setBackground(new java.awt.Color(238, 238, 238));
        btnFabricante.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnFabricante.setForeground(new java.awt.Color(51, 51, 51));
        btnFabricante.setText(" Fabricante");
        jPanelProdutos.add(btnFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 90, -1, -1));

        jPanelSelecao.add(jPanelProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 250, 260));

        btnFornecedores.setBackground(new java.awt.Color(238, 238, 238));
        btnFornecedores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnFornecedores.setForeground(new java.awt.Color(0, 0, 0));
        btnFornecedores.setText(" Fornecedores");
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });
        jPanelSelecao.add(btnFornecedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 170, -1));

        jPanelContasAPagar.setBackground(new java.awt.Color(238, 238, 238));
        jPanelContasAPagar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPagar.setBackground(new java.awt.Color(238, 238, 238));
        btnPagar.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(51, 51, 51));
        btnPagar.setText(" Pagar");
        jPanelContasAPagar.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 0, 130, -1));

        btnPagas.setBackground(new java.awt.Color(238, 238, 238));
        btnPagas.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnPagas.setForeground(new java.awt.Color(51, 51, 51));
        btnPagas.setText(" Pagas");
        jPanelContasAPagar.add(btnPagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 130, -1));

        jPanelSelecao.add(jPanelContasAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 150, 60));

        jPanelContasReceber.setBackground(new java.awt.Color(238, 238, 238));
        jPanelContasReceber.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReceber.setBackground(new java.awt.Color(238, 238, 238));
        btnReceber.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnReceber.setForeground(new java.awt.Color(51, 51, 51));
        btnReceber.setText(" Receber");
        jPanelContasReceber.add(btnReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, -1));

        btnRecebidas.setBackground(new java.awt.Color(238, 238, 238));
        btnRecebidas.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnRecebidas.setForeground(new java.awt.Color(51, 51, 51));
        btnRecebidas.setText(" Recebidas");
        jPanelContasReceber.add(btnRecebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jPanelSelecao.add(jPanelContasReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 60));

        btnClientes.setBackground(new java.awt.Color(238, 238, 238));
        btnClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 0, 0));
        btnClientes.setText(" Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanelSelecao.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, -1));

        jPanelSeletores.add(jPanelSelecao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1200, 410));

        jPanel1.add(jPanelSeletores, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 1220, 650));

        jPanelExecutar.setBackground(new java.awt.Color(99, 49, 148));
        jPanelExecutar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-play-30.png"))); // NOI18N
        jLabel3.setText(" Executar");
        jPanelExecutar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 180, 50));

        jPanel1.add(jPanelExecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 795, 180, 50));

        jPanel4.setBackground(new java.awt.Color(99, 49, 148));
        jPanel4.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(37, 37, 37));
        jPanel5.setLayout(null);

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(lblLogo);
        lblLogo.setBounds(0, 0, 300, 100);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(5, 5, 300, 100);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 860));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        if (btnClientes.isSelected()) {
            setVisibilidadeBotoesDeClientes(true, "N");
        } else {
            setVisibilidadeBotoesDeClientes(false, "S");
        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        if (btnFornecedores.isSelected()) {
            setVisibilidadeBotoesDeFornecedores(true, "N");
        } else {
            setVisibilidadeBotoesDeFornecedores(false, "S");
        }
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        if (btnProdutos.isSelected()) {
            setVisibilidadeBotoesDeProdutos(true, "N");
        } else {
            setVisibilidadeBotoesDeProdutos(false, "S");
        }
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void jComboBoxEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpresasActionPerformed
        if (!jComboBoxEmpresas.getSelectedItem().equals("Selecione")) {
            jPanelDadosEmpresa.setVisible(true);
            jPanelSelecao.setVisible(true);
        } else {
            jPanelDadosEmpresa.setVisible(false);
            jPanelSelecao.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxEmpresasActionPerformed

    private void mostrarListaDeEmpresasCombobox(List<Empresa> listaDeEmpresasSGBR) {
        jComboBoxEmpresas.removeAllItems();

        jComboBoxEmpresas.addItem("Selecione");

        listaDeEmpresasSGBR.forEach((empresa) -> {
            jComboBoxEmpresas.addItem(empresa.toString().toUpperCase());
        });
    }

    private void mostrarDadosEmpresaSelecionada(Empresa empresa) {
        lblRazaoSocial.setText(empresa.getRazaoSocial().toUpperCase());
        lblEmail.setText(empresa.getEndereco().toUpperCase());
        lblBairro.setText(empresa.getBairro().toUpperCase());
        lblEndereco.setText(empresa.getEndereco().toUpperCase());
        lblRegime.setText(empresa.getCrt().toUpperCase());
        lblCnpj.setText(empresa.getCnpj());
        lblIe.setText(empresa.getIe());
        lblCidade.setText(empresa.getCidade().toUpperCase());
        lblUf.setText(empresa.getUf().toUpperCase());
        lblTelefone.setText(empresa.getTelefone());
        lblEmail.setText(empresa.getEmail());
    }

    public void setVisibilidadePainelMigracao(boolean pode) {
        jPanelMigracao.setVisible(pode);
    }

    public void setVisibilidadePainelConfiguracao(boolean pode) {
        jPanelConfiguracao.setVisible(pode);
    }

    private void setVisibilidadeBotoesDeSelecaoParaMigracao(boolean pode) {
        btnReceber.setEnabled(pode);
        btnRecebidas.setEnabled(pode);
        btnPagar.setEnabled(pode);
        btnPagas.setEnabled(pode);
        btnUnidade.setEnabled(pode);
        btnCategoria.setEnabled(pode);
        btnSubcategoria.setEnabled(pode);
        btnFabricante.setEnabled(pode);
        btnNcm.setEnabled(pode);
        btnCest.setEnabled(pode);
        btnEstoque.setEnabled(pode);
    }

    private void setVisibilidadeBotoesDeClientes(boolean pode, String desmarcar) {
        if (desmarcar.equalsIgnoreCase("N")) {
            btnReceber.setEnabled(pode);
            btnRecebidas.setEnabled(pode);
        } else {
            btnReceber.setEnabled(pode);
            btnRecebidas.setEnabled(pode);
            btnReceber.setSelected(pode);
            btnRecebidas.setSelected(pode);
        }
    }

    private void setVisibilidadeBotoesDeFornecedores(boolean pode, String desmarcar) {
        if (desmarcar.equalsIgnoreCase("N")) {
            btnPagar.setEnabled(pode);
            btnPagas.setEnabled(pode);
        } else {
            btnPagar.setEnabled(pode);
            btnPagas.setEnabled(pode);
            btnPagar.setSelected(pode);
            btnPagas.setSelected(pode);
        }
    }

    private void setVisibilidadeBotoesDeProdutos(boolean pode, String desmarcar) {
        if (desmarcar.equalsIgnoreCase("N")) {
            btnUnidade.setEnabled(pode);
            btnCategoria.setEnabled(pode);
            btnSubcategoria.setEnabled(pode);
            btnFabricante.setEnabled(pode);
            btnNcm.setEnabled(pode);
            btnCest.setEnabled(pode);
            btnEstoque.setEnabled(pode);
        } else {
            btnUnidade.setEnabled(false);
            btnCategoria.setEnabled(false);
            btnSubcategoria.setEnabled(false);
            btnFabricante.setEnabled(false);
            btnNcm.setEnabled(false);
            btnCest.setEnabled(false);
            btnEstoque.setEnabled(false);
            btnUnidade.setSelected(false);
            btnCategoria.setSelected(false);
            btnSubcategoria.setSelected(false);
            btnFabricante.setSelected(false);
            btnNcm.setSelected(false);
            btnCest.setSelected(false);
            btnEstoque.setSelected(false);
        }
    }

    private void exibirMensagemEmTela(String mensagem, String caminhoIcone) {
        telaMensagemPrincipal = new TelaMensagemPrincipal(TelaPrincipal.this, mensagem, caminhoIcone);
        telaMensagemPrincipal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        telaMensagemPrincipal.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
        telaMensagemPrincipal.setVisible(true);
    }

    // Variaveis de icones.
    private static final String OK_ICON_PATH = "src/imagens/icons8-ok.gif";
    private static final String ATENCAO_ICON_PATH = "src/imagens/icons8-atencao.gif.gif";

    private void getTelaSucessoMigracao() {
        exibirMensagemEmTela("Migração finalizada com sucesso!", OK_ICON_PATH);
    }

    private void getTelaAtencao() {
        exibirMensagemEmTela("Selecione uma tebela!", ATENCAO_ICON_PATH);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton btnCategoria;
    public static javax.swing.JRadioButton btnCest;
    public static javax.swing.JRadioButton btnClientes;
    public static javax.swing.JRadioButton btnEstoque;
    public static javax.swing.JRadioButton btnFabricante;
    public static javax.swing.JRadioButton btnFornecedores;
    public static javax.swing.JRadioButton btnNcm;
    public static javax.swing.JRadioButton btnPagar;
    private javax.swing.JRadioButton btnPagas;
    public static javax.swing.JRadioButton btnProdutos;
    public static javax.swing.JRadioButton btnReceber;
    private javax.swing.JRadioButton btnRecebidas;
    public static javax.swing.JRadioButton btnSubcategoria;
    public static javax.swing.JRadioButton btnUnidade;
    private javax.swing.JComboBox<String> jComboBoxEmpresas;
    public static javax.swing.JComboBox<String> jComboBoxRegimeEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelConfiguracao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelConfiguracao;
    private javax.swing.JPanel jPanelContasAPagar;
    private javax.swing.JPanel jPanelContasReceber;
    private javax.swing.JPanel jPanelDadosEmpresa;
    private javax.swing.JPanel jPanelExecutar;
    private javax.swing.JPanel jPanelMenus;
    private javax.swing.JPanel jPanelMigracao;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JPanel jPanelSelecao;
    private javax.swing.JPanel jPanelSeletores;
    private javax.swing.JPanel jPanelsair;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblIe;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblRazaoSocial;
    private javax.swing.JLabel lblRegime;
    private javax.swing.JLabel lblSair;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblUf;
    // End of variables declaration//GEN-END:variables
}
