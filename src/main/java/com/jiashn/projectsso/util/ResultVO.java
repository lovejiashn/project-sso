package com.jiashn.projectsso.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: jiangjs
 * @Description: 公用返回类
 * @Date: 2021/12/2 10:09
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> ResultVO<T> success(T t){
        return ResultVO.<T>builder()
                .code(1000)
                .msg("成功")
                .data(t)
                .build();
    }

    public static ResultVO<?> success(){
        return ResultVO.builder()
                .code(1000)
                .msg("成功")
                .build();
    }
    public static ResultVO<?> error(){
        return ResultVO.builder()
                .code(5000)
                .msg("失败")
                .build();
    }

    public static ResultVO<?> error(String msg){
        return ResultVO.builder()
                .code(5000)
                .msg(msg)
                .build();
    }

    public static <T> ResultVO<T> error(Integer code,String msg,T t){
        return ResultVO.<T>builder()
                .code(code)
                .msg(msg)
                .data(t)
                .build();
    }

    public static <T> ResultVO<T> error(Integer code,String msg){
        return ResultVO.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

}