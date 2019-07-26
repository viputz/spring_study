package com.infomendes.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.infomendes.brewer.service.CadastroCervejaService;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class})
public class ServiceConfig {

}
