/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonogramSolver;

import static NonogramSolver.Nonogram.solvePuzzleUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author Hend Tayeb
 */
public class NonogramSolverUI extends javax.swing.JFrame {

    File fich;
    BufferedReader in;
    int method;
    long milliseconds, executionTimeMs;
    Scanner input;
    String output;
    /**
     * Creates new form NonogramSolverUI
     */
    public NonogramSolverUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Cat = new javax.swing.JButton();
        Horse = new javax.swing.JButton();
        Player = new javax.swing.JButton();
        House = new javax.swing.JButton();
        Moon = new javax.swing.JButton();
        Star = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose a Game"));

        Cat.setText("Cat");
        Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatActionPerformed(evt);
            }
        });

        Horse.setText("Horse");
        Horse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorseActionPerformed(evt);
            }
        });

        Player.setText("Player");
        Player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerActionPerformed(evt);
            }
        });

        House.setText("House");
        House.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HouseActionPerformed(evt);
            }
        });

        Moon.setText("Moon");
        Moon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoonActionPerformed(evt);
            }
        });

        Star.setText("Star");
        Star.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StarActionPerformed(evt);
            }
        });

        jButton2.setText("Create your own! ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(House, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Horse, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(Moon, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Star, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Horse, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(House, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Moon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Star, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("NONOGRAM SOLVER");
        jLabel2.setSize(new java.awt.Dimension(20, 20));

        jLabel1.setText("Choose the solution method:");
        jLabel1.setToolTipText("");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Backtracking", "Arc-consistency" }));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jButton1.setText("Go!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(38, 38, 38)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayerActionPerformed
        input = new Scanner(System.in);
        milliseconds = System.currentTimeMillis();
        try {
            fich = new File("./inputFiles/Player.txt");
            in = new BufferedReader(new FileReader(fich));
            method = jComboBox1.getSelectedIndex();
            output = solvePuzzleUI(in, method);
            //jTextArea1.setText(solvePuzzleUI(in, method));
            executionTimeMs = System.currentTimeMillis() - milliseconds;
            //jTextField1.setText("" + executionTimeMs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_PlayerActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void CatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatActionPerformed
        input = new Scanner(System.in);
       milliseconds = System.currentTimeMillis();
        try {
            fich = new File("./inputFiles/Cat.txt");
            in = new BufferedReader(new FileReader(fich));
            method = jComboBox1.getSelectedIndex();
            output = solvePuzzleUI(in, method);
            //jTextArea1.setText(solvePuzzleUI(in, method));
            executionTimeMs = System.currentTimeMillis() - milliseconds;
           // jTextField1.setText("" + executionTimeMs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_CatActionPerformed

    private void HorseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorseActionPerformed
         input = new Scanner(System.in);
        milliseconds = System.currentTimeMillis();
        try {
            fich = new File("./inputFiles/Horse.txt");
            in = new BufferedReader(new FileReader(fich));
            method = jComboBox1.getSelectedIndex();
            output = solvePuzzleUI(in, method);
            //jTextArea1.setText(solvePuzzleUI(in, method));
            executionTimeMs = System.currentTimeMillis() - milliseconds;
            //jTextField1.setText("" + executionTimeMs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_HorseActionPerformed

    private void HouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HouseActionPerformed
         input = new Scanner(System.in);
        milliseconds = System.currentTimeMillis();
        try {
            fich = new File("./inputFiles/House.txt");
            in = new BufferedReader(new FileReader(fich));
            method = jComboBox1.getSelectedIndex();
            output = solvePuzzleUI(in, method);
            //jTextArea1.setText(solvePuzzleUI(in, method));
            executionTimeMs = System.currentTimeMillis() - milliseconds;
            //jTextField1.setText("" + executionTimeMs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_HouseActionPerformed

    private void MoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoonActionPerformed
         input = new Scanner(System.in);
        milliseconds = System.currentTimeMillis();
        try {
            fich = new File("./inputFiles/Moon.txt");
            in = new BufferedReader(new FileReader(fich));
            method = jComboBox1.getSelectedIndex();
            output = solvePuzzleUI(in, method);
            //jTextArea1.setText(solvePuzzleUI(in, method));
            executionTimeMs = System.currentTimeMillis() - milliseconds;
            //jTextField1.setText("" + executionTimeMs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_MoonActionPerformed

    private void StarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StarActionPerformed
         input = new Scanner(System.in);
        milliseconds = System.currentTimeMillis();
        try {
            fich = new File("./inputFiles/Star.txt");
            in = new BufferedReader(new FileReader(fich));
            method = jComboBox1.getSelectedIndex();
            output = solvePuzzleUI(in, method);
            //jTextArea1.setText(solvePuzzleUI(in, method));
            executionTimeMs = System.currentTimeMillis() - milliseconds;
            //jTextField1.setText("" + executionTimeMs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_StarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFrame output_Win = new JFrame();
       output_Win.setLocationRelativeTo(null);
       JTextArea ta = new JTextArea();
       Font font1 = new Font("SansSerif", Font.PLAIN, 20);
       ta.setEditable(false);
       ta.setText(output);
       ta.setFont(font1);
       JTextField tf = new JTextField();
       tf.setEditable(false);
       tf.setText(executionTimeMs+"");
       JButton okb = new JButton("close");
       okb.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e)
        {
          output_Win.dispose();
        }
       });
       
       FlowLayout outputWin = new FlowLayout(FlowLayout.TRAILING);
       output_Win.setLayout(outputWin);
       output_Win.add(new JLabel("Output"));
       output_Win.add(ta);
       output_Win.add(new JLabel("Execution Time: "));
       output_Win.add(tf);
       output_Win.add(okb);
       output_Win.pack();
       output_Win.setVisible(true);
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UserGameWindowUI ug = new UserGameWindowUI();
        ug.setLocationRelativeTo(null);
        ug.method = jComboBox1.getSelectedIndex();
        ug.setVisible(true);
        //l.setVisible(false);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NonogramSolverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NonogramSolverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NonogramSolverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NonogramSolverUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NonogramSolverUI app = new NonogramSolverUI();
                app.setLocationRelativeTo(null);
                app.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cat;
    private javax.swing.JButton Horse;
    private javax.swing.JButton House;
    private javax.swing.JButton Moon;
    private javax.swing.JButton Player;
    private javax.swing.JButton Star;
    private javax.swing.JButton exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
