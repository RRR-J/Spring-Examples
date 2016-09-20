package com.springapp.mvc;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Async
    public void someBackgroundProcess() throws InterruptedException {
        System.out.println("TestService.someBackgroundProcess sleeping " + Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("TestService.someBackgroundProcess back to work " + Thread.currentThread().getName());
    }
}
