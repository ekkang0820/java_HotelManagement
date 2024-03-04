/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmgmttuto;

/**
 *
 * @author rkddm
 */
public class UserVO {
    private String userMail;
    private String userName;
    private String userPW;
    private String userPhone;

   
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPW() {
        return userPW;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public UserVO(String userMail, String userPW, String userName, String userPhone) {
        this.userMail= userMail;
        this.userPW = userPW;
        this.userName = userName;
        this.userPhone = userPhone;
       
	}
}
