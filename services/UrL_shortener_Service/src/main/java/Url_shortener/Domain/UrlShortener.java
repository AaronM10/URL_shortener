package Url_shortener.Domain;
import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class UrlShortener {

    @Id
    @Column(unique = true)
    private String code;

    private String longURL;

    private Integer numberOfClicks;

    // JPA requires a no-arg constructor
    public UrlShortener() {
    }

    public UrlShortener(String code, String longURL) {
        this.code = code;
        this.longURL = longURL;
        this.numberOfClicks = 0;
    }

    // getters
    public String getCode() { return code; }
    public String getLongURL() { return longURL; }
    public Integer getNumberOfClicks() { return numberOfClicks; }

    // setters
    public void setCode(String code) {this.code = code;}
    public void setLongURL(String longURL) {this.longURL = longURL;}
    public void setNumberOfClicks(Integer numberOfClicks) {this.numberOfClicks = numberOfClicks;}

}