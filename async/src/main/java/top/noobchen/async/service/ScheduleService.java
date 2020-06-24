package top.noobchen.async.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    public int i = 0;

    @Scheduled(cron = "0-59 * * * * ?")
    public void schedu(){
        System.out.println(i++);
    }
}
