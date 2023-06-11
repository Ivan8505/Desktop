/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objs;

/**
 *
 * @author ivan.grodrigues
 */
public class Login {

    /**
     * @return the userLogin
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * @param userLogin the userLogin to set
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * @return the senhaLogin
     */
    public String getSenhaLogin() {
        return senhaLogin;
    }

    /**
     * @param senhaLogin the senhaLogin to set
     */
    public void setSenhaLogin(String senhaLogin) {
        this.senhaLogin = senhaLogin;
    }
    
    private String userLogin;
    private String senhaLogin;
}
