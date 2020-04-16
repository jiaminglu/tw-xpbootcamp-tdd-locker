package cn.xpbootcamp.locker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SuperRobotTest {
    private Locker getLocker(int capacity, int vacancy) throws SaveBagFailException {
        Locker locker = new Locker(capacity);
        for (int i = 0; i < capacity - vacancy; i++) {
            locker.saveBag(new Bag());
        }
        return locker;
    }

    @Test
    public void should_bag_saved_in_1st_locker_and_print_ticket_when_save_bag_given_robot_manage_2_lockers_and_1st_locker_capacity_2_vacancy_1_and_2nd_locker_capacity_3_vacancy_1() throws SaveBagFailException, TakeOutBagFailException {
        Locker locker_1 = getLocker(2, 1);
        Locker locker_2 = getLocker(3, 1);
        SuperRobot robot = new SuperRobot(Arrays.asList(locker_1, locker_2));

        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);

        Assertions.assertEquals(bag, locker_1.takeOutBag(ticket));
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_bag_saved_in_1st_locker_and_print_ticket_when_save_bag_given_robot_manage_2_lockers_and_1st_locker_capacity_2_vacancy_1_and_2nd_locker_capacity_4_vacancy_2() throws SaveBagFailException, TakeOutBagFailException {
        Locker locker_1 = getLocker(2, 1);
        Locker locker_2 = getLocker(4, 2);
        SuperRobot robot = new SuperRobot(Arrays.asList(locker_1, locker_2));

        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);

        Assertions.assertEquals(bag, locker_1.takeOutBag(ticket));
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_bag_saved_in_2nd_locker_and_print_ticket_when_save_bag_given_robot_manage_2_lockers_and_1st_locker_capacity_3_vacancy_1_and_2nd_locker_capacity_2_vacancy_1() throws SaveBagFailException, TakeOutBagFailException {
        Locker locker_1 = getLocker(3, 1);
        Locker locker_2 = getLocker(2, 1);
        SuperRobot robot = new SuperRobot(Arrays.asList(locker_1, locker_2));

        Bag bag = new Bag();
        Ticket ticket = robot.saveBag(bag);

        Assertions.assertEquals(bag, locker_2.takeOutBag(ticket));
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_throw_save_bag_fail_exception_when_save_bag_given_robot_manage_2_lockers_and_both_are_full() throws SaveBagFailException {
        Locker locker_1 = getLocker(1, 0);
        Locker locker_2 = getLocker(1, 0);
        SuperRobot robot = new SuperRobot(Arrays.asList(locker_1, locker_2));

        Assertions.assertThrows(SaveBagFailException.class, () -> {
            robot.saveBag(new Bag());
        });
    }
}
