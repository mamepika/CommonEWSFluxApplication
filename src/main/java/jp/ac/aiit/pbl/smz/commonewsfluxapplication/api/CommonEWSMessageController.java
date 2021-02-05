package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import jp.ac.aiit.pbl.CommonEWSMessageDecoder;
import jp.ac.aiit.pbl.format.CommonEWSMessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/request")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam("commonews") String commonEws){
        CommonEWSMessageDecoder decoder = new CommonEWSMessageDecoder(CommonEWSMessageFormat.SEPTEMBER2020);
        var commonEWSMessage = decoder.decode(commonEws);
        System.out.println(commonEWSMessage);
        //System.out.println(commonEWSMessage);
        commonEWSMessageService.create(new CommonEWSSeptember2020(commonEWSMessage));
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
