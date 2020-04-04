package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobot {
    private List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket saveBag(Bag bag) throws SaveBagFailException {
        Ticket ticket = null;
        for (Locker locker : lockers) {
            if (locker.notFull()) {
                ticket = locker.saveBag(bag);
                break;
            }
        }
        if (ticket != null)
            return ticket;
        else
            throw new SaveBagFailException();
    }


    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        Bag bag = null;
        int count = 0;
        for (Locker locker : lockers) {
            try {
                bag = locker.takeOutBag(ticket);
                break;
            } catch (TakeOutBagFailException ignored) {
                count++;
            }
        }
        if (count < lockers.size())
            return bag;
        else
            throw new TakeOutBagFailException();
    }
}
