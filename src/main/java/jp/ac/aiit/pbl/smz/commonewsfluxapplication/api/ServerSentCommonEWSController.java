package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
