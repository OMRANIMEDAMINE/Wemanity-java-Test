

package Vue;
import technique.calendar;
import Controler.EntretientControler;
import Controler.CandidatControler;
import Model.Candidat;
import Model.Entretient;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author OMRANI
 */
public class Gestion_Entretiens extends javax.swing.JInternalFrame {

    /**
     * Creates new form Gestion_Entretiens
     */

    String actionCandidat;
    int CandidatCache;
    
    
    public Gestion_Entretiens() {
        initComponents();
        setRootPaneCheckingEnabled(false);
        javax.swing.plaf.InternalFrameUI x = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)x).setNorthPane(null);
    this.jLabelFlecheHaut.setVisible(false);
    
    // Mettre les champs des details du candidat non editable
    jTextFieldNom.setEditable(false);
    jTextFieldPrenom.setEditable(false);
    jTextFieldDateNaissCandidat.setEditable(false);
    jTextFieldPays.setEditable(false);
    jTextFieldVille.setEditable(false);
    jComboBoxActivite.setEditable(false); 
    jComboBoxEtat_civile.setEditable(false);
    jTextFieldTel.setEditable(false);
    jTextFieldMail.setEditable(false);

    CardLayout c =(CardLayout)this.jPanelCandidat.getLayout();
    c.show(jPanelCandidat, "card2");
          
    jTextField3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                 actualiserTableCandidatByString(jTextField3.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualiserTableCandidatByString(jTextField3.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualiserTableCandidatByString(jTextField3.getText());
            }
            
        });
        
        
          
    jTextField8.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualiserTableCandidatByStringEs(jTextField8.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualiserTableCandidatByStringEs(jTextField8.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualiserTableCandidatByStringEs(jTextField8.getText());
            }
            
    });
        
      

        
        
    }
    
    
    public void actualiserTableEntretient(int cand){
        EntretientControler es = new EntretientControler();
         List<Entretient> list= es.findByCandidat(cand);
         DefaultTableModel model = (DefaultTableModel)this.jTableEntrrtiens.getModel();
          model.setRowCount(0);
         if(!list.isEmpty())
         {
             for(Entretient f:list)
             {
               model.addRow(new Object[]{f.getId(),""+f.getCandidat().getNom()+""+f.getCandidat().getPrenom(),f.getDate(),f.getHeure(),f.getDescription(),f.getQualite(),f.getDefaut(),f.getDecision(),f.getNote()});
            
             

             }
         }
    }
    
    
    public void actualiserTableEntretient(){
        EntretientControler es = new EntretientControler();
         List<Entretient> list= es.getAll();
         DefaultTableModel model = (DefaultTableModel)this.jTableEntrrtiens.getModel();
          model.setRowCount(0);
         if(!list.isEmpty())
         {
             for(Entretient f:list)
             {
               model.addRow(new Object[]{f.getId(),""+f.getCandidat().getNom()+""+f.getCandidat().getPrenom(),f.getDate(),f.getHeure(),f.getDescription(),f.getQualite(),f.getDefaut(),f.getDecision(),f.getNote()});
             }
         }
    }
    
    
    public void actualiserTableEntretientBydate(String d1,String d2){
        EntretientControler es = new EntretientControler();
         List<Entretient> list= es.findEntretientBydate(d1, d2);
         DefaultTableModel model = (DefaultTableModel)this.jTableEntrrtiens.getModel();
          model.setRowCount(0);
         if(!list.isEmpty())
         {
             for(Entretient f:list)
             {
               model.addRow(new Object[]{f.getId(),f.getCandidat().getNom(),f.getCandidat().getPrenom(),f.getDate(),f.getHeure(),f.getDescription(),f.getQualite(),f.getDefaut(),f.getDecision(),f.getNote()});
             }
         }
    }
    
 
    
    
public void actualiserTableCandidat(){
        CandidatControler CDAO = new CandidatControler();
         List<Candidat> list= CDAO.getAll();
         DefaultTableModel model = (DefaultTableModel) this.jTableCandidats.getModel();
          model.setRowCount(0);
         if(!list.isEmpty())
         {
             for(Candidat a:list)
             {
                 model.addRow(new Object[]{a.getId(),a.getNom(),a.getPrenom(), a.getDatenaissance(), 
                     a.getPays(), a.getVille(), a.getActivite(),a.getEtat(),a.getTel(),a.getMail()
                 });
      
             }
         }
}
     
public void actualiserTableCandidatByStringEs(String code){
        CandidatControler CDAO = new CandidatControler();
         List<Candidat> list= CDAO.findByString(code);
         DefaultTableModel model = (DefaultTableModel) this.jTableCandidatsEntretient.getModel();
          model.setRowCount(0);
         if(!list.isEmpty())
         {
             for(Candidat a:list)
             {
                 model.addRow(new Object[]{a.getId(),""+a.getNom()+" "+a.getPrenom()
                 });
             }
         }
    }
     
     
public void actualiserTableCandidatByString(String code){
        CandidatControler CDAO = new CandidatControler();
         List<Candidat> list= CDAO.findByString(jTextField3.getText());
         DefaultTableModel model = (DefaultTableModel) this.jTableCandidats.getModel();
          model.setRowCount(0);
         if(!list.isEmpty())
         {
             for(Candidat a:list)
             {
                 model.addRow(new Object[]{a.getId(),a.getNom(),a.getPrenom(), a.getDatenaissance(), 
                     a.getPays(), a.getVille(), a.getActivite(),a.getEtat(),a.getTel(),a.getMail()
                 });
             }
         }
    }
     
     
    
    
    
    public boolean estVideCandidat(){
                return (
                        this.jComboBoxActivite1.getSelectedIndex()==0||
                        this.jComboBoxEtat_civile1.getSelectedIndex()==0||
                        this.jTextFieldNom1.getText().equals("")||                      
                        this.jTextFieldPrenom1.getText().equals("")||
                        this.jTextFieldDateNaissCandidat1.getText().equals("")
                        );
                     

                
    }
    
    public boolean estVideEntretient()
    {
        
         return (
                       Integer.parseInt(jSpinnerNote.getValue().toString())==0||
                        this.jTextAreaDescription.getText().equals("")                      
                 );
    }
    
 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButtonModifArt = new javax.swing.JButton();
        jButtonSuppArt = new javax.swing.JButton();
        jButtonImprimArt = new javax.swing.JButton();
        jButtonAddArt = new javax.swing.JButton();
        jLabelfleche_bas = new javax.swing.JLabel();
        jLabelFlecheHaut = new javax.swing.JLabel();
        jPanelGrid = new javax.swing.JPanel();
        jScrollPaneListeArtilce = new javax.swing.JScrollPane();
        jTableCandidats = new javax.swing.JTable();
        jPanelCandidat = new javax.swing.JPanel();
        panelCandidatDetails = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldDateNaissCandidat = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextFieldPays = new javax.swing.JTextField();
        jTextFieldVille = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextFieldTel = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jComboBoxEtat_civile = new javax.swing.JComboBox<String>();
        jComboBoxActivite = new javax.swing.JComboBox<String>();
        panelCandidatADDD = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextFieldNom1 = new javax.swing.JTextField();
        jTextFieldPrenom1 = new javax.swing.JTextField();
        jTextFieldDateNaissCandidat1 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldPays1 = new javax.swing.JTextField();
        jTextFieldVille1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jTextFieldTel1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextFieldMail1 = new javax.swing.JTextField();
        jComboBoxEtat_civile1 = new javax.swing.JComboBox<String>();
        jButton23 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jComboBoxActivite1 = new javax.swing.JComboBox<String>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCandidatsEntretient = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDate1 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDate2 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanelEntretient = new javax.swing.JPanel();
        jScrollPaneEntretient = new javax.swing.JScrollPane();
        jTableEntrrtiens = new javax.swing.JTable();
        jPanelAddEntretient = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaQualites = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jTextFieldCandidat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldHeure = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDefauts = new javax.swing.JTextArea();
        jComboBoxDecision = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jSpinnerNote = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Candidats"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jLabel13.setBackground(new java.awt.Color(0, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Search_25px.png"))); // NOI18N

        jTextField3.setBorder(null);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        jButtonModifArt.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModifArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/modifier.png"))); // NOI18N
        jButtonModifArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifArtActionPerformed(evt);
            }
        });

        jButtonSuppArt.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSuppArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supp.png"))); // NOI18N
        jButtonSuppArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppArtActionPerformed(evt);
            }
        });

        jButtonImprimArt.setBackground(new java.awt.Color(255, 255, 255));
        jButtonImprimArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); // NOI18N
        jButtonImprimArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimArtActionPerformed(evt);
            }
        });

        jButtonAddArt.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddArt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButtonAddArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddArtActionPerformed(evt);
            }
        });

        jLabelfleche_bas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Expand_Arrow_32px.png"))); // NOI18N
        jLabelfleche_bas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelfleche_basMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelfleche_basMouseEntered(evt);
            }
        });

        jLabelFlecheHaut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Collapse_Arrow_32px.png"))); // NOI18N
        jLabelFlecheHaut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFlecheHautMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelFlecheHautMouseEntered(evt);
            }
        });

        jPanelGrid.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPaneListeArtilce.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneListeArtilce.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)), "infos"));
        jScrollPaneListeArtilce.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPaneListeArtilce.setPreferredSize(new java.awt.Dimension(479, 523));

        jTableCandidats.setAutoCreateRowSorter(true);
        jTableCandidats.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableCandidats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prénom", "Date naissance", "Pays","Ville", "Activité", "Etat-Civile", "Tél","E-mail"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTableCandidats.setMinimumSize(new java.awt.Dimension(1100, 350));
        jTableCandidats.setPreferredSize(new java.awt.Dimension(1100, 450));
        jTableCandidats.setRowHeight(25);
        jTableCandidats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCandidatsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCandidatsMousePressed(evt);
            }
        });
        jScrollPaneListeArtilce.setViewportView(jTableCandidats);

        jPanelCandidat.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCandidat.setLayout(new java.awt.CardLayout());

        panelCandidatDetails.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setText("Nom");

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel34.setText("Prenom");

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel35.setText("Date naissance");

        jTextFieldNom.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldNom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomActionPerformed(evt);
            }
        });

        jTextFieldPrenom.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextFieldDateNaissCandidat.setEditable(false);
        jTextFieldDateNaissCandidat.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDateNaissCandidat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calender.png"))); // NOI18N
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel37.setText("Pays");

        jLabel38.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel38.setText("Ville");

        jLabel39.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel39.setText("Secteur d'activité");

        jTextFieldPays.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextFieldVille.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel41.setText("Etat-civile");

        jLabel42.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel42.setText("Tél");

        jTextFieldTel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel43.setText("E-mail");

        jTextFieldMail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jComboBoxEtat_civile.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner Etat-Civile", "Marié", "Celibataire", "Dévorcé", "Fiancé" }));
        jComboBoxEtat_civile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEtat_civileActionPerformed(evt);
            }
        });

        jComboBoxActivite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner domaine", "Infomatique", "Electronique", "Mecanique", "Management" }));
        jComboBoxActivite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActiviteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCandidatDetailsLayout = new javax.swing.GroupLayout(panelCandidatDetails);
        panelCandidatDetails.setLayout(panelCandidatDetailsLayout);
        panelCandidatDetailsLayout.setHorizontalGroup(
            panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCandidatDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDateNaissCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel39)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldVille, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jTextFieldPays, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jComboBoxActivite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEtat_civile, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        panelCandidatDetailsLayout.setVerticalGroup(
            panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCandidatDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(jTextFieldPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxEtat_civile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jTextFieldVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxActivite, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCandidatDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDateNaissCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanelCandidat.add(panelCandidatDetails, "card2");

        panelCandidatADDD.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel36.setText("Nom");

        jLabel40.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel40.setText("Prenom");

        jLabel44.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel44.setText("Date naissance");

        jTextFieldNom1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldNom1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldNom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNom1ActionPerformed(evt);
            }
        });

        jTextFieldPrenom1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextFieldDateNaissCandidat1.setEditable(false);
        jTextFieldDateNaissCandidat1.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDateNaissCandidat1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calender.png"))); // NOI18N
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel45.setText("Pays");

        jLabel46.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel46.setText("Ville");

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel47.setText("Secteur d'activité");

        jTextFieldPays1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextFieldVille1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel48.setText("Etat-civile");

        jLabel49.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel49.setText("Tél");

        jTextFieldTel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel50.setText("E-mail");

        jTextFieldMail1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jComboBoxEtat_civile1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner Etat-Civile", "Marié", "Celibataire", "Dévorcé", "Fiancé" }));
        jComboBoxEtat_civile1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEtat_civile1ItemStateChanged(evt);
            }
        });
        jComboBoxEtat_civile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEtat_civile1ActionPerformed(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/valider.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel (2).png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jComboBoxActivite1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner domaine", "Infomatique", "Electronique", "Mecanique", "Management" }));
        jComboBoxActivite1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxActivite1ItemStateChanged(evt);
            }
        });
        jComboBoxActivite1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActivite1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCandidatADDDLayout = new javax.swing.GroupLayout(panelCandidatADDD);
        panelCandidatADDD.setLayout(panelCandidatADDDLayout);
        panelCandidatADDDLayout.setHorizontalGroup(
            panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCandidatADDDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCandidatADDDLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCandidatADDDLayout.createSequentialGroup()
                        .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel44)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDateNaissCandidat1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNom1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPrenom1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel47)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldVille1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jTextFieldPays1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jComboBoxActivite1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEtat_civile1, 0, 146, Short.MAX_VALUE)
                            .addComponent(jTextFieldTel1)
                            .addComponent(jTextFieldMail1))))
                .addGap(328, 328, 328))
        );
        panelCandidatADDDLayout.setVerticalGroup(
            panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCandidatADDDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(jTextFieldPays1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxEtat_civile1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldPrenom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jTextFieldVille1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldMail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxActivite1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDateNaissCandidat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCandidatADDDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCandidat.add(panelCandidatADDD, "card3");

        javax.swing.GroupLayout jPanelGridLayout = new javax.swing.GroupLayout(jPanelGrid);
        jPanelGrid.setLayout(jPanelGridLayout);
        jPanelGridLayout.setHorizontalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneListeArtilce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCandidat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelGridLayout.setVerticalGroup(
            jPanelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGridLayout.createSequentialGroup()
                .addComponent(jScrollPaneListeArtilce, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonSuppArt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonModifArt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonImprimArt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAddArt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelfleche_bas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelFlecheHaut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonAddArt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModifArt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSuppArt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonImprimArt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelfleche_bas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                        .addComponent(jLabelFlecheHaut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Candidats", new javax.swing.ImageIcon(getClass().getResource("/image/iconStock.png")), jPanel1); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Entretients"));
        jPanel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)), "Candidats"));
        jScrollPane3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane3MousePressed(evt);
            }
        });

        jTableCandidatsEntretient.setAutoCreateRowSorter(true);
        jTableCandidatsEntretient.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableCandidatsEntretient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Designation"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jTableCandidatsEntretient.setRowHeight(25);
        jTableCandidatsEntretient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCandidatsEntretientMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableCandidatsEntretient);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imprimer.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("de");

        jTextFieldDate1.setEditable(false);
        jTextFieldDate1.setBackground(new java.awt.Color(255, 255, 255));

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calender.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("a");

        jTextFieldDate2.setEditable(false);
        jTextFieldDate2.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDate2ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calender.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 51));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jTextFieldDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jTextFieldDate2)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jTextFieldDate1)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Search_25px.png"))); // NOI18N

        jTextField8.setBorder(null);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelEntretient.setLayout(new java.awt.CardLayout());

        jScrollPaneEntretient.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneEntretient.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)), "Entretients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jScrollPaneEntretient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPaneEntretientMousePressed(evt);
            }
        });

        jTableEntrrtiens.setAutoCreateRowSorter(true);
        jTableEntrrtiens.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTableEntrrtiens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Candidat", "Date", "Heure", "Description", "Qualités", "Défauts", "Decision", "Note"
            }
        ));
        jTableEntrrtiens.setRowHeight(25);
        jScrollPaneEntretient.setViewportView(jTableEntrrtiens);

        jPanelEntretient.add(jScrollPaneEntretient, "card2");

        jPanelAddEntretient.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Description:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Qualité(s):");

        jTextAreaQualites.setColumns(20);
        jTextAreaQualites.setRows(5);
        jScrollPane1.setViewportView(jTextAreaQualites);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Date:");

        jTextFieldDate.setEditable(false);
        jTextFieldDate.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calender.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/valider.png"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancel (2).png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTextFieldCandidat.setEditable(false);
        jTextFieldCandidat.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCandidat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCandidatActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Candidat:");

        jTextFieldHeure.setEditable(false);
        jTextFieldHeure.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldHeure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHeureActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Heure:");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescription);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Defaut(s):");

        jTextAreaDefauts.setColumns(20);
        jTextAreaDefauts.setRows(5);
        jScrollPane4.setViewportView(jTextAreaDefauts);

        jComboBoxDecision.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accepté", "Refusé" }));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Decision:");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Note/20:");

        javax.swing.GroupLayout jPanelAddEntretientLayout = new javax.swing.GroupLayout(jPanelAddEntretient);
        jPanelAddEntretient.setLayout(jPanelAddEntretientLayout);
        jPanelAddEntretientLayout.setHorizontalGroup(
            jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                        .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                                .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldHeure, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(jTextFieldCandidat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxDecision, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinnerNote, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2))
                .addGap(143, 143, 143))
        );
        jPanelAddEntretientLayout.setVerticalGroup(
            jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                        .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldCandidat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldHeure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelAddEntretientLayout.createSequentialGroup()
                        .addComponent(jComboBoxDecision, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jSpinnerNote))))
                .addGap(5, 5, 5)
                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanelAddEntretientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelEntretient.add(jPanelAddEntretient, "card3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanelEntretient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanelEntretient, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(120, 120, 120))))
        );

        jTabbedPane1.addTab("Entretients", new javax.swing.ImageIcon(getClass().getResource("/image/iconeES.png")), jPanel4); // NOI18N

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelfleche_basMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelfleche_basMouseClicked
        // TODO add your handling code here:
         this.jPanelGrid.removeAll();
         this.jPanelGrid.setLayout(new GridLayout(1,1));
         this.jPanelGrid.add(this.jScrollPaneListeArtilce);
         this.jLabelfleche_bas.setVisible(false);
         this.jLabelFlecheHaut.setVisible(true);
         this.jTabbedPane1.repaint();
         
    }//GEN-LAST:event_jLabelfleche_basMouseClicked

    private void jLabelFlecheHautMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFlecheHautMouseClicked
        // TODO add your handling code here:
        this.jPanelGrid.removeAll();
         this.jPanelGrid.setLayout(new BorderLayout());
         this.jPanelGrid.add(this.jScrollPaneListeArtilce,BorderLayout.CENTER);
         this.jPanelGrid.add(this.jPanelCandidat,BorderLayout.SOUTH);
         this.jLabelfleche_bas.setVisible(true);
         this.jLabelFlecheHaut.setVisible(false);
         this.jPanelGrid.updateUI();
    }//GEN-LAST:event_jLabelFlecheHautMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "en cours de développement avec jasperreports ", "jasperreports", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTableCandidatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCandidatsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCandidatsMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
      
            JOptionPane.showMessageDialog(this, "en cours développement ", "en cours développement", JOptionPane.INFORMATION_MESSAGE);

           
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        calendar c = new calendar();
        c.setTxtdate(jTextFieldDate1);
        c.setAlwaysOnTop(true);
//        c.setLocation(jTextFieldDate1.getX(), jTextFieldDate1.getY()+jTextFieldDate1.getHeight());
       c.setLocationRelativeTo(this);
        
        //c.setSize(450, 300);
        c.setResizable(false);
        c.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButtonImprimArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimArtActionPerformed
        // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "en cours développement avec Jasperreports", "Jasperreports", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonImprimArtActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
          this.jButton10.setVisible(true);
          this.jButton13.setVisible(true);
          CardLayout c =(CardLayout)this.jPanelEntretient.getLayout();
          c.show(jPanelEntretient, "card2");
        
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButtonAddArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddArtActionPerformed
        // TODO add your handling code here
         actionCandidat="add";
         CardLayout c =(CardLayout)this.jPanelCandidat.getLayout();
         c.show(jPanelCandidat, "card3");
         this.jButtonAddArt.setVisible(false);
         this.jButtonImprimArt.setVisible(false);
         this.jButtonModifArt.setVisible(false);
         this.jButtonSuppArt.setVisible(false);
         this.jLabelfleche_bas.setVisible(false);
         
    }//GEN-LAST:event_jButtonAddArtActionPerformed

    private void jLabelFlecheHautMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFlecheHautMouseEntered
        // TODO add your handling code here:
         jLabelFlecheHaut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabelFlecheHautMouseEntered

    private void jLabelfleche_basMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelfleche_basMouseEntered
        // TODO add your handling code here:
        jLabelfleche_bas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabelfleche_basMouseEntered

    private void jTableCandidatsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCandidatsMousePressed
        // TODO add your handling code here:
        
        int i = jTableCandidats.getSelectedRow();
        if(i!=-1)
        {
            int idCandidat=Integer.parseInt(jTableCandidats.getValueAt(i, 0).toString());
            CandidatControler CDAO = new CandidatControler();
            Candidat a = CDAO.findByINT(idCandidat);            
            jTextFieldNom.setText(a.getNom());
            jTextFieldPrenom.setText(a.getPrenom());
            jTextFieldDateNaissCandidat.setText(a.getDatenaissance());
            jTextFieldPays.setText( a.getPays());//Integer.toString(a.getLimiteStock()));
            jTextFieldVille.setText(a.getVille());
            jComboBoxActivite.getModel().setSelectedItem((Object)a.getActivite().toString());
            jComboBoxEtat_civile.getModel().setSelectedItem((Object)a.getEtat().toString());         
            jTextFieldTel.setText(a.getTel());
            jTextFieldMail.setText(a.getMail());
       
        }
        
    }//GEN-LAST:event_jTableCandidatsMousePressed

    private void jButtonModifArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifArtActionPerformed
        // TODO add your handling code here:
        actionCandidat="modif";
        int i = jTableCandidats.getSelectedRow();
        if(i!=-1)
        {
           int idcand = (int)jTableCandidats.getValueAt(i, 0);
           String des = (String)jTableCandidats.getValueAt(i, 1);
           CandidatCache=idcand;
           int p = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment Modifier le Candidat '" + des + "'?", "Modifier Candidat", JOptionPane.YES_NO_OPTION);
           if (p == 0){
                CardLayout c =(CardLayout)this.jPanelCandidat.getLayout();
                c.show(jPanelCandidat, "card3");
                this.jButtonAddArt.setVisible(false);
                this.jButtonImprimArt.setVisible(false);
                this.jButtonModifArt.setVisible(false);
                this.jButtonSuppArt.setVisible(false);
                this.jLabelfleche_bas.setVisible(false);
               
                try{
                    CandidatControler art = new CandidatControler();
                    Candidat a = art.findByINT(idcand);
                    jTextFieldNom1.setText(a.getNom());
                    jTextFieldPrenom1.setText(a.getPrenom());
                    jTextFieldDateNaissCandidat1.setText(a.getDatenaissance());
                    jTextFieldPays1.setText( a.getPays());//Integer.toString(a.getLimiteStock()));
                    jTextFieldVille1.setText(a.getVille());
                    jComboBoxActivite1.getModel().setSelectedItem((Object)a.getActivite().toString());
                    jComboBoxEtat_civile1.getModel().setSelectedItem((Object)a.getEtat().toString());         
                    jTextFieldTel1.setText(a.getTel());
                    jTextFieldMail1.setText(a.getMail());
                    

                    
                    
                    
                }catch (Exception ex) {
                        Logger.getLogger(Gestion_Entretiens.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                
        
           }
        }else
        {
            JOptionPane.showMessageDialog(this, "Veillez Selectionner un Candidat", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonModifArtActionPerformed

    private void jButtonSuppArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppArtActionPerformed
        // TODO add your handling code here:
        int i = jTableCandidats.getSelectedRow();
        if(i!=-1)
        {
           int code = (int)jTableCandidats.getValueAt(i, 0);
           String des =(String)jTableCandidats.getValueAt(i, 1);
           int p = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment Supprimer le Candidat '" + des + "'?", "Supprimer Candidat", JOptionPane.YES_NO_OPTION);
           if (p == 0){
                try{
                    CandidatControler art = new CandidatControler();
                    Candidat a = art.findByINT(code);
                    if(art.delete(a)){
                            JOptionPane.showMessageDialog(this, "Candidat Suprimer avec succès ", "Succès de Supression", JOptionPane.INFORMATION_MESSAGE);
                            DefaultTableModel model = (DefaultTableModel) this.jTableCandidats.getModel();
                            model.setRowCount(0);
                            actualiserTableCandidat();
                    }else {
                        
                         JOptionPane.showMessageDialog(this, "Candidat non Supprimer! \n Des Documents Comptables sont Associés à cet Candidat ! \n Veuillez les supprimer avant. ", "Erreur de Suppression", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }catch (Exception ex) {
                        Logger.getLogger(Gestion_Entretiens.class.getName()).log(Level.SEVERE, null, ex);
                }   
           }
        }else
        {
            JOptionPane.showMessageDialog(this, "Veillez Selectionner un Candidat", "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSuppArtActionPerformed

    private void jTextFieldNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
     
      
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jComboBoxEtat_civileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEtat_civileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEtat_civileActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if(estVideEntretient()){
            JOptionPane.showMessageDialog(this, "Champ(s) Vide(s)", "Warning", JOptionPane.ERROR_MESSAGE);
        }else
         {
            String decision =jComboBoxDecision.getSelectedItem().toString();
            String date =jTextFieldDate.getText();
            String heure =jTextFieldHeure.getText();
            String qualite = jTextAreaQualites.getText();
            String description = jTextAreaDescription.getText();
            String defauts = jTextAreaDefauts.getText();
            String qualites = jTextAreaQualites.getText();
            int note =0;
            try{
                note = Integer.parseInt(jSpinnerNote.getValue().toString());
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Note Invalide", "Warning", JOptionPane.ERROR_MESSAGE);

            }
            int i = jTableCandidatsEntretient.getSelectedRow();
            int idcandidat = (int)jTableCandidatsEntretient.getValueAt(i, 0);
            String candidat= jTextFieldCandidat.getText();
            CandidatControler CDAO= new CandidatControler();
            Candidat C = CDAO.findByINT(idcandidat);
            Entretient e = new Entretient(C,date,heure,description,qualites,defauts,decision, note);
            try {
                        EntretientControler es = new EntretientControler();
                        if (es.insert(e)) {
                            JOptionPane.showMessageDialog(this, "Entretient de "+candidat+" est ajouté avec succès ", "Succès d'ajout", JOptionPane.INFORMATION_MESSAGE);
                                     
                        } else {
                            JOptionPane.showMessageDialog(this, "Entretient de "+candidat+" non ajouté", "Erreur d'ajout", JOptionPane.INFORMATION_MESSAGE);
                        }
                        this.jButton10.setVisible(true);
                        this.jButton13.setVisible(true);
                        CardLayout c =(CardLayout)this.jPanelEntretient.getLayout();
                        c.show(jPanelEntretient, "card2");
                    } catch (Exception ex) {
                        Logger.getLogger(Gestion_Entretiens.class.getName()).log(Level.SEVERE, null, ex);
                    }  
         }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextFieldDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDateActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        calendar c = new calendar();
        c.setTxtdate(jTextFieldDate);
        c.setAlwaysOnTop(true);
        c.setLocationRelativeTo(this);
        //c.setSize(450, 300);
        c.setResizable(false);
        c.setVisible(true);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jScrollPane3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MousePressed
        // TODO add your handling code here:
        
                  int i = jTableCandidatsEntretient.getSelectedRow();
        if(i!=-1)
        {
            int idCandidat=Integer.parseInt(jTableEntrrtiens.getValueAt(i, 0).toString());
           actualiserTableEntretient(idCandidat);
       
        }
        
    }//GEN-LAST:event_jScrollPane3MousePressed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jTableCandidatsEntretientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCandidatsEntretientMousePressed
        // TODO add your handling code here:
        int i=this.jTableCandidatsEntretient.getSelectedRow();
        if(i!=-1)
        {
            int id=(int)jTableCandidatsEntretient.getValueAt(i, 0);
            actualiserTableEntretient(id);
        }
    }//GEN-LAST:event_jTableCandidatsEntretientMousePressed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        int i =jTabbedPane1.getSelectedIndex();
        if(i!=-1)
        {
            if(i==0)
            {
                this.actualiserTableCandidat();
                 
            }
            if(i==1){
                this.actualiserTableCandidatByStringEs(jTextField8.getText());
                this.actualiserTableEntretient();
            }
                
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        calendar c = new calendar();
        c.setTxtdate(jTextFieldDate2);
        c.setAlwaysOnTop(true);
        c.setLocationRelativeTo(this);
        //c.setSize(450, 300);
        c.setResizable(false);
        c.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String d1=this.jTextFieldDate1.getText();
        String d2=this.jTextFieldDate2.getText();
        this.actualiserTableEntretientBydate(d1, d2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxActiviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActiviteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActiviteActionPerformed

    private void jTextFieldNom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNom1ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
       calendar c = new calendar();
        c.setTxtdate(jTextFieldDateNaissCandidat1);
        c.setAlwaysOnTop(true);
       c.setLocationRelativeTo(this);        
        c.setResizable(false);
        c.setVisible(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jComboBoxEtat_civile1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEtat_civile1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEtat_civile1ItemStateChanged

    private void jComboBoxEtat_civile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEtat_civile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEtat_civile1ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
         if(estVideCandidat()){
            JOptionPane.showMessageDialog(this, "Champ(s) Vide(s)", "Warning", JOptionPane.ERROR_MESSAGE);
        }else{

            String nom =jTextFieldNom1.getText().toString();
            String prenom =jTextFieldPrenom1.getText().toString();
            String datenaiss =jTextFieldDateNaissCandidat1.getText().toString();
            String pays =jTextFieldPays1.getText().toString();
            String ville =jTextFieldVille1.getText().toString();
            String activite = jComboBoxActivite1.getSelectedItem().toString();
            String etat = jComboBoxEtat_civile1.getSelectedItem().toString();
            String tel =jTextFieldTel1.getText().toString();
            String mail =jTextFieldMail1.getText().toString();
        
          
            Candidat v = new  Candidat(nom, prenom, datenaiss, pays, ville, activite, etat, tel, mail) ;

            try {
                CandidatControler CDAO = new CandidatControler();
                if(actionCandidat.equals("add"))
                {
                    if (CDAO.insert(v)) {
                        JOptionPane.showMessageDialog(this, "Candidat ajouté avec succès ", "Succès d'ajout", JOptionPane.INFORMATION_MESSAGE);
                        
                        actualiserTableCandidat();
                        ViderChampsCandidat();
                        CardLayout c =(CardLayout)this.jPanelCandidat.getLayout();
                        c.show(jPanelCandidat, "card2");
                        this.jButtonAddArt.setVisible(true);
                        this.jButtonImprimArt.setVisible(true);
                        this.jButtonModifArt.setVisible(true);
                        this.jButtonSuppArt.setVisible(true);
                        this.jLabelfleche_bas.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(this, "Candidat non ajouté ", "Erreur d'ajout", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else
                {
                    if (CDAO.update(v,CandidatCache)) {
                        JOptionPane.showMessageDialog(this, "Candidat modifié avec succès ", "Succès de Modification", JOptionPane.INFORMATION_MESSAGE);
                        
                        actualiserTableCandidat();
                         ViderChampsCandidat();
                        CardLayout c =(CardLayout)this.jPanelCandidat.getLayout();
                        c.show(jPanelCandidat, "card2");
                        this.jButtonAddArt.setVisible(true);
                        this.jButtonImprimArt.setVisible(true);
                        this.jButtonModifArt.setVisible(true);
                        this.jButtonSuppArt.setVisible(true);
                        this.jLabelfleche_bas.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Candidat non Modifier ", "Erreur de modification", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Gestion_Entretiens.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }
        
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
         
             CardLayout c =(CardLayout)this.jPanelCandidat.getLayout();
            c.show(jPanelCandidat, "card2");
            actualiserTableCandidatByString(jTextField3.getText());
        this.jButtonAddArt.setVisible(true);
        this.jButtonImprimArt.setVisible(true);
        this.jButtonModifArt.setVisible(true);
        this.jButtonSuppArt.setVisible(true);
        this.jLabelfleche_bas.setVisible(true);
                
        ViderChampsCandidat();
      
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jComboBoxActivite1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxActivite1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActivite1ItemStateChanged

    private void jComboBoxActivite1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActivite1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxActivite1ActionPerformed

    private void jTextFieldCandidatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCandidatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCandidatActionPerformed

    private void jTextFieldHeureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHeureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHeureActionPerformed

    private void jTextFieldDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDate2ActionPerformed

    private void jScrollPaneEntretientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneEntretientMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPaneEntretientMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAddArt;
    private javax.swing.JButton jButtonImprimArt;
    private javax.swing.JButton jButtonModifArt;
    private javax.swing.JButton jButtonSuppArt;
    private javax.swing.JComboBox<String> jComboBoxActivite;
    private javax.swing.JComboBox<String> jComboBoxActivite1;
    private javax.swing.JComboBox jComboBoxDecision;
    private javax.swing.JComboBox<String> jComboBoxEtat_civile;
    private javax.swing.JComboBox<String> jComboBoxEtat_civile1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFlecheHaut;
    private javax.swing.JLabel jLabelfleche_bas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelAddEntretient;
    private javax.swing.JPanel jPanelCandidat;
    private javax.swing.JPanel jPanelEntretient;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneEntretient;
    private javax.swing.JScrollPane jScrollPaneListeArtilce;
    private javax.swing.JSpinner jSpinnerNote;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCandidats;
    private javax.swing.JTable jTableCandidatsEntretient;
    private javax.swing.JTable jTableEntrrtiens;
    private javax.swing.JTextArea jTextAreaDefauts;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaQualites;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextFieldCandidat;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldDate1;
    private javax.swing.JTextField jTextFieldDate2;
    private javax.swing.JTextField jTextFieldDateNaissCandidat;
    private javax.swing.JTextField jTextFieldDateNaissCandidat1;
    private javax.swing.JTextField jTextFieldHeure;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldMail1;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldNom1;
    private javax.swing.JTextField jTextFieldPays;
    private javax.swing.JTextField jTextFieldPays1;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldPrenom1;
    private javax.swing.JTextField jTextFieldTel;
    private javax.swing.JTextField jTextFieldTel1;
    private javax.swing.JTextField jTextFieldVille;
    private javax.swing.JTextField jTextFieldVille1;
    private javax.swing.JPanel panelCandidatADDD;
    private javax.swing.JPanel panelCandidatDetails;
    // End of variables declaration//GEN-END:variables

    private void ViderChampsCandidat() {
            jTextFieldNom1.setText("");
            jTextFieldPrenom1.setText("");
            jTextFieldDateNaissCandidat1.setText("");
            jTextFieldPays1.setText("");
            jTextFieldVille1.setText("");
            jComboBoxActivite1.setSelectedIndex(0);
            jComboBoxEtat_civile1.setSelectedIndex(0);        
            jTextFieldTel1.setText("");
            jTextFieldMail1.setText("");

    }
}
