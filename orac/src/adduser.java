import java.nio.file.attribute.UserPrincipal;
import java.sql.*;

public class adduser {
    public void addUser(User user){
        String sql="insert into t_user(user_id,user_name,PASSWORD,CONTACT_TEL,EMAIL,CREATE_DATE)values(?,?,?,?,?,?)"; //?为参数占位符
        Connection conn=null;
        PreparedStatement pstmt=null; //通常利用PreparedStatement进行操作，性能得到优化
        try{
            conn=Dbtuil.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId() );
            pstmt.setString(2,user.getUserName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getContactTel());
            pstmt.setString(5,user.getEmail());
            //pstmt.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
            pstmt.executeUpdate();//执行增删改操作

        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            Dbtuil.close((PreparedStatement) conn);
            Dbtuil.close(pstmt);

        }

    }


}




