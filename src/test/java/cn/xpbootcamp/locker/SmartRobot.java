package cn.xpbootcamp.locker;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartRobot {
    private List<Locker> lockers;

    public SmartRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    private Optional<Locker> selectLocker() {
        return lockers.stream().max(Comparator.comparingInt(Locker::getEmptySlotCount));
    }

    public Ticket saveBag(Bag bag) throws SaveBagFailException {
        Optional<Locker> locker = selectLocker();
        if (locker.isPresent()) {
            return locker.get().saveBag(bag);
        }
        throw new SaveBagFailException();
    }

    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        Bag result = null;
        for (Locker locker : lockers) {
            try {
                result = locker.takeOutBag(ticket);
            } catch (TakeOutBagFailException e) {
            }
        }
        if (result != null)
            return result;
        else
            throw new TakeOutBagFailException();
    }
}
