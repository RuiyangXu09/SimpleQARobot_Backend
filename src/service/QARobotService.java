package service;

import module.Response;

import java.io.UnsupportedEncodingException;

/**
 * 该接口用于处理发起的请求
 */
public interface QARobotService {
    //获取传入的msg
    Response qaService(String msg) throws UnsupportedEncodingException;
}