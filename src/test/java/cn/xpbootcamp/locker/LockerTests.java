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

        Response response = locker.saveBag();
        Ticket ticket = response.getTicket();

        Assertions.assertNotNull(ticket);
        int newSlotCount = locker.getSlotCount();
        Assertions.assertEquals(oldSlotCount - 1, newSlotCount);
    }

    @Test
    public void expect_slot_count_unchanged_and_output_ticket_is_empty_when_save_bag_given_slot_count_is_zero() {
        Locker locker = new Locker();
        int slotCount = locker.getSlotCount();
        for (int i = 0; i < slotCount; i++) {
            locker.saveBag();
        }
        Assertions.assertEquals(0, locker.getSlotCount());

        Response response = locker.saveBag();
        Assertions.assertEquals(0, locker.getSlotCount());
        Assertions.assertNull(response.getTicket());
    }

    @Test
    public void expect_slot_count_increased_by_1_and_output_slot_number_when_take_out_bag_given_ticket_valid() {
        Locker locker = new Locker();

        // 存包
        Response response = locker.saveBag();
        Ticket ticket = response.getTicket();
        int slotNumber = response.getSlotNo();

        int oldSlotCount = locker.getSlotCount();

        // 取包
        int resultSlotNumber = locker.takeOutBag(ticket);

        int newSlotCount = locker.getSlotCount();
        Assertions.assertEquals(oldSlotCount + 1, newSlotCount);
        Assertions.assertEquals(slotNumber, resultSlotNumber);
    }

    @Test
    public void expect_ticket_invalidated_when_take_out_bag_given_ticket_valid() {
        Locker locker = new Locker();

        // 存包
        Response response = locker.saveBag();
        Ticket ticket = response.getTicket();
        int slotNumber = response.getSlotNo();

        int oldSlotCount = locker.getSlotCount();

        // 取包
        int resultSlotNumber = locker.takeOutBag(ticket);
        Assertions.assertEquals(oldSlotCount + 1, locker.getSlotCount());

        // 再次取包，票据失效
        int resultSlotNumber2 = locker.takeOutBag(ticket);
        Assertions.assertEquals(oldSlotCount + 1, locker.getSlotCount());
    }

    @Test
    public void expect_slot_count_unchanged_and_no_output_when_take_out_bag_given_invalid_ticket() {
        Locker locker = new Locker();
        Ticket ticket = new Ticket();

        int oldSlotCount = locker.getSlotCount();

        int resultSlotNumber = locker.takeOutBag(ticket);

        int newSlotCount = locker.getSlotCount();
        Assertions.assertEquals(oldSlotCount, newSlotCount);
        Assertions.assertEquals(-1, resultSlotNumber);
    }
}
