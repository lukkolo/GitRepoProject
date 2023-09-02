package com.example.gitrepoproject.domain.proxy;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Log4j2
public class GitProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("api.github.com")
    String url;


    public GitProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String makeGetRequest(String username) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
                .path("/users/" + username + "/repos");
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return response.getBody();
        } catch (IllegalArgumentException ex) {
            log.error("User: " + username + "not found");
        }
        return null;
    }

    public String makeBranchRequest(String username,String repo){
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
                .path("/repos/"+ username+"/" + repo+"/branches");
        try{
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return response.getBody();
        }catch (IllegalArgumentException ex){
            log.error("Branches for username: " + username + " not found");
        }
        return null;
    }

}
