/*
* Copyright (c) 2009 by Thomas Busey and Ruj Akavipat
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*     * Redistributions of source code must retain the above copyright
*       notice, this list of conditions and the following disclaimer.
*     * Redistributions in binary form must reproduce the above copyright
*       notice, this list of conditions and the following disclaimer in the
*       documentation and/or other materials provided with the distribution.
*     * Neither the name of the Experteyes nor the
*       names of its contributors may be used to endorse or promote products
*       derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY Thomas Busey and Ruj Akavipat ''AS IS'' AND ANY
* EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL Thomas Busey and Ruj Akavipat BE LIABLE FOR ANY
* DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
/*
 * NewProjectJDialog.java
 *
 * Created on September 24, 2007, 9:43 AM
 */

package eyetrackercalibrator.gui;

import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * This is one time disposible dialog
 * @author  ruj
 */
public class NewProjectJDialog extends javax.swing.JDialog {
    
    // This holds selected location from File Chooser (Not location in the project Location text field)
    File selectedLocation = new File(System.getProperty("user.home"));
    // True when user click on create
    boolean isApproved = false;
    
    /** Creates new form NewProjectJDialog */
    public NewProjectJDialog(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        projectLocationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel1.setText("Project Name:");

        projectNameTextField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                projectNameTextFieldPropertyChange(evt);
            }
        });
        projectNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                projectNameTextFieldFocusLost(evt);
            }
        });
        projectNameTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                projectNameTextFieldInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        projectNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                projectNameTextFieldKeyTyped(evt);
            }
        });

        jLabel2.setText("Project Location:");

        setProjectLocationTextField();

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        createButton.setText("Create");

        cancelButton.setText("Cancel");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(projectNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 241, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(projectLocationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 447, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(browseButton)))
                .addContainerGap(20, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(530, Short.MAX_VALUE)
                .add(createButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cancelButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(projectNameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(projectLocationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(browseButton)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 49, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(createButton)))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void projectNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_projectNameTextFieldFocusLost
        setProjectLocationTextField();
    }//GEN-LAST:event_projectNameTextFieldFocusLost
    
    private void projectNameTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_projectNameTextFieldPropertyChange
        setProjectLocationTextField();
    }//GEN-LAST:event_projectNameTextFieldPropertyChange
    
    private void projectNameTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_projectNameTextFieldInputMethodTextChanged
        
    }//GEN-LAST:event_projectNameTextFieldInputMethodTextChanged
    
    private void projectNameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_projectNameTextFieldKeyTyped
        
    }//GEN-LAST:event_projectNameTextFieldKeyTyped
    
    private void closeDialog(boolean isCreatePressed){
        isApproved = isCreatePressed;
        this.setVisible(false);
        this.dispose();
    }
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        browseDirectory(projectLocationTextField);
    }//GEN-LAST:event_browseButtonActionPerformed
    
    private void setProjectLocationTextField(){
        File location = new File(selectedLocation, projectNameTextField.getText());
        projectLocationTextField.setText(location.getAbsolutePath());
    }
    
    private void browseDirectory(JTextField targetField){
        // Set text box with directory that user chose.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(targetField.getText().length() > 1){
            // Get current selection from text field
            fileChooser.setSelectedFile(new File(targetField.getText()));
        }else{
            // Otherwise open to latest location if there is nothing in the field text
            fileChooser.setSelectedFile(selectedLocation);
        }
        
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            // Save current position
            selectedLocation = fileChooser.getSelectedFile();
            targetField.setText(selectedLocation.getAbsolutePath());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewProjectJDialog(new javax.swing.JFrame(),"Create project", true).setVisible(true);
            }
        });
    }
    
    public String getProjectName(){
        return projectNameTextField.getText();
    }
    
    public String getProjectLocation(){
        return projectLocationTextField.getText();
    }
    
    public boolean isApproved(){
        return isApproved;
    }
    
    /** Add action listener to listen to create and cancel button click event */
    public void addActionListener(ActionListener actionListener){
        cancelButton.addActionListener(actionListener);
        createButton.addActionListener(actionListener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField projectLocationTextField;
    private javax.swing.JTextField projectNameTextField;
    // End of variables declaration//GEN-END:variables
    
}
