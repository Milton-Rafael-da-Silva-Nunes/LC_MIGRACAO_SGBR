package telas;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author Rafael Nunes
 */
public class TelaConfirmacao extends JDialog {

    public TelaConfirmacao(TelaConfiguracaoBancoSGBR telaConfiguracaoBancoSgbr, String texto, String caminhoGif) {
        super(telaConfiguracaoBancoSgbr, "Tela confirmacao de conexão com o banco de dados", Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        configurarMouseListeners();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jLabelTexto.setText(texto);
        jLabelGif.setIcon(new ImageIcon(caminhoGif));
    }

    private void configurarMouseListeners() {
        jPanelOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelOk.setBackground(new Color(182, 187, 187));  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelOk.setBackground(new Color(48, 47, 97));  // Cor original
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Saindo da tela de confirmação.");
                dispose();  // Isso encerrará o programa
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTexto = new javax.swing.JLabel();
        jLabelGif = new javax.swing.JLabel();
        jPanelOk = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTexto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTexto.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 390, 60));

        jLabelGif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 50, 60));

        jPanelOk.setBackground(new java.awt.Color(48, 47, 97));
        jPanelOk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OK");
        jPanelOk.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 440, 30));

        jPanel1.add(jPanelOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 440, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfirmacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelGif;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOk;
    // End of variables declaration//GEN-END:variables
}
