package cn.xpbootcamp.locker;

import java.util.HashMap;
import java.util.Map;

public class Locker {

    private final int capacity;
    private Map<Ticket, Bag> savedBags;

    public Locker(int capacity) {
        this.capacity = capacity;
        savedBags = new HashMap<>(capacity);
    }

    public Ticket saveBag(Bag bag) throws SaveBagFailException {
        if (savedBags.size() >= capacity) {
            throw new SaveBagFailException();
        }
        Ticket ticket = new Ticket();
        savedBags.put(ticket, bag);
        return ticket;
    }

    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        if (!savedBags.containsKey(ticket)) {
            throw new TakeOutBagFailException();
        }
        Bag bag = savedBags.get(ticket);
        savedBags.remove(ticket);
        return bag;
    }

    public int getEmptySlotCount() {
        return capacity - savedBags.size();
    }

    public double getEmptyRate() {
        return getEmptySlotCount()/(double)capacity;
    }
}
