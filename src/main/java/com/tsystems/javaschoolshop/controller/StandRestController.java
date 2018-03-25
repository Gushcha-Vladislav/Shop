package com.tsystems.javaschoolshop.controller;


import com.tsystems.javaschoolshop.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tsystems.javaschoolshop.service.api.ProductService;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@RestController
@RequestMapping(value = "/advertising")
public class StandRestController {

    private final Set<SseEmitter> emitters = Collections.synchronizedSet(new HashSet<>());

    private final ProductService productService;

    @Autowired
    public StandRestController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/stand")
    @ResponseBody
    public List<ProductDto> getStandInformation() {
        List<ProductDto> result = productService.convertProductsToProductsDto(
                productService.findTop10Products(false));
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                sendNotificationForAllSubscribers();
            }
        }, 10000);

        return result;
    }

    @RequestMapping(value = "/stand/connection")
    public SseEmitter openConnection(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        final SseEmitter emitter = new SseEmitter(20000L);

        emitter.onTimeout(emitter::complete);
        emitter.onCompletion(() -> {
            synchronized (this.emitters) {
                emitters.remove(emitter);
            }
        });
        emitters.add(emitter);

        return emitter;
    }

    @RequestMapping(value = "/stand/update")
    private void sendNotificationForAllSubscribers() {
        synchronized (this.emitters) {
            for (SseEmitter emitter : emitters) {
                try {
                    emitter.send("update");
                    emitter.complete();
                } catch (Exception ignored) {
                    //we should ignore this exception
                    //because sometimes we have two similar connections to one user.
                    //One of them complete(timeout), another is active.
                    //After this catch block, completed exemplar will be removed.
                }
            }
        }

    }

}
