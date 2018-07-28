package com.cafe24.scheduler;

import com.cafe24.scheduler.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SchedulerApplication.class, args);
		NettyServer nettyServer = context.getBean(NettyServer.class);
		nettyServer.start();
	}
}
