package top.fjy8018.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class Log4j2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

    private static Logger log = LoggerFactory.getLogger(MsgFilter.class);

    @Override
    public void run(String... args) throws Exception {
        try {
            int a = 1;
            int b = 0;
            int c = a/b;
        }catch (ArithmeticException e){
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
