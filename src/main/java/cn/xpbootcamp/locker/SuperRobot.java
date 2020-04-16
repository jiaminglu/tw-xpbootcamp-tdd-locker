package cn.xpbootcamp.locker;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperRobot {
    private List<Locker> lockers;
    public SuperRobot(List<Locker> lockers) {
        this.lockers=lockers;
    }

    private Optional<Locker> selectMaxEmptyRateLocker() {
        return lockers.stream().max(Comparator.comparingDouble(Locker::getEmptyRate));
    }

    public Ticket saveBag(Bag bag) throws SaveBagFailException {
        Optional<Locker> locker = selectMaxEmptyRateLocker();
        if (locker.isPresent()) {
            return locker.get().saveBag(bag);
        }
        throw new SaveBagFailException();
    }

    public Bag takeOutBag(Ticket ticket) throws TakeOutBagFailException {
        Bag bag = null;
        for (Locker locker : lockers) {
            try {
                bag = locker.takeOutBag(ticket);
            } catch (TakeOutBagFailException ignore) {
            }
        }
        if (bag == null) {
            throw new TakeOutBagFailException();
        }
        return bag;
    }
}
