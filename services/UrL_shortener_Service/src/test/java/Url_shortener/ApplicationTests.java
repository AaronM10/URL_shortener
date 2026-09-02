package Url_shortener;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import Url_shortener.Controllers.UrlShortenerController;
import Url_shortener.Service.UrlShortenerService;

@WebMvcTest(UrlShortenerController.class)
class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlShortenerService urlService;

    @Test
    void testEndpoint() throws Exception {
        // Test your HTTP endpoint logic safely without touching PostgreSQL
    }
}