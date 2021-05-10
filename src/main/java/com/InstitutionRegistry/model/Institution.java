package com.InstitutionRegistry.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Institution implements Serializable {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String acro;

    private String uorg;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAcro() {
        return acro;
    }
    public void setAcro(String acro) {
        this.acro = acro;
    }

    public String getUorg() {
        return uorg;
    }
    public void setUorg(String uorg) {
        this.uorg = uorg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution that = (Institution) o;
        return id.equals(that.id) && name.equals(that.name) && acro.equals(that.acro) && Objects.equals(uorg, that.uorg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, acro, uorg);
    }
}
