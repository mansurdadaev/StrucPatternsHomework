package ru.otus.processor;

import ru.otus.model.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessorThrowException implements Processor{
    @Override
    public Message process(Message message) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ss");

        int evenSecond = Integer.parseInt(formatForDateNow.format(dateNow));

        while(true) {
            if (evenSecond % 2 == 0) {
                throw new RuntimeException();
            }
        }
    }
}
