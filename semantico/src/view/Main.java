/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Control;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Analyse;
import model.Code;
import model.Error;
import model.Stack;
import model.TableCellRenderer;

public class Main extends javax.swing.JFrame {
    private Control control;
    private ArrayList<Analyse> listAnalyse;
    ArrayList<Code> codeList;
    File file;
    IU_About about;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        control = new Control();
        listAnalyse = new ArrayList<>();
        about = new IU_About();
        disableMenuItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneLexical = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLexical = new javax.swing.JTable();
        tabbedPaneResult = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaResult = new javax.swing.JTextArea();
        tabbedPaneSemantic = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaResultSemantic = new javax.swing.JTextArea();
        tabbedPaneIntermediateCode = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaResultIntermediateCode = new javax.swing.JTextArea();
        tabbedPaneExecution = new javax.swing.JTabbedPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaResultExecution = new javax.swing.JTextArea();
        tabbedPaneEditor = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneAreaEdit = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemClose = new javax.swing.JMenuItem();
        menuAnalyse = new javax.swing.JMenu();
        menuItemLexic = new javax.swing.JMenuItem();
        menuItemSintatic = new javax.swing.JMenuItem();
        menuItemSemantic = new javax.swing.JMenuItem();
        menuGenerate = new javax.swing.JMenu();
        menuItemIntermediateCode = new javax.swing.JMenuItem();
        menuRun = new javax.swing.JMenu();
        menuItemExecute = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("myCompiler");
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 768));

        tableLexical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexeme", "Token", "Line", "IniCol", "EndCol", "Error"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLexical);

        tabbedPaneLexical.addTab("Tabla Lexico", jScrollPane1);

        textAreaResult.setColumns(20);
        textAreaResult.setRows(5);
        jScrollPane3.setViewportView(textAreaResult);

        tabbedPaneResult.addTab("Analisis Sintactico", jScrollPane3);

        tabbedPaneLexical.addTab("Resultados Sintacticos", tabbedPaneResult);

        textAreaResultSemantic.setColumns(20);
        textAreaResultSemantic.setRows(5);
        jScrollPane4.setViewportView(textAreaResultSemantic);

        tabbedPaneSemantic.addTab("Analisis Semantico", jScrollPane4);

        tabbedPaneLexical.addTab("Resultados Semanticos", tabbedPaneSemantic);

        textAreaResultIntermediateCode.setColumns(20);
        textAreaResultIntermediateCode.setRows(5);
        jScrollPane5.setViewportView(textAreaResultIntermediateCode);

        tabbedPaneIntermediateCode.addTab("Código Intermedio", jScrollPane5);

        tabbedPaneLexical.addTab("", tabbedPaneIntermediateCode);

        textAreaResultExecution.setColumns(20);
        textAreaResultExecution.setRows(5);
        jScrollPane7.setViewportView(textAreaResultExecution);

        tabbedPaneExecution.addTab("Ejecución", jScrollPane7);

        tabbedPaneLexical.addTab("", tabbedPaneExecution);

        tabbedPaneLexical.setSelectedIndex(1);

        jScrollPane2.setViewportView(textPaneAreaEdit);

        tabbedPaneEditor.addTab("Código", jScrollPane2);

        menuFile.setText("Archivo");
        menuFile.setToolTipText("");

        menuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemOpen.setText("Abrir");
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        menuFile.add(menuItemOpen);

        menuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSave.setText("Guardar");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuFile.add(menuItemSave);

        menuItemClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemClose.setText("Cerrar");
        menuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCloseActionPerformed(evt);
            }
        });
        menuFile.add(menuItemClose);

        jMenuBar1.add(menuFile);

        menuAnalyse.setText("Analisis");

        menuItemLexic.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menuItemLexic.setText("Lexico");
        menuItemLexic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemLexicMouseClicked(evt);
            }
        });
        menuItemLexic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLexicActionPerformed(evt);
            }
        });
        menuAnalyse.add(menuItemLexic);

        menuItemSintatic.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSintatic.setText("Sintactico");
        menuItemSintatic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSintaticActionPerformed(evt);
            }
        });
        menuAnalyse.add(menuItemSintatic);

        menuItemSemantic.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSemantic.setText("Semantico");
        menuItemSemantic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSemanticActionPerformed(evt);
            }
        });
        menuAnalyse.add(menuItemSemantic);

        jMenuBar1.add(menuAnalyse);

        menuItemIntermediateCode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menuItemIntermediateCode.setText("Intermediate Code");
        menuItemIntermediateCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIntermediateCodeActionPerformed(evt);
            }
        });
        menuGenerate.add(menuItemIntermediateCode);

        jMenuBar1.add(menuGenerate);

        menuItemExecute.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExecute.setText("Execute the Code");
        menuItemExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExecuteActionPerformed(evt);
            }
        });
        menuRun.add(menuItemExecute);

        jMenuBar1.add(menuRun);

        jMenu1.setText("Más");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneEditor))
            .addComponent(tabbedPaneLexical, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneLexical, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenActionPerformed
        String line = "";
        String textEdit = "";
        BufferedReader in = null;
        int counter = 0;
        
        // Handle open button action
        final JFileChooser fc = new JFileChooser();

        int returnVal = fc.showOpenDialog(this);

        if ( returnVal == JFileChooser.APPROVE_OPTION)
        {
            file = fc.getSelectedFile();

            try
            {
                in = new BufferedReader(new FileReader(file));
                
                while ( (line = in.readLine()) != null )
                {
                    counter++;
                    textEdit += line + "\n";
                }

                // This is where a real application would open the file
                System.out.println("Abriendo: " + file.getName() + "\n");
                System.out.println("\n\n" + line);
            }

            catch (IOException ex)
            {
                System.err.println("Error ! No es posible abrir el archivo ! " + ex);
            }

            finally
            {
                try {
                    in.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                textPaneAreaEdit.setText(textEdit);
                enableMenuItem();
            }
        }

        else
        {
            JOptionPane.showMessageDialog(null, "La operacion de apertura ha sido cancelada por el usuario.");
        }
    }//GEN-LAST:event_menuItemOpenActionPerformed

    private void menuItemLexicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLexicActionPerformed
        // Do Analyse Lexic
        if ( textPaneAreaEdit.getText() != "" )
            listAnalyse = control.analyseLexic(textPaneAreaEdit.getText());
        else
            JOptionPane.showMessageDialog(null, "Error ! Necesitas rellenar el area de código !");
        
        // Popula Table
        populateLexicalTable(listAnalyse);
        
        if ( listAnalyse.get( listAnalyse.size() - 1).getLexeme().equals("Error") )
            JOptionPane.showMessageDialog(null, "Error ! Se te olvido cerrar el comentario !");
        else
            JOptionPane.showMessageDialog(null, "Analisis lexico realizado con exito !");
        
        tabbedPaneLexical.setSelectedIndex(0);
    }//GEN-LAST:event_menuItemLexicActionPerformed

    private void menuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCloseActionPerformed
        int input = JOptionPane.showConfirmDialog(this, "Cerrar el compilador de Julián?");
        
        if ( input == 0 )
            this.dispose();
    }//GEN-LAST:event_menuItemCloseActionPerformed

    private void menuItemLexicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemLexicMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemLexicMouseClicked

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        int retval = fileChooser.showSaveDialog(this);
        
        if ( retval == JFileChooser.APPROVE_OPTION )
        {
            File file = fileChooser.getSelectedFile();
            
            if ( file == null )
                return;
            
            if ( !file.getName().toLowerCase().endsWith(".txt") )
                file = new File(file.getParentFile(), file.getName() + ".txt");
            
            try
            {
                textPaneAreaEdit.write(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
                Desktop.getDesktop().open(file);
            }
            
             catch (Exception e)
             {
                 e.printStackTrace();
             }
        }
    }//GEN-LAST:event_menuItemSaveActionPerformed

    private void menuItemSintaticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSintaticActionPerformed
        ArrayList<Error> list; 
        String temp = "";
        int i = 0;
        
        if ( textPaneAreaEdit.getText() != "" ) {
            if ( (list = control.analyseSintatic(textPaneAreaEdit.getText())).size() == 1 && list.get(0).getLine().equals("-1") ) {
                textAreaResult.setText("Analisis sintactico exitoso!!\n Sin errores !!\n");
                JOptionPane.showMessageDialog(null, "Analisis sintactio realizado con exito ! Sin errores !");
            } else {
                for (Error s: list ) {
                    temp += s.getError() + "  /  Linea = " + s.getLine() + "\n";
                    
                    if ( i % 2 != 0 )
                        temp += "---------------------------------------------------------------------------------------------------------------------------------------\n";
                    
                    i++;
                }
                
                textAreaResult.setText(temp);
                
                JOptionPane.showMessageDialog(null, "Error en el analisis sintactico !");
            }    
        }
        else 
            JOptionPane.showMessageDialog(null, "Error ! Rellene el area de código !");
        
        
        tabbedPaneLexical.setSelectedIndex(1);
    }//GEN-LAST:event_menuItemSintaticActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        about.setTitle("Acerca de");
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuItemSemanticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSemanticActionPerformed
        // Do Analyse Semantic
        ArrayList<Error> list;
        String temp = "";
        int i = 0;
        boolean errorSintatic = false;
        
        if ( !textPaneAreaEdit.getText().equals("") ) {
            list = new ArrayList<>();
            list = control.analyseSemantic(textPaneAreaEdit.getText());
        
            if ( list.size() == 1 && list.get(0).getLine().equals("-1") ) {
                textAreaResultSemantic.setText("Analisis semantico exitoso !!\n Sin errores !!\n");
                JOptionPane.showMessageDialog(null, "Analisis semantico exitoso !!\n Sin errore !");
            } 
            
            else {
                if ( list.get(list.size() - 1).getLine().equals("999") ) {
                    list.remove(list.size() - 1);
                    errorSintatic = true;
                }
                for (Error s: list ) {
                        temp += s.getError() + "  /  Linea = " + s.getLine() + "\n";
                        temp += "---------------------------------------------------------------------------------------------------------------------------------------\n";

                        i++;
                    }

                textAreaResultSemantic.setText(temp);
                
                if ( errorSintatic )
                    JOptionPane.showMessageDialog(null, "Al haber errores sintacticos no se realizo el analisis semantico!");
                else
                    JOptionPane.showMessageDialog(null, "Error o errores en el analsis semantico !");
            }

            list.clear();
            tabbedPaneLexical.setSelectedIndex(2);
        }
        
        else 
            JOptionPane.showMessageDialog(null, "Error ! Rellene el area de código !");
        
    }//GEN-LAST:event_menuItemSemanticActionPerformed

    private void menuItemExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExecuteActionPerformed
        int x, y;
        boolean aux = false;
        Stack stack = new Stack();
        x = 0;
        y = 0;
        int maior = 0;
        String result = "";
        
        if ( !codeList.isEmpty() ) {
            for ( Code c: codeList) {
                if ( c.getCode().equals("AMEM 1") ) {
                    String valor = JOptionPane.showInputDialog("Introdiuzca un numero entero: ");
                    result += "Introduzca un numero entero: \n";
                    
                    if ( !aux ) {
                        aux = true;
                       
                        if ( !valor.isEmpty() )
                            x = Integer.parseInt(valor);
                    }
                
                    else {
                        if ( !valor.isEmpty() )
                            y = Integer.parseInt(valor);
                    }
                } else if ( c.getCode().equals("ARMZ 0") ) {
                    stack.push(x);
                } else if ( c.getCode().equals("ARMZ 1") ) {
                    stack.push(y);
                } else if ( c.getCode().equals("CMMA") ) {
                    if ( x > y ) {
                        maior = x;
                    }
                    
                    else {
                        maior = y;
                    }
                } else if ( c.getCode().equals("CMME") ) {
                    if ( Integer.parseInt(stack.pop().toString()) < Integer.parseInt(stack.pop().toString()) ) {
                        maior = x;
                    }
                    
                    else {
                        maior = y;
                    }
                }
                
                else if ( c.getCode().equals("PARA") ) {
                    break;
                }
            }
        }
        result += maior + "\nLa ejecución termino con exito!";
        JOptionPane.showMessageDialog(null, maior + "\nLa ejecución termino con exito!");
        
        textAreaResultExecution.setText(result);
        tabbedPaneLexical.setSelectedIndex(4);
    }//GEN-LAST:event_menuItemExecuteActionPerformed

    private void menuItemIntermediateCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIntermediateCodeActionPerformed
        codeList = new ArrayList<>(); 
        String temp = "";
        
        if ( textPaneAreaEdit.getText() != "" ) {
            codeList = control.generateIntermediateCode(textPaneAreaEdit.getText());
            
            for ( Code c: codeList )
                if ( c.getCode().equals("NADA") )
                    temp += "0 " + c.getCode() + "\n";
                else
                    temp += c.getCode() + "\n";
            
            textAreaResultIntermediateCode.setText(temp);
        }
        
        else
            JOptionPane.showMessageDialog(null, "Error ! Sin texto, necesita rrellenar el area de código!");
        
         tabbedPaneLexical.setSelectedIndex(3);
    }//GEN-LAST:event_menuItemIntermediateCodeActionPerformed

    public void populateLexicalTable(ArrayList<Analyse> list)
    {
        DefaultTableModel model = (DefaultTableModel) tableLexical.getModel();
        ArrayList<Integer> wrong = new ArrayList<>(); 
        
        Object rowData[] = new Object[6];
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        for( int i = 0; i < list.size(); i++ )
        {   
            if ( list.get(i).getToken().equalsIgnoreCase("Caracter_Invalido") || !list.get(i).getError().equalsIgnoreCase("") )
                wrong.add(1); 
            else
                wrong.add(0);
        
            rowData[0] = list.get(i).getLexeme();
            rowData[1] = list.get(i).getToken();
            rowData[2] = list.get(i).getLine();
            rowData[3] = list.get(i).getIniCol();
            rowData[4] = list.get(i).getEndCol();
            rowData[5] = list.get(i).getError();
            
            model.addRow(rowData);
        }
        
        tableLexical.setDefaultRenderer(Object.class, new TableCellRenderer(wrong));
        tableLexical.setModel(model);
    }
    
    public String populateLines(int QtdLines)
    {
        String lines = "";
        
        for(int i = 1; i <= QtdLines; i++)
            lines += i + "\n";
        
        return lines;
    }
    
    public void disableMenuItem() {
        menuItemLexic.setEnabled(false);
        menuItemSave.setEnabled(false);
        menuItemSintatic.setEnabled(false);
        menuItemSemantic.setEnabled(false);
        menuItemIntermediateCode.setEnabled(false);
        menuItemExecute.setEnabled(false);
    }
    
    public void enableMenuItem() {
        menuItemLexic.setEnabled(true);
        menuItemSave.setEnabled(true);
        menuItemSintatic.setEnabled(true);
        menuItemSemantic.setEnabled(true);
        menuItemIntermediateCode.setEnabled(true);
        menuItemExecute.setEnabled(true);
    }
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JMenu menuAnalyse;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuGenerate;
    private javax.swing.JMenuItem menuItemClose;
    private javax.swing.JMenuItem menuItemExecute;
    private javax.swing.JMenuItem menuItemIntermediateCode;
    private javax.swing.JMenuItem menuItemLexic;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenuItem menuItemSemantic;
    private javax.swing.JMenuItem menuItemSintatic;
    private javax.swing.JMenu menuRun;
    private javax.swing.JTabbedPane tabbedPaneEditor;
    private javax.swing.JTabbedPane tabbedPaneExecution;
    private javax.swing.JTabbedPane tabbedPaneIntermediateCode;
    private javax.swing.JTabbedPane tabbedPaneLexical;
    private javax.swing.JTabbedPane tabbedPaneResult;
    private javax.swing.JTabbedPane tabbedPaneSemantic;
    private javax.swing.JTable tableLexical;
    private javax.swing.JTextArea textAreaResult;
    private javax.swing.JTextArea textAreaResultExecution;
    private javax.swing.JTextArea textAreaResultIntermediateCode;
    private javax.swing.JTextArea textAreaResultSemantic;
    private javax.swing.JTextPane textPaneAreaEdit;
    // End of variables declaration//GEN-END:variables
}
