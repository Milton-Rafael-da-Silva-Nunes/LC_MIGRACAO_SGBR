package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rafael Nunes
 */
public class TelaConfiguracaoBancoSGBR extends javax.swing.JFrame {

    private String caminhoDoArquivoSelecionado;
    
    public TelaConfiguracaoBancoSGBR() {
        initComponents();
        configurarMouseListeners();
        configurarGradienteTopo(jPanelTopo,  new Color(21, 30, 60), new Color(72, 61, 139), true);
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
        jPanelPesquisa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelPesquisa.setBackground(new Color(182, 187, 187));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelPesquisa.setBackground(new Color(255, 255, 255));  // Cor original
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirFileChooser();
                // Seta o caminho do banco para a tela do usuario
                jLabelLocalbanco.setText(" " + caminhoDoArquivoSelecionado);
            }
        });

        jPanelSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelSair.setBackground(new Color(182, 187, 187));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelSair.setBackground(new Color(106, 90, 205));  // Cor original
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Saindo da tela de configuração SGBR");
                dispose();  // Isso encerrará o programa
            }
        });
        
        jPanelSalvar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelSalvar.setBackground(new Color(182, 187, 187));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelSalvar.setBackground(new Color(106, 90, 205));  // Cor original
            }
        });
        
        jPanelTestarConexao.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelTestarConexao.setBackground(new Color(182, 187, 187));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelTestarConexao.setBackground(new Color(106, 90, 205));  // Cor original
            }
        });
    }
    
    private void abrirFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        // Define o filtro para aceitar apenas arquivos com extensões .FDB e .GDB
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Banco de Dados (*.FDB, *.GDB)", "FDB", "GDB");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // O usuário selecionou um arquivo
            caminhoDoArquivoSelecionado = fileChooser.getSelectedFile().getAbsolutePath();
            // Faça o que for necessário com o caminho do arquivo selecionado
            System.out.println("Caminho do arquivo selecionado: " + caminhoDoArquivoSelecionado);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelLocalbanco = new javax.swing.JLabel();
        jPanelPesquisa = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanelSair = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelSalvar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelTestarConexao = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanelTopo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Local:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, -1));

        jPanel2.setBackground(new java.awt.Color(106, 90, 205));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLocalbanco.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLocalbanco.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelLocalbanco.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLocalbanco.setText("  EX:");
        jPanel2.add(jLabelLocalbanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 35));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 600, 35));

        jPanelPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPesquisa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-35.png"))); // NOI18N
        jPanelPesquisa.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel1.add(jPanelPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 82, 50, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 660, 290));

        jPanelSair.setBackground(new java.awt.Color(106, 90, 205));
        jPanelSair.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sair-22.png"))); // NOI18N
        jLabel4.setText(" Sair");
        jPanelSair.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        jPanel1.add(jPanelSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 90, 50));

        jPanelSalvar.setBackground(new java.awt.Color(106, 90, 205));
        jPanelSalvar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-salvar-22.png"))); // NOI18N
        jLabel5.setText(" Salvar");
        jPanelSalvar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        jPanel1.add(jPanelSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 90, 50));

        jPanelTestarConexao.setBackground(new java.awt.Color(106, 90, 205));
        jPanelTestarConexao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-configuração-de-dados-22.png"))); // NOI18N
        jLabel6.setText(" Testar");
        jPanelTestarConexao.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 50));

        jPanel1.add(jPanelTestarConexao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 90, 50));

        jPanelTopo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo SGBR.png"))); // NOI18N
        jLabel7.setText(" Configuração com o banco de dados");

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracaoBancoSGBR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracaoBancoSGBR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracaoBancoSGBR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracaoBancoSGBR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConfiguracaoBancoSGBR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLocalbanco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JPanel jPanelSair;
    private javax.swing.JPanel jPanelSalvar;
    private javax.swing.JPanel jPanelTestarConexao;
    private javax.swing.JPanel jPanelTopo;
    // End of variables declaration//GEN-END:variables
}