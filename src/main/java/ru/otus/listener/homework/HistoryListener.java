package ru.otus.listener.homework;

import ru.otus.listener.Listener;
import ru.otus.model.Message;
import ru.otus.model.ObjectForMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoryListener implements Listener, HistoryReader {

    private final Map<Long, Message> historyMap = new HashMap<>();

    public HistoryListener() {
    }

    @Override
    public void onUpdated(Message msg) {
        var objectForMessage = new ObjectForMessage();
        objectForMessage.setData(new ArrayList<>(msg.getField13().getData()));

        historyMap.put(msg.getId(), msg.toBuilder()
                .field1(msg.getField1())
                .field2(msg.getField2())
                .field3(msg.getField3())
                .field4(msg.getField4())
                .field5(msg.getField5())
                .field6(msg.getField6())
                .field7(msg.getField7())
                .field8(msg.getField8())
                .field9(msg.getField9())
                .field10(msg.getField10())
                .field11(msg.getField11())
                .field12(msg.getField12())
                .field13(objectForMessage)
                .build());
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(historyMap.get(id));
    }
}
