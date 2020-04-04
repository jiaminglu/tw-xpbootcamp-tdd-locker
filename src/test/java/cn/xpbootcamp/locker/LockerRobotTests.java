package cn.xpbootcamp.locker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LockerRobotTests {
    @Test
    public void should_fail_when_save_bag_given_all_locker_full() throws SaveBagFailException {
        //given
        List<Locker> lockers = new ArrayList<>();
        lockers.add(getFullLocker());
        lockers.add(getFullLocker());
        LockerRobot robot = new LockerRobot(lockers);
        //when & then
        Assertions.assertThrows(SaveBagFailException.class, () -> {
            robot.saveBag(new Bag());
        });
    }

    @Test
    public void should_bag_saved_in_first_locker_when_save_bag_given_first_locker_not_full() throws SaveBagFailException, TakeOutBagFailException {
        //given
        List<Locker> lockers = new ArrayList<>();
        Locker locker_1 = new Locker(1);
        Locker locker_2 = new Locker(1);
        lockers.add(locker_1);
        lockers.add(locker_2);
        LockerRobot robot = new LockerRobot(lockers);
        //when
        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(bag, locker_1.takeOutBag(ticket));
    }

    @Test
    public void should_bag_saved_in_second_locker_when_save_bag_given_first_locker_full_and_second_locker_not_full() throws SaveBagFailException, TakeOutBagFailException {
        //given
        List<Locker> lockers = new ArrayList<>();
        Locker locker_1 = getFullLocker();
        Locker locker_2 = new Locker(1);
        lockers.add(locker_1);
        lockers.add(locker_2);
        LockerRobot robot = new LockerRobot(lockers);
        //when
        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(locker_2.takeOutBag(ticket), bag);
    }

    @Test
    public void should_success_when_take_out_bag_given_valid_ticket_and_bag_saved_in_first_locker() throws SaveBagFailException, TakeOutBagFailException {
        //given
        List<Locker> lockers = new ArrayList<>();
        Locker locker_1 = new Locker(1);
        Locker locker_2 = getFullLocker();
        Collections.addAll(lockers, locker_1, locker_2);
        LockerRobot robot = new LockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);
        //when
        Bag resultBag = robot.takeOutBag(ticket);
        //then
        Assertions.assertEquals(bag, resultBag);
    }

    @Test
    public void should_success_when_take_out_bag_given_valid_ticket_and_bag_saved_in_second_locker() throws SaveBagFailException, TakeOutBagFailException {
        //given
        List<Locker> lockers = new ArrayList<>();
        Locker locker_1 = getFullLocker();
        Locker locker_2 = new Locker(1);
        Collections.addAll(lockers, locker_1, locker_2);
        LockerRobot robot = new LockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);
        //when
        Bag resultBag = robot.takeOutBag(ticket);
        //then
        Assertions.assertEquals(bag, resultBag);
    }

    @Test
    public void should_fail_when_take_out_bag_given_used_ticket() throws SaveBagFailException, TakeOutBagFailException {
        //given
        List<Locker> lockers = new ArrayList<>();
        Locker locker = new Locker(1);
        lockers.add(locker);
        LockerRobot robot = new LockerRobot(lockers);
        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);
        robot.takeOutBag(ticket);
        //when & then
        Assertions.assertThrows(TakeOutBagFailException.class, () -> {
            robot.takeOutBag(ticket);
        });
    }

    @Test
    public void should_fail_when_take_out_bag_given_invalid_ticket() {
        //given
        List<Locker> lockers = new ArrayList<>();
        Locker locker = new Locker(1);
        lockers.add(locker);
        LockerRobot robot = new LockerRobot(lockers);
        //when & then
        Assertions.assertThrows(TakeOutBagFailException.class, () -> {
            robot.takeOutBag(new Ticket());
        });
    }

    private Locker getFullLocker() throws SaveBagFailException {
        Locker locker = new Locker(1);
        locker.saveBag(new Bag());
        return locker;
    }
}
