/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import commom.TagReader;
import commom.TagValue;
import commom.TagWriter;
import commom.Tags;
import commom.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Meep
 */
public class GroupForm extends javax.swing.JFrame {

    List<JButton> listOfFriendButton = new ArrayList<>();
    private static int numOFriend = 0;
    static String GroupName = "New Group";
    static List<String> GroupMember = new ArrayList<String>();

    static Socket conn;
    private TagReader reader;
    private TagWriter writer;
    JTable table = new JTable();
    public static List<User> AlreadyFriends;
    private String[] UserInformation;
    private String AccountName; //the login variable
    private int AccountID;
    private static String info;
    private List<String> Friendslist = new ArrayList<String>();
    private List<Integer> FriendStatus = new ArrayList<>();
    private static List<User> UserFriendsList = new ArrayList<>();

    /**
     * Creates new form SearchForm
     */
    public GroupForm(String userInfor, List<User> Friends) throws IOException {

        initComponents();
        setIcon();
        if (Friends != null) {
            if (!Friends.isEmpty()) {
                AlreadyFriends = Friends;
                UserFriendsList = Friends;
            } else {
                AlreadyFriends = null;
                UserFriendsList = null;
            }
        }
        System.out.println("fr: " + Friends.get(0).getUser_name());
        if (userInfor != null) {
            if (!userInfor.isEmpty()) {
                userInfor = userInfor.substring(1, userInfor.length() - 1);
                UserInformation = userInfor.split(" ");
                AccountName = UserInformation[1];
                AccountID = Integer.valueOf(UserInformation[0]);

            }
        }

        setTabValue_Friends();
        setTitle("Search Friends");
        setIcon();

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(620, 550));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAddList = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGroupName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbAddList.setText("Group Member:  ");

        jLabel3.setText("Group Name:");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreate))
                        .addGap(23, 23, 23)
                        .addComponent(lbAddList)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (GroupMember.size() > 0) {
            GroupName = txtGroupName.getText();
            if (!GroupMember.contains(AccountName)) {
                GroupMember.add(AccountName);
            }
            for (int i = 0; i < GroupMember.size(); i++) {
                System.out.println("member: " + GroupMember.get(i));
            }
            try {
                CreateGroup();
            } catch (IOException ex) {
                Logger.getLogger(GroupForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Complete");
            dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Please choose your group Members");
    }//GEN-LAST:event_btnCreateActionPerformed

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
            java.util.logging.Logger.getLogger(GroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GroupForm(info, AlreadyFriends).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GroupForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chat_assignment/res/iconfinder_flower_1055057.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAddList;
    private javax.swing.JTextField txtGroupName;
    // End of variables declaration//GEN-END:variables

    private void SearchFriend() {
        // Addtopanel();
//    String input = txtSearchinput.getText();
//    DefaultTableModel model = (DefaultTableModel) tblSearchoutput.getModel();
////    model.setDataVector(new Object[][]{}, new Object[]{});
//    model.setRowCount(0);
////    model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
//       
//        try {
//            tblSearchoutput= new JTable(model);
//                 
//            conn = new Socket(ServerInfo.IP, 9000);
//            reader = new TagReader(conn.getInputStream());  
//            writer = new TagWriter(conn.getOutputStream()); 
//            String[] request = {Tags.SEARCH, "<"+input+">"};
//            TagValue tv = new TagValue(request[0], request[1].getBytes());
//            writer.writeTag(tv);
//            writer.flush();
//            tv = reader.getTagValue();            
//            if(tv.getTag().equals(Tags.SUCCESS)){
//                noRes.setVisible(false);
//                List<User> users= getContent(tv.getContent());
//                for(int i=0;i<users.size();i++){
//                    
//                    String name= users.get(i).getUser_name();
//                    String IP=users.get(i).getIP_addr();
//                    int status= users.get(i).getStatus();
//                    
//                    
//                    
////                    JButton btn= new JButton("JButton_"+i);  
////                    model.setDataVector(new Object[][]{{name,IP,status}}, new Object[]{"Name","Button"});
//                    model.addRow(new Object[]{name,IP,status});                     
//                    tblSearchoutput.getColumn("Button").setCellRenderer(new ButtonRenderer());
//                    tblSearchoutput.getColumn("Button").setCellEditor( new ButtonEditor(new JCheckBox()));
//                }
//                txtSearchinput.setText("");
//            }
//            else
//            {
//                noRes.setVisible(true);
//            }            
//            
//        } catch (Exception e) {
//            System.err.println("Network error");
//        }
    }

    private List<User> getContent(byte[] content) {
        String s = new String(content);
        s = s.replace("<", "");
        s = s.replace(">", "");

        String[] arrString = s.split("\\|");
        List<User> users = new ArrayList<>();

        for (String str : arrString) {
            String[] arrAttr = str.split(" ");
            users.add(new User(Integer.parseInt(arrAttr[0]), arrAttr[1], arrAttr[2], Integer.parseInt(arrAttr[3])));
        }

        return users;
    }

//    private void SearchforFriends() {
//        DefaultTableModel dm = new DefaultTableModel();
//        dm.setRowCount(0);
//        dm.setDataVector(new Object[][]{{"button 1", "foo"},
//        {"button 2", "bar"}}, new Object[]{"Add_Friends", "String"});
//
//        Object[] tblHeader = {"Name", "IP_Adress", "Status", "Add_Friends"};
//
//        String input = txtSearchinput.getText();
//        try {
////            tblSearchoutput= new JTable(dm);
//
//            conn = new Socket(ServerInfo.IP, 9000);
//            reader = new TagReader(conn.getInputStream());
//            writer = new TagWriter(conn.getOutputStream());
//            String[] request = {Tags.SEARCH, "<" + input + ">"};
//            TagValue tv = new TagValue(request[0], request[1].getBytes());
//            writer.writeTag(tv);
//            writer.flush();
//            tv = reader.getTagValue();
//            if (tv.getTag().equals(Tags.SUCCESS)) {
//                noRes.setVisible(false);
//                List<User> users = getContent(tv.getContent());
//
//                Object[][] tblData = new Object[users.size()][4];
//                
//                for (int i = 0; i < users.size(); i++) {
//
//                    String name = users.get(i).getUser_name();
//                    String IP = users.get(i).getIP_addr();
//                    int status = users.get(i).getStatus();
//                    int userID = users.get(i).getID();
//
//                    //model.addRow(new Object[]{name,IP,status});
//                    
//                        tblData[i][0] = name;
//                        tblData[i][1] = IP;
//                        if (status == 0) {
//                            tblData[i][2] = "Offline";
//                        } else {
//                            tblData[i][2] = "Online";
//                        }
//                        tblData[i][3] = AccountID + "_" + AccountName + " " + userID + "_" + name;
//                       
//                    
//                    
//                }
//
//                dm.setDataVector(tblData, tblHeader);
//                txtSearchinput.setText("");
//
//                table.setModel(dm);
//                ButtonRenderer needbtn = new ButtonRenderer();
//                needbtn.setText("Suprise");
//                table.getColumn("Add_Friends").setCellRenderer(needbtn);
//                table.getColumn("Add_Friends").setCellEditor(new ButtonEditor(new JCheckBox()));
////                JTable table = new JTable(dm);               
////                table.getColumn("Add_Friends").setCellRenderer(new ButtonRenderer());
////                table.getColumn("Add_Friends").setCellEditor(new ButtonEditor(new JCheckBox()));
////                JScrollPane scroll = new JScrollPane(table);
////                jPanel1.add(scroll);
//            } else {
//                noRes.setVisible(true);
//            }
//
//        } catch (Exception e) {
//            System.err.println("Network error");
//        }
//
//        ////////////////////////////////////////////////////////////////////////////////////
////    JTable table = new JTable(dm);
////    table.getColumn("Add_Friends").setCellRenderer(new ButtonRenderer());
////    table.getColumn("Add_Friends").setCellEditor(new ButtonEditor(new JCheckBox()));
////    JScrollPane scroll = new JScrollPane(table);
////    jPanel1.add(scroll);
//    }
    private void CreateGroup() throws UnknownHostException, IOException, IOException {
        if (GroupName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Group Name");
        } else {
            for (int i = 0; i < GroupMember.size(); i++) {
                conn = new Socket(ServerInfo.IP, 9000);
                reader = new TagReader(conn.getInputStream());
                writer = new TagWriter(conn.getOutputStream());
                String CreateInfo = "<" + GroupName + " " + GroupMember.get(i) + ">";
                System.out.println("createinfo: " + CreateInfo);
                String[] request = {Tags.CREATE, CreateInfo};
                try {

                    TagValue tv = new TagValue(request[0], request[1].getBytes());
                    writer.writeTag(tv);
                    writer.flush();
                    tv = reader.getTagValue();
                    System.out.println(tv.getTag());
                    if (tv.getTag().equals(Tags.SUCCESS)) {
                        System.out.println("Add success");
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong");
                    }
                } catch (Exception e) {
                    //System.err.println("Network error");
                    e.printStackTrace();
                }
            }
        }

    }

    private void updateFriendlist() {
        if (UserFriendsList != null) {
            System.out.println("User is not null");
            if (!UserFriendsList.isEmpty()) {
                if (Friendslist != null) {
                    if (!Friendslist.isEmpty()) {
                        Friendslist.clear();
                    }

                    for (int i = 0; i < UserFriendsList.size(); i++) {
                        String x = UserFriendsList.get(i).getUser_name();
                        FriendStatus.add((UserFriendsList.get(i).getStatus()));
                        Friendslist.add(x);
                        System.out.println("FriendList: " + Friendslist.get(i));
                    }
                }
            }
        } else {
            Friendslist = null;
        }
    }

    private void setTabValue_Friends() throws IOException {
        updateFriendlist();
        Component[] componentList = jPanel1.getComponents();
        for (Component c : componentList) {
            c.setVisible(false);
        }
        jPanel1.removeAll();
        List<String> name = new ArrayList<String>();

        if (Friendslist != null) {
            name = Friendslist;
        }

        if (!(name.isEmpty())) {
            //boolean[] onl = {true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
            List<Integer> online = new ArrayList<>();
            if (FriendStatus != null) {
                online = FriendStatus;
            }
            listOfFriendButton.clear();

//          jPanel1.setLayout( new FlowLayout() );
            int i = 0;
            int co_x = 10;
            int co_y = 50 * i;
            int panel_weight = 220;
            int panel_height = 50;
            numOFriend = name.size();

            //display friend in tab
            for (i = 0; i < name.size(); i++) {
                co_y = 50 * i;
                String temp = "JButton_" + name.get(i);
                String friendUserName = name.get(i);
                JButton btn = new JButton(temp);
                //BufferedReader buffered = null;
                listOfFriendButton.add(btn);
                //String username = UserFriendsList.get(i).getIP_addr();
                //String IP_address = UserFriendsList.get(i).getUser_name();
                //String myIP = getPublicIP();
//             btn.setOnAction(new EventHandler<ActionEvent>() {
//        @Override public void handle(ActionEvent actionEvent) {
//            System.out.println("from: "+temp);

//        }
//    });
                btn.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        int j = 0;
                        if (btn.getBackground() == Color.magenta) {
                            btn.setBackground(new JButton().getBackground());
                            GroupMember.remove(friendUserName);
                            lbAddList.setText("Already Add: ");
                            for (int i = 0; i < GroupMember.size(); i++) {
                                lbAddList.setText(lbAddList.getText() + " " + GroupMember.get(i) + ",");
                            }
                        } else {
                            if (GroupMember.contains(friendUserName))// no adding twice
                            {

                            } else {
                                GroupMember.add(friendUserName);
                                lbAddList.setText("Already Add: ");
                                for (int i = 0; i < GroupMember.size(); i++) {
                                    lbAddList.setText(lbAddList.getText() + " " + GroupMember.get(i) + ",");
                                }

                                btn.setBackground(Color.magenta);
                            }
                        }

                        //                                                
                    }
                });
                btn.setBounds(co_x, co_y, panel_weight, panel_height);
                if (online.get(i) == 1) {
                    JLabel onl_icon = new JLabel();
                    onl_icon.setText("");
                    onl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_Icon_Element_Earth_02_513724.png")));
                    onl_icon.setBounds(co_x + 220 + 3, co_y, panel_weight, panel_height);
                    jPanel1.add(onl_icon);
                    Socket socket = null;

                } else {
                    JLabel onl_icon = new JLabel();
                    onl_icon.setText("");
                    onl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_assignment/res/iconfinder_b_4_2578285.png")));
                    onl_icon.setBounds(co_x + 220 + 8, co_y, panel_weight, panel_height);
                    jPanel1.add(onl_icon);

                }
                btn.setText(name.get(i));
                jPanel1.add(btn);
            }

        }
    }
}

//class ButtonRenderer extends JButton implements TableCellRenderer {
//    public ButtonRenderer() {
//        setOpaque(true);
//    }
//
//    public Component getTableCellRendererComponent(JTable table, Object value,
//            boolean isSelected, boolean hasFocus, int row, int column) {
//        if (isSelected) {
//            setForeground(table.getSelectionForeground());
//            setBackground(table.getSelectionBackground());
//        } else {
//            setForeground(table.getForeground());
//            setBackground(UIManager.getColor("Button.background"));
//        }
//
////        setText((value == null) ? "" : value.toString());
//        setText("Add");
//        return this;
//    }
//}
//
//class ButtonEditor extends DefaultCellEditor {
//
//    private Socket conn;
//    private TagReader reader;
//    private TagWriter writer;
//    private String[] request;
//
//    protected JButton button;
//
//    private String label;
//
//    private boolean isPushed;
//
//    private String AccountName;
//    private int AccountID;
//    private String FoundName;
//    private int FoundID;
//
//    public ButtonEditor(JCheckBox checkBox) {
//        super(checkBox);
//        button = new JButton();
//        button.setOpaque(true);
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                fireEditingStopped();
//            }
//        });
//    }
//
//    public Component getTableCellEditorComponent(JTable table, Object value,
//            boolean isSelected, int row, int column) {
//        if (isSelected) {
//            button.setForeground(table.getSelectionForeground());
//            button.setBackground(table.getSelectionBackground());
//        } else {
//            button.setForeground(table.getForeground());
//            button.setBackground(table.getBackground());
//        }
//        label = (value == null) ? "hello" : value.toString();
////        button.setText(label);
//        button.setText("Add");
//        isPushed = true;
//        return button;
//    }
//
//    public Object getCellEditorValue() {
//        if (isPushed) {
//
//            String[] nameAid = label.split(" ", 2); // Format( 'loginID' '_' 'loginName' "(space)" 'FoundID' '_' 'FoundName')           
//            String[] Account = nameAid[0].split("_", 2);
//            String[] Found = nameAid[1].split("_", 2);
//
//            AccountName = Account[1];
//            AccountID = Integer.valueOf(Account[0]);
//            FoundName = Found[1];
//            FoundID = Integer.valueOf(Found[0]);
//            if(AccountID!=FoundID)
//            {if (checkifFriend()) {
//                JOptionPane.showMessageDialog(button, "You 2 have already been friends");
//            } else {
//                if (RequestFriend()) {
//                    JOptionPane.showMessageDialog(button, "Request Friends sent");
//                } else {
//                    JOptionPane.showMessageDialog(button, "Request has already sent to " + FoundName);
//                }
//            }
//            }
//            else{JOptionPane.showMessageDialog(button, "Why Request to yourself...???");}
////            JOptionPane.showMessageDialog(button, label + ": Ouch!");
//
//        }
//        isPushed = false;
//        return new String(label);
//    }
//
//    public boolean stopCellEditing() {
//        isPushed = false;
//        return super.stopCellEditing();
//    }
//
//    protected void fireEditingStopped() {
//        super.fireEditingStopped();
//    }
//
//    private boolean checkifFriend() {
//        List<User> Friends = ImportListFriends(AccountName);
//        if(Friends!=null)
//            for (int i = 0; i < Friends.size(); i++) {
//                if (FoundID == Friends.get(i).getID()) {
//                    return true;
//                }
//            }
//        return false;
//    }
//
//    private java.util.List<User> ImportListFriends(String username) {
//        String[] askF = {Tags.FIND_FRIEND, "<" + username + ">"};
//        List<User> users = null;
//        try {
//            conn = new Socket(ServerInfo.IP, 9000);
//            reader = new TagReader(conn.getInputStream());
//            writer = new TagWriter(conn.getOutputStream());
//            TagValue tv2 = new TagValue(askF[0], askF[1].getBytes());
//            writer.writeTag(tv2);
//            writer.flush();
//            tv2 = reader.getTagValue();
////                System.out.println("ask: "+ tv2.getTag());
//            if (tv2.getTag().equals(Tags.SUCCESS)) {
//                users = getUsers(tv2.getContent());
//                for (User usr : users) {
////                        System.out.println("get this: "+usr.getUser_name());
//                }
//            }
//
//        } catch (Exception e) {
//            System.err.println("Network error");
//        }
//        return users;
//    }
//
//    private java.util.List<User> getUsers(byte[] content) {
//        String string = new String(content);
//        string = string.replace("<", "");
//        string = string.replace(">", "");
//
//        String[] arrString = string.split("\\|");
//        java.util.List<User> users = new ArrayList<>();
//
//        for (String str : arrString) {
//            String[] arrAttr = str.split(" ");
//            users.add(new User(Integer.parseInt(arrAttr[0]), arrAttr[1], arrAttr[2], Integer.parseInt(arrAttr[3])));
//        }
//        return users;
//    }
//
//    private boolean RequestFriend() {
//        String[] askF = {Tags.REQUEST, "<" + AccountName + " " + FoundName + ">"};
//        List<User> users = null;
//        try {
//            conn = new Socket(ServerInfo.IP, 9000);
//            reader = new TagReader(conn.getInputStream());
//            writer = new TagWriter(conn.getOutputStream());
//            TagValue tv2 = new TagValue(askF[0], askF[1].getBytes());
//            writer.writeTag(tv2);
//            writer.flush();
//            tv2 = reader.getTagValue();
////                System.out.println("ask: "+ tv2.getTag());
//            if (tv2.getTag().equals(Tags.SUCCESS)) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (Exception e) {
//            System.err.println("Network error");
//        }
//        return false;
//    }
//}