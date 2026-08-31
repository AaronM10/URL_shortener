package Url_shortener.DTO;

import Url_shortener.Domain.UrlShortener;
import Url_shortener.Repository.UrlShortenerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;

public class UrlShortenerDTO {
    private String code;
    private String longURL;
    private Integer numberOfClicks;

    //getters
    public String getCode() { return code; }
    public String getLongURL() { return longURL; }
    public Integer getNumberOfClicks() { return numberOfClicks; }

    // setters
    public void setCode(String code) {this.code = code;}
    public void setLongURL(String longURL) {this.longURL = longURL;}
    public void setNumberOfClicks(Integer numberOfClicks) {this.numberOfClicks = numberOfClicks;}


    //Setting to entity
    public UrlShortener toEntity(UrlShortenerRepository urlShortenerRepository) {
        UrlShortener entity = new UrlShortener();
        entity.setCode(this.code);
        entity.setLongURL(this.longURL);
        entity.setNumberOfClicks(this.numberOfClicks);
        return entity;
    }
}
