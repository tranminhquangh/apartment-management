/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.accounts;

/**
 *
 * @author tranp
 */
public class AccountDTO {
    private String Username;
    private String Password;
    private String RoleID;
    private boolean accountStatus;

    public AccountDTO() {
        
    }

    public AccountDTO(String Username, String Password, String RoleID, boolean accountStatus) {
        this.Username = Username;
        this.Password = Password;
        this.RoleID = RoleID;
        this.accountStatus = accountStatus;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    
    
    
}
