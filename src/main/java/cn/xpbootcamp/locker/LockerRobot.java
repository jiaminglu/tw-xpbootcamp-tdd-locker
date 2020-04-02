package cn.xpbootcamp.locker;

import java.util.List;

public class LockerRobot {
    private List<Locker> lockers;

    public LockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket saveBag(Bag bag) throws SaveBagFailException {
        for (Locker locker : lockers) {
            try {
                return locker.saveBag(bag);
            } catch (SaveBagFailException ignored) {
            }
        }
        throw new SaveBagFailException();
    }

    public Locker findLocker(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isTicketValid(ticket)) {
                return locker;
            }
        }
        return null;
    }

    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        for (Locker locker: lockers){
            try{
                return locker.takeOutBag(ticket);
            } catch (TakeOutBagFailException ignored) {
            }
        }
        throw new TakeOutBagFailException();
    }
}
