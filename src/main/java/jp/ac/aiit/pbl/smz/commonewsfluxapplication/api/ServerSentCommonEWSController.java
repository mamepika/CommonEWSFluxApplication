package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import jp.ac.aiit.pbl.CommonEWSMessageDecoder;
import jp.ac.aiit.pbl.format.CommonEWSMessage;
import jp.ac.aiit.pbl.format.CommonEWSMessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ServerSentCommonEWSController {


    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "/feed",
        produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CommonEWSSeptember2020> feed(final Model model){
        final Flux<CommonEWSSeptember2020> commonStream = Flux.fromIterable(this.messageRepository.findLatestOne()).delayElements(Duration.ofSeconds(5L));
        model.addAttribute("data",commonStream);
        return commonStream;
    }

    @GetMapping("/request")
    public CommonEWSSeptember2020 decode(@RequestParam("commonews") String commonEws){
        CommonEWSMessageDecoder decoder = new CommonEWSMessageDecoder(CommonEWSMessageFormat.SEPTEMBER2020);
        return new CommonEWSSeptember2020(decoder.decode(commonEws));
    }
}
