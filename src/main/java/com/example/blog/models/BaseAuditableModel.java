package com.example.blog.models;

import java.util.Date;
import java.util.Objects;

/**
 * @author smustafov
 */
public abstract class BaseAuditableModel extends BaseModel {

    private Date createdOn;

    private Date modifiedOn;

    private String createdBy;

    private String modifiedBy;

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BaseAuditableModel that = (BaseAuditableModel) o;
        return Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(modifiedOn, that.modifiedOn) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(modifiedBy, that.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), createdOn, modifiedOn, createdBy, modifiedBy);
    }
}
