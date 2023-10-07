package com.bridge.report;


import cn.dev33.satoken.util.SaResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
public class NativeInspectionApplication {

  public static void main(String[] args) {
    SpringApplication.run(NativeInspectionApplication.class, args);
  }



  @RestControllerAdvice
  public static class GlobalExceptionHandler {

    /**
     * 全局异常拦截
     */
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
      e.printStackTrace();
      return SaResult.error(e.getMessage());
    }
  }




}
