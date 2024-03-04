/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelmgmttuto;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author bbeun
 */
public class Reservation extends javax.swing.JFrame {
  
    /**
     * Creates new form Reservations
     */
    public Reservation() {
        initComponents();
        GetRooms();
        GetCustomer();
        showReservations();
        CostTb.setEditable(false);
    }
    
   private void GetRooms() {
    try {
        HotelDAO dao = new HotelDAO();
        List<Integer> roomNumbers = dao.getAvailableRooms();
        RoomCb.removeAllItems();
        for(int roomNum : roomNumbers) {
            RoomCb.addItem(String.valueOf(roomNum));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
    
  private void UpdateRoom() {
    try {
        HotelDAO dao = new HotelDAO();
        int roomNumber = Integer.parseInt(RoomCb.getSelectedItem().toString());
        dao.updateRoomStatus(roomNumber, "Reserved");
        JOptionPane.showMessageDialog(this, "객실 상태 변경");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
    
    private void UpdatetoAvail() {
    try {
        HotelDAO dao = new HotelDAO();
        dao.updateRoomToAvailable(R); // R은 선택된 방 번호를 나타내는 변수
        JOptionPane.showMessageDialog(this, "객실 상태 변경");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
    int RC;
    
   private void GetCost() {
    try {
        HotelDAO dao = new HotelDAO();
        int roomNumber = Integer.parseInt(RoomCb.getSelectedItem().toString());
        int cost = dao.getRoomCost(roomNumber);
        CostTb.setText(String.valueOf(cost));
        RC = cost;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
    
    private void GetCustomer() {
    try {
        HotelDAO dao = new HotelDAO();
        List<Integer> customerIds = dao.getCustomers();
        CustomerCb.removeAllItems();
        for(int custId : customerIds) {
            CustomerCb.addItem(String.valueOf(custId));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
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
        jPanel2 = new javax.swing.JPanel();
        LogoutBtn = new javax.swing.JLabel();
        RoomBtn = new javax.swing.JLabel();
        CustBtn = new javax.swing.JLabel();
        ReservBtn = new javax.swing.JLabel();
        DashboradBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DurationTb = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReservList = new javax.swing.JTable();
        AddBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CustomerCb = new javax.swing.JComboBox<>();
        RoomCb = new javax.swing.JComboBox<>();
        reDate = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        CostTb = new javax.swing.JTextField();
        FetchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        LogoutBtn.setFont(new java.awt.Font("맑은 고딕", 3, 18)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11.png"))); // NOI18N
        LogoutBtn.setText("로그아웃");
        LogoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBtnMouseClicked(evt);
            }
        });

        RoomBtn.setFont(new java.awt.Font("맑은 고딕", 3, 22)); // NOI18N
        RoomBtn.setForeground(new java.awt.Color(255, 255, 255));
        RoomBtn.setIcon(new javax.swing.ImageIcon("C:\\Java_Project\\HotelMgmtTuto\\src\\images\\c.png")); // NOI18N
        RoomBtn.setText("객실");
        RoomBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomBtnMouseClicked(evt);
            }
        });

        CustBtn.setFont(new java.awt.Font("맑은 고딕", 3, 22)); // NOI18N
        CustBtn.setForeground(new java.awt.Color(255, 255, 255));
        CustBtn.setIcon(new javax.swing.ImageIcon("C:\\Java_Project\\HotelMgmtTuto\\src\\images\\u.png")); // NOI18N
        CustBtn.setText("고객");
        CustBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustBtnMouseClicked(evt);
            }
        });

        ReservBtn.setFont(new java.awt.Font("맑은 고딕", 3, 22)); // NOI18N
        ReservBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReservBtn.setIcon(new javax.swing.ImageIcon("C:\\Java_Project\\HotelMgmtTuto\\src\\images\\r.png")); // NOI18N
        ReservBtn.setText("예약");
        ReservBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReservBtnMouseClicked(evt);
            }
        });

        DashboradBtn.setFont(new java.awt.Font("맑은 고딕", 3, 22)); // NOI18N
        DashboradBtn.setForeground(new java.awt.Color(255, 255, 255));
        DashboradBtn.setIcon(new javax.swing.ImageIcon("C:\\Java_Project\\HotelMgmtTuto\\src\\images\\d.png")); // NOI18N
        DashboradBtn.setText("매출");
        DashboradBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboradBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DashboradBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(ReservBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RoomBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(RoomBtn)
                .addGap(28, 28, 28)
                .addComponent(CustBtn)
                .addGap(36, 36, 36)
                .addComponent(ReservBtn)
                .addGap(37, 37, 37)
                .addComponent(DashboradBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutBtn)
                .addGap(18, 18, 18))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Reservation");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("룸 번호");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("고객");

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("예약날짜");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("기간");

        DurationTb.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        DurationTb.setForeground(new java.awt.Color(51, 51, 51));

        ReservList.setBackground(new java.awt.Color(0, 102, 102));
        ReservList.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        ReservList.setForeground(new java.awt.Color(255, 255, 255));
        ReservList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Room", "Customer", "Date", "Duration", "Cost"
            }
        ));
        ReservList.setGridColor(new java.awt.Color(51, 51, 51));
        ReservList.setRowHeight(29);
        ReservList.setRowMargin(1);
        ReservList.setSelectionBackground(new java.awt.Color(0, 51, 51));
        ReservList.setShowHorizontalLines(true);
        ReservList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReservListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ReservList);

        AddBtn.setBackground(new java.awt.Color(240, 240, 240));
        AddBtn.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        AddBtn.setText("예약");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(240, 240, 240));
        CancelBtn.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        CancelBtn.setText("취소");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Java_Project\\HotelMgmtTuto\\src\\images\\r.png")); // NOI18N
        jLabel2.setText("Hotel Management System");

        CustomerCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        CustomerCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerCbActionPerformed(evt);
            }
        });

        RoomCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        RoomCb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RoomCbItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("비용");

        CostTb.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N

        FetchBtn.setBackground(new java.awt.Color(240, 240, 240));
        FetchBtn.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        FetchBtn.setText("계산");
        FetchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FetchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(DurationTb)
                                    .addComponent(AddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(FetchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CustomerCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RoomCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(reDate, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(CostTb))
                                .addGap(56, 56, 56)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(490, 490, 490)
                                .addComponent(jLabel1)))
                        .addGap(72, 103, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(315, 315, 315))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoomCb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerCb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DurationTb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel12))
                            .addComponent(FetchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CostTb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBtnMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutBtnMouseClicked
    
   private void showReservations() {
    try {
        HotelDAO dao = new HotelDAO();
        ResultSet rs = dao.getReservations();
        ReservList.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
    
    int Reid;
    
    private void CountReservations() {
    try {
        HotelDAO dao = new HotelDAO();
        Reid = dao.getNextReservationId();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
}
    
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if (RoomCb.getSelectedIndex() == -1 || CustomerCb.getSelectedIndex() == -1 || DurationTb.getText().isEmpty() || CostTb.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "정보를 모두 입력하세요.");
    } else {
        try {
            HotelDAO dao = new HotelDAO();
            int reservId = dao.getNextReservationId();
            int roomNum = Integer.parseInt(RoomCb.getSelectedItem().toString());
            int custNum = Integer.parseInt(CustomerCb.getSelectedItem().toString());

            // 날짜 형식 변환
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String redate = dateFormat.format(reDate.getDate());

            int duration = Integer.parseInt(DurationTb.getText());
            int cost = Integer.parseInt(CostTb.getText());

            dao.addReservation(reservId, roomNum, custNum, redate, duration, cost);
            JOptionPane.showMessageDialog(this, "객실 예약 성공");
            // 추가 코드: 예약 목록 갱신, 객실 상태 업데이트 등
            showReservations();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    }//GEN-LAST:event_AddBtnActionPerformed

    int Key = 0;
    
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        try {
        HotelDAO dao = new HotelDAO();
        dao.cancelReservation(Key);
        JOptionPane.showMessageDialog(this, "예약 취소");

        // 필요한 추가 코드 (예: 예약 목록 갱신, 객실 상태 업데이트 등)
        showReservations();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void RoomCbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RoomCbItemStateChanged
        GetCost();
    }//GEN-LAST:event_RoomCbItemStateChanged

    private void FetchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FetchBtnActionPerformed
        int TotalAmt = RC * Integer.valueOf(DurationTb.getText().toString());
        CostTb.setText(""+TotalAmt);
        showReservations();
    }//GEN-LAST:event_FetchBtnActionPerformed

    private void RoomBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomBtnMouseClicked
        new Rooms().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RoomBtnMouseClicked

    int R;
    
    private void ReservListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservListMouseClicked
        DefaultTableModel model = (DefaultTableModel) ReservList.getModel();
        int MyIndex = ReservList.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        R = Integer.valueOf(model.getValueAt(MyIndex, 1).toString());
        RoomCb.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
        CustomerCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        DurationTb.setText(model.getValueAt(MyIndex,4).toString());
        CostTb.setText(model.getValueAt(MyIndex, 5).toString());
    }//GEN-LAST:event_ReservListMouseClicked

    private void CustBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustBtnMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CustBtnMouseClicked

    private void ReservBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservBtnMouseClicked
        new Reservation().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReservBtnMouseClicked

    private void DashboradBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboradBtnMouseClicked
        new DashBoard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboradBtnMouseClicked

    private void CustomerCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerCbActionPerformed

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
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTextField CostTb;
    private javax.swing.JLabel CustBtn;
    private javax.swing.JComboBox<String> CustomerCb;
    private javax.swing.JLabel DashboradBtn;
    private javax.swing.JTextField DurationTb;
    private javax.swing.JButton FetchBtn;
    private javax.swing.JLabel LogoutBtn;
    private javax.swing.JLabel ReservBtn;
    private javax.swing.JTable ReservList;
    private javax.swing.JLabel RoomBtn;
    private javax.swing.JComboBox<String> RoomCb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser reDate;
    // End of variables declaration//GEN-END:variables
}