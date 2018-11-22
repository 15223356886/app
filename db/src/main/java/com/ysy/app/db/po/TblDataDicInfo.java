package com.ysy.app.db.po;

import java.util.Date;

public class TblDataDicInfo {
    private String dataDicId;

    private String dataKey;

    private String dataValue;

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

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey == null ? null : dataKey.trim();
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
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