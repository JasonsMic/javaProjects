package com.example.demo1.exception;

import com.example.demo1.model.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


// 统一的异常类进行处理(把默认的异常返回信息改成自定义的异常返回信息)
// 当GlobalContrller抛出HospitalException异常时，将自动找到此类中对应的方法执行，并返回json数据给前台
@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = CustomException.class)//异常处理器，处理CustomException异常
    public ResponseEntity<?> handlerException(HttpServletRequest request, CustomException e){
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setData("some data");
       return new ResponseEntity<>(errorInfo,HttpStatus.OK);
    }
}
