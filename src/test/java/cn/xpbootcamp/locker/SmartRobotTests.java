package cn.xpbootcamp.locker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartRobotTests {

    Locker createFullLocker() throws SaveBagFailException {
        Locker locker = new Locker(1);
        locker.saveBag(new Bag());
        return locker;
    }

    @Test
    void should_throw_save_bag_fail_exception_when_save_bag_using_smart_robot_given_all_lockers_full() throws SaveBagFailException {
        Locker locker1 = createFullLocker();
        Locker locker2 = createFullLocker();
        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        SmartRobot robot = new SmartRobot(lockers);

        Assertions.assertThrows(SaveBagFailException.class, () -> {
            robot.saveBag(new Bag());
        });
    }

    @Test
    void should_bag_in_second_locker_and_print_ticket_when_save_bag_using_smart_robot_given_locker1_has_1_slot_and_locker2_has_2_slots() throws TakeOutBagFailException, SaveBagFailException {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        Bag bag = new Bag();

        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = robot.saveBag(bag);

        Assertions.assertEquals(bag, locker2.takeOutBag(ticket));
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_bag_in_first_locker_and_print_ticket_when_save_bag_using_smart_robot_given_locker1_has_2_slot_and_locker2_has_1_slots() throws TakeOutBagFailException, SaveBagFailException {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(1);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        Bag bag = new Bag();

        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = robot.saveBag(bag);

        Assertions.assertEquals(bag, locker1.takeOutBag(ticket));
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_bag_in_first_locker_and_print_ticket_when_save_bag_using_smart_robot_given_locker1_has_2_slot_and_locker2_has_2_slots() throws TakeOutBagFailException, SaveBagFailException {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(2);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        Bag bag = new Bag();

        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = robot.saveBag(bag);

        Assertions.assertEquals(bag, locker1.takeOutBag(ticket));
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_my_bag_when_take_out_bag_using_smart_robot_given_valid_ticket_and_bag_saved_in_first_locker() throws SaveBagFailException, TakeOutBagFailException {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(1);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        Bag bag = new Bag();

        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = robot.saveBag(bag);

        Bag resultBag = robot.takeOutBag(ticket);
        Assertions.assertEquals(bag, resultBag);
    }

    @Test
    void should_return_my_bag_when_take_out_bag_using_smart_robot_given_valid_ticket_and_bag_saved_in_second_locker() throws SaveBagFailException, TakeOutBagFailException {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        Bag bag = new Bag();

        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = robot.saveBag(bag);

        Bag resultBag = robot.takeOutBag(ticket);
        Assertions.assertEquals(bag, resultBag);
    }

    @Test
    void should_throw_take_out_bag_fail_exception_when_take_out_bag_using_smart_robot_given_used_ticket() throws SaveBagFailException, TakeOutBagFailException {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        Bag bag = new Bag();
        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = robot.saveBag(bag);
        robot.takeOutBag(ticket);

        Assertions.assertThrows(TakeOutBagFailException.class, () -> {
            robot.takeOutBag(ticket);
        });
    }

    @Test
    void should_throw_take_out_bag_fail_exception_when_take_out_bag_using_smart_robot_given_invalid_ticket() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);

        List<Locker> lockers = new ArrayList<>();
        lockers.add(locker1);
        lockers.add(locker2);

        SmartRobot robot = new SmartRobot(lockers);
        Ticket ticket = new Ticket();

        Assertions.assertThrows(TakeOutBagFailException.class, () -> {
            robot.takeOutBag(ticket);
        });
    }

}
