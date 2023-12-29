package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Nunes
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        imagemLc();
        configurarMouseListeners();
        configurarGradienteMenus(jPanelMenus, new Color(72, 61, 139), new Color(21, 30, 60), false);
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
                new TelaConfiguracaoBancoSGBR().setVisible(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 860));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelConfiguracao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelConfiguracao;
    private javax.swing.JPanel jPanelMenus;
    private javax.swing.JPanel jPanelMigracao;
    private javax.swing.JPanel jPanelsair;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSair;
    // End of variables declaration//GEN-END:variables
}
