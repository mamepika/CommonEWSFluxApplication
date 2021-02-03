package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ConfigAutowireable
@Dao
public interface MessageRepository {

    @Select
    public List<CommonEWSSeptember2020> findAll();

    @Select
    public List<CommonEWSSeptember2020> findLatestOne();

    @Insert
    @Transactional
    public int create(CommonEWSSeptember2020 common);
}
