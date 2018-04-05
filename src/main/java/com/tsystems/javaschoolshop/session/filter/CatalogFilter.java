package com.tsystems.javaschoolshop.session.filter;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CatalogFilter {

    private int idCategory=0;
    private int typeCort=0;

    public CatalogFilter() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getTypeCort() {
        return typeCort;
    }

    public void setTypeCort(int typeCort) {
        this.typeCort = typeCort;
    }
}
