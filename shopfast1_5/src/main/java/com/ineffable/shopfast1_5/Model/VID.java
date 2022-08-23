package com.ineffable.shopfast1_5.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VID implements Serializable {

    private String variantName;
    private String variantValue;
    private Long pid;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VID vid = (VID) o;
        return getVariantName().equals(vid.getVariantName()) && getVariantValue().equals(vid.getVariantValue()) && getPid().equals(vid.getPid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVariantName(), getVariantValue(), getPid());
    }

    public VID(String variantName, String variantValue, Long pid) {
        this.variantName = variantName;
        this.variantValue = variantValue;
        this.pid = pid;
    }



    public VID() {
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getVariantValue() {
        return variantValue;
    }

    public void setVariantValue(String variantValue) {
        this.variantValue = variantValue;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
