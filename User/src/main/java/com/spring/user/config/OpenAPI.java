package com.spring.user.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info=@Info(
				title = "UserAPI",
				description="API for Users"
				,termsOfService="t&c",
				version="V3"
				)
		)
public class OpenAPI {

}
