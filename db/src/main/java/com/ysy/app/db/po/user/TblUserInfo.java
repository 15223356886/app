package com.ysy.app.db.po.user;

import java.util.Date;

public class TblUserInfo {
    private String userId;

    private String userCode;

    private String userPwd;

    private String salt;

    private String status;

    private Date createDate;

    private String icon;

    private String openId;

    private String sex;

    private Date birthday;

    private String userQrCode;

    private String wechatQrCode;

    private String address;

    private String identifitionCode;

    private String phone;

    private String userName;

    private String userType;

    private Date lastLoginDate;

    private String lastLoginIp;

    private String lastLoginCity;

    private String loginType;

    private String gesturePwd;

    private String isGesture;

    private String isFinger;

    private String nickName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserQrCode() {
        return userQrCode;
    }

    public void setUserQrCode(String userQrCode) {
        this.userQrCode = userQrCode == null ? null : userQrCode.trim();
    }

    public String getWechatQrCode() {
        return wechatQrCode;
    }

    public void setWechatQrCode(String wechatQrCode) {
        this.wechatQrCode = wechatQrCode == null ? null : wechatQrCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdentifitionCode() {
        return identifitionCode;
    }

    public void setIdentifitionCode(String identifitionCode) {
        this.identifitionCode = identifitionCode == null ? null : identifitionCode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getLastLoginCity() {
        return lastLoginCity;
    }

    public void setLastLoginCity(String lastLoginCity) {
        this.lastLoginCity = lastLoginCity == null ? null : lastLoginCity.trim();
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public String getGesturePwd() {
        return gesturePwd;
    }

    public void setGesturePwd(String gesturePwd) {
        this.gesturePwd = gesturePwd == null ? null : gesturePwd.trim();
    }

    public String getIsGesture() {
        return isGesture;
    }

    public void setIsGesture(String isGesture) {
        this.isGesture = isGesture == null ? null : isGesture.trim();
    }

    public String getIsFinger() {
        return isFinger;
    }

    public void setIsFinger(String isFinger) {
        this.isFinger = isFinger == null ? null : isFinger.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
}