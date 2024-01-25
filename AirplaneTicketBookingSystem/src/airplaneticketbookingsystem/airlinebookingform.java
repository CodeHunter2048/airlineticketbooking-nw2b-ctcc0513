/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airplaneticketbookingsystem;


import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author paulo
 */
public class airlinebookingform extends javax.swing.JFrame {

    /**
     * Creates new form airlinebookingform
     */
    
   
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3307/Kalapati_Travels";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "1234";
    
    private List<String> suggestions;
    private LinkedList <String> QueueLists = new LinkedList<>();
    private DefaultListModel<String> listModel;
    
    public airlinebookingform() {
        initComponents();
        Panel3.setVisible(false);
        Panel2.setVisible(false);
        Panel7.setVisible(false);
        Panel1.setVisible(true);
        Panel5.setVisible(false);
        Panel4.setVisible(false);
        Panel6.setVisible(false);
        
        PassField2.setEchoChar('*');
        PassField3.setEchoChar('*');
         
        
        setIcon();
        initializeSuggestions();
        
        
        TravNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components don't fire these events
            }
        });
    }
    
    private void initializeSuggestions() {
        suggestions = new ArrayList<>();
    }

    private void updateSuggestions() {
        String searchName = TravNameField.getText();
        suggestions.clear();

        String url = "jdbc:mysql://localhost:3307/Kalapati_Travels";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT name FROM travelers_acc WHERE name LIKE ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchName + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        suggestions.add(resultSet.getString("name"));
                    }
                }
            }

            // Display the suggestions
            displaySuggestions();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displaySuggestions() {
        // Update the JComboBox model with the new suggestions
        suggestionsComboBox.setModel(new DefaultComboBoxModel<>(suggestions.toArray(new String[0])));

        // Set the text in the TravNameField as the selected item in the suggestionsComboBox
        if (!suggestions.isEmpty()) {
            suggestionsComboBox.setSelectedItem(suggestions.get(0));
        }
    }
 
    class jPanelGradient extends JPanel{
        protected void paintComponent(Graphics g)   {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(135,206,250);
        Color color2 = new Color(240,248,255);
        GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
        g2d.setPaint (gp);
        g2d.fillRect(0, 0, width, height);
        }
    }
        class jPanelGradient1 extends JPanel{
        protected void paintComponent(Graphics g)   {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(135,206,250);
        Color color2 = new Color(240,248,255);
        GradientPaint gp = new GradientPaint(0,0,color1,180,height,color2);
        g2d.setPaint (gp);
        g2d.fillRect(0, 0, width, height);
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

        jLayeredPane2 = new javax.swing.JLayeredPane();
        Panel2 = new javax.swing.JPanel();
        jPanel6 = new jPanelGradient();
        jPanel7 = new jPanelGradient1();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        UserField2 = new javax.swing.JTextField();
        CreateAccountButton2 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        PassField2 = new javax.swing.JPasswordField();
        PassField3 = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        AgeTF = new javax.swing.JTextField();
        NameTF = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        SexCB = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        AddTF = new javax.swing.JTextField();
        OccTF = new javax.swing.JTextField();
        ConTF = new javax.swing.JTextField();
        NatCB = new javax.swing.JComboBox<>();
        Panel3 = new javax.swing.JPanel();
        jPanel8 = new jPanelGradient();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        AdminLoginB = new javax.swing.JButton();
        PassField = new javax.swing.JPasswordField();
        Panel1 = new javax.swing.JPanel();
        jPanel1 = new jPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        UserField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LoginB = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        PassField1 = new javax.swing.JPasswordField();
        Panel7 = new javax.swing.JPanel();
        SecondPanel = new jPanelGradient();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TravNameL = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TravDesL = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TravSeatL = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Panel4 = new javax.swing.JPanel();
        jPanel3 = new jPanelGradient();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        TravNameField = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        suggestionsComboBox = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        QueueList = new javax.swing.JList<>();
        Refresh = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        Panel5 = new javax.swing.JPanel();
        jPanel5 = new jPanelGradient();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        AddTF5 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        NameTF5 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        SexCB3 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        AgeTF5 = new javax.swing.JTextField();
        OccTF5 = new javax.swing.JTextField();
        ConTF5 = new javax.swing.JTextField();
        NatCB2 = new javax.swing.JComboBox<>();
        Save = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Panel6 = new javax.swing.JPanel();
        jPanel4 = new jPanelGradient();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        TravNameLabel = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        DesCB = new javax.swing.JComboBox<>();
        Classa = new javax.swing.JButton();
        Classb = new javax.swing.JButton();
        EditB = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        DeleteTransB = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kalapati Travels");
        setBackground(new java.awt.Color(93, 132, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(1176, 600));

        Panel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setOpaque(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("CREATE ACCOUNT");

        jLabel50.setText("USERNAME");

        jLabel51.setText("PASSWORD");

        jLabel52.setText("CONFIRM PASSWORD");

        UserField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserField2ActionPerformed(evt);
            }
        });

        CreateAccountButton2.setText("CONFIRM");
        CreateAccountButton2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CreateAccountButton2MouseMoved(evt);
            }
        });
        CreateAccountButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateAccountButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateAccountButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateAccountButton2MouseExited(evt);
            }
        });
        CreateAccountButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountButton2ActionPerformed(evt);
            }
        });
        CreateAccountButton2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CreateAccountButton2PropertyChange(evt);
            }
        });

        jButton20.setText("CANCEL");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton20MouseExited(evt);
            }
        });
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        PassField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassField2ActionPerformed(evt);
            }
        });

        PassField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassField3ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("SHOW");
        jToggleButton1.setMaximumSize(new java.awt.Dimension(60, 23));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(80, 20));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PassField2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserField2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PassField3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addGap(184, 184, 184))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel49))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreateAccountButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel49)
                .addGap(51, 51, 51)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PassField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreateAccountButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Please enter your information.");

        jLabel39.setText("NAME");

        jLabel43.setText("AGE");

        jLabel44.setText("SEX");

        AgeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeTFActionPerformed(evt);
            }
        });

        NameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTFActionPerformed(evt);
            }
        });

        jLabel45.setText("ADDRESS");

        jLabel46.setText("CONTACT");

        SexCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel47.setText("NATIONALITY");

        jLabel48.setText("OCCUPATION");

        AddTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTFActionPerformed(evt);
            }
        });

        OccTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccTFActionPerformed(evt);
            }
        });

        ConTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConTFActionPerformed(evt);
            }
        });

        NatCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguan or Barbudan", "Argentine", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabé", "Burundian", "Chinese", "Filipino", "Japanese", "Thai" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel38)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39)
                                        .addComponent(jLabel48)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel43)
                                                .addComponent(jLabel45)
                                                .addComponent(jLabel46)
                                                .addComponent(AgeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(19, 19, 19)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel44)
                                                .addComponent(SexCB, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel47)
                                        .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(AddTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ConTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(OccTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(NatCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AgeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SexCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addGap(1, 1, 1)
                        .addComponent(ConTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NatCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OccTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Panel3.setBackground(new java.awt.Color(255, 255, 255));
        Panel3.setOpaque(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setText("ADMIN Login");

        jLabel13.setText("PASSWORD");

        jLabel12.setText("USERNAME");

        UserField.setPreferredSize(new java.awt.Dimension(64, 30));
        UserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserFieldActionPerformed(evt);
            }
        });

        jButton5.setText("CANCEL");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        AdminLoginB.setText("LOGIN");
        AdminLoginB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminLoginBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminLoginBMouseExited(evt);
            }
        });
        AdminLoginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminLoginBActionPerformed(evt);
            }
        });

        PassField.setPreferredSize(new java.awt.Dimension(64, 30));
        PassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel11))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(156, 156, 156)
                            .addComponent(jLabel13))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(jLabel12))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AdminLoginB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(59, 59, 59)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(AdminLoginB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        Panel1.setBackground(new java.awt.Color(255, 255, 255));
        Panel1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Login");

        UserField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("PASSWORD");

        jLabel3.setText("USERNAME");

        LoginB.setText("LOGIN");
        LoginB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoginBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoginBMouseExited(evt);
            }
        });
        LoginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBActionPerformed(evt);
            }
        });

        jButton2.setText("CREATE ACCOUNT");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ADMIN");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        PassField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(LoginB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserField1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(PassField1))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PassField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        Panel7.setBackground(new java.awt.Color(255, 255, 255));
        Panel7.setOpaque(false);

        SecondPanel.setBackground(new java.awt.Color(255, 255, 255));
        SecondPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Traveler's Info");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("TRAVELER'S NAME:");

        TravNameL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TravNameL.setText("N/A");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("DESTINATION:");

        TravDesL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TravDesL.setText("N/A");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("SEAT NO.");

        TravSeatL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TravSeatL.setText("N/A");

        jButton4.setText("LOGOUT");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SecondPanelLayout = new javax.swing.GroupLayout(SecondPanel);
        SecondPanel.setLayout(SecondPanelLayout);
        SecondPanelLayout.setHorizontalGroup(
            SecondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecondPanelLayout.createSequentialGroup()
                .addGroup(SecondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecondPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4))
                    .addGroup(SecondPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(SecondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(TravNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TravDesL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TravSeatL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecondPanelLayout.createSequentialGroup()
                .addGap(0, 191, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        SecondPanelLayout.setVerticalGroup(
            SecondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecondPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TravNameL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TravDesL)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TravSeatL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout Panel7Layout = new javax.swing.GroupLayout(Panel7);
        Panel7.setLayout(Panel7Layout);
        Panel7Layout.setHorizontalGroup(
            Panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel7Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(SecondPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        Panel7Layout.setVerticalGroup(
            Panel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel7Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(SecondPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        Panel4.setBackground(new java.awt.Color(255, 255, 255));
        Panel4.setOpaque(false);
        Panel4.setRequestFocusEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Traveler's Info");

        jLabel27.setText("NAME SEARCH");

        TravNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TravNameFieldActionPerformed(evt);
            }
        });

        jButton9.setText("CONFIRM");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("CANCEL");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        suggestionsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestionsComboBoxActionPerformed(evt);
            }
        });

        jLabel30.setText("WAITING LIST");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel30MousePressed(evt);
            }
        });

        jButton11.setText("REMOVE");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(QueueList);

        jScrollPane2.setViewportView(jScrollPane1);

        Refresh.setText("Refresh");
        Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RefreshMouseExited(evt);
            }
        });
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        jButton12.setText("PROCESS");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(336, 336, 336))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TravNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suggestionsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Refresh)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(TravNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suggestionsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        Panel5.setBackground(new java.awt.Color(255, 255, 255));
        Panel5.setOpaque(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Traveler's Info");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setText("AGE");

        AddTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTF5ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("NAME");

        NameTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTF5ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("SEX");

        SexCB3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("ADDRESS");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("CONTACT");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("NATIONALITY");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setText("OCCUPATION");

        AgeTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeTF5ActionPerformed(evt);
            }
        });

        OccTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccTF5ActionPerformed(evt);
            }
        });

        ConTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConTF5ActionPerformed(evt);
            }
        });

        NatCB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguan or Barbudan", "Argentine", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabé", "Burundian", "Filipino", "Chinese", "Japanese", "Thai" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel36)
                            .addComponent(jLabel34)
                            .addComponent(NameTF5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel35))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(AgeTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SexCB3, 0, 123, Short.MAX_VALUE))
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(AddTF5)
                            .addComponent(OccTF5)
                            .addComponent(ConTF5)
                            .addComponent(NatCB2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel32)
                .addGap(32, 32, 32)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SexCB3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgeTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addComponent(NatCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OccTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        Save.setText("SAVE/UPDATE");
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveMouseExited(evt);
            }
        });
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        jButton18.setText("EXIT/CANCEL");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton18MouseExited(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        Delete.setText("DELETE ACCOUNT");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteMouseExited(evt);
            }
        });
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel5Layout = new javax.swing.GroupLayout(Panel5);
        Panel5.setLayout(Panel5Layout);
        Panel5Layout.setHorizontalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        Panel5Layout.setVerticalGroup(
            Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel5Layout.createSequentialGroup()
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        Panel6.setBackground(new java.awt.Color(255, 255, 255));
        Panel6.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("SELECT DESTINATION");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("NAME:");

        TravNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TravNameLabel.setText("Juan Dela Cruz");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("DESTINATION:");

        DesCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manila", "Cebu", "Davao" }));

        Classa.setText("CLASS A");
        Classa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClassaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClassaMouseExited(evt);
            }
        });
        Classa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassaActionPerformed(evt);
            }
        });

        Classb.setText("CLASS B");
        Classb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClassbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClassbMouseExited(evt);
            }
        });
        Classb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassbActionPerformed(evt);
            }
        });

        EditB.setText("EDIT");
        EditB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditBMouseExited(evt);
            }
        });
        EditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBActionPerformed(evt);
            }
        });

        jButton15.setText("CANCEL");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        DeleteTransB.setText("REMOVE SEAT");
        DeleteTransB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteTransBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteTransBMouseExited(evt);
            }
        });
        DeleteTransB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTransBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel31)
                                    .addComponent(TravNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Classa, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(EditB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Classb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DeleteTransB, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                            .addComponent(DesCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel28)
                .addGap(33, 33, 33)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TravNameLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(DesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Classa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Classb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteTransB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel6Layout = new javax.swing.GroupLayout(Panel6);
        Panel6.setLayout(Panel6Layout);
        Panel6Layout.setHorizontalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        Panel6Layout.setVerticalGroup(
            Panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel6Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        jLayeredPane2.setLayer(Panel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Panel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Panel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Panel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Panel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Panel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(Panel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(221, 221, 221)
                    .addComponent(Panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(301, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(257, 257, 257)
                    .addComponent(Panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(298, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(271, 271, 271)
                    .addComponent(Panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(338, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap(405, Short.MAX_VALUE)
                    .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(388, Short.MAX_VALUE)))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Panel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(Panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addComponent(Panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(161, Short.MAX_VALUE)))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addContainerGap(37, Short.MAX_VALUE)
                    .addComponent(Panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(124, Short.MAX_VALUE)))
        );

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airplaneticketbookingsystem/Screenshot 2023-12-30 220514.png"))); // NOI18N
        jLabel37.setPreferredSize(new java.awt.Dimension(1176, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1063, 604));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void UserField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserField1ActionPerformed
        // TODO add your handling code here:
        String username1 = this.UserField1.getText();
        char[] passvalue1 = this.PassField1.getPassword();
        String password1 = new String(passvalue1);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String query = "SELECT * FROM travelers_acc WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, username1);
                    preparedStatement.setString(2, password1);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        if (resultSet.next()) {
                            String name = resultSet.getString("name");
                            String destination = resultSet.getString("destination");
                            String travelClass = resultSet.getString("class");
                            int seatNumber = resultSet.getInt("seatnum");
                            String seatID;
                            if (seatNumber != 0 && destination != null && !destination.equalsIgnoreCase("non")) {
                                seatID = travelClass + seatNumber;
                            } else {
                                seatID = "NON";
                            }

                            this.Panel1.setVisible(false);
                            this.Panel7.setVisible(true);
                            this.TravNameL.setText(name);
                            this.TravDesL.setText(destination);
                            this.TravSeatL.setText(seatID);
                            this.UserField1.setText("");
                            this.PassField1.setText("");
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Invalid username or password", "Login Error", 0);
                        }
                    } catch (Throwable var17) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var16) {
                                var17.addSuppressed(var16);
                            }
                        }

                        throw var17;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var18) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var15) {
                            var18.addSuppressed(var15);
                        }
                    }

                    throw var18;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var19) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var14) {
                        var19.addSuppressed(var14);
                    }
                }

                throw var19;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var20) {
            var20.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing the login", "Error", 0);
        }
    }//GEN-LAST:event_UserField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Panel7.setVisible(false);
        Panel1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Panel3.setVisible(true);
        Panel1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void LoginBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBActionPerformed
        // TODO add your handling code here:
        String username1 = this.UserField1.getText();
        char[] passvalue1 = this.PassField1.getPassword();
        String password1 = new String(passvalue1);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String query = "SELECT * FROM travelers_acc WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, username1);
                    preparedStatement.setString(2, password1);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        if (resultSet.next()) {
                            String name = resultSet.getString("name");
                            String destination = resultSet.getString("destination");
                            String travelClass = resultSet.getString("class");
                            int seatNumber = resultSet.getInt("seatnum");
                            String seatID;
                            if (seatNumber != 0 && destination != null && !destination.equalsIgnoreCase("non")) {
                                seatID = travelClass + seatNumber;
                            } else {
                                seatID = "NON";
                            }

                            this.Panel1.setVisible(false);
                            this.Panel7.setVisible(true);
                            this.TravNameL.setText(name);
                            this.TravDesL.setText(destination);
                            this.TravSeatL.setText(seatID);
                            this.UserField1.setText("");
                            this.PassField1.setText("");
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Invalid username or password", "Login Error", 0);
                        }
                    } catch (Throwable var17) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var16) {
                                var17.addSuppressed(var16);
                            }
                        }

                        throw var17;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var18) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var15) {
                            var18.addSuppressed(var15);
                        }
                    }

                    throw var18;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var19) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var14) {
                        var19.addSuppressed(var14);
                    }
                }

                throw var19;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var20) {
            var20.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing the login", "Error", 0);
        }

    }//GEN-LAST:event_LoginBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Panel2.setVisible(true);
        Panel1.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        Panel4.setVisible(true);
        Panel6.setVisible(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void NameTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTF5ActionPerformed

    private void AgeTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeTF5ActionPerformed

    private void OccTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OccTF5ActionPerformed

    private void ConTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConTF5ActionPerformed

    private void AddTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddTF5ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        
        Panel5.setVisible(false);
        Panel6.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String name = this.suggestionsComboBox.getSelectedItem().toString();
        TravNameField.setText(suggestionsComboBox.getSelectedItem().toString());
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String query = "SELECT * FROM travelers_acc WHERE name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, name);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        if (resultSet.next()) {
                            this.Panel6.setVisible(true);
                            this.Panel4.setVisible(false);
                            String travelerName = resultSet.getString("name");
                            this.TravNameLabel.setText(travelerName);
                            String travelerDestination = resultSet.getString("destination");
                            this.DesCB.setSelectedItem(travelerDestination);
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Name not found in the database", "Name Error", 0);
                        }
                    } catch (Throwable var12) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var11) {
                                var12.addSuppressed(var11);
                            }
                        }

                        throw var12;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var13) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var10) {
                            var13.addSuppressed(var10);
                        }
                    }

                    throw var13;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var14) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var15) {
            var15.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void EditBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBActionPerformed
        // TODO add your handling code here:
        String name = this.TravNameField.getText();
        this.Panel5.setVisible(true);
        this.Panel6.setVisible(false);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String selectQuery = "SELECT * FROM travelers_acc WHERE name=?";
                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);

                try {
                    selectStatement.setString(1, name);
                    ResultSet resultSet = selectStatement.executeQuery();

                    try {
                        if (resultSet.next()) {
                            this.NameTF5.setText(resultSet.getString("name"));
                            this.AgeTF5.setText(resultSet.getString("age"));
                            this.AddTF5.setText(resultSet.getString("address"));
                            this.ConTF5.setText(resultSet.getString("contact"));
                            this.OccTF5.setText(resultSet.getString("occupation"));
                            String travelerSex = resultSet.getString("sex");
                            if (travelerSex.equalsIgnoreCase("Male")) {
                                this.SexCB3.setSelectedIndex(0);
                            } else if (travelerSex.equalsIgnoreCase("Female")) {
                                this.SexCB3.setSelectedIndex(1);
                            }

                            String travelerNationality = resultSet.getString("nationality");
                            this.NatCB2.setSelectedItem(travelerNationality);
                        }
                    } catch (Throwable var12) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var11) {
                                var12.addSuppressed(var11);
                            }
                        }

                        throw var12;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var13) {
                    if (selectStatement != null) {
                        try {
                            selectStatement.close();
                        } catch (Throwable var10) {
                            var13.addSuppressed(var10);
                        }
                    }

                    throw var13;
                }

                if (selectStatement != null) {
                    selectStatement.close();
                }
            } catch (Throwable var14) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var15) {
            var15.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_EditBActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        //Make a logout warning here
        Panel3.setVisible(true);
        Panel4.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentRemoved

    private void NameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTFActionPerformed

    private void AgeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeTFActionPerformed

    private void AddTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddTFActionPerformed

    private void OccTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OccTFActionPerformed

    private void ConTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConTFActionPerformed

    private void UserField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserField2ActionPerformed

    private void CreateAccountButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountButton2ActionPerformed
        String name = this.NameTF.getText();
        String address = this.AddTF.getText();
        String sage = this.AgeTF.getText();
        String contact = this.ConTF.getText();
        String nationality = (String)this.NatCB.getSelectedItem();
        String occupation = this.OccTF.getText();
        String sex = (String)this.SexCB.getSelectedItem();
        String Username = this.UserField2.getText();
        char[] passvalue2 = this.PassField2.getPassword();
        String password = new String(passvalue2);
        char[] passvalue3 = this.PassField3.getPassword();
        String password3 = new String(passvalue3);
        int age = 0;
        boolean valid = true;
        if (name.isEmpty()) {
            valid = false;
        }

        if (address.isEmpty()) {
            valid = false;
        }

        if (!contact.matches("\\d{11}")) {
            valid = false;
        }

        if (sage.isEmpty()) {
            valid = false;
        } else {
            age = Integer.parseInt(sage);
        }

        if (age < 0) {
            valid = false;
        }

        if (nationality.isEmpty()) {
            valid = false;
        }

        if (occupation.isEmpty()) {
            valid = false;
        }

        if (Username.isEmpty()) {
            valid = false;
        }

        if (!password.equals(password3)) {
            valid = false;
            JOptionPane.showMessageDialog((Component)null, "Passwords do not match!");
        }

        if (!valid) {
            JOptionPane.showMessageDialog((Component)null, "Please check all your information");
        }

        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                ps = conn.prepareStatement("SELECT name FROM travelers_acc WHERE name = '" + name + "'");

                try {
                    rs = ps.executeQuery();

                    try {
                        if (rs.next()) {
                            valid = false;
                            JOptionPane.showMessageDialog((Component)null, "Name already exists!");
                        }
                    } catch (Throwable var32) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var27) {
                                var32.addSuppressed(var27);
                            }
                        }

                        throw var32;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var33) {
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (Throwable var26) {
                            var33.addSuppressed(var26);
                        }
                    }

                    throw var33;
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (Throwable var34) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var25) {
                        var34.addSuppressed(var25);
                    }
                }

                throw var34;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var35) {
            var35.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while checking the name!");
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                ps = conn.prepareStatement("SELECT name FROM travelers_acc WHERE username = '" + Username + "'");

                try {
                    rs = ps.executeQuery();

                    try {
                        if (rs.next()) {
                            valid = false;
                            JOptionPane.showMessageDialog((Component)null, "Username already exists!");
                        }
                    } catch (Throwable var28) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var24) {
                                var28.addSuppressed(var24);
                            }
                        }

                        throw var28;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var29) {
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (Throwable var23) {
                            var29.addSuppressed(var23);
                        }
                    }

                    throw var29;
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (Throwable var30) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var22) {
                        var30.addSuppressed(var22);
                    }
                }

                throw var30;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var31) {
            var31.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while checking the username!");
        }

        if (valid) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");
                ps = conn.prepareStatement("INSERT INTO travelers_acc (username, password, name, age, sex, address, contact, nationality, occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, Username);
                ps.setString(2, password);
                ps.setString(3, name);
                ps.setInt(4, age);
                ps.setString(5, sex);
                ps.setString(6, address);
                ps.setString(7, contact);
                ps.setString(8, nationality);
                ps.setString(9, occupation);
                int rows = ps.executeUpdate();
                QueueLists.offer(name);
                this.Panel2.setVisible(false);
                this.Panel1.setVisible(true);
                //Clear the TextFields
                NameTF.setText("");
                AgeTF.setText("");
                AddTF.setText("");
                ConTF.setText("");
                OccTF.setText("");
                UserField2.setText("");
                PassField2.setText("");
                PassField3.setText("");
                
                JOptionPane.showMessageDialog((Component)null, "Account created successfully!");
                ps.close();
                this.con.close();
            } catch (SQLException var21) {
                var21.printStackTrace();
                JOptionPane.showMessageDialog((Component)null, "An error occurred while creating the account!");
            }
        }
    }//GEN-LAST:event_CreateAccountButton2ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        Panel2.setVisible(false);
        Panel1.setVisible(true);
        //Clear the TextFields
                NameTF.setText("");
                AgeTF.setText("");
                AddTF.setText("");
                ConTF.setText("");
                OccTF.setText("");
                UserField2.setText("");
                PassField2.setText("");
                PassField3.setText("");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void UserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserFieldActionPerformed
        // TODO add your handling code here:
        String username = this.UserField.getText();
        char[] passvalue = this.PassField.getPassword();
        String password = new String(passvalue);

        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");
            String sql = "SELECT * FROM admin_login WHERE username = ? AND password = ?";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, username);
            this.ps.setString(2, password);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                this.Panel3.setVisible(false);
                this.Panel4.setVisible(true);
                this.UserField.setText("");
                this.PassField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", 0);
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (this.rs != null) {
                    this.rs.close();
                }

                if (this.ps != null) {
                    this.ps.close();
                }

                if (this.con != null) {
                    this.con.close();
                }
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }
    }//GEN-LAST:event_UserFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Panel3.setVisible(false);
        Panel1.setVisible(true);
        this.TravNameField.setText("");
       UserField.setText("");
       PassField.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void AdminLoginBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminLoginBActionPerformed
        String username = this.UserField.getText();
        char[] passvalue = this.PassField.getPassword();
        String password = new String(passvalue);

        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");
            String sql = "SELECT * FROM admin_login WHERE username = ? AND password = ?";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, username);
            this.ps.setString(2, password);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                this.Panel3.setVisible(false);
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (String string : QueueLists) {
                    listModel.addElement(string);
                }

                QueueList.setModel(listModel);
                this.Panel4.setVisible(true);
                this.UserField.setText("");
                this.PassField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", 0);
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (this.rs != null) {
                    this.rs.close();
                }

                if (this.ps != null) {
                    this.ps.close();
                }

                if (this.con != null) {
                    this.con.close();
                }
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }
    }//GEN-LAST:event_AdminLoginBActionPerformed

    private void CreateAccountButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountButton2MouseEntered
        // TODO add your handling code here:
        CreateAccountButton2.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_CreateAccountButton2MouseEntered

    private void CreateAccountButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountButton2MouseExited
        // TODO add your handling code here:
        CreateAccountButton2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_CreateAccountButton2MouseExited

    private void jButton20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseEntered
        // TODO add your handling code here:
        jButton20.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_jButton20MouseEntered

    private void jButton20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseExited
        // TODO add your handling code here:
        jButton20.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton20MouseExited

    private void AdminLoginBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminLoginBMouseEntered
        // TODO add your handling code here:
        AdminLoginB.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_AdminLoginBMouseEntered

    private void AdminLoginBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminLoginBMouseExited
        // TODO add your handling code here:
        AdminLoginB.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_AdminLoginBMouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
        jButton5.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        // TODO add your handling code here:
        jButton5.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton5MouseExited

    private void LoginBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBMouseEntered
        // TODO add your handling code here:
        LoginB.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_LoginBMouseEntered

    private void LoginBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBMouseExited
        // TODO add your handling code here:
        LoginB.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_LoginBMouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
        jButton3.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        // TODO add your handling code here:
        jButton3.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        // TODO add your handling code here:
        jButton4.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        jButton4.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
        jButton9.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        // TODO add your handling code here:
        jButton9.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
        jButton10.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
        // TODO add your handling code here:
        jButton10.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton10MouseExited

    private void SaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseEntered
        // TODO add your handling code here:
        Save.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_SaveMouseEntered

    private void SaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseExited
        // TODO add your handling code here:
        Save.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SaveMouseExited

    private void DeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseEntered
        // TODO add your handling code here:
        Delete.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_DeleteMouseEntered

    private void DeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseExited
        // TODO add your handling code here:
        Delete.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_DeleteMouseExited

    private void jButton18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseEntered
        // TODO add your handling code here:
        jButton18.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_jButton18MouseEntered

    private void jButton18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseExited
        // TODO add your handling code here:
        jButton18.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton18MouseExited

    private void ClassaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassaMouseEntered
        // TODO add your handling code here:
        Classa.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_ClassaMouseEntered

    private void ClassaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassaMouseExited
        // TODO add your handling code here:
        Classa.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ClassaMouseExited

    private void ClassbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassbMouseEntered
        // TODO add your handling code here:
        Classb.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_ClassbMouseEntered

    private void ClassbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassbMouseExited
        // TODO add your handling code here:
        Classb.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_ClassbMouseExited

    private void EditBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBMouseEntered
        // TODO add your handling code here:
        EditB.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_EditBMouseEntered

    private void EditBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBMouseExited
        // TODO add your handling code here:
        EditB.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_EditBMouseExited

    private void DeleteTransBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteTransBMouseEntered
        // TODO add your handling code here:
        DeleteTransB.setBackground(new Color(135, 206, 235));
    }//GEN-LAST:event_DeleteTransBMouseEntered

    private void DeleteTransBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteTransBMouseExited
        // TODO add your handling code here:
        DeleteTransB.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_DeleteTransBMouseExited

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        // TODO add your handling code here:
        jButton15.setBackground(new Color(225,6,0));
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        // TODO add your handling code here:
        jButton15.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButton15MouseExited

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        String name = this.TravNameField.getText();
        int confirmChoice = JOptionPane.showConfirmDialog((Component)null, "Are you sure you want to delete the traveler's account?", "Confirm Deletion", 0, 2);
        if (confirmChoice == 0) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

                try {
                    String deleteQuery = "DELETE FROM travelers_acc WHERE name=?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);

                    try {
                        deleteStatement.setString(1, name);
                        int rowsAffected = deleteStatement.executeUpdate();
                        if (rowsAffected > 0) {
                            this.Panel4.setVisible(true);
                            this.Panel5.setVisible(false);
                            JOptionPane.showMessageDialog((Component)null, "Traveler's account deleted.", "Deletion Successful", 1);
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "No matching traveler found.", "No Matching Record", 2);
                        }
                    } catch (Throwable var11) {
                        if (deleteStatement != null) {
                            try {
                                deleteStatement.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (deleteStatement != null) {
                        deleteStatement.close();
                    }
                } catch (Throwable var12) {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var13) {
                var13.printStackTrace();
                JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed
    
    private void ClassbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassbActionPerformed
        // TODO add your handling code here:
        String name = this.TravNameField.getText();
        String destination = (String)this.DesCB.getSelectedItem();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                int classBCount = this.getPassengerCount(connection, "B", destination);
                int classACount = this.getPassengerCount(connection, "A", destination);
                if (classBCount >= 10 && classACount >= 10) {
                    JOptionPane.showMessageDialog((Component)null, "Both Class A and Class B are full. Next flight leaves in 5 hours.", "All Flights Full", 1);
                } else if (classBCount >= 10) {
                    JOptionPane.showMessageDialog((Component)null, "Class B is full. Please try Class A.", "Class B Full", 1);
                } else {
                    int seatNumber = this.assignSeatNumberB(connection, destination);
                    String updateQuery = "UPDATE travelers_acc SET class='B', destination=?, seatnum=? WHERE name=?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

                    try {
                        updateStatement.setString(1, destination);
                        updateStatement.setInt(2, seatNumber);
                        updateStatement.setString(3, name);
                        updateStatement.executeUpdate();
                    } catch (Throwable var14) {
                        if (updateStatement != null) {
                            try {
                                updateStatement.close();
                            } catch (Throwable var13) {
                                var14.addSuppressed(var13);
                            }
                        }

                        throw var14;
                    }

                    if (updateStatement != null) {
                        updateStatement.close();
                    }

                    JOptionPane.showMessageDialog((Component)null, "Seat assigned in Class B.", "Seat Assigned", 1);
                }
            } catch (Throwable var15) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var12) {
                        var15.addSuppressed(var12);
                    }
                }

                throw var15;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var16) {
            var16.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_ClassbActionPerformed

    private int assignSeatNumberB(Connection connection, String destination) {
        String maxSeatNumberQuery = "SELECT MAX(seatnum) FROM travelers_acc WHERE class='B' AND destination=?";
        String takenSeatsQuery = "SELECT seatnum FROM travelers_acc WHERE class='B' AND destination=?";

        try {
            PreparedStatement maxSeatNumberStatement = connection.prepareStatement(maxSeatNumberQuery);

            label138: {
                int var10;
                try {
                    PreparedStatement takenSeatsStatement;
                    label140: {
                        takenSeatsStatement = connection.prepareStatement(takenSeatsQuery);

                        try {
                            maxSeatNumberStatement.setString(1, destination);
                            takenSeatsStatement.setString(1, destination);
                            int maxSeatNumber = 0;
                            Set<Integer> takenSeatNumbers = new HashSet();
                            ResultSet takenSeatsResultSet = maxSeatNumberStatement.executeQuery();

                            try {
                                if (takenSeatsResultSet.next()) {
                                    maxSeatNumber = takenSeatsResultSet.getInt(1);
                                }
                            } catch (Throwable var17) {
                                if (takenSeatsResultSet != null) {
                                    try {
                                        takenSeatsResultSet.close();
                                    } catch (Throwable var15) {
                                        var17.addSuppressed(var15);
                                    }
                                }

                                throw var17;
                            }

                            if (takenSeatsResultSet != null) {
                                takenSeatsResultSet.close();
                            }

                            takenSeatsResultSet = takenSeatsStatement.executeQuery();

                            try {
                                while(takenSeatsResultSet.next()) {
                                    takenSeatNumbers.add(takenSeatsResultSet.getInt("seatnum"));
                                }
                            } catch (Throwable var16) {
                                if (takenSeatsResultSet != null) {
                                    try {
                                        takenSeatsResultSet.close();
                                    } catch (Throwable var14) {
                                        var16.addSuppressed(var14);
                                    }
                                }

                                throw var16;
                            }

                            if (takenSeatsResultSet != null) {
                                takenSeatsResultSet.close();
                            }

                            for(int i = 1; i <= maxSeatNumber + 1; ++i) {
                                if (!takenSeatNumbers.contains(i)) {
                                    var10 = i;
                                    break label140;
                                }
                            }
                        } catch (Throwable var18) {
                            if (takenSeatsStatement != null) {
                                try {
                                    takenSeatsStatement.close();
                                } catch (Throwable var13) {
                                    var18.addSuppressed(var13);
                                }
                            }

                            throw var18;
                        }

                        if (takenSeatsStatement != null) {
                            takenSeatsStatement.close();
                        }
                        break label138;
                    }

                    if (takenSeatsStatement != null) {
                        takenSeatsStatement.close();
                    }
                } catch (Throwable var19) {
                    if (maxSeatNumberStatement != null) {
                        try {
                            maxSeatNumberStatement.close();
                        } catch (Throwable var12) {
                            var19.addSuppressed(var12);
                        }
                    }

                    throw var19;
                }

                if (maxSeatNumberStatement != null) {
                    maxSeatNumberStatement.close();
                }

                return var10;
            }

            if (maxSeatNumberStatement != null) {
                maxSeatNumberStatement.close();
            }
        } catch (SQLException var20) {
            Logger.getLogger(airlinebookingform.class.getName()).log(Level.SEVERE, (String)null, var20);
        }

        return 0;
    }
    
    private void CreateAccountButton2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountButton2MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccountButton2MouseMoved

    private void CreateAccountButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateAccountButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccountButton2MouseClicked

    private void PassField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassField2ActionPerformed

    private void PassField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassField3ActionPerformed

    private void ClassaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassaActionPerformed
        // TODO add your handling code here:
        String name = this.TravNameField.getText();
        String destination = (String)this.DesCB.getSelectedItem();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                int classACount = this.getPassengerCount(connection, "A", destination);
                int classBCount = this.getPassengerCount(connection, "B", destination);
                if (classACount >= 10 && classBCount >= 10) {
                    JOptionPane.showMessageDialog((Component)null, "Both Class A and Class B are full. Next flight leaves in 5 hours.", "All Flights Full", 1);
                } else if (classACount >= 10) {
                    JOptionPane.showMessageDialog((Component)null, "Class A is full. Please try Class B.", "Class A Full", 1);
                } else {
                    int seatNumber = this.assignSeatNumber(connection, destination);
                    String updateQuery = "UPDATE travelers_acc SET class='A', destination=?, seatnum=? WHERE name=?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

                    try {
                        updateStatement.setString(1, destination);
                        updateStatement.setInt(2, seatNumber);
                        updateStatement.setString(3, name);
                        updateStatement.executeUpdate();
                    } catch (Throwable var14) {
                        if (updateStatement != null) {
                            try {
                                updateStatement.close();
                            } catch (Throwable var13) {
                                var14.addSuppressed(var13);
                            }
                        }

                        throw var14;
                    }

                    if (updateStatement != null) {
                        updateStatement.close();
                    }

                    JOptionPane.showMessageDialog((Component)null, "Seat assigned in Class A.", "Seat Assigned", 1);
                }
            } catch (Throwable var15) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var12) {
                        var15.addSuppressed(var12);
                    }
                }

                throw var15;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var16) {
            var16.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_ClassaActionPerformed

    private void DeleteTransBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTransBActionPerformed
        String name = this.TravNameField.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String deleteQuery = "UPDATE travelers_acc SET destination='non', seatnum=null WHERE name=?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);

                try {
                    deleteStatement.setString(1, name);
                    int rowsAffected = deleteStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog((Component)null, "Traveler's destination and seat number deleted.", "Deletion Successful", 1);
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "No matching traveler found.", "No Matching Record", 2);
                    }
                } catch (Throwable var10) {
                    if (deleteStatement != null) {
                        try {
                            deleteStatement.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (deleteStatement != null) {
                    deleteStatement.close();
                }
            } catch (Throwable var11) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var12) {
            var12.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_DeleteTransBActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        String oname = this.TravNameField.getText();
        String name = this.NameTF5.getText();
        String age = this.AgeTF5.getText();
        String address = this.AddTF5.getText();
        String contact = this.ConTF5.getText();
        String nationality = this.NatCB2.getSelectedItem().toString();
        String occupation = this.OccTF5.getText();
        String sex = this.SexCB3.getSelectedItem().toString();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String updateQuery = "UPDATE travelers_acc SET name=?, age=?, address=?, contact=?, nationality=?, occupation=?, sex=? WHERE name=?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

                try {
                    updateStatement.setString(1, name);
                    updateStatement.setString(2, age);
                    updateStatement.setString(3, address);
                    updateStatement.setString(4, contact);
                    updateStatement.setString(5, nationality);
                    updateStatement.setString(6, occupation);
                    updateStatement.setString(7, sex);
                    updateStatement.setString(8, oname);
                    int rowsAffected = updateStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog((Component)null, "Traveler's information updated.", "Update Successful", 1);
                        this.TravNameField.setText(name);
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "No matching traveler found.", "No Matching Record", 2);
                    }
                } catch (Throwable var17) {
                    if (updateStatement != null) {
                        try {
                            updateStatement.close();
                        } catch (Throwable var16) {
                            var17.addSuppressed(var16);
                        }
                    }

                    throw var17;
                }

                if (updateStatement != null) {
                    updateStatement.close();
                }
            } catch (Throwable var18) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var15) {
                        var18.addSuppressed(var15);
                    }
                }

                throw var18;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var19) {
            var19.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void TravNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TravNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TravNameFieldActionPerformed

    private void suggestionsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestionsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suggestionsComboBoxActionPerformed

    private void PassField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassField1ActionPerformed
        // TODO add your handling code here:
        String username1 = this.UserField1.getText();
        char[] passvalue1 = this.PassField1.getPassword();
        String password1 = new String(passvalue1);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String query = "SELECT * FROM travelers_acc WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, username1);
                    preparedStatement.setString(2, password1);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        if (resultSet.next()) {
                            String name = resultSet.getString("name");
                            String destination = resultSet.getString("destination");
                            String travelClass = resultSet.getString("class");
                            int seatNumber = resultSet.getInt("seatnum");
                            String seatID;
                            if (seatNumber != 0 && destination != null && !destination.equalsIgnoreCase("non")) {
                                seatID = travelClass + seatNumber;
                            } else {
                                seatID = "NON";
                            }

                            this.Panel1.setVisible(false);
                            this.Panel7.setVisible(true);
                            this.TravNameL.setText(name);
                            this.TravDesL.setText(destination);
                            this.TravSeatL.setText(seatID);
                            this.UserField1.setText("");
                            this.PassField1.setText("");
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Invalid username or password", "Login Error", 0);
                        }
                    } catch (Throwable var17) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var16) {
                                var17.addSuppressed(var16);
                            }
                        }

                        throw var17;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var18) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var15) {
                            var18.addSuppressed(var15);
                        }
                    }

                    throw var18;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var19) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var14) {
                        var19.addSuppressed(var14);
                    }
                }

                throw var19;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var20) {
            var20.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing the login", "Error", 0);
        }
    }//GEN-LAST:event_PassField1ActionPerformed

    private void PassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassFieldActionPerformed
        // TODO add your handling code here:
        String username = this.UserField.getText();
        char[] passvalue = this.PassField.getPassword();
        String password = new String(passvalue);

        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");
            String sql = "SELECT * FROM admin_login WHERE username = ? AND password = ?";
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, username);
            this.ps.setString(2, password);
            this.rs = this.ps.executeQuery();
            if (this.rs.next()) {
                this.Panel3.setVisible(false);
                this.Panel4.setVisible(true);
                this.UserField.setText("");
                this.PassField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", 0);
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        } finally {
            try {
                if (this.rs != null) {
                    this.rs.close();
                }

                if (this.ps != null) {
                    this.ps.close();
                }

                if (this.con != null) {
                    this.con.close();
                }
            } catch (SQLException var13) {
                var13.printStackTrace();
            }

        }
    }//GEN-LAST:event_PassFieldActionPerformed

    private void CreateAccountButton2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CreateAccountButton2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateAccountButton2PropertyChange

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String stiring = QueueList.getSelectedValue().toString();
        QueueLists.remove(stiring);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String string : QueueLists) {
        listModel.addElement(string);
        }

        QueueList.setModel(listModel);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void RefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshMouseEntered

    private void RefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RefreshMouseExited

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Assuming QueueLists is a List<String> or similar collection
        for (String string : QueueLists) {
            listModel.addElement(string);
        }

        QueueList.setModel(listModel);

    }//GEN-LAST:event_RefreshActionPerformed

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        String name = QueueList.getSelectedValue().toString();
        TravNameField.setText(QueueList.getSelectedValue().toString());
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Kalapati_Travels", "root", "1234");

            try {
                String query = "SELECT * FROM travelers_acc WHERE name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, name);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        if (resultSet.next()) {
                            this.Panel6.setVisible(true);
                            QueueLists.remove(name);
                            this.Panel4.setVisible(false);
                            String travelerName = resultSet.getString("name");
                            this.TravNameLabel.setText(travelerName);
                            String travelerDestination = resultSet.getString("destination");
                            this.DesCB.setSelectedItem(travelerDestination);
                        } else {
                            JOptionPane.showMessageDialog((Component)null, "Name not found in the database", "Name Error", 0);
                        }
                    } catch (Throwable var12) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var11) {
                                var12.addSuppressed(var11);
                            }
                        }

                        throw var12;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var13) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var10) {
                            var13.addSuppressed(var10);
                        }
                    }

                    throw var13;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var14) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var15) {
            var15.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "An error occurred while processing", "Error", 0);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if(jToggleButton1.isSelected()){
            PassField2.setEchoChar((char)0);
            PassField3.setEchoChar((char)0);//By this line of code. We will actually see the actual characters
            jToggleButton1.setText("HIDE");
        }else{
            PassField2.setEchoChar('*');
            PassField3.setEchoChar('*');
            jToggleButton1.setText("SHOW");
            
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    private int getPassengerCount(Connection connection, String travelClass, String destination) throws SQLException {
        String countQuery = "SELECT COUNT(*) FROM travelers_acc WHERE class = ? AND destination = ?";
        PreparedStatement countStatement = connection.prepareStatement(countQuery);
        
        int var7;
        label69: {
            try {
                label70: {
                    countStatement.setString(1, travelClass);
                    countStatement.setString(2, destination);
                    ResultSet countResultSet = countStatement.executeQuery();

                    label71: {
                        try {
                            if (countResultSet.next()) {
                                var7 = countResultSet.getInt(1);
                                break label71;
                            }
                        } catch (Throwable var11) {
                            if (countResultSet != null) {
                                try {
                                    countResultSet.close();
                                } catch (Throwable var10) {
                                    var11.addSuppressed(var10);
                                }
                            }

                            throw var11;
                        }

                        if (countResultSet != null) {
                            countResultSet.close();
                        }
                        break label70;
                    }

                    if (countResultSet != null) {
                        countResultSet.close();
                    }
                    break label69;
                }
            } catch (Throwable var12) {
                if (countStatement != null) {
                    try {
                        countStatement.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (countStatement != null) {
                countStatement.close();
            }

            return 0;
        }

        if (countStatement != null) {
            countStatement.close();
        }

        return var7;
    }

    private int assignSeatNumber(Connection connection, String destination) {
        String maxSeatNumberQuery = "SELECT MAX(seatnum) FROM travelers_acc WHERE class='A' AND destination=?";
        String takenSeatsQuery = "SELECT seatnum FROM travelers_acc WHERE class='A' AND destination=?";

        try {
            PreparedStatement maxSeatNumberStatement = connection.prepareStatement(maxSeatNumberQuery);

            label138: {
                int var10;
                try {
                    PreparedStatement takenSeatsStatement;
                    label140: {
                        takenSeatsStatement = connection.prepareStatement(takenSeatsQuery);

                        try {
                            maxSeatNumberStatement.setString(1, destination);
                            takenSeatsStatement.setString(1, destination);
                            int maxSeatNumber = 0;
                            Set<Integer> takenSeatNumbers = new HashSet();
                            ResultSet takenSeatsResultSet = maxSeatNumberStatement.executeQuery();

                            try {
                                if (takenSeatsResultSet.next()) {
                                    maxSeatNumber = takenSeatsResultSet.getInt(1);
                                }
                            } catch (Throwable var17) {
                                if (takenSeatsResultSet != null) {
                                    try {
                                        takenSeatsResultSet.close();
                                    } catch (Throwable var15) {
                                        var17.addSuppressed(var15);
                                    }
                                }

                                throw var17;
                            }

                            if (takenSeatsResultSet != null) {
                                takenSeatsResultSet.close();
                            }

                            takenSeatsResultSet = takenSeatsStatement.executeQuery();

                            try {
                                while(takenSeatsResultSet.next()) {
                                    takenSeatNumbers.add(takenSeatsResultSet.getInt("seatnum"));
                                }
                            } catch (Throwable var16) {
                                if (takenSeatsResultSet != null) {
                                    try {
                                        takenSeatsResultSet.close();
                                    } catch (Throwable var14) {
                                        var16.addSuppressed(var14);
                                    }
                                }

                                throw var16;
                            }

                            if (takenSeatsResultSet != null) {
                                takenSeatsResultSet.close();
                            }

                            for(int i = 1; i <= maxSeatNumber + 1; ++i) {
                                if (!takenSeatNumbers.contains(i)) {
                                    var10 = i;
                                    break label140;
                                }
                            }
                        } catch (Throwable var18) {
                            if (takenSeatsStatement != null) {
                                try {
                                    takenSeatsStatement.close();
                                } catch (Throwable var13) {
                                    var18.addSuppressed(var13);
                                }
                            }

                            throw var18;
                        }

                        if (takenSeatsStatement != null) {
                            takenSeatsStatement.close();
                        }
                        break label138;
                    }

                    if (takenSeatsStatement != null) {
                        takenSeatsStatement.close();
                    }
                } catch (Throwable var19) {
                    if (maxSeatNumberStatement != null) {
                        try {
                            maxSeatNumberStatement.close();
                        } catch (Throwable var12) {
                            var19.addSuppressed(var12);
                        }
                    }

                    throw var19;
                }

                if (maxSeatNumberStatement != null) {
                    maxSeatNumberStatement.close();
                }

                return var10;
            }

            if (maxSeatNumberStatement != null) {
                maxSeatNumberStatement.close();
            }
        } catch (SQLException var20) {
            Logger.getLogger(airlinebookingform.class.getName()).log(Level.SEVERE, (String)null, var20);
        }

        return 1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new airlinebookingform().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddTF;
    private javax.swing.JTextField AddTF5;
    private javax.swing.JButton AdminLoginB;
    private javax.swing.JTextField AgeTF;
    private javax.swing.JTextField AgeTF5;
    private javax.swing.JButton Classa;
    private javax.swing.JButton Classb;
    private javax.swing.JTextField ConTF;
    private javax.swing.JTextField ConTF5;
    private javax.swing.JButton CreateAccountButton2;
    private javax.swing.JButton Delete;
    private javax.swing.JButton DeleteTransB;
    private javax.swing.JComboBox<String> DesCB;
    private javax.swing.JButton EditB;
    private javax.swing.JButton LoginB;
    private javax.swing.JTextField NameTF;
    private javax.swing.JTextField NameTF5;
    private javax.swing.JComboBox<String> NatCB;
    private javax.swing.JComboBox<String> NatCB2;
    private javax.swing.JTextField OccTF;
    private javax.swing.JTextField OccTF5;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel5;
    private javax.swing.JPanel Panel6;
    private javax.swing.JPanel Panel7;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JPasswordField PassField1;
    private javax.swing.JPasswordField PassField2;
    private javax.swing.JPasswordField PassField3;
    private javax.swing.JList<String> QueueList;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton Save;
    private javax.swing.JPanel SecondPanel;
    private javax.swing.JComboBox<String> SexCB;
    private javax.swing.JComboBox<String> SexCB3;
    private javax.swing.JLabel TravDesL;
    private javax.swing.JTextField TravNameField;
    private javax.swing.JLabel TravNameL;
    private javax.swing.JLabel TravNameLabel;
    private javax.swing.JLabel TravSeatL;
    private javax.swing.JTextField UserField;
    private javax.swing.JTextField UserField1;
    private javax.swing.JTextField UserField2;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox<String> suggestionsComboBox;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

  

    }

