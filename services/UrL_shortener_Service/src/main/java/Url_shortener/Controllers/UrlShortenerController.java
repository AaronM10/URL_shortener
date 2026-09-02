package Url_shortener.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Url_shortener.DTO.UrlShortenerDTO;
import Url_shortener.Domain.UrlShortener;
import Url_shortener.Service.UrlShortenerService;

@RestController
@RequestMapping("/shorten")
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping({"/create"})
    public ResponseEntity<UrlShortener> createModule(@RequestBody UrlShortenerDTO newUrlBody) {
        String longUrl = newUrlBody.getLongURL();
        UrlShortener url = urlShortenerService.createShortUrl(longUrl);
        //Need to add so that when it creates a module it links to the user
        return ResponseEntity.ok(url);
    }


}
