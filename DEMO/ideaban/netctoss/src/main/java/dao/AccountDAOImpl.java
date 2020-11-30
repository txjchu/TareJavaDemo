package dao;

import entity.Account;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 账务账号 DAO 实现类
 * @author: Peter
 * @date: 2020/11/27 1:18
 */
public class AccountDAOImpl implements IAccountDAO{

    /**
     * 将 rs 结果集中的查询结果数据映射为 Account 对象
     * 该方法应放在判断 rs.next() 之后，且抛出 SQLException.
     * @param rs
     * @return
     */
    private Account createAccount(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setAccountId(new Integer(rs.getString("account_id")));
        account.setRecommenderId(rs.getString("recommender_id"));
        account.setLoginName(rs.getString("login_name"));
        account.setLoginPasswd(rs.getString("login_passwd"));
        account.setStatus(rs.getString("status"));
        account.setCreateDate(rs.getTimestamp("create_date"));
        account.setPauseDate(rs.getDate("pause_date"));
        account.setCloseDate(rs.getDate("close_date"));
        account.setRealName(rs.getString("real_name"));
        account.setIdcardNo(rs.getString("idcard_no"));
        account.setBirthdate(rs.getDate("birthdate"));
        account.setGender(rs.getString("gender"));
        account.setOccupation(rs.getString("occupation"));
        account.setTelephone(rs.getString("telephone"));
        account.setEmail(rs.getString("email"));
        account.setMailaddress(rs.getString("mailaddress"));
        account.setZipcode(rs.getString("zipcode"));
        account.setQq(rs.getString("qq"));
        account.setLastLoginTime(rs.getDate("last_login_time"));
        account.setLastLoginIp(rs.getString("last_login_ip"));

        return account;
    }

    /**
     * 查询所有 account 账务账户 记录
     * @return
     */
    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<Account>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM account");
            rs = ps.executeQuery();
            while(rs.next()){
                Account account = createAccount(rs);
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询账务账号列表失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return accounts;
    }

    /**
     * 根据 ID 查找记录
     * @param accountId
     * @return
     */
    @Override
    public Account findById(Integer accountId)  {
        Account account = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM account WHERE account_id = ?");
            ps.setObject(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                account = createAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据ID查询账务账户记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return account;
    }




    @Override
    public void save(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("INSERT INTO account(" +
                    "account_id, " +
                    "real_name, " +
                    "idcard_no, " +
                    "login_name, " +
                    "login_passwd, " +
                    "telephone, " +
                    "recommender_id, " +
                    "birthdate, " +
                    "email, " +
                    "occupation, " +
                    "gender, " +
                    "mailaddress, " +
                    "zipcode, " +
                    "qq," +
                    "status) " +
                    "VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setObject(1, account.getRealName());
            ps.setObject(2, account.getIdcardNo());
            ps.setObject(3, account.getLoginName());
            ps.setObject(4, account.getLoginPasswd());
            ps.setObject(5, account.getTelephone());
            ps.setObject(6, account.getRecommenderId());
            ps.setObject(7, account.getBirthdate());
            ps.setObject(8, account.getEmail());
            ps.setObject(9, account.getOccupation());
            ps.setObject(10, account.getGender());
            ps.setObject(11, account.getMailaddress());
            ps.setObject(12, account.getZipcode());
            ps.setObject(13, account.getQq());
            ps.setObject(14, account.getStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("保存账务账户记录失败", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 删除记录
     * @param accountId
     */
    @Override
    public void delete(Integer accountId) {
        if(accountId == null){
            return;
        }
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("DELETE FROM account WHERE account_id = ?");
            ps.setObject(1, accountId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除账务账号记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 修改记录
     * @param account
     */
    @Override
    public void update(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE account SET " +
                    "real_name = ?," +
                    "idcard_no = ?," +
                    "login_name = ?," +
//                    "login_passwd = ?," +
                    "telephone = ?," +
                    "recommender_id = ?," +
                    "birthdate = ?," +
                    "email = ?," +
                    "occupation = ?," +
                    "gender = ?," +
                    "mailaddress = ?," +
                    "zipcode = ?," +
                    "qq = ?" +
                    "WHERE account_id = ?");
            ps.setObject(1, account.getRealName());
            ps.setObject(2, account.getIdcardNo());
            ps.setObject(3, account.getLoginName());
//            ps.setObject(4, account.getLoginPasswd());
            ps.setObject(4, account.getTelephone());
            ps.setObject(5, account.getRecommenderId());
            ps.setObject(6, account.getBirthdate());
            ps.setObject(7, account.getEmail());
            ps.setObject(8, account.getOccupation());
            ps.setObject(9, account.getGender());
            ps.setObject(10, account.getMailaddress());
            ps.setObject(11, account.getZipcode());
            ps.setObject(12, account.getQq());
            ps.setObject(13, account.getAccountId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改账务账号记录失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }


    /**
     * 修改账务账号的开通、暂停状态。 开通0 暂停1
     * @param account
     */
    @Override
    public void updateStatus(Account account) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("UPDATE account SET status = ? WHERE account_id = ?");
            ps.setObject(1, account.getStatus());
            ps.setObject(2, account.getAccountId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改账务账号状态失败！", e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    /**
     * 根据身份证号查询账务账号记录
     * @param idcardNo
     * @return
     */
    @Override
    public Account findByIdcordNo(String idcardNo) {
        Account account = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.openConnection();
            ps = conn.prepareStatement("SELECT * FROM account WHERE idcard_no = ?");
            ps.setObject(1, idcardNo);
            rs = ps.executeQuery();
            while (rs.next()){
                account = createAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据身份证号查询账务账号记录失败！",e );
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return account;
    }

}
