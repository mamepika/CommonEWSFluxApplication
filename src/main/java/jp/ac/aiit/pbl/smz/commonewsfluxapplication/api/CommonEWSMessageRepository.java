package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import org.seasar.doma.Dao;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonEWSMessageRepository{

    private static List<CommonEWSSeptember2020> messages = new ArrayList<>();
    static{
        messages.add(new CommonEWSSeptember2020("PatternA","MT44","ALERT"));
        messages.add(new CommonEWSSeptember2020("PatternA","MT44","EXTREME"));
        messages.add(new CommonEWSSeptember2020("PatternA","MT44","TEST"));
    }

    public Flux<CommonEWSSeptember2020> findAll(){
        return Flux.fromIterable(messages).delayElements(Duration.ofSeconds(2L));
    }

    public int create() {
        messages.add(new CommonEWSSeptember2020("PatternB","MT44","CREATE"));
        return 1;
    }
}
