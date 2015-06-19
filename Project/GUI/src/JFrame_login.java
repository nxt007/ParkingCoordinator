
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import serviceLevel.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kiker
 */
public class JFrame_login extends javax.swing.JFrame
{

    public boolean isAdmin()
    {
        return isAdmin;
    }

    private boolean isAdmin;
    public JFrame_login()
    {
        initComponents();
        try
        {
            Utils.getUserService();
        } catch (RemoteException | NotBoundException ex)
        {
            Logger.getLogger(JFrame_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel3 = new javax.swing.JLabel();
        jLabel_login = new javax.swing.JLabel();
        jTextField_login = new javax.swing.JTextField();
        jLabel_password = new javax.swing.JLabel();
        jButton_login = new javax.swing.JButton();
        jLabel_loginErrorMsg = new javax.swing.JLabel();
        jPasswordField_password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, -1, -1));

        jLabel_login.setText("Login");
        getContentPane().add(jLabel_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTextField_login.setText("testL");
        getContentPane().add(jTextField_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, 30));

        jLabel_password.setText("Password");
        getContentPane().add(jLabel_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jButton_login.setText("Sign in");
        jButton_login.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_loginActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 170, 40));

        jLabel_loginErrorMsg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel_loginErrorMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 280, 60));

        jPasswordField_password.setText("testP");
        getContentPane().add(jPasswordField_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 170, 30));

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed
        try
        {
            Session session = new Session(
                    jTextField_login.getText(),
                    new String(jPasswordField_password.getPassword()));

            String res = Utils.getUserService().logInUser(session);
            jLabel_loginErrorMsg.setVisible(false);
            if (!res.isEmpty())
            {
                jLabel_loginErrorMsg.setText(res);
                jLabel_loginErrorMsg.setVisible(true);
            } else
            {
                
                isAdmin = Utils.getUserService().checkIfAdmin(session);
                JFrame frame = new JFrame_main(this, session);
                frame.setVisible(true);
                this.setVisible(false);
            }
        } catch (RemoteException | NotBoundException ex)
        {
            Logger.getLogger(JFrame_login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        try
        {
            // TODO add your handling code here:
            Session session = new Session(
                    jTextField_login.getText(),
                    new String(jPasswordField_password.getPassword()));

            String res = Utils.getUserService().registerUser(session);

            jLabel_loginErrorMsg.setText(res);
            jLabel_loginErrorMsg.setVisible(true);

        } catch (RemoteException | NotBoundException ex)
        {
            Logger.getLogger(JFrame_login.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(JFrame_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(JFrame_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(JFrame_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(JFrame_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new JFrame_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_login;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_login;
    private javax.swing.JLabel jLabel_loginErrorMsg;
    private javax.swing.JLabel jLabel_password;
    private javax.swing.JPasswordField jPasswordField_password;
    private javax.swing.JTextField jTextField_login;
    // End of variables declaration//GEN-END:variables
}
