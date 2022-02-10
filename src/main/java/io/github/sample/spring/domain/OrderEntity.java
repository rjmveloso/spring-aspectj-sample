package io.github.sample.spring.domain;

import io.github.sample.spring.jdbc.support.ClobConverterAdapter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Clob;

@Entity
public class OrderEntity extends ClobConverterAdapter {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String number;

    @Lob
    private Clob invoice;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInvoice() {
        return getClobConverter().read(invoice);
    }

    public void setInvoice(String field) {
        this.invoice = getClobConverter().create(field);
    }

}

