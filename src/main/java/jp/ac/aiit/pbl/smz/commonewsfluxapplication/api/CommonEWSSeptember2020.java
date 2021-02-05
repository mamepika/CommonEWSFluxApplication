package jp.ac.aiit.pbl.smz.commonewsfluxapplication.api;

import jp.ac.aiit.pbl.format.CommonEWSMessage;
import org.seasar.doma.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "common")
public class CommonEWSSeptember2020 {

    public CommonEWSSeptember2020(String preamble,String mt,String messageType){
        this.preamble = preamble;
        this.mt = mt;
        this.messageType = messageType;
    }

    public CommonEWSSeptember2020(CommonEWSMessage commonEWSMessage){
        this.preamble = commonEWSMessage.getPrefix().getPreamble().toString();
        this.mt = commonEWSMessage.getPrefix().getMessageType().toString();
        this.messageType = commonEWSMessage.getMessageType().getMessageType();
        this.country = commonEWSMessage.getCountry().getCountryName();
        this.provider = "0000";
        this.severity = commonEWSMessage.getSeverity().getSeverity();
        this.guidance = commonEWSMessage.getGuidanceToReact().getInstruction();
        this.latitude = commonEWSMessage.getLatitude();
        this.longitude = commonEWSMessage.getLongitude();
        this.eventOnset = commonEWSMessage.getEventOnset().value().toLocalDateTime();

    }

    public CommonEWSSeptember2020(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String preamble;

    private String mt;

    private String messageType;

    private String country;

    private String provider;

    private String severity;

    private String guidance;

    private Double latitude;

    private Double longitude;

    private LocalDateTime eventOnset;

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


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getEventOnset() {
        return eventOnset;
    }

    public void setEventOnset(LocalDateTime eventOnset) {
        this.eventOnset = eventOnset;
    }
}
