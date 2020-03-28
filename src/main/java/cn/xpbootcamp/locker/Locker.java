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
        if(slots.size()<capacity) {
            Ticket ticket = new Ticket();
            slots.put(ticket,bag);
            return ticket;
        }
        else{
            throw new SaveBagFailException();
        }
    }

    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        if(slots.containsKey(ticket)){
            Bag bag = slots.get(ticket);
            slots.remove(ticket);
            return bag;
        }
        else{
            throw new TakeOutBagFailException();
        }
    }
}
