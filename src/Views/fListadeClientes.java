package Views;

import DAO.PedidoDAO;
import DAO.PessoaDAO;
import DAO.itensPedidoDAO;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Pedido;
import models.Pessoa;
import models.itensPedido;

/**
 *
 * @author Rodrigo and Danilo
 */
public class fListadeClientes extends javax.swing.JDialog {

    /**
     * Creates new form fListadeClientes
     */
    
    int x, y;
    
    public fListadeClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));
        
        readJTable();
    }
    
    //Função para ler valores do BD e atualizá-los.
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        PessoaDAO pDAO = new PessoaDAO();
        
        for(Pessoa p: pDAO.read()){
            
            modelo.addRow(new Object[]{
                p.getId_pessoa(),
                p.getNome(),
                p.getEndereco(),
                p.getCpf(),
                p.getTelefone(),
                p.getSexo(),
            });
        }
    }
    
    //Função para ler valores do BD e atualizá-los.
    public void readJTableForClient(String client){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        PessoaDAO pDAO = new PessoaDAO();
        modelo.setNumRows(0);
        
        for(Pessoa p: pDAO.readForClient(client)){
            
            modelo.addRow(new Object[]{
                p.getId_pessoa(),
                p.getNome(),
                p.getEndereco(),
                p.getCpf(),
                p.getTelefone(),
                p.getSexo(),
            });
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2_Excluir = new javax.swing.JButton();
        jButton3_Fechar = new javax.swing.JButton();
        jButton4_Editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_filtro_cliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Endereço", "CPF", "Telefone", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2_Excluir.setText("Excluir");
        jButton2_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_ExcluirActionPerformed(evt);
            }
        });

        jButton3_Fechar.setText("Fechar");
        jButton3_Fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_FecharActionPerformed(evt);
            }
        });

        jButton4_Editar.setText("Salvar");
        jButton4_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_EditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtro:");

        jTextField1_filtro_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_filtro_clienteActionPerformed(evt);
            }
        });
        jTextField1_filtro_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_filtro_clienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButton4_Editar)
                        .addGap(137, 137, 137)
                        .addComponent(jButton2_Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3_Fechar)
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1_filtro_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1_filtro_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2_Excluir)
                    .addComponent(jButton3_Fechar)
                    .addComponent(jButton4_Editar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt){
        
    }
    
    private void jButton3_FecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_FecharActionPerformed
        //Botão Fechar 
        this.dispose();
    }//GEN-LAST:event_jButton3_FecharActionPerformed

    private void jButton4_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_EditarActionPerformed
        // Botão EDITAR        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        
        if (jTable1.getSelectedRow() != -1){
                        
            Pessoa p = new Pessoa();
            
             p.setId_pessoa(((int) modelo.getValueAt(jTable1.getSelectedRow(), 0)));
             p.setNome((String) modelo.getValueAt(jTable1.getSelectedRow(), 1));
             p.setEndereco((String) modelo.getValueAt(jTable1.getSelectedRow(), 2));
             p.setCpf((String) modelo.getValueAt(jTable1.getSelectedRow(), 3));
             p.setTelefone((String) modelo.getValueAt(jTable1.getSelectedRow(), 4));
             p.setSexo((String) modelo.getValueAt(jTable1.getSelectedRow(), 4));
             
             PessoaDAO pdao = new PessoaDAO();
             
             pdao.update(p);
             
        }
    }//GEN-LAST:event_jButton4_EditarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Clique do mouse na tabela
       x = jTable1.getSelectedRow();
       
       if(x!= -1 && x!= y){
       
       DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
       
       while(jTable1.getRowCount()>0){
            modelo.removeRow(0);
        }
           readJTableForClient(jTextField1_filtro_cliente.getText());
           
        jTable1.setRowSelectionInterval(x, x);
       }
        y = x;
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_ExcluirActionPerformed
       
        //EXCLUIR
        
         DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        
        if (jTable1.getSelectedRow() != -1) {
            
            Pessoa p = new Pessoa();
             p.setId_pessoa((int) modelo.getValueAt(jTable1.getSelectedRow(), 0));
             
             PedidoDAO ppdao = new PedidoDAO();
             itensPedidoDAO idao = new itensPedidoDAO();
             
             
             for(Pedido p2 : ppdao.excluirpegarpedidos(p)){
            
            int n = p2.getNumero_pedido();
            
            idao.deletenovo(n);
            ppdao.deletenovo(n);
            
        }
             
             
             
             
             
             

            PessoaDAO pdao = new PessoaDAO();

            pdao.delete(p);
            
        }
        
        while(jTable1.getRowCount()>0){
            modelo.removeRow(0);
        }
        readJTable();
        
    }//GEN-LAST:event_jButton2_ExcluirActionPerformed

    private void jTextField1_filtro_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_filtro_clienteActionPerformed
        
    }//GEN-LAST:event_jTextField1_filtro_clienteActionPerformed

    private void jTextField1_filtro_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_filtro_clienteKeyTyped
        readJTableForClient(jTextField1_filtro_cliente.getText());
    }//GEN-LAST:event_jTextField1_filtro_clienteKeyTyped
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fListadeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fListadeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fListadeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fListadeClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fListadeClientes dialog = new fListadeClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2_Excluir;
    private javax.swing.JButton jButton3_Fechar;
    private javax.swing.JButton jButton4_Editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1_filtro_cliente;
    // End of variables declaration//GEN-END:variables
}
