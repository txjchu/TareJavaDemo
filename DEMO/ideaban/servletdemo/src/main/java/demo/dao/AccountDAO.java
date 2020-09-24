package demo.dao;

import demo.JDBCUtil;
import demo.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Peter
 * @date: 2020/9/21 2:00
 */
public class AccountDAO {

    private static final String EXCEPTION_MSG = "连接数据库异常！";

    /**
     * 查询所有记录
     */
    public List<Account> findAll() throws SQLException {
        List<Account> accounts = new ArrayList<Account>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM account");
            rs = ps.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setAccountId(Integer.parseInt(rs.getString("account_id")));
                account.setLoginName(rs.getString("login_name"));
                account.setStatus(rs.getString("status"));
                account.setRealName(rs.getString("real_name"));
                account.setIdcardNo(rs.getString("idcard_no"));
                account.setTelephone(rs.getString("telephone"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return accounts;
    }

    /**
     * 根据 ID 查询记录
     */
    public Account findById(int id) throws SQLException {
        Account account = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM account WHERE account_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                // 此时再初始化 account, 若不初始化，则下一步会 空指针异常
                account = new Account();

                account.setAccountId(rs.getInt("account_id"));
                account.setLoginName(rs.getString("login_name"));
                account.setStatus(rs.getString("status"));
                account.setRealName(rs.getString("real_name"));
                account.setIdcardNo(rs.getString("idcard_no"));
                account.setTelephone(rs.getString("telephone"));
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return account;
    }

    /**
     * 删除记录，根据 ID
     */
    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("DELETE FROM account WHERE account_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 添加记录
     */
    public void save(Account account) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("INSERT INTO account(account_id,login_name,status,real_name,idcard_no,telephone)" +
                    " VALUES(null, ?, ?, ?, ?, ?)");
            ps.setString(1, account.getLoginName());
            ps.setString(2, account.getStatus());
            ps.setString(3, account.getRealName());
            ps.setString(4, account.getIdcardNo());
            ps.setString(5, account.getTelephone());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 修改记录
     */
    public void modify(Account account) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE account SET login_name = ?, real_name = ?, idcard_no = ?, telephone = ? WHERE account_id = ?");
            ps.setString(1, account.getLoginName());
//            ps.setString(2, account.getStatus());

            ps.setString(2, account.getRealName());
            ps.setString(3, account.getIdcardNo());
            ps.setString(4, account.getTelephone());
            ps.setInt(5, account.getAccountId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_MSG);
            e.printStackTrace();
            throw e;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

}
