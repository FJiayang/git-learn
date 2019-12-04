package top.fjy8018.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Log4j2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

    private static Logger log = LoggerFactory.getLogger(MsgFilter.class);

    @Override
    public void run(String... args) throws Exception {
        String randomString = getRandomString(50005);
        log.info("生成的长度： "+randomString.length());
        log.info(randomString);
    }


    public String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
