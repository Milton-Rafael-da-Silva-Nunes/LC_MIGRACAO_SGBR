package telas;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Rafael Nunes
 */
public class TelaSucessoMigracao extends JDialog {

    public TelaSucessoMigracao(TelaPrincipal telaPrincipal, String mensagemTela, String caminhoGif) {
        super(telaPrincipal, "Tela de Sucesso Migração", Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        configurarMouseListeners();
        ajustarTextoImagem(mensagemTela, caminhoGif);
    }
    
    private void ajustarTextoImagem(String mensagemTela, String caminhoGif) {
        JLabel textoLabel = new JLabel(mensagemTela + " ");
        textoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        textoLabel.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon imagemIcon = new ImageIcon(caminhoGif);

        JLabel imagemLabel = new JLabel(imagemIcon);

        jLabelMensagemTela.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jLabelMensagemTela.add(textoLabel);
        jLabelMensagemTela.add(imagemLabel);
    }
    
    private void configurarMouseListeners() {
        jPanelOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelOK.setBackground(new Color(182, 187, 187));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelOK.setBackground(new Color(48, 47, 97));  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); 
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMensagemTela = new javax.swing.JLabel();
        jPanelOK = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(480, 198));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMensagemTela.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelMensagemTela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelMensagemTela, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 60));

        jPanelOK.setBackground(new java.awt.Color(48, 47, 97));
        jPanelOK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OK");
        jPanelOK.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 40));

        jPanel1.add(jPanelOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 440, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(TelaConfirmacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMensagemTela;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOK;
    // End of variables declaration//GEN-END:variables
}
