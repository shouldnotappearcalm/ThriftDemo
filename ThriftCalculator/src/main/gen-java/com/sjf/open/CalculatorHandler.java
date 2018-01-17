package com.sjf.open;

import org.apache.thrift.TException;

/**
 * 计算器处理类
 *
 * @author gaozhirong
 * @create 2018-01-17 下午9:14
 **/
public class CalculatorHandler implements CalculatorService.Iface {
    @Override
    public int add(int num1, int num2) throws TException {
        return num1 + num2;
    }
    @Override
    public int minus(int num1, int num2) throws TException {
        return num1 - num2;
    }
    @Override
    public int multi(int num1, int num2) throws TException {
        return num1 * num2;
    }
    @Override
    public int divi(int num1, int num2) throws TException {
        if(num2 == 0){
            throw new RuntimeException("分母不能为0");
        }
        return num1 / num2;
    }
}
