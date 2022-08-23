package com.ineffable.shopfast1_5.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Variant {
    @EmbeddedId
    private VID vid;

    public Variant(VID vid) {
        this.vid = vid;
    }

    public Variant() {
    }

    public VID getVid() {
        return vid;
    }

    public void setVid(VID vid) {
        this.vid = vid;
    }
}
