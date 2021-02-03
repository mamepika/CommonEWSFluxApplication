package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import org.seasar.doma.*;

@Entity
@Table(name = "common")
public class CommonEWSSeptember2020 {

    public CommonEWSSeptember2020(String preamble,String mt,String messageType){
        this.preamble = preamble;
        this.mt = mt;
        this.messageType = messageType;
    }

    public CommonEWSSeptember2020(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String preamble;

    private String mt;

    private String messageType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

    public String getMt() {
        return mt;
    }

    public void setMt(String mt) {
        this.mt = mt;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}
