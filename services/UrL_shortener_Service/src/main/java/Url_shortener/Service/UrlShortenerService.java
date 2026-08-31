package Url_shortener.Service;

import Url_shortener.Domain.UrlShortener;
import Url_shortener.DTO.UrlShortenerDTO;
import Url_shortener.Repository.UrlShortenerRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@Service
@Transactional
public class UrlShortenerService {

    private final UrlShortenerRepository urlShortenerRepository;
    private static final String MODULE_NOT_FOUND = "Module does not exist";

    public UrlShortenerService(UrlShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }
    //CRUD OPERATIONS
    public UrlShortener createShortUrl(String longUrl) {
        UrlShortener shortUrlEntity = new UrlShortener();
        String randomCode = checkingAndCreatingRandomCode();
        shortUrlEntity.setCode(randomCode);
        shortUrlEntity.setLongURL(longUrl);
        shortUrlEntity.setNumberOfClicks(0);
        return urlShortenerRepository.save(shortUrlEntity);
    }


    public static String creatingRandomCode(){
        String code = "";
        int i = 0;
        while (i < 6) {
            int randomLetterNumber = (int)((Math.random() * 27) + 96); // 97 to 122 (ascii values of lower case letters)
            int lowerOrUpper = (int)(Math.random() * 2); // 0 to 1 (ascii values of lower case letters)
            if (lowerOrUpper == 0) {
                char character = (char) randomLetterNumber;
                code += String.valueOf(character).toUpperCase();
            } else if (lowerOrUpper == 1) {
                char character = (char) randomLetterNumber;
                code += character;
            }
            i++;
        }
        return code;
    }

    //Essentially calls the creating random code but also checks if that code has already been made
    public String checkingAndCreatingRandomCode(){
        String randomCode = creatingRandomCode();
        do {
            randomCode = creatingRandomCode();
        }while (urlShortenerRepository.findById(randomCode).isPresent());
        return randomCode;
    }

}

