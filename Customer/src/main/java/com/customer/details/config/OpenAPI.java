package com.customer.details.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
		info=@Info(
				title = "CustomerAPI",
				description="API for Customers"
				,termsOfService="t&c",
				version="V3"
				),
		servers = {
				@Server(
						description = "this url is for dev",
						url = "http://localhost:8080"
						),
				@Server(
						description = "this url is for user",
						url = "http://localhost:8080"
						)
		}
		)

@SecurityScheme(
		name="Security"
		,bearerFormat = "HTTPBASICS",
		in = SecuritySchemeIn.HEADER
		,type = SecuritySchemeType.HTTP
		)
public class OpenAPI {

}
