package com.bluesight;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.bluesight.service.ProcessPhoneNumber;

@SpringBootApplication
public class CodeChallengeApplication implements CommandLineRunner, ApplicationContextAware {

	private static Logger LOG = LoggerFactory
		      .getLogger(CodeChallengeApplication.class);
	
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws IOException {
        LOG.info("EXECUTING : command line runner");
        ProcessPhoneNumber service = applicationContext.getBean(ProcessPhoneNumber.class);       
        if (args.length != 2) {
        	LOG.error("Usage: java -jar Codechallenge.jsr <PhoneNumber> <Path To Dictionary>");
        }
        LOG.info("Result {}", service.procesPhoneNumber(args[0], args[1]));	
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}
}
