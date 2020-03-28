package cn.xpbootcamp.locker;

public class Locker {

    private final int capacity;
    private Ticket[] slots;

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public int getSlotCount() {
        int count = 0;
        for (Ticket slot : slots) {
            if (slot == null)
                count++;
        }
        return count;
    }

    public Ticket saveBag(Bag bag) {
        return new Ticket();
    }

    public Bag takeOutBag(Ticket ticket) {
        return new Bag();
    }
}
