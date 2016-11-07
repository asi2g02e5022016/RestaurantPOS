//    AgilePOS  - Touch Friendly Point Of Sale
//    Copyright (C) 2008-2009 Openbravo, S.L.
//    http://www.unicenta.com
//
//    This file is part of AgilePOS
//
//    AgilePOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   AgilePOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with AgilePOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.payment;

import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.util.AltEncrypter;
import javax.swing.JPanel;

/**
 *
 * @author  Mikel Irurita
 */
public class ConfigPaymentPanelGeneric extends javax.swing.JPanel implements PaymentConfiguration {

    /** Creates new form ConfigPaymentPanelGeneric */
    public ConfigPaymentPanelGeneric() {
        initComponents();
    }
    
    /**
     *
     * @return
     */
    @Override
    public JPanel getComponent() {  
        return this;
    }
    
    /**
     *
     * @param config
     */
    @Override
    public void loadProperties(AppConfig config) {
        String sCommerceID = config.getProperty("payment.commerceid");
        String sCommercePass = config.getProperty("payment.commercepassword");
        
        if (sCommerceID != null && sCommercePass != null && sCommercePass.startsWith("crypt:")) {
            jtxtCommerceID.setText(config.getProperty("payment.commerceid"));
            AltEncrypter cypher = new AltEncrypter("cypherkey" + config.getProperty("payment.commerceid"));
            jtxtCommercePwd.setText(cypher.decrypt(config.getProperty("payment.commercepassword").substring(6)));
        }
    }
    
    /**
     *
     * @param config
     */
    @Override
    public void saveProperties(AppConfig config) {
        config.setProperty("payment.commerceid", jtxtCommerceID.getText());
        AltEncrypter cypher = new AltEncrypter("cypherkey" + jtxtCommerceID.getText());       
        config.setProperty("payment.commercepassword", "crypt:" + cypher.encrypt(new String(jtxtCommercePwd.getPassword())));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtCommerceID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtCommercePwd = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(650, 75));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText(AppLocal.getIntString("label.commerceid")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(91, 30));

        jtxtCommerceID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtxtCommerceID.setPreferredSize(new java.awt.Dimension(91, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("label.commercepwd")); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));

        jtxtCommercePwd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtxtCommercePwd.setPreferredSize(new java.awt.Dimension(91, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtCommerceID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCommercePwd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCommerceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtCommercePwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtxtCommerceID;
    private javax.swing.JPasswordField jtxtCommercePwd;
    // End of variables declaration//GEN-END:variables

}
