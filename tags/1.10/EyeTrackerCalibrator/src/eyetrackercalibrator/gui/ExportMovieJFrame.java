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
 * ExportMovieJFrame.java
 *
 * Created on March 18, 2008, 11:10 AM
 */
package eyetrackercalibrator.gui;

import eyetrackercalibrator.Main;
import eyetrackercalibrator.framemanaging.FrameManager;
import eyetrackercalibrator.framemanaging.MovieFrameExporter;
import eyetrackercalibrator.framemanaging.ScreenFrameManager;
import eyetrackercalibrator.math.EyeGazeComputing;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author  ruj
 */
public class ExportMovieJFrame extends javax.swing.JFrame implements PropertyChangeListener {

    private static double CORNER_FRAME_SCALE = 0.3;
    public static String FFMPEG_LOCATION_PROPERTY_KEY = "ffmpeg location";
    MovieFrameExporter movieFrameExporter = null;
    int start;
    int totalProcess;

    /** Creates new form ExportMovieJFrame */
    public ExportMovieJFrame(File currentDir, int exportWidth, int exportHeight,
            EyeGazeComputing eyeGazeComputing, int eyeOffset, int screenOffset,
            FrameManager eyeFrameManager, ScreenFrameManager screenFrameManager) {

        // Load ffmpeg location
        File propertyFile = new File(Main.PROPERTY_FILE);
        // Default to OSX path
        File ffmpegFile = null;
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream(propertyFile);
            properties.loadFromXML(fileInputStream);
            String ffmpegLocationStr = properties.getProperty(FFMPEG_LOCATION_PROPERTY_KEY);
            if (ffmpegLocationStr != null) {
                ffmpegFile = new File(ffmpegLocationStr);
            }
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportMovieJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();

        // Set up initial range t export
        int totalEyeFrame = eyeFrameManager.getTotalFrames();
        int totalScreenFrame = screenFrameManager.getTotalFrames();
        int diff = eyeOffset - screenOffset;
        int totalExport = 0;
        if (diff > 0) {
            totalExport = Math.max(totalEyeFrame - diff, totalScreenFrame);
        } else {
            totalExport = Math.max(totalEyeFrame, totalScreenFrame + diff);
        }
        this.toTextField.setText(String.valueOf(totalExport));
        this.start = 1;
        this.totalProcess = totalExport + 1;

        this.progressBar.setStringPainted(true);
        File defaultPath = new File(currentDir, "MovieFrames");
        this.exportLocationTextField.setText(defaultPath.getAbsolutePath());
        repaint();

        // Set up exporter
        this.movieFrameExporter = new MovieFrameExporter(exportWidth, exportHeight,
                CORNER_FRAME_SCALE, eyeGazeComputing, eyeOffset, screenOffset,
                eyeFrameManager, screenFrameManager, ffmpegFile,
                Integer.parseInt(this.frameRateTextField.getText()), this);

    }

    /** 
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputButtonGroup = new javax.swing.ButtonGroup();
        eyetrackercalibrator.gui.util.TextFieldPosIntInputVerifier textFieldPosIntInputVerifier = new eyetrackercalibrator.gui.util.TextFieldPosIntInputVerifier();
        textFieldPosFloatInputVerifier1 = new eyetrackercalibrator.gui.util.TextFieldPosFloatInputVerifier();
        jLabel1 = new javax.swing.JLabel();
        exportLocationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        eyeOnlyCheckBox = new javax.swing.JCheckBox();
        screenOnlyCheckBox = new javax.swing.JCheckBox();
        sideBySideCheckBox = new javax.swing.JCheckBox();
        screenInCornerCheckBox = new javax.swing.JCheckBox();
        eyeInCornerCheckBox = new javax.swing.JCheckBox();
        progressBar = new javax.swing.JProgressBar();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fromTextField = new javax.swing.JTextField();
        toTextField = new javax.swing.JTextField();
        drawCornerCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        gazeAverageTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        frameRateTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        movieOnlyRadioButton = new javax.swing.JRadioButton();
        movieAndFramesRadioButton = new javax.swing.JRadioButton();
        framesOnlyRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Exporting Movie Frames");
        setResizable(false);

        jLabel1.setText("Export Location:");

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Export Types"));

        eyeOnlyCheckBox.setText("Eye only");

        screenOnlyCheckBox.setText("Screen only");

        sideBySideCheckBox.setSelected(true);
        sideBySideCheckBox.setText("Eye and screen side by side");

        screenInCornerCheckBox.setText("Screen in the corner of eye");

        eyeInCornerCheckBox.setText("Eye in the corner of screen");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(eyeOnlyCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(screenOnlyCheckBox)
                .add(18, 18, 18)
                .add(sideBySideCheckBox))
            .add(jPanel1Layout.createSequentialGroup()
                .add(eyeInCornerCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(screenInCornerCheckBox))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(eyeOnlyCheckBox)
                    .add(screenOnlyCheckBox)
                    .add(sideBySideCheckBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(eyeInCornerCheckBox)
                    .add(screenInCornerCheckBox))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("From:");

        jLabel3.setText("To:");

        fromTextField.setText("1");
        fromTextField.setInputVerifier(textFieldPosIntInputVerifier);

        toTextField.setText("1");
        toTextField.setInputVerifier(textFieldPosIntInputVerifier);

        drawCornerCheckBox.setText("Draw corners in screen frames");

        jLabel4.setText("Moving median gaze point across");

        gazeAverageTextField.setText("3");
        gazeAverageTextField.setInputVerifier(textFieldPosIntInputVerifier);
        gazeAverageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gazeAverageTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("frames");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Options"));

        jLabel7.setText("Frame rate:");
        jPanel2.add(jLabel7);

        frameRateTextField.setText("30");
        frameRateTextField.setInputVerifier(textFieldPosFloatInputVerifier1);
        frameRateTextField.setPreferredSize(new java.awt.Dimension(60, 28));
        jPanel2.add(frameRateTextField);

        jLabel6.setText("fps");
        jPanel2.add(jLabel6);

        outputButtonGroup.add(movieOnlyRadioButton);
        movieOnlyRadioButton.setSelected(true);
        movieOnlyRadioButton.setText("Movie only");
        jPanel2.add(movieOnlyRadioButton);

        outputButtonGroup.add(movieAndFramesRadioButton);
        movieAndFramesRadioButton.setText("Movie and frame files");
        jPanel2.add(movieAndFramesRadioButton);

        outputButtonGroup.add(framesOnlyRadioButton);
        framesOnlyRadioButton.setText("Fram files only");
        jPanel2.add(framesOnlyRadioButton);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(exportLocationTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(browseButton)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(okButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(cancelButton)
                                .add(5, 5, 5))
                            .add(progressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
                        .add(22, 22, 22))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jLabel3)))
                            .add(layout.createSequentialGroup()
                                .add(drawCornerCheckBox)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel4)
                                .add(1, 1, 1)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(gazeAverageTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel5))
                            .add(toTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .add(fromTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(exportLocationTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(browseButton))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(fromTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(17, 17, 17)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(toTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(drawCornerCheckBox)
                    .add(jLabel4)
                    .add(gazeAverageTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(progressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(okButton)
                    .add(cancelButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (this.movieFrameExporter != null) {
            this.movieFrameExporter.cancel();
        }

        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        // Check if it has focus
        if (!this.okButton.isFocusOwner()) {
            return;
        }

        boolean error = false;

        // Get to and from
        int from = 0, to = 0;
        // There is no need to catch error here coz we do input validation at the textfield
        from = Integer.parseInt(this.fromTextField.getText());
        to = Integer.parseInt(this.toTextField.getText());

        File exportDirectory = new File(this.exportLocationTextField.getText());

        // Set up start and end
        this.start = Math.min(to, from);
        this.totalProcess = Math.abs(to - from) + 1;
        this.progressBar.setMaximum(this.totalProcess);

        // Get number of average frame with sanity check
        String avgStr = this.gazeAverageTextField.getText();
        int averageFrames = 1;
        if (avgStr != null) {
            int v = 1;
            try {
                v = Integer.parseInt(avgStr);
            } catch (NumberFormatException numberFormatException) {
            }
            averageFrames = Math.max(1, v);
            this.gazeAverageTextField.setText(String.valueOf(averageFrames));
            repaint();
        }

        // Check output type
        if (!(eyeOnlyCheckBox.isSelected() ||
                screenOnlyCheckBox.isSelected() ||
                eyeInCornerCheckBox.isSelected() ||
                screenInCornerCheckBox.isSelected() ||
                sideBySideCheckBox.isSelected())) {
            // None is selected so warn the user and do nothing
            // Show warning dialog
            JOptionPane.showMessageDialog(this,
                    "Please select at least one export type.",
                    "No Export Type Is Selected",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean createMovieFile = true;
        boolean deleteMoviePictureFile = true;
        if (movieAndFramesRadioButton.isSelected()) {
            deleteMoviePictureFile = false;
        } else if (framesOnlyRadioButton.isSelected()) {
            deleteMoviePictureFile = false;
            createMovieFile = false;
        }

        // Check if ffmpeg is needed
        if (this.movieOnlyRadioButton.isSelected() ||
                this.movieAndFramesRadioButton.isSelected()) {
            File ffmpegFile = this.movieFrameExporter.getFfmpegExecutable();
            if (ffmpegFile == null || !ffmpegFile.exists()) {
                // We don't have valid copy of ffmpeg.  Ask user to give one
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Please Locate FFMPEG Executable");
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    ffmpegFile = chooser.getSelectedFile();

                    // Set ffmpeg file for exporter
                    this.movieFrameExporter.setFfmpegExecutable(ffmpegFile);

                    // Save the selection
                    File propertyFile = new File(Main.PROPERTY_FILE);
                    Properties properties = new Properties();

                    // If old file exists load it
                    if (propertyFile.exists()) {
                        try {
                            FileInputStream fileInputStream = null;
                            fileInputStream = new FileInputStream(propertyFile);
                            properties.loadFromXML(fileInputStream);
                            fileInputStream.close();
                        } catch (IOException ex) {
                            Logger.getLogger(ExportMovieJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            // Make one
                            propertyFile.createNewFile();
                        } catch (IOException ex) {
                            Logger.getLogger(ExportMovieJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    // Set new property
                    properties.setProperty(FFMPEG_LOCATION_PROPERTY_KEY, ffmpegFile.getAbsolutePath());

                    // Save the config
                    FileOutputStream outputStream;
                    try {
                        outputStream = new FileOutputStream(Main.PROPERTY_FILE);
                        properties.storeToXML(outputStream, null);
                        outputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ExportMovieJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    return;
                }
            }
        }

        this.okButton.setVisible(false);

        this.movieFrameExporter.exportThread(exportDirectory, from, to,
                this.drawCornerCheckBox.isSelected(),
                this.eyeOnlyCheckBox.isSelected(),
                this.screenOnlyCheckBox.isSelected(),
                this.sideBySideCheckBox.isSelected(),
                this.eyeInCornerCheckBox.isSelected(),
                this.screenInCornerCheckBox.isSelected(),
                createMovieFile, deleteMoviePictureFile, averageFrames);
    }//GEN-LAST:event_okButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // Set text box with directory that user chose.
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (this.exportLocationTextField.getText().length() > 1) {
            // Get current selection from text field
            fileChooser.setSelectedFile(new File(exportLocationTextField.getText()));
        } else {
            // Otherwise open to latest location if there is nothing in the field text
            fileChooser.setSelectedFile(new File("."));
        }

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.exportLocationTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void gazeAverageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gazeAverageTextFieldActionPerformed
        // Check content
        String input = gazeAverageTextField.getText();
        // Try parsing it
        int value = 3;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            // This is bad so falls to default
            gazeAverageTextField.setText(String.valueOf(value));
            return;
        }
        // Cap value
        value = Math.max(1, value);

        // Reset output
        gazeAverageTextField.setText(String.valueOf(value));
}//GEN-LAST:event_gazeAverageTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox drawCornerCheckBox;
    private javax.swing.JTextField exportLocationTextField;
    private javax.swing.JCheckBox eyeInCornerCheckBox;
    private javax.swing.JCheckBox eyeOnlyCheckBox;
    private javax.swing.JTextField frameRateTextField;
    private javax.swing.JRadioButton framesOnlyRadioButton;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JTextField gazeAverageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton movieAndFramesRadioButton;
    private javax.swing.JRadioButton movieOnlyRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.ButtonGroup outputButtonGroup;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JCheckBox screenInCornerCheckBox;
    private javax.swing.JCheckBox screenOnlyCheckBox;
    private javax.swing.JCheckBox sideBySideCheckBox;
    private eyetrackercalibrator.gui.util.TextFieldPosFloatInputVerifier textFieldPosFloatInputVerifier1;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables

    public void propertyChange(PropertyChangeEvent evt) {
        int completed = (Integer) evt.getNewValue();

        if (completed > 0) {
            completed = completed - start + 1;

            if (completed >= this.totalProcess && evt.getPropertyName().startsWith("Completed")) {
                this.progressBar.setString(evt.getPropertyName());
                this.cancelButton.setText("Close");
            } else {
                this.progressBar.setString(evt.getPropertyName() + " " + completed + " of " + this.totalProcess);
            }
            this.progressBar.setValue(completed);

        } else if (completed < 0) {
            this.progressBar.setString(evt.getPropertyName());
            this.progressBar.setValue(this.totalProcess - 1);
        }

    }
}