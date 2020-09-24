package demo.entity;

/**
 * @author: Peter
 * @date: 2020/9/21 1:56
 */
public class Account {
    private int accountId;
    private String loginName;
    private String realName;
    private String status;
    private String idcardNo;
    private String telephone;

    @Override
    public String toString() {
        return accountId +" "+ loginName +" "+ status +" "+ realName +" "+ idcardNo +" "+ telephone;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
