/**
 * <p>Title: User.java</p>  
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>  
 * <p>Company: www.landasoft.com</p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午4:20:50 
 * @version 1.0  
 */
package com.landasoft.mas.demo.rabbitmq.bean;

import java.io.Serializable;

/**
 * <p>Title: User</p>  
 * <p>Description: 发送消息</p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午4:20:50
 */
/**
 * <p>Title: User</p>  
 * <p>Description: </p>  
 * @author wulinyun  
 * @date 2019年2月25日 下午4:43:11
 */
public class User implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
}
