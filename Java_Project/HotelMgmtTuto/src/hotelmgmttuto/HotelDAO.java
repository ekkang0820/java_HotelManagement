package hotelmgmttuto;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class HotelDAO {

    private Connection connect() {
        // 데이터베이스 연결 설정
        String url = "jdbc:mysql://localhost:3306/HotelDb";
        String user = "root";
        String password = "eksldpf1!";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ResultSet listCustomers() {
        // 고객 목록 조회
        String query = "SELECT * FROM customer";
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void addCustomer(CustomerVO customer) {
        String query = "INSERT INTO customer(custName, custPhone, custGen, custAdd, custDob)  VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customer.getCustName());
            stmt.setString(2, customer.getCustPhone());
            stmt.setString(3, customer.getCustGen());
            stmt.setString(4, customer.getCustAdd());
            stmt.setString(5, customer.getCustDob());
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

     public void updateCustomer(CustomerVO customer) {
        String query = "UPDATE customer SET custname = ?, custphone = ?, custgen = ?, custadd = ?, custDob = ? WHERE custnum = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customer.getCustName());
            stmt.setString(2, customer.getCustPhone());
            stmt.setString(3, customer.getCustGen());
            stmt.setString(4, customer.getCustAdd());
            stmt.setString(5, customer.getCustDob());
            stmt.setInt(6, customer.getCustNum());
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

   public void deleteCustomer(int custNum) {
        String query = "DELETE FROM customer WHERE custNum = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, custNum);
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet searchCustomer(String name) {
        // 고객 검색
        String query = "SELECT * FROM customer WHERE custName LIKE ?";
        try {
            Connection conn = connect();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name + "%");
            return stmt.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
      public int countCustomers() {
        int maxCustNum = 0;
        String query = "SELECT count(*) FROM customer";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                maxCustNum = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return maxCustNum;
    }
     
      
    public List<Integer> getRooms() {
    List<Integer> rooms = new ArrayList<>();
    String query = "SELECT roomNum FROM roomTbl";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            rooms.add(rs.getInt("roomNum"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return rooms;
}

      public int countRooms() {
    int roomCount = 0;
    String query = "SELECT COUNT(*) FROM roomTbl";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        if (rs.next()) {
            roomCount = rs.getInt(1);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return roomCount;
}
      public int incomeByRoom(int roomNumber) {
    int income = 0;
    String query = "SELECT SUM(Cost) FROM reservTbl WHERE Room = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, roomNumber);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                income = rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return income;
}
      public int totalIncome() {
    int totalIncome = 0;
    String query = "SELECT SUM(Cost) FROM reservTbl";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        if (rs.next()) {
            totalIncome = rs.getInt(1);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return totalIncome;
}
      public List<Integer> getAvailableRooms() {
    List<Integer> rooms = new ArrayList<>();
    String query = "SELECT roomNum FROM roomTbl WHERE roomStatus = '예약가능'";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            rooms.add(rs.getInt("roomNum"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return rooms;
}
      public void updateRoomStatus(int roomNumber, String status) {
    String query = "UPDATE roomTbl SET roomStatus = ? WHERE roomNum = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, status);
        stmt.setInt(2, roomNumber);
        stmt.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
      public List<Integer> getCustomers() throws SQLException {
    List<Integer> customers = new ArrayList<>();
    String query = "SELECT custNum FROM customer";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            customers.add(rs.getInt("custNum"));
        }
    }
    return customers;
}
      public void addReservation(int reservNum, int roomNum, int custNum, String date, int duration, int cost) throws SQLException {
    String query = "INSERT INTO reservTbl VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, reservNum);
        stmt.setInt(2, roomNum);
        stmt.setInt(3, custNum);
        stmt.setString(4, date);
        stmt.setInt(5, duration);
        stmt.setInt(6, cost);
        stmt.executeUpdate();
    }
}
      public void cancelReservation(int reservNum) throws SQLException {
    String query = "DELETE FROM reservTbl WHERE reservNum = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, reservNum);
        stmt.executeUpdate();
    }
}
      public int getNextReservationId() throws SQLException {
    String query = "SELECT MAX(reservNum) FROM reservTbl";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        if (rs.next()) {
            return rs.getInt(1) + 1;
        } else {
            return 1; // 처음 예약하는 경우
        }
    }
}
      public void updateRoomToAvailable(int roomNumber) throws SQLException {
    String status = "Available";
    String query = "UPDATE roomTbl SET roomStatus = ? WHERE roomNum = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, status);
        stmt.setInt(2, roomNumber);
        stmt.executeUpdate();
    }
}
//      public int getNextReservationId() throws SQLException {
//    int nextId = 1;
//    String query = "SELECT MAX(reservNum) FROM reservTbl";
//    try (Connection conn = connect();
//         Statement stmt = conn.createStatement();
//         ResultSet rs = stmt.executeQuery(query)) {
//        if (rs.next()) {
//            nextId = rs.getInt(1) + 1;
//        }
//    }
//    return nextId;
//}

//public void addReservation(int reservNum, int roomNum, int custNum, String date, int duration, int cost) throws SQLException {
//    String query = "INSERT INTO reservTbl VALUES (?, ?, ?, ?, ?, ?)";
//    try (Connection conn = connect();
//         PreparedStatement stmt = conn.prepareStatement(query)) {
//        stmt.setInt(1, reservNum);
//        stmt.setInt(2, roomNum);
//        stmt.setInt(3, custNum);
//        stmt.setString(4, date);
//        stmt.setInt(5, duration);
//        stmt.setInt(6, cost);
//        stmt.executeUpdate();
//    }
//}   
      public int getRoomCost(int roomNumber) throws SQLException {
    int cost = 0;
    String query = "SELECT Price FROM roomTbl WHERE roomNum = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, roomNumber);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                cost = rs.getInt("Price");
            }
        }
    }
    return cost;
}
public ResultSet getReservations() throws SQLException {
    Connection conn = connect();
    Statement stmt = conn.createStatement();
    String query = "SELECT * FROM reservTbl";
    return stmt.executeQuery(query);
}
//public int getNextReservationId() throws SQLException {
//    int nextId = 1;
//    String query = "SELECT MAX(reservNum) FROM reservTbl";
//    try (Connection conn = connect();
//         Statement stmt = conn.createStatement();
//         ResultSet rs = stmt.executeQuery(query)) {
//        if (rs.next()) {
//            nextId = rs.getInt(1) + 1;
//        }
//    }
//    return nextId;
//}

public ResultSet getAllRooms() throws SQLException {
    String query = "SELECT * FROM roomTbl";
    Connection conn = connect();
    Statement stmt = conn.createStatement();
    return stmt.executeQuery(query);
}

public ResultSet getRoomsByCategory(String category) throws SQLException {
    String query = "SELECT * FROM roomTbl WHERE roomType = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, category);
        return stmt.executeQuery();
    }
}
public int getNextRoomNumber() throws SQLException {
    int nextRoomNumber = 1; // 기본값 설정
    String query = "SELECT MAX(roomNum) FROM roomTbl";
    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        if (rs.next()) {
            nextRoomNumber = rs.getInt(1) + 1; // 가장 높은 방 번호에서 1을 더해 다음 번호 계산
        }
    }
    return nextRoomNumber;
}
public void addRoom(String roomName, String category, String status, int price) throws SQLException {
    int roomId = getNextRoomNumber(); // 새로운 방 번호를 가져옵니다.
    String query = "INSERT INTO roomTbl (roomNum, roomName, roomType, roomStatus, Price) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, roomId);
        stmt.setString(2, roomName);
        stmt.setString(3, category);
        stmt.setString(4, status);
        stmt.setInt(5, price);
        stmt.executeUpdate();
    }
}
public void deleteRoom(int roomNumber) throws SQLException {
    String query = "DELETE FROM roomTbl WHERE roomNum = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, roomNumber);
        stmt.executeUpdate();
    }
}
public void updateRoom(int roomNumber, String roomName, String roomType, String roomStatus, int price) throws SQLException {
    String query = "UPDATE roomTbl SET roomName = ?, roomType = ?, roomStatus = ?, price = ? WHERE roomNum = ?";
    try (Connection conn = connect();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, roomName);
        stmt.setString(2, roomType);
        stmt.setString(3, roomStatus);
        stmt.setInt(4, price);
        stmt.setInt(5, roomNumber);
        stmt.executeUpdate();
    }
}

      
}