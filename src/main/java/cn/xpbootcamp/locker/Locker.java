package cn.xpbootcamp.locker;

public class Locker {

    private final int slotLength=19;
    private Ticket[] slots = new Ticket[slotLength];

    public int getSlotCount() {
        int count = 0;
        for (Ticket slot : slots) {
            if (slot == null)
                count++;
        }
        return count;
    }

    public Response saveBag() {
        Ticket ticket = new Ticket();
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                slots[i] = ticket;
                return new Response(ticket, i);
            }
        }
        return new Response(null,-1);
    }
}
