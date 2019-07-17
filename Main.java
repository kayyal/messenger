















import com.mysql.jdbc.UpdatableResultSet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MysqlCon {
    MysqlCon() throws SQLException {
    }

    public static void main(String args[]) throws SQLException, ParseException, ClassNotFoundException {
        delete(1);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        getCurrentTimeUsingDate();

        //DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        //Date today = new Date(2);

        //Date todayWithZeroTime = (Date) formatter.parse(formatter.format(today));
        MysqlCon app = new MysqlCon();
       // app.isUsernameRegistered("reza");
        // insert three new rows
        app.insert(4, "mahd", "milad", "2019-07-04", "5231");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/massanger_db", "root", "");
//here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();



            String sql1 = "DELETE FROM users  WHERE user_name=?,user_pass=?";


            PreparedStatement statement1 = con.prepareStatement(sql1);
            //st.executeUpdate("INSERT INTO users " + "VALUES (1004,mahdi, 'milad', '2019-07-04.', '5632136')");
            statement1.setString(2, "mahdi");

            statement1.setString(1,"svcdxdvzscczdxcvXCXCxzczxc");
//            System.out.println(statement.);
            System.out.println(statement1.executeUpdate());
            int rows = statement1.executeUpdate();
            if (rows > 0) {
                System.out.println("A user was update successfully!");
            }


            ResultSet rs = stmt.executeQuery("select * from users ");
            //int s=rs.findColumn("user_name");
        //    String a=rs.getString(s);


            while (rs.next())
                System.out.println(rs.getString(2).equals("mahdi"));
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void delete(int id) throws ClassNotFoundException {
        String sql = "DELETE FROM users WHERE user_name=?";
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/massanger_db", "root", "");
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, "reza");
            // execute the delete statement
            System.out.println(    pstmt.executeUpdate());
            pstmt.executeUpdate();
            System.out.println(    pstmt.executeUpdate());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void insert (Integer n,String s,String a,String b,String d) {
        String sql = "INSERT INTO users(user_id,user_name,user_real_name,user_last_seen,user_pass) VALUES(?,?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getStackTrace());
        }
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/massanger_db", "root", "");

             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1,n);
            pstmt.setString(2,s);
            pstmt.setString(3, a);
            pstmt.setString(4, b);
            pstmt.setString(5, d);
            pstmt.execute();



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/massanger_db", "root", "");
  //   PreparedStatement st = con.prepareStatement("SELECT user_name FROM users WHERE user_name= = ?");
//
//    {
//        st.setString(1, "reza");
//        ResultSet r1 = st.executeQuery();
//        System.out.println(r1.next());
////        if (r1.next()) {
//            usernameExists = true;
//        }

public boolean isUsernameRegistered(String username) {
    String query = "SELECT FROM users WHERE user_name= ?" ;  //get username

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/massanger_db", "root", "");
        Statement stmt = con.prepareStatement(query);
        ((PreparedStatement) stmt).setString(1, username);
        ResultSet rs = stmt.executeQuery(query);
        if (rs != null) {
            return true;
        } else {
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return true;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return true;
    }
}public static void getCurrentTimeUsingDate() {
        Date date = new Date(1);
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
    }

}











