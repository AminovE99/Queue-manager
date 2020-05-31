package ru.itis.queuesolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.itis.queuesolution.entity.Organization;
import ru.itis.queuesolution.repository.OrganizationRepository;
import ru.itis.queuesolution.repository.TableRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class WebfluxRabbitmqStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebfluxRabbitmqStudyApplication.class, args);
        generateData(context);
    }

    private static void generateData(ConfigurableApplicationContext context) {
        OrganizationRepository restaurantRepository = context.getBean(OrganizationRepository.class);
        TableRepository tableRepository = context.getBean(TableRepository.class);

//        List<Table> tables = new ArrayList<>();
//        tables.add(Table.builder().place(4).isBooked(false).build());
//        tables.add(Table.builder().place(2).isBooked(false).build());
//        tables.add(Table.builder().place(2).isBooked(false).build());
//        tables.add(Table.builder().place(4).isBooked(true).build());
        Organization hospital = restaurantRepository.save(Organization.builder()
                .email("hospistal@gmail.com")
                .title("Bolnitsya n1")
                .build());

    }

    @Bean
    public RestTemplate restTemplate() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
