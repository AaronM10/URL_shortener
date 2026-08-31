package Url_shortener.Repository;

import Url_shortener.Domain.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, String> {

}