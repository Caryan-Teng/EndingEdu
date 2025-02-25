package me.caryan.volunteerregistersys.aop;

import me.caryan.volunteerregistersys.entity.response.ResultVo;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ResultVo<Object> response = new ResultVo<>();
        return new ResultVo(500, "请求参数验证失败", response.getData());
    }
}
