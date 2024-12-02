package kr.co.smartquest;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class SmartquestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartquestApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(DataSource dataSource) {
        return args -> {

            Connection connection = dataSource.getConnection();
        };
    }

    @Bean
    public ModelMapper modelMapper() { // 하는 이유가 setter 없이 product랑 prodcutDto 변환 해주려고
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().
                setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).
                setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
