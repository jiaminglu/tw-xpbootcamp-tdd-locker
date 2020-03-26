package cn.xpbootcamp.locker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTests {

    @Test
    public void expect_slot_count_is_19_when_new_locker() {
        Locker locker = new Locker();
        int slotCount = locker.getSlotCount();
        Assertions.assertEquals(19, slotCount);
    }

    @Test
    public void expect_slot_count_decrease_by_one_and_output_ticket_when_save_bag_given_slot_count_is_not_zero() {
        Locker locker = new Locker();
        int oldSlotCount = locker.getSlotCount();
        Assertions.assertNotEquals(0, oldSlotCount);

        String ticket = locker.saveBag();

        Assertions.assertNotNull(ticket);
        int newSlotCount = locker.getSlotCount();
        Assertions.assertEquals(newSlotCount, oldSlotCount - 1);
    }

    @Test
    public void expect_slot_count_unchanged_and_output_ticket_is_empty_when_save_bag_given_slot_count_is_zero() {

    }

}
