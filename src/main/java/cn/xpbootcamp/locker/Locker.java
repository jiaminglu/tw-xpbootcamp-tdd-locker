package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private final int capacity;
    private Map<Ticket, Bag> slots;

    public Locker(int capacity) {
        this.capacity = capacity;
        slots = new HashMap<>(capacity);
    }

    public Ticket saveBag(Bag bag) throws SaveBagFailException {
        if (slots.size() >= capacity) {
            throw new SaveBagFailException();
        }
        Ticket ticket = new Ticket();
        slots.put(ticket, bag);
        return ticket;
    }

    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        if (!slots.containsKey(ticket)) {
            throw new TakeOutBagFailException();
        }
        Bag bag = slots.get(ticket);
        slots.remove(ticket);
        return bag;
    }

    boolean notFull() {
        return slots.size()>=capacity;
    }
}
