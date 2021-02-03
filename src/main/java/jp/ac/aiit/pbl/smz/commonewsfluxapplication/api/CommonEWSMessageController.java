package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CommonEWSMessageController {

    @Autowired
    private CommonEWSMessageService commonEWSMessageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(){
        commonEWSMessageService.create(new CommonEWSSeptember2020("PatternA","MT44","ALERT " + LocalDateTime.now().toString()));
    }


    @GetMapping
    public String index(Model model){
        //Flux<CommonEWSSeptember2020> flux = Flux.fromIterable(september2020List);

        //IReactiveDataDriverContextVariable variable =
        //        new ReactiveDataDriverContextVariable(commonEWSMessageService.findAll(),1);
        //model.addAttribute("items", variable);

        return "index";
    }
}
