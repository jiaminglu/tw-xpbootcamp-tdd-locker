package cn.xpbootcamp.locker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTests {


    @Test
    public void should_output_ticket_when_save_bag_given_locker_is_not_full() {
        //Given
        Locker locker = new Locker(19);
        //When
        Ticket ticket = locker.saveBag(new Bag());
        //Then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_throw_save_bag_fail_exception_when_save_bag_given_locker_is_full() {
        //Given
        Locker locker = new Locker(0);
        //When & Then
        Assertions.assertThrows(SaveBagFailException.class, () -> {
            locker.saveBag(new Bag());
        });
    }

    @Test
    public void should_get_bag_when_take_out_bag_given_valid_ticket() {
        //Given
        Locker locker = new Locker(5);
        Bag bagSaved = new Bag();
        Ticket ticket = locker.saveBag(bagSaved);
        //When
        Bag bagTakedOut = locker.takeOutBag(ticket);
        //Then
        Assertions.assertEquals(bagTakedOut, bagSaved);
    }

    @Test
    public void should_throw_take_out_bag_fail_exception_when_take_out_bag_given_used_ticket() {
        //Given
        Locker locker = new Locker(5);
        Ticket ticket = locker.saveBag(new Bag());
        locker.takeOutBag(ticket);
        //When & Then
        Assertions.assertThrows(SaveBagFailException.class, () -> {
            locker.takeOutBag(ticket);
        });
    }

    @Test
    public void expect_throw_take_out_bag_fail_exception_when_take_out_bag_given_invalid_ticket() {
        //Given
        Locker locker = new Locker(5);
        Ticket ticket = new Ticket();
        //When & Then
        Assertions.assertThrows(SaveBagFailException.class, () -> {
            locker.takeOutBag(ticket);
        });
    }
}
