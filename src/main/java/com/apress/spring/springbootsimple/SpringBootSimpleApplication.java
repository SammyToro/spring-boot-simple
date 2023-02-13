package com.apress.spring.springbootsimple;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootSimpleApplication {

	// public static void main(String[] args) {

	// 	//Using the spring application builder fluent api
	// 	Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
	// 	new SpringApplicationBuilder()
	// 		.bannerMode(Banner.Mode.OFF)
	// 		.sources(SpringBootSimpleApplication.class)
	// 		.listeners(new ApplicationListener<ApplicationEvent>() {

	// 			@Override
	// 			public void onApplicationEvent(ApplicationEvent event) {
	// 				// TODO Auto-generated method stub
	// 				log.info("### > "+ event.getClass().getCanonicalName());
					
	// 			}
				
	// 		})
	// 		.run(args);
	// }

	//## Application Argument ##//
	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootSimpleApplication.class, args);
	}

	@Component
	class MyComponent{

		private static final Logger log = LoggerFactory.getLogger(MyComponent.class);

		@Autowired
		public MyComponent(ApplicationArguments args){
			boolean enable  = args.containsOption("enable");
			if(enable){
				log.info("## > You are enabled!");
			}

			List<String> _args = args.getNonOptionArgs();
			log.info("## > extra args ...");
			if(!_args.isEmpty()){
				_args.forEach(file -> log.info(file));
			}
		}
	}

}
