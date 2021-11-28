package com.Siemens.Model;

import javax.persistence.*;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assertId;
    private String assertName;

    public void setAssertName(String assertName) {
        this.assertName = assertName;
    }

    public Long getAssertId() {
        return assertId;
    }

    public void setAssertId(Long assertId) {
        this.assertId = assertId;
    }

    public String getAssertName() {
        return assertName;
    }
}
