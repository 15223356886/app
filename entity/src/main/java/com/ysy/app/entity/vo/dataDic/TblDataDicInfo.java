package com.ysy.app.entity.vo.dataDic;

import java.io.Serializable;
import java.util.Date;

public class TblDataDicInfo implements Serializable {
    private static final long serialVersionUID = 1017708038887871226L;
    private String dataDicId;

    private String key;

    private String value;

    private String dataDicType;

    private String status;

    private Date createDate;

    private Date updateDate;

    public String getDataDicId() {
        return dataDicId;
    }

    public void setDataDicId(String dataDicId) {
        this.dataDicId = dataDicId == null ? null : dataDicId.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDataDicType() {
        return dataDicType;
    }

    public void setDataDicType(String dataDicType) {
        this.dataDicType = dataDicType == null ? null : dataDicType.trim();
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}