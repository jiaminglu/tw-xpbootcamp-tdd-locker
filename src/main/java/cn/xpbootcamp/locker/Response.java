package cn.xpbootcamp.locker;

public class Response {
    private Ticket ticket;
    private int slotNo;

    public Response(Ticket ticket, int slotNo) {
        this.ticket = ticket;
        this.slotNo = slotNo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getSlotNo() {
        return slotNo;
    }
}
