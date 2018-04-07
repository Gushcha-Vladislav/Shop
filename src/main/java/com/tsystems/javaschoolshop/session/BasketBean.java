package com.tsystems.javaschoolshop.session;

import com.tsystems.javaschoolshop.model.dto.BasketProductDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Storage Bean
 */
@Component("basketBean")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BasketBean {

    private List<BasketProductDto> basket = new ArrayList<>();

    /**
     * Getter of the basket
     * @return BasketProductDto list
     */
    public List<BasketProductDto> getBasket() {
        return basket;
    }

    /**
     * Setter of the basket
     * @param basket - basket list
     */
    public void setBasket(List<BasketProductDto> basket) {
        this.basket = basket;
    }

}
