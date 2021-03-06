/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import Controler.EntretientControler;
import Model.Entretient;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author OMRANI
 */
public class Home extends javax.swing.JInternalFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI x = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)x).setNorthPane(null);
        this.actualiserTableEntretientToday();


    }
    
    public void actualiserTableEntretientToday(){
         EntretientControler es = new EntretientControler();
         List<Entretient> list= es.findToday();
         DefaultTableModel model = (DefaultTableModel)this.jTableEntretientdujourHome.getModel();
          model.setRowCount(0);
          
         if(!list.isEmpty())
         {
             for(Entretient f:list)
             {
               model.addRow(new Object[]{f.getId(),f.getCandidat().getNom(),f.getCandidat().getPrenom(),f.getDate(),f.getHeure(),f.getDescription(),f.getQualite(),f.getDefaut(),f.getDecision(),f.getNote()});
             }
           
         }else{
            JOptionPane.showMessageDialog(this, "pas des entretiens aujourd'hui ", "entretien du jour", JOptionPane.INFORMATION_MESSAGE);

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

        jPanel1 = new javax.swing.JPanel();
        EntretiensToday = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEntretientdujourHome = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        EntretiensToday.setLayout(new java.awt.CardLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mes Entretients d'aujourd'hui"));

        jTableEntretientdujourHome.setAutoCreateRowSorter(true);
        jTableEntretientdujourHome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jTableEntretientdujourHome.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTableEntretientdujourHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom Candidat", "Prenom Candidat", "Date", "Heure", "Description", "Qualite", "Defaut", "Decision", "Note"
            }
        ));
        jTableEntretientdujourHome.setRowHeight(25);
        jTableEntretientdujourHome.getColumnModel().getColumn(0).setPreferredWidth(50);
        jScrollPane2.setViewportView(jTableEntretientdujourHome);

        EntretiensToday.add(jScrollPane2, "card2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(EntretiensToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(EntretiensToday, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EntretiensToday;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEntretientdujourHome;
    // End of variables declaration//GEN-END:variables
}
