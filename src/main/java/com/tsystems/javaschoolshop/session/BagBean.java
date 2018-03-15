package com.tsystems.javaschoolshop.session;

import com.tsystems.javaschoolshop.model.dto.BagProductDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("bagBean")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BagBean {

    private List<BagProductDto> bag = new ArrayList<>();

    public List<BagProductDto> getBag() {
        return bag;
    }

    public void setBag(List<BagProductDto> bag) {
        this.bag = bag;
    }

}
