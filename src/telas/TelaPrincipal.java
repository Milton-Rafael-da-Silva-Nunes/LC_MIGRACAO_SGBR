package telas;

import conexaoDB.firebird.FirebirdConnector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Nunes
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private FirebirdConnector firebirdConnector;

    public TelaPrincipal() {
        initComponents();
        imagemLc();
        esconderPaineis();
        configurarMouseListeners();
        configurarGradienteMenus(jPanelMenus, new Color(72, 61, 139), new Color(21, 30, 60), false);
        firebirdConnector = new FirebirdConnector();
    }

    private void configurarGradienteMenus(JPanel panel, Color startColor, Color endColor, boolean horizontal) {
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
                    gradientPaint = new GradientPaint(w, 0, startColor, 0, 0, darkerEndColor);
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
        // Adiciona ouvintes de eventos de mouse ao JPanelConfiguracao
        jPanelConfiguracao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelConfiguracao.setBackground(new Color(123, 104, 238));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelConfiguracao.setBackground(new Color(48, 47, 97));  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                TelaConfiguracaoBancoSGBR telaConfiguracao = new TelaConfiguracaoBancoSGBR(TelaPrincipal.this, firebirdConnector);
                telaConfiguracao.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                telaConfiguracao.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
                telaConfiguracao.setVisible(true);
            }
        });

        // Adiciona ouvintes de eventos de mouse ao JPanelMigracao
        jPanelMigracao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelMigracao.setBackground(new Color(123, 104, 238));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelMigracao.setBackground(new Color(48, 47, 97));  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                jPanelSeletores.setVisible(true);
            }
        });

        // Adiciona ouvintes de eventos de mouse ao JLabel lblSair
        jPanelsair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelsair.setBackground(new Color(123, 104, 238));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelsair.setBackground(new Color(106, 90, 205));  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);  // Isso encerrará o programa
                System.out.println("Saindo do sistema");
            }
        });
    }

    private void imagemLc() {
        ImageIcon icon = new ImageIcon("src/imagens/lc_logoSofthouse.gif");
        icon.setImage(icon.getImage().getScaledInstance(280, 280, 20));
        lblLogo.setIcon(icon);
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
        lblLogo = new javax.swing.JLabel();
        jPanelSeletores = new javax.swing.JPanel();
        jPanelContasReceber = new javax.swing.JPanel();
        btnReceber = new javax.swing.JRadioButton();
        btnRecebidas = new javax.swing.JRadioButton();
        btnClientes = new javax.swing.JRadioButton();
        jPanelContasAPagar = new javax.swing.JPanel();
        btnPagar = new javax.swing.JRadioButton();
        btnPagas = new javax.swing.JRadioButton();
        btnFornecedores = new javax.swing.JRadioButton();
        jPanelProdutos = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButton5 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        btnProdutos = new javax.swing.JRadioButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(106, 90, 205));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelsair.setBackground(new java.awt.Color(106, 90, 205));
        jPanelsair.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sair-50.png"))); // NOI18N
        jPanelsair.add(lblSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        jPanel3.add(jPanelsair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, 60, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, -10, 1270, 120));

        jPanelMenus.setBackground(new java.awt.Color(48, 47, 97));
        jPanelMenus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(106, 90, 205));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(182, 187, 187));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Home");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 100));

        jPanelMenus.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 115));

        jPanelConfiguracao.setBackground(new java.awt.Color(48, 47, 97));
        jPanelConfiguracao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelConfiguracao.setBackground(new java.awt.Color(255, 255, 255));
        jLabelConfiguracao.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelConfiguracao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-configuração-40.png"))); // NOI18N
        jLabelConfiguracao.setText("  Configuração");
        jPanelConfiguracao.add(jLabelConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 100));

        jPanelMenus.add(jPanelConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 310, 110));

        jPanelMigracao.setBackground(new java.awt.Color(48, 47, 97));
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

        jPanel1.add(jPanelMenus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 310, 760));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 110));

        jPanelSeletores.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeletores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelSeletores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContasReceber.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContasReceber.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReceber.setBackground(new java.awt.Color(255, 255, 255));
        btnReceber.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnReceber.setForeground(new java.awt.Color(51, 51, 51));
        btnReceber.setText(" Receber");
        jPanelContasReceber.add(btnReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, -1));

        btnRecebidas.setBackground(new java.awt.Color(255, 255, 255));
        btnRecebidas.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnRecebidas.setForeground(new java.awt.Color(51, 51, 51));
        btnRecebidas.setText(" Recebidas");
        jPanelContasReceber.add(btnRecebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jPanelSeletores.add(jPanelContasReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, 150, 60));

        btnClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnClientes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 0, 0));
        btnClientes.setText(" Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanelSeletores.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 40, 260, -1));

        jPanelContasAPagar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContasAPagar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPagar.setBackground(new java.awt.Color(255, 255, 255));
        btnPagar.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(51, 51, 51));
        btnPagar.setText(" Pagar");
        jPanelContasAPagar.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 0, 130, -1));

        btnPagas.setBackground(new java.awt.Color(255, 255, 255));
        btnPagas.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btnPagas.setForeground(new java.awt.Color(51, 51, 51));
        btnPagas.setText(" Pagas");
        jPanelContasAPagar.add(btnPagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 130, -1));

        jPanelSeletores.add(jPanelContasAPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 150, 60));

        btnFornecedores.setBackground(new java.awt.Color(255, 255, 255));
        btnFornecedores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnFornecedores.setForeground(new java.awt.Color(0, 0, 0));
        btnFornecedores.setText(" Fornecedores");
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });
        jPanelSeletores.add(btnFornecedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 260, -1));

        jPanelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProdutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton1.setText(" Unidades");
        jPanelProdutos.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 0, 160, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton2.setText(" Categorias");
        jPanelProdutos.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 30, -1, -1));

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton3.setText(" Subcategorias");
        jPanelProdutos.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 60, -1, -1));

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton4.setText(" Ncm");
        jPanelProdutos.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 140, -1, -1));
        jPanelProdutos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 130, 210, 5));

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton5.setText(" Cest");
        jPanelProdutos.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 170, -1, -1));
        jPanelProdutos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 210, 210, 5));

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton6.setText(" Estoque");
        jPanelProdutos.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 220, 180, -1));

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(51, 51, 51));
        jRadioButton7.setText(" Fabricante");
        jPanelProdutos.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 90, -1, -1));

        jPanelSeletores.add(jPanelProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 250, 260));

        btnProdutos.setBackground(new java.awt.Color(255, 255, 255));
        btnProdutos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnProdutos.setForeground(new java.awt.Color(0, 0, 0));
        btnProdutos.setText(" Produtos");
        btnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutosActionPerformed(evt);
            }
        });
        jPanelSeletores.add(btnProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 260, -1));

        jPanel1.add(jPanelSeletores, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 1220, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 860));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        if (btnClientes.isSelected()) {
            jPanelContasReceber.setVisible(true);
        } else {
            jPanelContasReceber.setVisible(false);
        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        if (btnFornecedores.isSelected()) {
            jPanelContasAPagar.setVisible(true);
        } else {
            jPanelContasAPagar.setVisible(false);
        }
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void btnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutosActionPerformed
        if (btnProdutos.isSelected()) {
            jPanelProdutos.setVisible(true);
        } else {
            jPanelProdutos.setVisible(false);
        }
    }//GEN-LAST:event_btnProdutosActionPerformed

    private void esconderPaineis() {
        jPanelSeletores.setVisible(false);
        jPanelContasReceber.setVisible(false);
        jPanelContasAPagar.setVisible(false);
        jPanelProdutos.setVisible(false);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnClientes;
    private javax.swing.JRadioButton btnFornecedores;
    private javax.swing.JRadioButton btnPagar;
    private javax.swing.JRadioButton btnPagas;
    private javax.swing.JRadioButton btnProdutos;
    private javax.swing.JRadioButton btnReceber;
    private javax.swing.JRadioButton btnRecebidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelConfiguracao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelConfiguracao;
    private javax.swing.JPanel jPanelContasAPagar;
    private javax.swing.JPanel jPanelContasReceber;
    private javax.swing.JPanel jPanelMenus;
    private javax.swing.JPanel jPanelMigracao;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JPanel jPanelSeletores;
    private javax.swing.JPanel jPanelsair;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSair;
    // End of variables declaration//GEN-END:variables
}
