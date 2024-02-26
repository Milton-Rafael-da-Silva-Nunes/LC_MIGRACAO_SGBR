package telas;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import static telas.TelaPrincipal.cinza;
import static telas.TelaPrincipal.roxo;

/**
 *
 * @author Rafael Nunes
 */
public class TelaConfirmacao extends JDialog {

    public TelaConfirmacao(TelaConfiguracaoBancoSGBR telaConfiguracaoBancoSgbr, String texto, String caminhoGif) {
        super(telaConfiguracaoBancoSgbr, "Tela confirmacao de conexão com o banco de dados", Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        configurarMouseListeners();
        ajustarTextoImagem(texto, caminhoGif);
    }

    private void ajustarTextoImagem(String mensagemTela, String caminhoGif) {
        JLabel textoLabel = new JLabel(mensagemTela + " ");
        textoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        textoLabel.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon imagemIcon = new ImageIcon(caminhoGif);

        JLabel imagemLabel = new JLabel(imagemIcon);

        jLabelTexto.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jLabelTexto.add(textoLabel);
        jLabelTexto.add(imagemLabel);
    }

    private void configurarMouseListeners() {
        jPanelOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jPanelOk.setBackground(cinza);  // Cor ao passar o mouse
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jPanelOk.setBackground(roxo);  // Cor original
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
        jLabelTexto = new javax.swing.JLabel();
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
        jPanel1.add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 440, 60));

        jPanelOk.setBackground(new java.awt.Color(99, 49, 148));
        jPanelOk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OK");
        jPanelOk.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 40));

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
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOk;
    // End of variables declaration//GEN-END:variables
}
