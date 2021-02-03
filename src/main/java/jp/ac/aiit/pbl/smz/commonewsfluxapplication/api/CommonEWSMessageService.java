package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class CommonEWSMessageService {

    @Autowired
    private MessageRepository messageRepository;


    public void create(CommonEWSSeptember2020 common){
        messageRepository.create(common);
    }

    public Flux<CommonEWSSeptember2020> findAll(){
        //final Flux<CommonEWSSeptember2020> s
        return Flux.fromIterable(messageRepository.findAll()).delayElements(Duration.ofSeconds(4));
    }
}
