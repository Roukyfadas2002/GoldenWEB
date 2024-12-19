package com.golden.src;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.golden.src.config.FlywayConfig;

@SpringBootApplication
public class SrcApplication {

	public static void main(String[] args) {
		runFlywayMigration();

		SpringApplication.run(SrcApplication.class, args);
	}

	private static void runFlywayMigration() {
		FlywayConfig.runFlywayMigration("db/migration", "jdbc:h2:file:/Users/leo.villeneuve/Documents/Projet/HORNET/git/hornet/backend/database/data", "sa", "password");
	}

}
